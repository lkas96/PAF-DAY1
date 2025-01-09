package vttp.batch5.paf.Day1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vttp.batch5.paf.Day1.models.Game;
import vttp.batch5.paf.Day1.services.GameService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping
public class GameController {
    @Autowired
    private GameService gameService;

    @GetMapping("/games")
    public ModelAndView getGames(@RequestParam(defaultValue = "5") int count) {
        List<Game> gamesList = gameService.getGames(count);
        ModelAndView mav = new ModelAndView("games");
        mav.addObject("games", gamesList);
        mav.setStatus(HttpStatusCode.valueOf(200));
        return mav;
    }

    @GetMapping("/games2")
    public String getGames(Model model) {
        List<Game> games = gameService.getGames();
        System.out.println(games.toString());
        model.addAttribute("games", games);
        return "games";
    }
    


}
