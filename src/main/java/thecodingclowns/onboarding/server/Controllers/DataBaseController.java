package thecodingclowns.onboarding.server.Controllers;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import thecodingclowns.onboarding.server.API.ProfessionRepository;
import thecodingclowns.onboarding.server.API.QuestionRepository;
import thecodingclowns.onboarding.server.API.TaskVariantRepository;
import thecodingclowns.onboarding.server.API.TestRepository;
import thecodingclowns.onboarding.server.API.UserRepository;
import thecodingclowns.onboarding.server.Models.Profession;
import thecodingclowns.onboarding.server.Models.Question;
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

    @GetMapping("/get-professions")
    public List<Profession> getAllProfessions(){
        List<Profession> list = (List<Profession>) professionRepository.findAll();
        return list;
    }

    @GetMapping("/get-users")
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();
        for (User user : userRepository.findAll()) {
            users.add(user);
        }
        return users;
    }

    // метод авторизации пользователя по почте и паролю
    @PostMapping("/auth")
    public User authUser(@RequestBody User user) {
        if (userRepository.findByEmail(user.getEmail()).getPassword() == user.getPassword()) {        
            return userRepository.findByEmail(user.getEmail());
        }
        return null;
    }

    @GetMapping("/get-questions")
    public List<Question> getAllQuestions() {
        List<Question> list = (List<Question>) questionRepository.findAll();
        return list;
    }

    @GetMapping("/get-task-variants")
    public List<TaskVariant> getAllTasks() {
        List<TaskVariant> list = (List<TaskVariant>) taskVariantRepository.findAll();
        return list;
    }

    @GetMapping("/get-test")
    public List<Test> getAllTests() {
        List<Test> list = (List<Test>) testRepository.findAll();
        return list;
    }

    @GetMapping("/get-test-by-id")
    public List<Test> getTest(@RequestParam int id) {
        List<Test> list = (List<Test>) testRepository.findByTestId(id);
        return list;
    }
    
}
