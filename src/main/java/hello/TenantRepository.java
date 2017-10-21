package hello;

import org.springframework.data.repository.CrudRepository;
import hello.Tenant;
public interface TenantRepository extends CrudRepository<Tenant, Long> {
	
}
