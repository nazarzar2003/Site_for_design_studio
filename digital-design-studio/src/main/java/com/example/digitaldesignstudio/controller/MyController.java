package com.example.digitaldesignstudio.controller;

import com.example.digitaldesignstudio.model.Review;
import com.example.digitaldesignstudio.repo.ReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/")
public class MyController {
    private final ReviewRepo reviewRepo;

    @Autowired
    public MyController(ReviewRepo reviewRepo) {
        this.reviewRepo = reviewRepo;
    }

    @GetMapping
    public ModelAndView getIndex() {

        ModelAndView mav = new ModelAndView();
        List<Review> reviews = (List<Review>) reviewRepo.findAll();
        mav.addObject("reviews", reviews); // Добавить данные модели
        mav.setViewName("index"); // Установить имя представления
        return mav;
    }

    @PostMapping
    public String createReview(@RequestParam("name") String username, @RequestParam("message") String message){
        reviewRepo.save(new Review(username, message));
        return "redirect:/";
    }

    @PostMapping("mess")
    public String sendMessage(@RequestParam("email-name") String name, @RequestParam("email-number") String number,
                              @RequestParam("email-email") String email, @RequestParam("email-message") String message) {
        //логіка для відправки
        return "redirect:/";
    }


}
