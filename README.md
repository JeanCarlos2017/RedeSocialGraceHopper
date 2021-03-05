# RedeSocialGraceHopper
GraceHopper é uma rede social com o intuito de ajudar os seus usuários  encontrar um caminho/trilha que o direcionem para a aquisição de conhecimento que é desejado pelos seus seguidores

# Funcionalidades do sistema até o momento
## Usuário 
### 1. O sistema permite o cadastro de usuários.
 - [x] Durante o cadastro a sua senha é criptografada
 - [x] para realizar o cadastro o usuário precisa passar um e-mail com formato válido
 - [x] não é permitido que os usuários possuam o mesmo nome
 - [ ]  verifica que o usuário está passando um nome válido
 - [ ] exige um padrão de senha para o usuário
### 2. O sistema permite que o usuário faça login
- [x] recupera um usuário através de nome e senha
- [x] criptografa a senha do usuário antes de fazer a verificação no banco de dados 
- [x] cria um token codificado para o usuário e libera o acesso para as funcionalidades do sistema 
### 3. O sistema permite que o usuário realize a operação de logout
- [ ] o token passado para o usuário expira e ele perde o acesso às funcionalidades do sistema

## Tema 
### 1. O sistema permite que o usuário cadastre um tema
 - [x] o sistema permite que o usuário digite uma categoria para o tema
### 2. O sistema permite que o usuário altere um tema
### 3. O sistema permite que o usuário busque um tema
 - [x] buscar o tema pela categoria
-  [x] buscar postagens de acordo com o tema 


## Postagem 
### 1.	O sistema permite que o usuário cadastre uma postagem
- [x] o sistema vincula um usuário com uma postagem
- [x] o sistema garante que a postagem tenha um título 
- [x] o sistema garante que a postagem tenha ao menos imagem ou um conteúdo
- [x] o sistema permite que o usuário vincule quantas postagens desejar ao tema 
### 2. O sistema permite que o usuário altere uma postagem 
- [x] o sistema permite que o usuário altere o título de uma postagem 
- [x] o sistema permite que o usuário altere o conteúdo de uma postagem 
- [x] o sistema permite que o usuário altere a imagem de uma postagem 
- [x] o sistema permite que o usuário altere os temas vinculados a uma postagem 
- [ ] o sistema mostra as alterações feitas em cima de uma postagem
### 3. O sistema permite que o usuário remova uma postagem 
- [x] o sistema remove o vinculo que todos temas tinham com a postagem excluída 
### 4. O sistema permite a busca de uma postagem 
- [x] o sistema permite listar todas as postagens
- [x] o sistema permite a busca de uma postagem pelo seu id 
- [ ] o sistema permite a busca de uma postagem pelo seu nome


# Como executar o projeto? 
Caso não saiba como executar uma aplicação Spring Boot com Maven ou um executável Jar clique [aqui](https://www.codeflow.site/pt/article/spring-boot-run-maven-vs-executable-jar)

# Tecologias usadas no projeto até o momento?

 1. [Spring Tools 4](https://spring.io/tools) integrado a IDE [Eclipse](https://www.eclipse.org/downloads/download.php?file=/oomph/epp/2020-12/R/eclipse-inst-jre-win64.exe)
 
 2. [Spring Boot](https://start.spring.io/) para a configuração do projeto, ele foi usado com o auxílio do Spring Tools 4.
 
 3. [Spring MVC](https://blog.algaworks.com/spring-mvc/) para saber mais 
 
 4. [Maven](https://maven.apache.org/)
 
 6. [Spring Data JPA](https://spring.io/projects/spring-data)
 7. [Spring Security](https://spring.io/projects/spring-security)


