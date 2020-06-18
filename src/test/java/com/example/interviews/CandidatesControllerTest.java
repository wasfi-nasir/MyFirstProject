package com.example.interviews;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;

public class CandidatesControllerTest {

    @BeforeEach
    void setup() throws Exception{
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;

    }

}
