package test;

import java.net.URI;
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

public class Client {

	public static void main(String[] args) {
		
		try{
		
			ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
			RestTemplate restTemplate = (RestTemplate)context.getBean("restTemplate");
			
			HttpHeaders headers = new HttpHeaders();
	    	headers.setContentType(MediaType.APPLICATION_JSON);
	    
			HttpEntity<String> entity = new HttpEntity<String>(headers);
			
			URI uri = new URI("http://localhost:8080/GradleSpringRest/myRent/entryPoint");
			
			ResponseEntity<ResourceSupport> response = restTemplate.exchange(uri , HttpMethod.GET, entity, ResourceSupport.class);
			HttpStatus statusCode = response.getStatusCode();
			if(statusCode != HttpStatus.OK){
				System.out.println("Erreur");
			}
			
			ResourceSupport resourceSupport = response.getBody();
			
			System.out.println(resourceSupport);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}

}
