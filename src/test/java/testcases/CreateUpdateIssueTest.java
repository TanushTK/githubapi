package testcases;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import pojo.CreateIssueResponsePojo;
import uitls.ProviderManager;

import static uitls.BuilderClass.buildCreateIssueBody;
import static uitls.BuilderClass.buildHeaders;
import static uitls.BuilderClass.buildUpdateIssueBody;
import static uitls.ResponseBuilderClass.buildIssueResponseToPojo;
import static uitls.ResponseBuilderClass.headSecurityValidation;

public class CreateUpdateIssueTest {
    private int id;

    @Test(invocationCount = 5)
    public void createIssueValidCase() throws JsonProcessingException {
        String apiUrl = ProviderManager.getBaseURL() + ProviderManager.getEndPoint("issues");
        RequestSpecification requestSpec = RestAssured.given();
        buildCreateIssueBody(requestSpec);
        buildHeaders(requestSpec);
        Response response = requestSpec.post(apiUrl);
        headSecurityValidation(response);
        CreateIssueResponsePojo createIssueResponsePojo = buildIssueResponseToPojo(response);
        id = createIssueResponsePojo.getNumber();
    }

    @Test(dependsOnMethods = {"createIssueValidCase"}, invocationCount = 5)
    public void updateIssueValidCase() throws JsonProcessingException {
        String apiUrl = ProviderManager.getBaseURL() + ProviderManager.getEndPoint("issues") + id;
        RequestSpecification requestSpec = RestAssured.given();
        buildUpdateIssueBody(requestSpec);
        buildHeaders(requestSpec);
        Response response = requestSpec.post(apiUrl);
        headSecurityValidation(response);
        CreateIssueResponsePojo createIssueResponsePojo = buildIssueResponseToPojo(response);
    }
}
