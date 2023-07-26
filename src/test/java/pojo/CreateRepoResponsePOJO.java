package pojo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Data
public class CreateRepoResponsePOJO {
    private int id;
    private String node_id;
    private String name;
    private String full_name;
    private boolean myprivate;
    private Owner owner;
    private String html_url;
    private Object description;
    private boolean fork;
    private String url;
    private String forks_url;
    private String keys_url;
    private String collaborators_url;
    private String teams_url;
    private String hooks_url;
    private String issue_events_url;
    private String events_url;
    private String assignees_url;
    private String branches_url;
    private String tags_url;
    private String blobs_url;
    private String git_tags_url;
    private String git_refs_url;
    private String trees_url;
    private String statuses_url;
    private String languages_url;
    private String stargazers_url;
    private String contributors_url;
    private String subscribers_url;
    private String subscription_url;
    private String commits_url;
    private String git_commits_url;
    private String comments_url;
    private String issue_comment_url;
    private String contents_url;
    private String compare_url;
    private String merges_url;
    private String archive_url;
    private String downloads_url;
    private String issues_url;
    private String pulls_url;
    private String milestones_url;
    private String notifications_url;
    private String labels_url;
    private String releases_url;
    private String deployments_url;
    private Date created_at;
    private Date updated_at;
    private Date pushed_at;
    private String git_url;
    private String ssh_url;
    private String clone_url;
    private String svn_url;
    private Object homepage;
    private int size;
    private int stargazers_count;
    private int watchers_count;
    private Object language;
    private boolean has_issues;
    private boolean has_projects;
    private boolean has_downloads;
    private boolean has_wiki;
    private boolean has_pages;
    private boolean has_discussions;
    private int forks_count;
    private Object mirror_url;
    private boolean archived;
    private boolean disabled;
    private int open_issues_count;
    private Object license;
    private boolean allow_forking;
    private boolean is_template;
    private boolean web_commit_signoff_required;
    private ArrayList<Object> topics;
    private String visibility;
    private int forks;
    private int open_issues;
    private int watchers;
    private String default_branch;
    private Permissions permissions;
    private boolean allow_squash_merge;
    private boolean allow_merge_commit;
    private boolean allow_rebase_merge;
    private boolean allow_auto_merge;
    private boolean delete_branch_on_merge;
    private boolean allow_update_branch;
    private boolean use_squash_pr_title_as_default;
    private String squash_merge_commit_message;
    private String squash_merge_commit_title;
    private String merge_commit_message;
    private String merge_commit_title;
    private int network_count;
    private int subscribers_count;

    @Getter
    @Data
    public static class Owner {
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

    @Getter
    @Data
    public static class Permissions {
        private boolean admin;
        private boolean maintain;
        private boolean push;
        private boolean triage;
        private boolean pull;
    }
}
