package vttp.batch5.paf.Day1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vttp.batch5.paf.Day1.models.Game;
import vttp.batch5.paf.Day1.repository.GameRepository;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepo;

    // default return 5
    // good to have hard stop
    // minimize resources
    public List<Game> getGames() {
        return gameRepo.getGames(5);
    }

    // overloading method custom limits.
    public List<Game> getGames(int count) {
        return gameRepo.getGames(count);
    }
}