package pojo;

import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class CreateInvalidTokenPojo {
    private String message;
    private String documentation_url;
}
