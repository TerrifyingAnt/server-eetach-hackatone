package thecodingclowns.onboarding.server.API;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import thecodingclowns.onboarding.server.Models.Test;

public interface TestRepository extends CrudRepository<Test, Integer>{
    public List<Test> findByTestId(Integer testId);
}
