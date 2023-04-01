package thecodingclowns.onboarding.server.API;

import org.springframework.data.repository.CrudRepository;

import thecodingclowns.onboarding.server.Models.Answer;

public interface AnswerRepository extends CrudRepository<Answer, Integer>{
    
}
