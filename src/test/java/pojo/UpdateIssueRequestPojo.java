package pojo;

import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;


@Getter
@Data
public class UpdateIssueRequestPojo {
    private String title;
    private String body;
    private String state;
    private ArrayList<String> labels;
}
