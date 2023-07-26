package testcases;


import com.fasterxml.jackson.core.JsonProcessingException;
import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import pojo.CreateInvalidTokenPojo;
import pojo.CreateRepoResponsePOJO;
import uitls.ProviderManager;
import uitls.BuilderClass;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static uitls.BuilderClass.buildHeaders;
import static uitls.BuilderClass.buildBody;
import static uitls.BuilderClass.buildHeadersWithInvalidToken;
import static uitls.ResponseBuilderClass.headSecurityValidation;
import static uitls.ResponseBuilderClass.buildResponseToPojo;
import static uitls.ResponseBuilderClass.buildResponseInvalidToPojo;

public class GitHubRepoCreationTest {
    @Test
    public void createRepoValidCase() throws JsonProcessingException {
        String apiUrl = ProviderManager.getBaseURL() + ProviderManager.getEndPoint("repo");
        RequestSpecification requestSpec = RestAssured.given();
        buildBody(requestSpec);
        buildHeaders(requestSpec);
        Response response = requestSpec.post(apiUrl);
        headSecurityValidation(response);
        CreateRepoResponsePOJO createRepoResponsePOJO = buildResponseToPojo(response);
        assertThat(createRepoResponsePOJO.getName(), is(equalToIgnoringCase(BuilderClass.repoName)));
        assertThat(createRepoResponsePOJO.getId(), notNullValue());
        assertThat(createRepoResponsePOJO.getOwner().getLogin(), equalToIgnoringCase("TanushTK"));
        assertThat(createRepoResponsePOJO.getOpen_issues(), is(greaterThanOrEqualTo(0)));
        assertThat(createRepoResponsePOJO.getUrl(), containsStringIgnoringCase("TanushTK"));
        assertThat(createRepoResponsePOJO.getOwner().getUrl(), containsStringIgnoringCase("TanushTK"));
        assertThat(createRepoResponsePOJO.getOwner().getHtml_url(), containsStringIgnoringCase("TanushTK"));
        assertThat(createRepoResponsePOJO.getOwner().getRepos_url(), containsStringIgnoringCase("TanushTK"));
        assertThat(createRepoResponsePOJO.getOwner().getType(), containsStringIgnoringCase("User"));
        assertThat(createRepoResponsePOJO.getHtml_url(), containsStringIgnoringCase("TanushTK"));
        assertThat(createRepoResponsePOJO.getVisibility(), containsStringIgnoringCase("public"));
        assertThat(createRepoResponsePOJO.getDefault_branch(), containsStringIgnoringCase("main"));
        assertThat(createRepoResponsePOJO.getPermissions().isAdmin(), is(true));
        assertThat(createRepoResponsePOJO.getPermissions().isMaintain(), is(true));
        assertThat(createRepoResponsePOJO.getPermissions().isPush(), is(true));
        assertThat(createRepoResponsePOJO.getPermissions().isTriage(), is(true));
        assertThat(createRepoResponsePOJO.getPermissions().isPull(), is(true));
    }

    @Test
    @Description("Create Repo using Invalid Bearer Token")
    public void createRepoInValidCase() throws JsonProcessingException {
        String apiUrl = ProviderManager.getBaseURL() + ProviderManager.getEndPoint("repo");
        RequestSpecification requestSpec = RestAssured.given();
        buildBody(requestSpec);
        buildHeadersWithInvalidToken(requestSpec);
        Response response = requestSpec.post(apiUrl);
        headSecurityValidation(response);
        CreateInvalidTokenPojo createInvalidTokenPojo = buildResponseInvalidToPojo(response);
        assertThat(createInvalidTokenPojo.getMessage(), equalToIgnoringCase("Bad credentials"));
        assertThat(createInvalidTokenPojo.getDocumentation_url(), equalToIgnoringCase("https://docs.github.com/rest"));
    }

    @Test
    @Description("Create Repo using Invalid Base URL")
    public void createRepoInValidEndPoint() throws JsonProcessingException {
        String apiUrl = ProviderManager.getBaseURL() + ProviderManager.getEndPoint("invalidrepo");
        RequestSpecification requestSpec = RestAssured.given();
        buildBody(requestSpec);
        buildHeadersWithInvalidToken(requestSpec);
        Response response = requestSpec.post(apiUrl);
        headSecurityValidation(response);
        System.out.println(response.prettyPrint());
        CreateInvalidTokenPojo createInvalidTokenPojo = buildResponseInvalidToPojo(response);
        assertThat(createInvalidTokenPojo.getMessage(), equalToIgnoringCase("Bad credentials"));
        assertThat(createInvalidTokenPojo.getDocumentation_url(), equalToIgnoringCase("https://docs.github.com/rest"));
    }
}
