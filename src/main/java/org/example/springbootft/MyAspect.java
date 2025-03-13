package org.example.springbootft;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


/*
/ 什麼是 Spring AOP？
  AOP 的概念，就是「透過切面，統一的去處理方法之間的共同邏輯」
 */


@Aspect
@Component
public class MyAspect {



//  前面的這個 @Before，他指定的就是 「時機點」
//  在 @Before 後面的小括號中的程式，稱為「切入點 (Pointcut)」，即是去指定哪個方法要被切
@Before("execution(* org.example.springbootft.HpPrinter.*(..))")
    public void before(){
        System.out.println("before");
    }



}
