package org.example.springbootft;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GameRowMapper implements RowMapper<Game> {

    @Override
    public Game mapRow(ResultSet rs, int rowNum) throws SQLException {
        Game game = new Game();
        game.setGame_serial(rs.getInt("game_serial"));
        game.setName(rs.getString("name"));
        game.setPrice(rs.getBigDecimal("price"));
        game.setType(rs.getString("type"));
        game.setPublish_date(rs.getTimestamp("publish_date"));
        return game;
    }
}
