package app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Passenger;
import app.repository.PassengerRepository;
@Service
@Transactional
public class PassengerServiceImpl implements PassengerService {
	@Autowired
	private PassengerRepository repo;
	@Override
	public Passenger getOne(String id) {
		return repo.findById(id).get();
	}

	@Override
	public List<Passenger> getAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Passenger add(Passenger passenger) {
		// TODO Auto-generated method stub
		return repo.save(passenger);
	}

}
