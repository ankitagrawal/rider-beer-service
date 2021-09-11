package rider.framework.msscriderbeerservice.web.mapper;

import org.mapstruct.Mapper;
import rider.framework.msscriderbeerservice.domain.Beer;
import rider.framework.msscriderbeerservice.web.model.BeerDto;


@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

    BeerDto beerToBeerDTo(Beer beer);
    Beer beerDtoToBeer(BeerDto beerDto);


}
