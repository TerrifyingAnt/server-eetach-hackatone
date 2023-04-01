package thecodingclowns.onboarding.server.API;

import org.springframework.data.repository.CrudRepository;

import thecodingclowns.onboarding.server.Models.Profession;

public interface ProfessionRepository extends CrudRepository<Profession, Integer> {
    public Profession findByTitle(String profession);
    
}
