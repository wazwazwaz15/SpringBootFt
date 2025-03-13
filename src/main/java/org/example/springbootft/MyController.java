package org.example.springbootft;


import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MyController {

    @Autowired
    @Qualifier("hpPrinter")
    private Printer printer;


    @RequestMapping("/test")
    public String test(@RequestParam String name) {
        System.out.println("尋找印表機的名稱為" + name);
        System.out.println("...........正在加載網頁");
        printer.print("這是hpPrinter");
        return "這是hpPrinter";

    }


    @RequestMapping("/test2")
    public String test2(@RequestHeader String info) {
        System.out.println("前端送來的header:"+info);
        printer.print("這是hpPrinter");
        return "這是hpPrinter";

    }

    @RequestMapping("/test2/{game}")
    public String test3(@PathVariable String game) {
        System.out.println("前端送來的Path路徑為:"+game);
//        printer.print("這是hpPrinter");
        return "已收到";

    }


    @RequestMapping("/product")
    public String getProduct(@RequestBody MonsterHunter  monsterHunter) {
        System.out.println("...正在前往產品網頁");
        System.out.println(monsterHunter.getName() + "-" + monsterHunter.getGeneration());
        return "mh2";
    }


}
