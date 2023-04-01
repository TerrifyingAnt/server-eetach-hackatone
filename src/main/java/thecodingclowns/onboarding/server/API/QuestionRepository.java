package thecodingclowns.onboarding.server.API;

import org.springframework.data.repository.CrudRepository;

import thecodingclowns.onboarding.server.Models.Question;

public interface QuestionRepository extends CrudRepository<Question, Integer>{
    
}
