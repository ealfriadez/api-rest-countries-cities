package pe.edu.unfv.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.edu.unfv.model.Country;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CityDTO {

	private Long id;	
	private String name;
	private Country country;
}
