package pe.edu.unfv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.unfv.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long>{
	
}
