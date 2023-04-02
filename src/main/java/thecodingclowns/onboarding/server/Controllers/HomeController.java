package thecodingclowns.onboarding.server.Controllers;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import io.minio.messages.Upload;
import thecodingclowns.onboarding.server.API.ThemeRepository;
import thecodingclowns.onboarding.server.API.QuestionRepository;
import thecodingclowns.onboarding.server.API.AnswerRepository;
import thecodingclowns.onboarding.server.API.TaskVariantRepository;
import thecodingclowns.onboarding.server.API.MinioService;
import thecodingclowns.onboarding.server.Models.Theme;
import thecodingclowns.onboarding.server.Models.FileDto;
import thecodingclowns.onboarding.server.Models.Question;
import thecodingclowns.onboarding.server.Models.Answer;
import thecodingclowns.onboarding.server.Models.TaskVariant;

import org.springframework.http.MediaType;

@Controller
public class HomeController {

    @Autowired
    ThemeRepository themeRepository;

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    AnswerRepository answerRepository;

    @Autowired
    TaskVariantRepository taskVariantRepository;
    
    @Autowired
    MinioService minioService;

    @GetMapping("/admin")
    public String showHomePage(Model model) {
        List<String> themes = new ArrayList<>();
        for(Theme theme1: themeRepository.findAll()){
            themes.add(theme1.getTitle());
        }

        model.addAttribute("themes", themes);
        System.out.println(themes);
        return "Admin";
    }

    @PostMapping(value = "/save-question", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.IMAGE_PNG_VALUE)
    public String saveQuestion(@RequestParam("question") String question,
    @RequestParam("option1") String option1,
    @RequestParam("option2") String option2,
    @RequestParam("option3") String option3,
    @RequestParam("option4") String option4,
    @RequestParam(value = "rightAnswer1", required = false) Boolean rightAnswer1,
    @RequestParam(value = "rightAnswer2", required = false) Boolean rightAnswer2,
    @RequestParam(value = "rightAnswer3", required = false) Boolean rightAnswer3,
    @RequestParam(value = "rightAnswer4", required = false) Boolean rightAnswer4,
    @RequestParam("theme") String theme,
    @RequestPart("picture") FileDto request) {
        Question questionObj = new Question();
        questionObj.setTitle(question);
        questionObj.setTheme(themeRepository.findByTitle(theme)); 
        System.out.println(request.getClass());
        if(request != null){
            questionObj.setSourcePath(request.getTitle());
        }
        questionRepository.save(questionObj);

        Answer answer1 = new Answer();
        answer1.setTitle(option1);
        Answer answer2 = new Answer();
        answer2.setTitle(option2);
        Answer answer3 = new Answer();
        answer3.setTitle(option3);
        Answer answer4 = new Answer();
        answer4.setTitle(option4);

        answerRepository.save(answer1);
        answerRepository.save(answer2);
        answerRepository.save(answer3);
        answerRepository.save(answer4);

        TaskVariant taskVariant1 = new TaskVariant();
        taskVariant1.setQuestion(questionObj);
        taskVariant1.setAnswer(answer1);
        if(rightAnswer1 != null) {
        taskVariant1.setIsTrue(rightAnswer1);
            if(rightAnswer1)
                taskVariant1.setScore(5);
        }
        else {
            taskVariant1.setIsTrue(false);
        }

        TaskVariant taskVariant2 = new TaskVariant();
        taskVariant2.setQuestion(questionObj);
        taskVariant2.setAnswer(answer2);
        taskVariant2.setIsTrue(rightAnswer2);
        if(rightAnswer2 != null) {
            taskVariant2.setIsTrue(rightAnswer4);
            if(rightAnswer2)
                taskVariant2.setScore(5);
        }
        else {
            taskVariant2.setIsTrue(false);
        }
        TaskVariant taskVariant3 = new TaskVariant();
        taskVariant3.setQuestion(questionObj);
        taskVariant3.setAnswer(answer3);
        taskVariant3.setIsTrue(rightAnswer3);
        if(rightAnswer3 != null) {
            taskVariant3.setIsTrue(rightAnswer4);
            if(rightAnswer3)
                taskVariant3.setScore(5);
        }
        else {
            taskVariant3.setIsTrue(false);
        }

        TaskVariant taskVariant4 = new TaskVariant();
        taskVariant4.setQuestion(questionObj);
        taskVariant4.setAnswer(answer4);
        if(rightAnswer4 != null) {
            taskVariant4.setIsTrue(rightAnswer4);
            if(rightAnswer4)
                taskVariant4.setScore(5);
        }
        else {
            taskVariant4.setIsTrue(false);
        }
        
        taskVariantRepository.save(taskVariant1);
        taskVariantRepository.save(taskVariant2);
        taskVariantRepository.save(taskVariant3);
        taskVariantRepository.save(taskVariant4);

        if(request != null) {
            minioService.uploadFile(request);
        }

        return "redirect:/admin";
    }
}


