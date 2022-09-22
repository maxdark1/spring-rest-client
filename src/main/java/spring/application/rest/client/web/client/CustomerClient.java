package spring.application.rest.client.web.client;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import spring.application.rest.client.web.model.BeerDto;
import spring.application.rest.client.web.model.CustomerDTO;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(value = "sfg.brewery", ignoreUnknownFields = false)
public class CustomerClient {
    private String apihost;
    public  final String CUSTOMER_PATH_V1 = "/api/v1/customer/";
    private final RestTemplate restTemplate;

    public CustomerClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public CustomerDTO getCustomerById(UUID uuid){
        return restTemplate.getForObject(apihost + CUSTOMER_PATH_V1 + uuid.toString(), CustomerDTO.class);
    }

    public URI savedNewCustomer(CustomerDTO costumer){
        return restTemplate.postForLocation(apihost + CUSTOMER_PATH_V1, costumer);
    }

    public void updateCustomer(UUID customerId, CustomerDTO customer){
        restTemplate.put(apihost + CUSTOMER_PATH_V1 + customerId.toString(), customer);
    }

    public void deleteCustomer(UUID customerId){
        restTemplate.delete(apihost + CUSTOMER_PATH_V1 + customerId.toString());
    }

    public void setApihost(String apihost){
        this.apihost = apihost;
    }
}
