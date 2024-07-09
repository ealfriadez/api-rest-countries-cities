package pe.edu.unfv.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.unfv.dto.CountryDTO;
import pe.edu.unfv.model.Country;
import pe.edu.unfv.service.CountryService;

@RestController
@RequestMapping("/api/countries")
public class CountryController {

	@Autowired
	private CountryService countryService;
	
	@GetMapping
	public List<CountryDTO> getAllCountries(){
		List<Country> countries = countryService.getAllCountries();
		return countries.stream()
				.map(this::convertToDto)
				.collect(Collectors.toList());
	}
	
	@GetMapping("/{id}")
	public CountryDTO getCountryById(@PathVariable Long id) {
		return countryService.getCountryById(id)
				.map(this::convertToDto)
				.orElse(null);
	} 
	
	@PostMapping
	public CountryDTO saveCountry(@RequestBody CountryDTO countryDTO) {
		Country country = convertToEntity(countryDTO);
		Country saveCountry = countryService.saveCountry(country);
		return convertToDto(saveCountry);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCountry(@PathVariable Long id) {
		countryService.deleteCountry(id);
	}
	
	
	
	private CountryDTO convertToDto(Country country) {		
		CountryDTO countryDTO = new CountryDTO();
		countryDTO.setId(country.getId());
		countryDTO.setName(country.getName());
		return countryDTO;
	}
	
	private Country convertToEntity(CountryDTO countryDTO) {
		Country country = new Country();
		country.setId(countryDTO.getId());
		country.setName(countryDTO.getName());
		return country;
	}
}
