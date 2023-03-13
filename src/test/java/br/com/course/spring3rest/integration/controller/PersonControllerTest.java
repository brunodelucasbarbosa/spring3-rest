package br.com.course.spring3rest.integration.controller;

import br.com.course.spring3rest.config.TestConfig;
import br.com.course.spring3rest.dto.PersonDTOTest;
import br.com.course.spring3rest.integration.AbstractIntegrationTest;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.DeserializationFeature;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import static io.restassured.RestAssured.given;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PersonControllerTest extends AbstractIntegrationTest {

    private static RequestSpecification specification;
    private static ObjectMapper objectMapper;

    private static PersonDTOTest person;

    @BeforeAll
    public static void setup() {
        objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }

    @Test
    @Order(1)
    public void testCreate() throws IOException {
        mockPerson();

        specification = new RequestSpecBuilder()
                .addHeader(TestConfig.HEADER_PARAM_ORIGIN, "http://localhost:8080")
                .setBasePath("/person")
                .setPort(TestConfig.SERVER_PORT)
                    .addFilter(new RequestLoggingFilter(LogDetail.ALL))
                    .addFilter(new ResponseLoggingFilter(LogDetail.ALL))
                .build();

        var content = given().spec(specification)
                .contentType(TestConfig.CONTENT_TYPE_JSON)
                .body(person)
                .when()
                .post()
                .then()
                .statusCode(200)
                .extract()
                .body()
                .asString();

        PersonDTOTest createdPerson = objectMapper.readValue(content, PersonDTOTest.class);
        person = createdPerson;

        Assertions.assertNotNull(createdPerson);
        Assertions.assertEquals("Test", createdPerson.getFirstName());
        Assertions.assertEquals("LastName", createdPerson.getLastName());
        Assertions.assertEquals("M", createdPerson.getGender());
        Assertions.assertEquals("Test City", createdPerson.getAddress());

    }

    private void mockPerson() {
        person = new PersonDTOTest();
        person.setFirstName("Test");
        person.setLastName("LastName");
        person.setGender("M");
        person.setAddress("Test City");
    }
}
