package rider.framework.msscriderbeerservice.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import rider.framework.msscriderbeerservice.domain.Beer;
import rider.framework.msscriderbeerservice.repositories.BeerRepository;

import java.math.BigDecimal;

@Component
public class BeerLoader implements CommandLineRunner {


    private  final  BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();

    }

    private void loadBeerObjects(){
      if(beerRepository.count()==0){

          beerRepository.save(
                  Beer.builder().beerName("mango bobs")
                  .beerStyle("abbc")
                  .quantityToBrew(30)
                  .minOnHand(12)
                  .upc(5656565656565L)
                  .price(new BigDecimal("12.95")).build());


          beerRepository.save(
                  Beer.builder().beerName("Galaxy bobs")
                          .beerStyle("pale_ale")
                          .quantityToBrew(30)
                          .minOnHand(12)
                          .upc(5656565653465L)
                          .price(new BigDecimal("22.95")).build());



      }

        System.out.println("No of bear objects " +  beerRepository.count());

    }
}
