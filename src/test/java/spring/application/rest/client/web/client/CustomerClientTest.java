package spring.application.rest.client.web.client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring.application.rest.client.web.model.BeerDto;
import spring.application.rest.client.web.model.CustomerDTO;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerClientTest {
    @Autowired
    CustomerClient client;

    @Test
    void getCustomerById() {
        CustomerDTO dto = client.getCustomerById(UUID.randomUUID());
        assertNotNull(dto);
    }

    @Test
    void testSaveNewCustomer(){
        CustomerDTO dto = CustomerDTO.builder().name("New Client").build();
        URI uri = client.savedNewCustomer(dto);
        assertNotNull(uri);
        System.out.println(uri.toString());
    }

    @Test
    void  testUpdateCustomer(){
        CustomerDTO dto = CustomerDTO.builder().name("Updated Customer").build();
        client.updateCustomer(UUID.randomUUID(), dto);
    }

    @Test
    void testDeleteCustomer(){
        client.deleteCustomer(UUID.randomUUID());
    }
}