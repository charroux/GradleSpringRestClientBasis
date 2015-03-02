package dto;

public class CarDTO {
	
	String plateNumber;

	public String getPlateNumber() {
		return plateNumber;
	}

	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	@Override
	public String toString() {
		return "CarDTO [plateNumber=" + plateNumber + "]";
	}
	
}