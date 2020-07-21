package io.gupshup.callbackService.repository;

import java.util.List;

import io.gupshup.callbackService.model.Callback;
import org.springframework.data.repository.CrudRepository;

public interface CallbackRepository extends CrudRepository<Callback, Long>{
	
	List<Callback> findByRequestId(long requestId);

}
