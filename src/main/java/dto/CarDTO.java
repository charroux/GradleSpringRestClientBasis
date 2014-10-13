package dto;

import org.springframework.hateoas.ResourceSupport;

public class CarDTO extends ResourceSupport{
	
	String numberPlate;

	public String getNumberPlate() {
		return numberPlate;
	}

	public void setNumberPlate(String numberPlate) {
		this.numberPlate = numberPlate;
	}

}
