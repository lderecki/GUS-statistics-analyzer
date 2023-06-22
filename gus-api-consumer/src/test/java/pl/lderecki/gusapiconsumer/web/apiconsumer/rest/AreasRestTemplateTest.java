package pl.lderecki.gusapiconsumer.web.apiconsumer.rest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.lderecki.gusapiconsumer.dto.AreaDTO;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AreasRestTemplateTest {

    private AreasRestTemplate testing;

    @BeforeEach
    void setUp() {
        testing = new AreasRestTemplate();
    }

    @Test
    void getAreasShouldReturnNotEmptyListOfAreas() {

        List<AreaDTO> mappedResponse = testing.getAreas();
        assertFalse(mappedResponse.isEmpty());
    }
}