package rider.framework.msscriderbeerservice.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import rider.framework.msscriderbeerservice.web.model.BeerDto;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest
class BeerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void getBeer() {
        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/beer/"+ UUID.randomUUID().toString()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void saveNewBeer() throws  Exception {

        BeerDto beerDto = BeerDto.builder().build();
        String beerDataJson = objectMapper.writeValueAsString(beerDto);

        mockMvc.perform(post("/api/v1/beer").contentType(MediaType.APPLICATION_JSON)
        .content(beerDataJson))
        .andExpect(status().isCreated());

    }

    @Test
    void handleUpdate() throws  Exception{
        BeerDto beerDto = BeerDto.builder().build();
        String beerDataJson = objectMapper.writeValueAsString(beerDto);

        mockMvc.perform(put("/api/v1/beer/" + UUID.randomUUID().toString()).contentType(MediaType.APPLICATION_JSON)
                .content(beerDataJson))
                .andExpect(status().isNoContent());

    }
}