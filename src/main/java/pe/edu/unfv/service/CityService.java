package pe.edu.unfv.service;

import java.util.List;
import java.util.Optional;

import pe.edu.unfv.model.City;

public interface CityService {

	List<City> getAllCities();
	Optional<City> getCityById(Long id);
	List<City> getCitiesByCountry(Long countryId);
	City saveCity(City city);
	void deleteCity(Long id);
}
