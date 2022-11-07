package app.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import app.entity.Passenger;
import app.repository.PassengerRepository;
@Service
@Transactional
public class PassengerServiceImpl implements PassengerService {
	private static final String REDIS_CACHE_VALUE = "passenger";
	@Autowired
	private PassengerRepository repo;
    @Autowired
    private RedisTemplate template;
	
	@Override
	public Passenger getOne(String id) {
		Passenger passenger =  null;
		passenger = (Passenger) template.opsForHash().get(REDIS_CACHE_VALUE, id);
		if(passenger != null)
			return passenger;
		System.out.println("get from db");
		passenger = repo.findById(id).get();
		if(passenger.getId()!= null)
			template.opsForHash().put(REDIS_CACHE_VALUE, passenger.getId(), passenger);
		return passenger;
	}

	@Override
	public List<Passenger> getAll() {
		List<Passenger> ls =(List<Passenger>) template.opsForHash().values(REDIS_CACHE_VALUE);
		if(ls.size() > 0)
			return ls;
		ls = repo.findAll();
		if(ls.size() > 0) {
			Map<String, Passenger> map = new HashMap<>();
			for(Passenger p : ls) {
				map.put(p.getId(), p);
			}
			if(map.size() > 0)
				template.opsForHash().putAll(REDIS_CACHE_VALUE, map);
		}
			
		
		
		System.out.println("get from db");
		return repo.findAll();
	}

	@Override
	public Passenger add(Passenger passenger) {
		template.opsForHash().put(REDIS_CACHE_VALUE, passenger.getId(), passenger);
		return repo.save(passenger);
	}
	

	public boolean delete(String id) {
		try {
			template.opsForHash().delete(REDIS_CACHE_VALUE, id);
			repo.deleteById(id);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	
}
