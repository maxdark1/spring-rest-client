package spring.application.rest.client.web.client;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import spring.application.rest.client.web.model.BeerDto;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(value = "sfg.brewery", ignoreUnknownFields = false)
public class BreweryClient {
    private String apihost;
    public  final String BEER_PATH_V1 = "/api/v1/beer/";
    private final RestTemplate restTemplate;

    public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public BeerDto getBeerById(UUID uuid){
        return restTemplate.getForObject(apihost + BEER_PATH_V1 + uuid.toString(), BeerDto.class);
    }

    public URI savedNewBeer(BeerDto beer){
        return restTemplate.postForLocation(apihost + BEER_PATH_V1, beer);
    }

    public void updateBeer(UUID beerId, BeerDto beer){
        restTemplate.put(apihost + BEER_PATH_V1 + beerId.toString(), beer);
    }

    public void deleteBeer(UUID beerId){
        restTemplate.delete(apihost + BEER_PATH_V1 + beerId.toString());
    }
    public void setApihost(String apihost){
        this.apihost = apihost;
    }
}
