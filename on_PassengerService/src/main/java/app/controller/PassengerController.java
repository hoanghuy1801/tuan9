package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Passenger;
import app.service.PassengerService;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("/passengers")
public class PassengerController {
	@Autowired
	private PassengerService passengerService;
	int count = 1;

	@GetMapping
	public List<Passenger> findAll() {
		System.out.println("- retry "+ (count++));
		
		return passengerService.getAll();
	}
	
	@GetMapping("/{id}")
	public Passenger getPassenger(@PathVariable String id) {
		System.out.println(id);
		return passengerService.getOne(id);
	}

	@PostMapping()
	public Passenger save(@RequestBody Passenger passenger) {
		return passengerService.add(passenger);
	}


}
