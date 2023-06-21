package pl.lderecki.gusapiconsumer.web.apiconsumer.interceptor;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.support.HttpRequestWrapper;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import pl.lderecki.gusapiconsumer.configuration.EnvironmentVariablesLoader;

import java.io.IOException;
import java.net.URI;

public class HeadersInterceptor implements ClientHttpRequestInterceptor {

    //TODO export api key as system variable
    private final String API_KEY;
    private static final String LANG = "pl";
    private static final String ACCEPT = "application/json";


    public HeadersInterceptor() {
        API_KEY = EnvironmentVariablesLoader.getInstance().getApiKey();
    }

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {

        String query = "lang=" + LANG;
        URI basicUri = request.getURI();


        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .scheme(basicUri.getScheme())
                .host(basicUri.getHost())
                .path(basicUri.getPath())
                .query(basicUri.getQuery())
                .query(query)
                .build();

        URI uriWithQuery = uriComponents.toUri();

        HttpRequest requestWithQuery = new HttpRequestWrapper(request) {
            @Override
            public URI getURI() {
                return uriWithQuery;
            }
        };

        request.getHeaders().set("accept", ACCEPT);
        request.getHeaders().set("X-ClientId", API_KEY);

        return execution.execute(requestWithQuery, body);
    }
}
