package com.example.demo.controllers;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest(webEnvironment =  SpringBootTest.WebEnvironment.DEFINED_PORT)
class AdderControllerTest {



    @BeforeEach
     void beforeAll() {
        RestAssured.delete("http://localhost:8080/adder");
    }

    @Test
    void getTest() {
        given().get("http://localhost:8080/adder/current").then().statusCode(200).assertThat().body(equalTo("0"));
    }
    @Test
    void add() {

    }

    @Test
    void postTest() {
        RestAssured.with().param("num", 10).when().post("http://localhost:8080/adder").then().statusCode(200).assertThat().body(equalTo("10"));
    }

    @Test
    void delete() {
    }



    @Test
    void test_Put_01(){
        given().param("num",3).when().put("http://localhost:8080/adder").then().statusCode(200).body(equalTo("3"));
    }

    @Test
    void test_Put_02(){
        given().param("num",3).when().put("http://localhost:8080/adder").then().statusCode(200).body(equalTo("3"));
        given().param("num",6).when().put("http://localhost:8080/adder").then().statusCode(200).body(equalTo("9"));
        given().param("num",1).when().put("http://localhost:8080/adder").then().statusCode(200).body(equalTo("10"));
    }
}