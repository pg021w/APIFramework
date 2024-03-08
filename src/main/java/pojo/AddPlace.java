package pojo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class AddPlace {

    private Location location;
    private int accuracy;
    private String name;
    private String phone_number;
    private String address;
    private List<String> types;
    private String website;
    private String language;
}
