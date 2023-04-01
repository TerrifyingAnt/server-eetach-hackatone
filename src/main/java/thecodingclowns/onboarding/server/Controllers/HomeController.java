package thecodingclowns.onboarding.server.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


import thecodingclowns.onboarding.server.API.ThemeRepository;
import thecodingclowns.onboarding.server.Models.Theme;
import thecodingclowns.onboarding.server.Models.Question;

@Controller
public class HomeController {

    @Autowired
    ThemeRepository themeRepository;

    @GetMapping("/admin")
    public String showHomePage(@RequestParam("question") String question,
        @RequestParam("option1") String option1,
        @RequestParam("option2") String option2,
        @RequestParam("option3") String option3,
        @RequestParam("option4") String option4,
        @RequestParam("theme") String theme,
        @RequestParam("sourcePath") String path,
        Model model) {

        Question questionObj = new Question();
        questionObj.setTitle(question);
        questionObj.setTheme(theme); 
        if(path != null){
            questionObj.setSourcePath(path);
        }
        Answer answer1 = new Answer();
        answer1.setTitle(option1);
        Answer answer2 = new Answer();
        answer2.setTitle(option2);
        Answer answer3 = new Answer();
        answer3.setTitle(option3);
        Answer answer4 = new Answer();
        answer4.setTitle(option4);


        List<String> themes = new ArrayList<>();
        for(Theme theme1: themeRepository.findAll()){
            themes.add(theme1.getTitle());
        }

        model.addAttribute("themes", themes);
        System.out.println(themes);
        return "Admin";
    }
}


