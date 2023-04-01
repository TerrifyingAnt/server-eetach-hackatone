package thecodingclowns.onboarding.server.API;

import org.springframework.data.repository.CrudRepository;

import thecodingclowns.onboarding.server.Models.Result;

public interface Resultrepository extends CrudRepository<Result, Integer>{
    
}
