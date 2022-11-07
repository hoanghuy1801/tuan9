package app.controller;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import app.dto.BillingDto;
import app.entity.Billing;
import app.service.BillingService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class BillingController {
	@Autowired
	private BillingService service;
	
	
	
	@PostMapping("/billings")
	public Billing addBill(@RequestBody Billing bill) {
		return service.save(bill);
	}
	@GetMapping("/billings")
	public List<Billing> getAll(){
		return service.getAll();
	}
	
	int count = 1;
	@GetMapping("billings/{id}")
//	@Retry(name = "passenger")
//	@CircuitBreaker(name = "passenger")
	@RateLimiter(name = "passenger")
	public BillingDto getOne(@PathVariable String id) {
		try {
	        System.out.println(Thread.currentThread().getName() + "...running  " +
	                LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
	        
	    } catch (Exception e){
	        System.out.println(e.getLocalizedMessage());
	    }
					
		return service.getOne(id);
	}

}
