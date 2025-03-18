package org.example.springbootft;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Game_service {
    @Autowired
    private Game_dao game_dao;

    public Game getGame(int id) {
        Game game = game_dao.getGameInfo(id);
        return game;
    }

    public String addGame(Game game) {
        String result = game_dao.InsertNewGame(game);
        return result;
    }

}
