package app.service;

import java.util.List;

import app.dto.BillingDto;
import app.entity.Billing;

public interface BillingService {
		Billing save(Billing bill);
		BillingDto getOne(String id);
		List<Billing> getAll();
}
