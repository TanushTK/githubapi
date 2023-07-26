package pojo;

import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;


@Getter
@Data
public class CreateIssueRequestPojo
{
        private String title;
        private String body;
        private ArrayList<String> labels;
}
