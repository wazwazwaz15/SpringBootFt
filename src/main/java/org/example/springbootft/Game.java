package org.example.springbootft;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Game {
   public Integer game_serial;
    public String version ;
    public String type;
    public String name;
    public BigDecimal price;
    public  Timestamp publish_date;


    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Integer getGame_serial() {
        return game_serial;
    }

    public void setGame_serial(Integer game_serial) {
        this.game_serial = game_serial;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Timestamp getPublish_date() {
        return publish_date;
    }

    public void setPublish_date(Timestamp publish_date) {
        this.publish_date = publish_date;
    }
}
