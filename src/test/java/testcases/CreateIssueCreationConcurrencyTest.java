package testcases;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import pojo.CreateIssueResponsePojo;
import uitls.ProviderManager;

import static uitls.BuilderClass.*;
import static uitls.ResponseBuilderClass.buildIssueResponseToPojo;
import static uitls.ResponseBuilderClass.headSecurityValidation;

public class CreateIssueCreationConcurrencyTest
{
    final int NUMBER_OF_USERS_5 = 5;
    final int NUMBER_OF_USERS_7 = 7;
    final int NUMBER_OF_USERS_10 = 10;

    @Test(threadPoolSize = NUMBER_OF_USERS_5, invocationCount = NUMBER_OF_USERS_5)
    public void testApiWith5ConcurrentUsers() throws JsonProcessingException {
        String apiUrl = ProviderManager.getBaseURL()+ ProviderManager.getEndPoint("issues");
        RequestSpecification requestSpec = RestAssured.given();
        buildCreateIssueBody(requestSpec);
        buildHeaders(requestSpec);
        Response response = requestSpec.post(apiUrl);
        headSecurityValidation(response);
        CreateIssueResponsePojo createIssueResponsePojo = buildIssueResponseToPojo(response);
        int id = createIssueResponsePojo.getNumber();
        apiUrl = ProviderManager.getBaseURL()+ ProviderManager.getEndPoint("issues")+id;
        buildUpdateIssueBody(requestSpec);
        buildHeaders(requestSpec);
        response = requestSpec.post(apiUrl);
        headSecurityValidation(response);
    }

    @Test(threadPoolSize = NUMBER_OF_USERS_7, invocationCount = NUMBER_OF_USERS_7)
    public void testApiWith7ConcurrentUsers() throws JsonProcessingException {
        String apiUrl = ProviderManager.getBaseURL()+ ProviderManager.getEndPoint("issues");
        RequestSpecification requestSpec = RestAssured.given();
        buildCreateIssueBody(requestSpec);
        buildHeaders(requestSpec);
        Response response = requestSpec.post(apiUrl);
        headSecurityValidation(response);
        CreateIssueResponsePojo createIssueResponsePojo = buildIssueResponseToPojo(response);
        int id = createIssueResponsePojo.getNumber();
        apiUrl = ProviderManager.getBaseURL()+ ProviderManager.getEndPoint("issues")+id;
        buildUpdateIssueBody(requestSpec);
        buildHeaders(requestSpec);
        response = requestSpec.post(apiUrl);
        headSecurityValidation(response);
    }

    @Test(threadPoolSize = NUMBER_OF_USERS_10, invocationCount = NUMBER_OF_USERS_10)
    public void testApiWith10ConcurrentUsers() throws JsonProcessingException {
        String apiUrl = ProviderManager.getBaseURL()+ ProviderManager.getEndPoint("issues");
        RequestSpecification requestSpec = RestAssured.given();
        buildCreateIssueBody(requestSpec);
        buildHeaders(requestSpec);
        Response response = requestSpec.post(apiUrl);
        headSecurityValidation(response);
        CreateIssueResponsePojo createIssueResponsePojo = buildIssueResponseToPojo(response);
        int id = createIssueResponsePojo.getNumber();
        apiUrl = ProviderManager.getBaseURL()+ ProviderManager.getEndPoint("issues")+id;
        buildUpdateIssueBody(requestSpec);
        buildHeaders(requestSpec);
        response = requestSpec.post(apiUrl);
        headSecurityValidation(response);
    }
}
