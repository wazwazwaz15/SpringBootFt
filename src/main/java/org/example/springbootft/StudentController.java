package org.example.springbootft;


import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @PostMapping("/students")
    public String create(@RequestBody Student student) {
        String result = "";
        System.out.println("準備新增資料...............");
        if (student != null) {
            System.out.println("名稱:" + student.getName());
            System.out.println("學生碼:" + student.getId());
            result = "執行資料庫的Create 操作............執行成功!";
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
