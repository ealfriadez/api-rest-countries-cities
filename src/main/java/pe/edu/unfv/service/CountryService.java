package pe.edu.unfv.service;

import java.util.List;
import java.util.Optional;

import pe.edu.unfv.model.Country;

public interface CountryService {

	List<Country> getAllCountries();
	Optional<Country> getCountryById(Long id);	
	Country saveCountry(Country country);
	void deleteCountry(Long id);
}
