package thecodingclowns.onboarding.server.API;

import org.springframework.data.repository.CrudRepository;

import thecodingclowns.onboarding.server.Models.TaskVariant;

public interface TaskVariantRepository extends CrudRepository<TaskVariant, Integer>{
    
}
