package Utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

public class utils {

    protected static String place_id = null;
    protected static RequestSpecification req;
    protected static Response res;

    static RequestSpecification requestSpecification;

    public RequestSpecification requestSpecification() throws IOException {

        if (requestSpecification == null) {
            FileInputStream file = new FileInputStream("src/test/resources/global.properties");
            Properties properties = new Properties();
            properties.load(file);

            FileOutputStream fileOutputStream = new FileOutputStream("log.txt");
            PrintStream printStream = new PrintStream(fileOutputStream);
            requestSpecification = new RequestSpecBuilder().setBaseUri(properties.getProperty("URI"))
                    .addQueryParam("key", "qaclick123").addFilter(RequestLoggingFilter.logRequestTo(printStream))
                    .addFilter(ResponseLoggingFilter.logResponseTo(printStream)).build();


        }
        return requestSpecification;
    }

    public String getJsonValue(String key, Response res)
    {
        JsonPath jsonPath = new JsonPath(res.asString());
        String value=jsonPath.getString(key);
        return value;
    }
}
