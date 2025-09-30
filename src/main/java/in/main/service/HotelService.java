package in.main.service;

import org.springframework.stereotype.Service;
import java.util.List;
import in.main.model.Hotel;
import in.main.repository.HotelRepository;

@Service
public class HotelService {

	private final HotelRepository repository;

	public HotelService(HotelRepository repository) {
		this.repository = repository;
	}
	
	public List<Hotel> getAllHotels(){
		return repository.findAll();
	}
	
	public Hotel getHotelById(int id) {
		 return repository.findById(id).orElse(null);
	}
	
	public Hotel saveHotel(Hotel hotel) {
		return repository.save(hotel);
	}
	
	public void deleteHotel(int id) {
		repository.deleteById(id);
	}
	
	public Hotel updateHotel(int id, Hotel updatedHotel) {
		
        return repository.findById(id).map(hotel -> {
            // update fields one by one
            hotel.setName(updatedHotel.getName());
            hotel.setLocation(updatedHotel.getLocation());
            hotel.setStars(updatedHotel.getStars());
            hotel.setPrice(updatedHotel.getPrice());
            hotel.setAmenities(updatedHotel.getAmenities());
            hotel.setFeatures(updatedHotel.getFeatures());
            hotel.setImages(updatedHotel.getImages());

            // save changes
            return repository.save(hotel);
        }).orElse(null); // return null if not found
    }
	
	 
}
