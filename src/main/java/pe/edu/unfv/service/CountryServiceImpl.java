package pe.edu.unfv.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.unfv.model.Country;
import pe.edu.unfv.repository.CountryRepository;

@Service
public class CountryServiceImpl implements CountryService{

	@Autowired
	private CountryRepository countryRepository;
	
	@Override
	public List<Country> getAllCountries() {		
		return countryRepository.findAll();
	}

	@Override
	public Optional<Country> getCountryById(Long id) {		
		return countryRepository.findById(id);
	}

	@Override
	public Country saveCountry(Country country) {		
		return countryRepository.save(country);
	}

	@Override
	public void deleteCountry(Long id) {
		countryRepository.deleteById(id);		
	}

}
