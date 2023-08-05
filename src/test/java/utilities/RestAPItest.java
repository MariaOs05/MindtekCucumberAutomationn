package utilities;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class RestAPItest {
    public static void main(String[] args) {
        /*
       Make GET  yard api call.
       1.Request
          URL-> BaseUrl & Endpoint -> http://3.137.169.132/en-us/api/v2/yards/10/
          Hearers-> Authorisation(token), Accept(application/json)
          Method->GET
       2.Response
       Status code
       Json Data

         */

       Response response = given().baseUri("http://3.137.169.132/en-us/api/v2")
                .and().header("authorization", "Token 9d3994dd2afd7d1d8ae9ecf4d77e45932bb210d6")
                .and().accept("application/json")
                .when().get("/yards/10/");

        System.out.println(response.statusCode());
        System.out.println(response.body().asString());

        /*
        POST  call
        REQUEST
        1.URL -> BaseURL + ENDPOINT
        2. headers -> Authorization(Token), Content-Type(application/json),, Accept(application/json)
        3. Payload/Body -> json
        4.Method POST

        RESPONSE:
        1.Status code-> 201
        2.Body-> json
         */
        Response postResponse = given().baseUri("http://3.137.169.132/en-us/api/v2")
                .and().header("authorization","Token 9d3994dd2afd7d1d8ae9ecf4d77e45932bb210d6" )
                .and().accept("application/json")
                .and().contentType("application/json")
                .and().body("{\n" +
                        "  \"location\": \"maria2\",\n" +
                        "  \"status\": \"active\",\n" +
                        "  \"address\": \"124 high st\",\n" +
                        "  \"apt_suite_company_co\": \"2kl\",\n" +
                        "  \"city\": \"Chicago\",\n" +
                        "  \"state\": \"IL\",\n" +
                        "  \"zip_code\": \"60654\",\n" +
                        "  \"spots\": \"333333\",\n" +
                        "  \"warning\": \"\",\n" +
                        "  \"notes\": \"\",\n" +
                        "  \"yard_picture\": [],\n" +
                        "  \"contacts\": [\n" +
                        "    {\n" +
                        "      \"service_phone\": \"773-574-9994\",\n" +
                        "      \"service_contact_name\": \"\",\n" +
                        "      \"owner_phone\": \"\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"service_phone_number\": [\n" +
                        "    {\n" +
                        "      \"service_phone\": \"773-574-9994\",\n" +
                        "      \"service_contact_name\": \"\",\n" +
                        "      \"owner_phone\": \"\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"owner_phone_number\": [\n" +
                        "    {\n" +
                        "      \"owner_phone\": \"\",\n" +
                        "      \"owner_contact_name\": \"\"\n" +
                        "    }\n" +
                        "  ]\n" +
                        "}")
                .when().post("/yards/");
        System.out.println(postResponse.statusCode());
        System.out.println(postResponse.body().asString());


        /*
        Patch Call
           Request:
           1.URL-> BaseURL+ Endpoint
            2. headers -> Authorization(Token), Acception(application/json),, Accept(application/json)
            3.Payload -> json
            4Method -> PATCH
             RESPONSE:
             1.Status code - 200
             2.Body- json
      */

        Response updateResponse = given().baseUri("http://3.137.169.132/en-us/api/v2")
                .and().header("Authorization","Token 9d3994dd2afd7d1d8ae9ecf4d77e45932bb210d6")
                .and().accept("application/json")
                .and().contentType("application/json")
                .and().body("{\n" +
                        "  \"id\": 59,\n" +
                        "  \"location\": \"maria os 3 \",\n" +
                        "  \"name\": \"Y59\",\n" +
                        "  \"status\": \"active\",\n" +
                        "  \"address\": \"124 high st\",\n" +
                        "  \"apt_suite_company_co\": \"2kl\",\n" +
                        "  \"city\": \"Chicago\",\n" +
                        "  \"state\": \"IL\",\n" +
                        "  \"zip_code\": \"60654\",\n" +
                        "  \"spots\": 333333,\n" +
                        "  \"warning\": \"\",\n" +
                        "  \"notes\": \"\",\n" +
                        "  \"contacts\": [\n" +
                        "    {\n" +
                        "      \"service_phone\": \"773-574-9994\",\n" +
                        "      \"service_contact_name\": \"\",\n" +
                        "      \"owner_phone\": \"\",\n" +
                        "      \"owner_contact_name\": \"\",\n" +
                        "      \"id\": 156\n" +
                        "    }\n" +
                        "  ]\n" +
                        "}")
                .when().patch("/yards/59/");
        System.out.println(updateResponse.statusCode());
        System.out.println(updateResponse.body().asString());

    }
}
