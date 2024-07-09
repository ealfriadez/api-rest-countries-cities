package pe.edu.unfv.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.unfv.model.City;
import pe.edu.unfv.repository.CityRepository;

@Service
public class CityServiceImpl implements CityService {

	@Autowired
	private CityRepository cityRepository;
	
	@Override
	public List<City> getAllCities() {		
		return cityRepository.findAll();
	}

	@Override
	public Optional<City> getCityById(Long id) {		
		return cityRepository.findById(id);
	}

	@Override
	public List<City> getCitiesByCountry(Long countryId) {				
		return cityRepository.findByCountryId(countryId);
	}

	@Override
	public City saveCity(City city) {		
		return cityRepository.save(city);
	}

	@Override
	public void deleteCity(Long id) {		
		cityRepository.deleteById(id);
	}
	
}