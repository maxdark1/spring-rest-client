package spring.application.rest.client.web.client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring.application.rest.client.web.model.BeerDto;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient client;

    @Test
    void getBeerById() {
        BeerDto dto = client.getBeerById(UUID.randomUUID());
        assertNotNull(dto);
    }

    @Test
    void testSaveNewBeer(){
        BeerDto dto = BeerDto.builder().beerName("New Beer").build();
        URI uri = client.savedNewBeer(dto);
        assertNotNull(uri);
        System.out.println(uri.toString());
    }

    @Test
    void  testUpdateBeer(){
        BeerDto dto = BeerDto.builder().beerName("Updated Beer").build();
        client.updateBeer(UUID.randomUUID(), dto);
    }

    @Test
    void testDeleteBeer(){
        client.deleteBeer(UUID.randomUUID());
    }
}