package Utils;

import lombok.Getter;

@Getter
public enum APIResources {


    AddPlace("/maps/api/place/add/json"),
    GetPlace("/maps/api/place/get/json"),
    DeletePlace("/maps/api/place/delete/json");
    private String resource;

    APIResources(String resource) {
        this.resource= resource;
    }

}
