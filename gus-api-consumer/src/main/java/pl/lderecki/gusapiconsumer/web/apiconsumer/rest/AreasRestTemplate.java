package pl.lderecki.gusapiconsumer.web.apiconsumer.rest;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import pl.lderecki.gusapiconsumer.web.apiconsumer.interceptor.HeadersInterceptor;

public class AreasRestTemplate {

    private RestTemplate restTemplate = new RestTemplate();
    private static final String ENDPOINT_URL = "https://api-dbw.stat.gov.pl/api/1.1.0/area/area-area";

    public String getAreas() {

        restTemplate.getInterceptors().add(new HeadersInterceptor());
        ResponseEntity<String> response = restTemplate.exchange(ENDPOINT_URL, HttpMethod.GET, null, String.class); //, requestParameters);

        return response.getBody();
    }
}
