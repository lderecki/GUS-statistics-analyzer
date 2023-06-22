package pl.lderecki.gusapiconsumer.web.apiconsumer.rest;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import pl.lderecki.gusapiconsumer.dto.AreaDTO;
import pl.lderecki.gusapiconsumer.web.apiconsumer.interceptor.HeadersInterceptor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AreasRestTemplate {

    private final RestTemplate restTemplate = new RestTemplate();
    private static final String ENDPOINT_URL = "https://api-dbw.stat.gov.pl/api/1.1.0/area/area-area";

    public List<AreaDTO> getAreas() {

        restTemplate.getInterceptors().add(new HeadersInterceptor());
        ResponseEntity<AreaDTO[]> response = restTemplate.exchange(ENDPOINT_URL, HttpMethod.GET, null, AreaDTO[].class);

        List<AreaDTO> result = Arrays.asList(response.getBody());

        return result;
    }
}
