package thecodingclowns.onboarding.server.Controllers;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import thecodingclowns.onboarding.server.API.ProfessionRepository;
import thecodingclowns.onboarding.server.API.QuestionRepository;
import thecodingclowns.onboarding.server.API.ResultRepository;
import thecodingclowns.onboarding.server.API.TaskVariantRepository;
import thecodingclowns.onboarding.server.API.TestRepository;
import thecodingclowns.onboarding.server.API.UserRepository;
import thecodingclowns.onboarding.server.Models.Profession;
import thecodingclowns.onboarding.server.Models.Question;
import thecodingclowns.onboarding.server.Models.Result;
import thecodingclowns.onboarding.server.Models.TaskVariant;
import thecodingclowns.onboarding.server.Models.Test;
import thecodingclowns.onboarding.server.Models.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api")
public class DataBaseController {
    

    @Autowired
    ProfessionRepository professionRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    TaskVariantRepository taskVariantRepository;

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    TestRepository testRepository;

    @Autowired
    ResultRepository resultRepository;


    // метод для получения пользователей (пароли не передаются)
    // хз, тут костыль конечно, но с другой стороны у нас mvp...
    @GetMapping("/get-users")
    public List<User> getAllUsers(@RequestParam(name = "filter", required = false) String filter, @RequestParam(name = "profession", required = false) String profession) {
        List<User> users = new ArrayList<User>();
        if(filter != null) {
            if(filter.indexOf("8", 0) != -1) {
                for (User user : userRepository.findByPhoneNumberContaining(filter)) {
                    user.setPassword("");
                    users.add(user);
                }
            }   
            else
            for (User user : userRepository.findByFullNameContaining(filter)) {
                user.setPassword("");
                users.add(user);
            }
        }
        if(profession != null && users.size() > 0) {
            List<User> newUsers = new ArrayList<User>();
            for(User user : users) {
                if(user.getProfession().getTitle().equals(profession)) {
                    newUsers.add(user);
                }
            }
            users = new ArrayList<User>(newUsers);
        }
        else
        if(profession != null) {
            for (User user : userRepository.findAllByProfession(professionRepository.findByTitle(profession))) {
                user.setPassword("");
                users.add(user);
            }
        }
        else
        if(users.size() == 0)
        for (User user : userRepository.findAll()) {
            user.setPassword("");
            users.add(user);
        }
        return users;
    }

    // метод авторизации пользователя по почте и паролю
    @PostMapping("/auth")
    public ResponseEntity<User> authUser(@RequestBody User user) {
        if (userRepository.findByEmail(user.getEmail()).getPassword() == user.getPassword()) {        
            return ResponseEntity.ok(userRepository.findByEmail(user.getEmail()));
        }
        return ResponseEntity.badRequest().build();
    }

    // метод для получения тестового задания
    @GetMapping("/get-test/{id}")
    public List<Test> getTest(@PathVariable("id") int id) {
        List<Test> list = (List<Test>) testRepository.findByTestId(id);
        return list;
    }

    @GetMapping("/get-test")
    public List<Test> getAllTests() {
        List<Test> list = (List<Test>) testRepository.findAll();
        return list;
    }


    // метод для получения результатов тестирования пользователя TODO
    @GetMapping("/get-result")
    public List<Result> getResult() {
        List<Result> list = (List<Result>) resultRepository.findAll();
        return list;
    }  

    // метод для загрузки результатов
    @PostMapping("/upload-result")
    public void uploadTestResult(@RequestBody List<Result> resultList) {
        for(int i = 0; i < resultList.size(); i++)
            resultRepository.save(resultList.get(i)); 
    }  





    
}
