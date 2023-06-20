package pl.lderecki.gusapiconsumer.web.apiconsumer.interceptor;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.support.HttpRequestWrapper;

import java.io.IOException;
import java.net.URI;

public class HeadersInterceptor implements ClientHttpRequestInterceptor {

    private static final String API_KEY = "Hm6CxsoRfJ8Zv90UxFllSanw164P84HgFn0AYIAt0Sg=";
    private static final String LANG = "pl";
    private static final String ACCEPT = "application/json";

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {

        String query = "?lang=" + LANG;
        String pathWithQuery = request.getURI().getPath() + query;
        URI uriWithQuery = request.getURI().resolve(pathWithQuery);

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
