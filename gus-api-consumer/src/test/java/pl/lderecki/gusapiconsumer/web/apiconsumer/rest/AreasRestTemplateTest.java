package pl.lderecki.gusapiconsumer.web.apiconsumer.rest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AreasRestTemplateTest {

    private AreasRestTemplate testing;

    @BeforeEach
    void setUp() {
        testing = new AreasRestTemplate();
    }

    @Test
    void getAreasShouldReturnNotEmptyListOfAreas() {
        assertTrue(testing.getAreas().contains("\"id\": 1"));
    }
}