package org.example.springbootft;


import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class StudentController {
 static Logger logger = Logger.getLogger("IMPORT");

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @PostMapping("/students")
    public String create(@RequestBody List<Student> student) {
        String new_line = System.getProperty("line.separator");
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO twn.student (id,name) ").append(new_line);
        sql.append("VALUES (:id,:name)");

        List<Map<String, Object>> list = new ArrayList<>();

        String result = "";
        System.out.println("準備新增資料...............");
        if (student != null) {
            int count = 0;
            for (Student bean : student) {
                Map<String, Object> map = new HashMap<>();
                System.out.println("名稱:" + bean.getName());
                System.out.println("學生碼:" + bean.getId());
                map.put("id", bean.getId());
                map.put("name", bean.getName());
                list.add(map);
                if (list.size() == 10) {
                    namedParameterJdbcTemplate.batchUpdate(sql.toString(), list.toArray(new Map[0]));
                }
                count++;
            }
            if(list.size()>0){
                namedParameterJdbcTemplate.batchUpdate(sql.toString(), list.toArray(new Map[0]));
            }
            System.out.println("總筆數為"+count);

                result = "新增資料............執行成功!";



        } else {
            result = "並未收到任何資料請重新輸入";
        }
        return result;
    }

    @GetMapping("/students/{id}")
    public String read(@PathVariable Integer id) {
        String result = "";
        System.out.println("準備查詢資料...............");
        if (id == 2023031301) {
            result = "執行資料庫的read 操作............執行成功!";
        } else {
            result = "這位學生並不存在......";
        }
        return result;
    }


    @PutMapping("/students/{id}")
    public String update(@PathVariable Integer id, @RequestBody Student student) {
        String result = "";
        System.out.println("準備查詢資料...............");
        if (id == 2023031301) {
            System.out.println("查詢成功!");
            System.out.println("準備更新資料...............");
            System.out.println("更新成功!");
            System.out.println("更名為" + student.getName());
            result = "執行資料庫的put 操作............執行成功!";

        } else {
            result = "這位學生並不存在......";
        }
        return result;
    }


    @DeleteMapping("/students/{id}")
    public String delete(@PathVariable Integer id) {
        String result = "";
        System.out.println("準備查詢資料...............");
        if (id == 2023031301) {
            System.out.println("查詢成功!");
            System.out.println("準備刪除資料...............");
            System.out.println("刪除成功!");
            result = "執行資料庫的delete 操作............執行成功!";
        } else {
            result = "這位學生並不存在......";
        }
        return result;
    }


}
