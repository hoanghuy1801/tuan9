package app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import app.entity.Passenger;

@Service
public interface PassengerService {
	Passenger getOne(String id);
	List<Passenger> getAll();
	Passenger add(Passenger passenger);

}
