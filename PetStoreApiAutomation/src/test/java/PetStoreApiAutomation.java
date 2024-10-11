import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

public class PetStoreApiAutomation {

    @Test
    @Description("Create a new user in the PetStore API")
    public void createUserInfo() {
        String payLoad = "{\n" +
                "  \"id\": 456,\n" +
                "  \"username\": \"doktor\",\n" +
                "  \"firstName\": \"aslı\",\n" +
                "  \"lastName\": \"dağlı\",\n" +
                "  \"email\": \"eurhan@gmail.com\",\n" +
                "  \"password\": \"123456789\",\n" +
                "  \"phone\": \"1234567\",\n" +
                "  \"userStatus\": 0\n" +
                "}";
        RestAssured.given()
                .body(payLoad)
                .contentType(ContentType.JSON)
                .when()
                .post("https://petstore.swagger.io/v2/user")
                .then()
                .statusCode(200);
    }

    @Test
    @Description("Update user information in the PetStore API")
    public void updateUserInfo() {
        String payLoad = "{\n" +
                "  \"id\": 775,\n" +
                "  \"username\": \"developer\",\n" +
                "  \"firstName\": \"reyhan\",\n" +
                "  \"lastName\": \"kağnı\",\n" +
                "  \"email\": \"e@i.c\",\n" +
                "  \"password\": \"12345\",\n" +
                "  \"phone\": \"12345\",\n" +
                "  \"userStatus\": 0\n" +
                "}";
        RestAssured.given()
                .body(payLoad)
                .contentType(ContentType.JSON)
                .when()
                .put("https://petstore.swagger.io/v2/user/doktor")
                .then()
                .statusCode(200);
    }

    @Test
    @Description("Retrieve user information from the PetStore API")
    public void getUserInfo() {
        RestAssured.given()
                .when()
                .get("https://petstore.swagger.io/v2/user/doktor")
                .then()
                .statusCode(200);
    }

    @Test
    @Description("Delete a user from the PetStore API")
    public void deleteUserInfo() {
        RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .delete("https://petstore.swagger.io/v2/user/doktor")
                .then()
                .statusCode(200);
    }

    @Test
    @Description("Login a user to the PetStore API")
    public void loginUserInfo() {
        RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .get("https://petstore.swagger.io/v2/user/login?username=doktor&password=123456789")
                .then()
                .statusCode(200);
    }

    @Test
    @Description("Logout a user from the PetStore API")
    public void logoutUserInfo() {
        RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .get("https://petstore.swagger.io/v2/user/logout")
                .then()
                .statusCode(200);
    }
}
