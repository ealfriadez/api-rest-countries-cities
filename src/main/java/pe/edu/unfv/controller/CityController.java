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

import pe.edu.unfv.dto.CityDTO;
import pe.edu.unfv.model.City;
import pe.edu.unfv.service.CityService;

@RestController
@RequestMapping("/api/cities")
public class CityController {

	@Autowired
	private CityService cityService;
	
	@GetMapping
	public List<CityDTO> getAllCities(){
		List<City> cities = cityService.getAllCities();
		return cities.stream()
				.map(this::convertToDto)
				.collect(Collectors.toList());
	}
	
	@GetMapping("/{id}")
	public CityDTO getCityById(@PathVariable Long id) {
		return cityService.getCityById(id)
				.map(this::convertToDto)
				.orElse(null);
	} 
	
	@GetMapping("/country/{countryId}")
	public List<CityDTO> getCitiesByCountry(@PathVariable Long countryId){
		List<City> cities = cityService.getCitiesByCountry(countryId);
		return cities.stream()
				.map(this::convertToDto)
				.collect(Collectors.toList());
	}
	
	@PostMapping
	public CityDTO saveCityDTO(@RequestBody CityDTO cityDTO) {
		City city = convretToEntity(cityDTO);
		City savedCity = cityService.saveCity(city);
		return convertToDto(savedCity);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCity(@PathVariable Long id) {
		cityService.deleteCity(id);
	}
	
	
	
	
	private CityDTO convertToDto(City city) {		
		CityDTO cityDTO = new CityDTO();
		cityDTO.setId(city.getId());
		cityDTO.setName(city.getName());
		cityDTO.setCountry(city.getCountry());
		return cityDTO;
	}
	
	private City convretToEntity(CityDTO cityDTO) {
		City city = new City();
		city.setId(cityDTO.getId());
		city.setName(cityDTO.getName());
		city.setCountry(cityDTO.getCountry());
		return city;
	}
	
}
