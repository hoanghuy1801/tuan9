package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import app.entity.Billing;

@Repository
public interface BillingRepository extends JpaRepository<Billing, String> {
	@Query(nativeQuery = true, value = "select * from billings where passengerId=?1")
	List<Billing> findAllByPassengerId( String passengerId);
}
