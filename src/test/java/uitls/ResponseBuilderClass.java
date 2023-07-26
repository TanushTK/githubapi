package uitls;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import pojo.CreateInvalidTokenPojo;
import pojo.CreateIssueResponsePojo;
import pojo.CreateRepoResponsePOJO;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.is;


public class ResponseBuilderClass
{
    public static CreateRepoResponsePOJO buildResponseToPojo(Response response) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        CreateRepoResponsePOJO objectMapped = objectMapper.readValue(response.getBody().asString(), CreateRepoResponsePOJO.class);
        assertThat("Status code is not 201",response.getStatusCode(), is(201));
        assertThat("Status code is not 201",response.getStatusLine(), is(equalToIgnoringCase("HTTP/1.1 201 Created")));
        return objectMapped;
    }

    public static CreateInvalidTokenPojo buildResponseInvalidToPojo(Response response) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        CreateInvalidTokenPojo objectMapped = objectMapper.readValue(response.getBody().asString(), CreateInvalidTokenPojo.class);
        assertThat("Status code is not 201",response.getStatusCode(), is(401));
        return objectMapped;
    }

    public static CreateIssueResponsePojo buildIssueResponseToPojo(Response response) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        CreateIssueResponsePojo objectMapped = objectMapper.readValue(response.getBody().asString(), CreateIssueResponsePojo.class);
        return objectMapped;
    }

    public static void headSecurityValidation(Response response)
    {
        Headers headers = response.getHeaders();
        assertThat(headers.getValue("Strict-Transport-Security"),is("max-age=31536000; includeSubdomains; preload"));
        assertThat(headers.getValue("X-Content-Type-Options"),is("nosniff"));
        assertThat(headers.getValue("X-XSS-Protection"),is("0"));
        assertThat(headers.getValue("Content-Security-Policy"),is("default-src 'none'"));
    }
}
