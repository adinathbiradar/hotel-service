package in.main.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "hotel")
public class Hotel {
	
	   @Id
	   @GeneratedValue(strategy = GenerationType.AUTO)
	   private int id;

	   
	    private String name;
	    private int stars;
	    private String location;
	    private double price;
	    private int totalRooms;
	    
	    @ElementCollection
	    private List<String> images;

	    @ElementCollection
	    private List<String> amenities;

	    @ElementCollection
	    private List<String> features;

	    

}
