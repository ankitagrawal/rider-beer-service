package rider.framework.msscriderbeerservice.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import rider.framework.msscriderbeerservice.domain.Beer;

import java.util.UUID;

public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID> {
}
