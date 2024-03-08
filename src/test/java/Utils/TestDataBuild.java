package Utils;

import pojo.AddPlace;
import pojo.Location;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestDataBuild {

    public static AddPlace getTestDataForAddPlace(String name, String phone_number, String address)
    {
        List list =new ArrayList(Arrays.asList("shoe park","shop"));
        Location location = Location.builder().lat(-38.383494).lng(33.427362).build();
        AddPlace place = AddPlace.builder().location(location)
                .accuracy(50).name(name).phone_number(phone_number)
                .address(address).types(list)
                .website("http: //google.com").language("French").build();

        return place;
    }
}
