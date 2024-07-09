package pe.edu.unfv.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.unfv.model.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long>{
	
	List<City> findByCountryId(Long country);
}
