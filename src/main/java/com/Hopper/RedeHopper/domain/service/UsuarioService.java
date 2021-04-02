package com.Hopper.RedeHopper.domain.service;

import java.nio.charset.Charset;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.Hopper.RedeHopper.domain.model.UsuarioEntidade;
import com.Hopper.RedeHopper.domain.model.UsuarioLogin;
import com.Hopper.RedeHopper.domain.repository.UsuarioRepository;

@Service
public class UsuarioService {
	//validação de email
	private static final String EMAIL_PATTERN = 
	        "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
	        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	private boolean validaEmail(String email) {
		Matcher matcher = pattern.matcher(email);
	    return matcher.matches();
	}

	private boolean validaNome(String nome) {
		//verifica se já existe um usuário com esse nome
		Optional<UsuarioEntidade> encontrou= usuarioRepository.findByNome(nome);
		if(encontrou.isEmpty()) return true;
		else return false; 
		
	}

	public UsuarioEntidade cadastraUsuario(UsuarioEntidade usuario) {
		//verifica se o email e nome sao válidos 
		if(this.validaEmail(usuario.getEmail()) && this.validaNome(usuario.getNome())) {
			//criptografa a senha do usuário 
			BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
			String senhaEncoder= encoder.encode(usuario.getSenha());
			usuario.setSenha(senhaEncoder);
			//gera um código para o usuário de acordo com o nome escolhido 
			usuario.setCodigo_usuario();
			//por fim salva o usuário
			return usuarioRepository.save(usuario);
		}else return null;
	}

	public Optional<UsuarioLogin> login(Optional<UsuarioLogin> userParametro) {
		BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
		//busca o usuário no banco de dados pelo nome, como o nome é unico não há conflitos
		Optional<UsuarioEntidade> usuario= usuarioRepository.findByNome(userParametro.get().getNome());
		if(usuario.isPresent()) {
			//verifica se a senha do usuário é igual a senha do banco, faz essa verificação considerando a criptografia
			if(encoder.matches(userParametro.get().getSenha(), usuario.get().getSenha())) {
				//gero o token do usuário
				String auth= userParametro.get().getNome() + ":"+ userParametro.get().getSenha();
				byte[] encondeAuth= Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader= "Basic "+new String(encondeAuth);
				//colocando as informações de usuário no userParametro - que é o usuário para login 
				userParametro.get().setToken(authHeader);
				userParametro.get().setCodigo_usuario(usuario.get().getCodigo_usuario());
				userParametro.get().setUrl_foto(usuario.get().getUrl_foto());
				userParametro.get().setEmail(usuario.get().getEmail());
				userParametro.get().setId(usuario.get().getId_usuario());
				return userParametro;				
			}else {
				return null;
			}
		}else {
			return null;
		}
	}

	public void logout(UsuarioEntidade usuario) {

	}

	public UsuarioRepository getUsuarioRepository() {
		return usuarioRepository;
	}
	
	
}
