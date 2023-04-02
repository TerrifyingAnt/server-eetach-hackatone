package thecodingclowns.onboarding.server.API;

import org.springframework.data.repository.CrudRepository;

import thecodingclowns.onboarding.server.Models.Theme;


public interface ThemeRepository extends CrudRepository<Theme, Integer>{
    public Theme findByTitle(String title);
    
}
