package repoPack;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import hotelPack.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer>
{
}
