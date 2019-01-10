package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DiceController {

    private Integer[] dice;

    @GetMapping("/rolldice")
    public String askUserForNumber(){
        dice = new Integer[10];
        for (int i=0; i < 10; i++){
            dice[i] = ((int) (Math.random() *  6 + 1));
        }

        return "rolldicelinks";
    }

    @GetMapping("/rolldice/{userNum}")
    public String showResults(@PathVariable String userNum, Model model){
        int counter = 0;
        int userNumConverted = Integer.parseInt(userNum);
        for (int i = 0; i < 10; i++) {
            if (userNumConverted == dice[i]) {
                counter++;
            }
        }
        model.addAttribute("randomNum", dice);
        model.addAttribute("userNum", userNumConverted);

        return "rolldice";
    }
}
