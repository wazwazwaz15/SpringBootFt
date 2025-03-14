package org.example.springbootft;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PhoneController {

    private static Logger logger = Logger.getLogger("IMPORT");
    @Autowired
    private NamedParameterJdbcTemplate jdbc;


    @GetMapping("/phone/{id}")
    public String readPhone(@PathVariable int id) {
        String sql = "select * from public.apple where id = :id";

        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        List<Phone> beans = jdbc.query(sql, map, new PhoneRowMapper());
        String message = "";

        if (beans.size() == 0) {
            message = "手機型號並不存在";
            logger.warn(message);
        } else {
            for (Phone bean : beans) {
                message = "型號:" + bean.getId() + "\n" + "顏色:" + bean.getColor() + "\n" + "價格:" + bean.getPrice();
                logger.info(message);
            }
        }
        return message;
    }

    @PostMapping("/phone")
    public String createPhone(@RequestBody Phone phone) {

        Map<String, Object> map = new HashMap<>();
        String sql = "INSERT INTO public.apple VALUES (:id, :color, :price) ";
        map.put("id", phone.getId());
        map.put("color", phone.getColor());
        map.put("price", phone.getPrice());
        int result = jdbc.update(sql, map);
        if (result == 1) {
            logger.info("新增成功");
            return "SUCCESS";
        } else {
            logger.error("新增失敗");
            return "ERROR";
        }

    }


}
