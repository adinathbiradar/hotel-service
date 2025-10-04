package in.main.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.main.model.Hotel;
import in.main.service.HotelService;
import java.util.List;


@Controller
@RestController
@CrossOrigin(origins = {
	    "http://localhost:4200",
	    "https://hotelbookingbyadinath.netlify.app"
	})
@RequestMapping("/hotels")
public class HotelController {

	
	private final HotelService hotelService;

	public HotelController(HotelService hotelservice) {
		this.hotelService=hotelservice;
	}
	
	@GetMapping
	public List<Hotel> getAllHotels(){
		return hotelService.getAllHotels();
	}
	
	@GetMapping("/{id}")
	public Hotel getHotelById(@PathVariable int id) {
		return hotelService.getHotelById(id);
	}
	
	@PostMapping
	public Hotel saveHotel(@RequestBody Hotel hotel) {
		return hotelService.saveHotel(hotel);
	}
	
	@DeleteMapping("/{id}")
	public void deleteHotel(@PathVariable int id) {
		hotelService.deleteHotel(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Hotel> updateHotel(@PathVariable  int id,@RequestBody Hotel hotel) {
		Hotel updated = hotelService.updateHotel(id, hotel);
		if(updated!=null) {
			return ResponseEntity.ok(updated);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
}
