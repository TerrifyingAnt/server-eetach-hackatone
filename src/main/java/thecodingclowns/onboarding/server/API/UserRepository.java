package thecodingclowns.onboarding.server.API;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import thecodingclowns.onboarding.server.Models.Profession;
import thecodingclowns.onboarding.server.Models.User;

public interface UserRepository extends CrudRepository<User, Integer>{
    public User findByEmail(String email);
    public List<User> findAllByProfession(Profession profession);
    
}
