package pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Date;


@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Data
public class CreateIssueResponsePojo {
    private String url;
    private String repository_url;
    private String labels_url;
    private String comments_url;
    private String events_url;
    private String html_url;
    private int id;
    private String node_id;
    private int number;
    private String title;
    private User user;
    private ArrayList<Label> labels;
    private String state;
    private boolean locked;
    private Object assignee;
    private ArrayList<Object> assignees;
    private Object milestone;
    private int comments;
    private Date created_at;
    private Date updated_at;
    private Date closed_at;
    private String author_association;
    private Object active_lock_reason;
    private String body;
    private ClosedBy closed_by;
    private Reactions reactions;
    private String timeline_url;
    private Object performed_via_github_app;
    private String state_reason;

    @JsonIgnoreProperties(ignoreUnknown = true)
    @Getter
    @Data
    public static class ClosedBy {
        private String login;
        private int id;
        private String node_id;
        private String avatar_url;
        private String gravatar_id;
        private String url;
        private String html_url;
        private String followers_url;
        private String following_url;
        private String gists_url;
        private String starred_url;
        private String subscriptions_url;
        private String organizations_url;
        private String repos_url;
        private String events_url;
        private String received_events_url;
        private String type;
        private boolean site_admin;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @Getter
    @Data
    public static class Label {
        private long id;
        private String node_id;
        private String url;
        private String name;
        private String color;
        @JsonProperty("default")
        private boolean mydefault;
        private String description;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @Getter
    @Data
    public static class Reactions {
        private String url;
        private int total_count;
        private int laugh;
        private int hooray;
        private int confused;
        private int heart;
        private int rocket;
        private int eyes;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @Getter
    @Data
    public static class User {
        private String login;
        private int id;
        private String node_id;
        private String avatar_url;
        private String gravatar_id;
        private String url;
        private String html_url;
        private String followers_url;
        private String following_url;
        private String gists_url;
        private String starred_url;
        private String subscriptions_url;
        private String organizations_url;
        private String repos_url;
        private String events_url;
        private String received_events_url;
        private String type;
        private boolean site_admin;
    }
}
