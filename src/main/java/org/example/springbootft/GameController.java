package org.example.springbootft;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class GameController {

    private Logger logger = Logger.getLogger("IMPORT");

    @Autowired
    private Game_service game_service;




    @GetMapping("/game")
    public String getGame(Model model) {
        model.addAttribute("game", new Game());
        return "game";
    }


    @PostMapping("/game")
    public String CreateGame(@ModelAttribute  Game game, Model model) {

        String result = game_service.addGame(game);

        if (result.equals("success")) {
            model.addAttribute("game", game);
            return "success";
        } else {
            return "error";
        }


    }


}
