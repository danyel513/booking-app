package servicePack;

import hotelPack.Hotel;
import org.springframework.web.bind.annotation.CrossOrigin;
import repoPack.HotelRepository;
import databasePack.HotelDBC;
import exceptionsPack.HotelException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200/")
@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private HotelDBC hotelDBC;

    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    public Hotel saveHotel(Hotel hotel) {
        try {
            hotelDBC.insert(hotel);
            return hotel;
        } catch (HotelException e) {
            throw new RuntimeException("Failed to save hotel: " + e.getMessage());
        }
    }
}
