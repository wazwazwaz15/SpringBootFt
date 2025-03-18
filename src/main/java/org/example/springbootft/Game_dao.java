package org.example.springbootft;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class Game_dao {
    private String new_line = System.getProperty("line.separator");

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private Logger logger = Logger.getLogger("IMPORT");

    public Game getGameInfo(Integer id) {
        Map<String, Object> map = new HashMap<String, Object>();
        String sql = "select * from public.game where game_serial = :game_serial";
        map.put("game_serial", id);
        List<Game> games = namedParameterJdbcTemplate.query(sql, map, new GameRowMapper());

        if (games.size() > 0) {
            return games.get(0);
        } else {
            logger.warn("No games found");
            return null;
        }

    }
    public String InsertNewGame(Game game) {
        Map<String, Object> map = new HashMap<String, Object>();
        String sql = "INSERT INTO PUBLIC.game (game_serial,version,type,name,price,publish_date) VALUES (:game_serial,:version,:type,:name,:price,:publish_date)";
        map.put("game_serial", game.getGame_serial());
        map.put("version",game.getVersion());
        map.put("type",game.getType());
        map.put("name",game.getName());
        map.put("price",game.getPrice());
        map.put("publish_date",game.getPublish_date());

        int result = namedParameterJdbcTemplate.update(sql,map);

        if (result > 0) {
            return "success";
        } else {
            logger.warn("game already exists");
            return "error";
        }

    }








}
