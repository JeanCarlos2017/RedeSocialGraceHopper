<<<<<<< HEAD
	package com.Hopper.RedeHopper.repository;
=======
package com.Hopper.RedeHopper.repository;
>>>>>>> a1e4e6904861994f15c33e000e6d387f69100d1a

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Hopper.RedeHopper.model.Tema;

public interface TemaRepository extends JpaRepository<Tema, Long>{
	List<Tema> findAllByCategoriaContainingIgnoreCase(String categoria);

}
