package vttp.batch5.paf.Day1.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import vttp.batch5.paf.Day1.models.Game;

import static vttp.batch5.paf.Day1.repository.Queries.*;

import java.util.LinkedList;
import java.util.List;

@Repository
public class GameRepository {
    
    @Autowired
    private JdbcTemplate template;

    //takes in a custom counter
    public List<Game> getGames(int count){

        SqlRowSet rs = template.queryForRowSet(SQL_SELECT_GAME_COUNT, count);
        List<Game> results = new LinkedList<>();

        //will return true if there are records to read
        //next() will return true if there are rows
        //so while there are rows, loop through each rows 
        while(rs.next()){
            results.add(Game.toMovie(rs));
        }

        return results;
    }

    //for default
    //make the above one flexible for other uses
    public List<Game> getGames(){
        return getGames(5);
    }

}
