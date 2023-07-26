package uitls;

import io.restassured.specification.RequestSpecification;
import pojo.CreateIssueRequestPojo;
import pojo.CreateRepoRequestPojo;
import pojo.UpdateIssueRequestPojo;

import java.util.ArrayList;

import static uitls.DateUitls.getTimeData;


public class BuilderClass
{
    public static String repoName;

    public static void buildHeaders(RequestSpecification requestSpec)
    {
        String accessToken = ProviderManager.getAccessToken("valid");
        requestSpec.header("Content-Type", "application/json");
        requestSpec.header("Authorization", "Bearer " + accessToken);
    }

    public static void buildHeadersWithInvalidToken(RequestSpecification requestSpec)
    {
        String accessToken = ProviderManager.getAccessToken("invalid");
        requestSpec.header("Content-Type", "application/json");
        requestSpec.header("Authorization", "Bearer " + accessToken);
    }

    public static void buildHeadersWithInvalidContentType(RequestSpecification requestSpec)
    {
        String accessToken = ProviderManager.getAccessToken("valid");
        requestSpec.header("Content-Type", "application/text");
        requestSpec.header("Authorization", "Bearer " + accessToken);
    }

    public static void buildBody(RequestSpecification requestSpec)
    {
        CreateRepoRequestPojo createRepoRequestPojo = new CreateRepoRequestPojo();
        repoName = "TestRepoName"+getTimeData();
        createRepoRequestPojo.setName(repoName);
        requestSpec.body(createRepoRequestPojo);
    }

    public static void buildCreateIssueBody(RequestSpecification requestSpec)
    {
        ArrayList<String> array = new ArrayList();
        array.add("Bug");
        CreateIssueRequestPojo createRepoRequestPojo = new CreateIssueRequestPojo();
        createRepoRequestPojo.setTitle("Creating the New Bug"+getTimeData());
        createRepoRequestPojo.setBody("Bug body "+getTimeData());
        createRepoRequestPojo.setLabels(array);
        requestSpec.body(createRepoRequestPojo);
    }

    public static void buildUpdateIssueBody(RequestSpecification requestSpec)
    {
        ArrayList<String> array = new ArrayList();
        array.add("Bug");
        UpdateIssueRequestPojo updateIssueRequestPojo = new UpdateIssueRequestPojo();
        updateIssueRequestPojo.setTitle("Creating the New Bug"+getTimeData());
        updateIssueRequestPojo.setBody("Bug body "+getTimeData());
        updateIssueRequestPojo.setState("Close");
        updateIssueRequestPojo.setLabels(array);
        requestSpec.body(updateIssueRequestPojo);
    }
}
