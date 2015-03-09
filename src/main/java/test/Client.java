package test;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.http.ResponseEntity;
import org.springframework.core.ParameterizedTypeReference;

import dto.CarDTO;

public class Client {

	public static void main(String[] args) {
		
		try{
		
			ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
			RestTemplate restTemplate = (RestTemplate)context.getBean("restTemplate");
			
			HttpHeaders headers = new HttpHeaders();
	    	headers.setContentType(MediaType.APPLICATION_JSON);
	    
			HttpEntity<String> entity = new HttpEntity<String>(headers);
			
			// get a list of unrented cars
			URI uri = new URI("http://localhost:8080/GradleSpringRestBasis-master/car");
			
			ResponseEntity<ArrayList> responseList = restTemplate.exchange(uri , HttpMethod.GET, entity, ArrayList.class);
			HttpStatus statusCode = responseList.getStatusCode();
			if(statusCode != HttpStatus.OK){
				System.out.println("Erreur");
			}
			
			ArrayList carList = responseList.getBody();
			System.out.println("Unrented cars: " + carList);
			
			// get a car specifications
			uri = new URI("http://localhost:8080/GradleSpringRestBasis-master/car/AA11AA");
			
			ResponseEntity<CarDTO> response = restTemplate.exchange(uri , HttpMethod.GET, entity, CarDTO.class);
			statusCode = response.getStatusCode();
			if(statusCode != HttpStatus.OK){
				System.out.println("Erreur");
			}
			
			CarDTO car = response.getBody();
			System.out.println("Car specifications: " + car);
			
			// rent a car
			uri = new URI("http://localhost:8080/GradleSpringRestBasis-master/car/AA11AA");
			restTemplate.delete(uri);
			
			// display cars list
			uri = new URI("http://localhost:8080/GradleSpringRestBasis-master/car");
			
			responseList = restTemplate.exchange(uri , HttpMethod.GET, entity, ArrayList.class);
			statusCode = responseList.getStatusCode();
			if(statusCode != HttpStatus.OK){
				System.out.println("Erreur");
			}
			
			carList = responseList.getBody();
			System.out.println("Unrented cars: " + carList);
			
			
			// get back a car
			uri = new URI("http://localhost:8080/GradleSpringRestBasis-master/car/AA11AA");
			restTemplate.put(uri, null);
			
			// display cars list
			uri = new URI("http://localhost:8080/GradleSpringRestBasis-master/car");
						
			responseList = restTemplate.exchange(uri , HttpMethod.GET, entity, ArrayList.class);
			statusCode = responseList.getStatusCode();
			if(statusCode != HttpStatus.OK){
				System.out.println("Erreur");
			}
						
			carList = responseList.getBody();
			System.out.println("Unrented cars: " + carList);
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}

}
