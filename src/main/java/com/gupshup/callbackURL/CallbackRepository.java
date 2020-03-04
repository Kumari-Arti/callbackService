package com.gupshup.callbackURL;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface CallbackRepository extends CrudRepository<Callback, Long>{
	
	List<Callback> findByRequestId(long requestId);
}
