package org.example.springbootft;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class AppleController {

    private static Logger logger = Logger.getLogger("IMPORT");

//    @Autowired
//    private SessionFactory sessionFactory;

    @Autowired
    private AppleService appleService;
//
//    @GetMapping("/apple/{id}")
//    public Apple readPhone(@PathVariable Long id) {
//        Transaction transaction = null;
//        Apple apple = null;
//        try (Session session = sessionFactory.openSession()) {
//            transaction = session.beginTransaction();
//            apple = session.get(Apple.class, id);
//            transaction.commit();
//
//        }catch (Exception e) {
//            if(transaction != null) {
//                transaction.rollback();
//                logger.error(e);
//            }
//        }
//        return apple;
//    }
//
//
//    @PostMapping("/apple")
//    public String createPhone(@RequestBody Apple apple) {
//        Transaction transaction = null;
//        Session session = null;
//        String message = "Success";
//
//        try {
//            session = sessionFactory.openSession();  // ✅ 讓 Session 手動關閉
//            transaction = session.beginTransaction();
//            session.save(apple);
//            transaction.commit();  // ✅ 交易成功才 commit
//        } catch (Exception e) {
//            message = "error";
//            if (transaction != null && transaction.getStatus().canRollback()) {
//                try {
//                    transaction.rollback();  // ✅ rollback 之前 Session 仍然有效
//                } catch (Exception rollbackEx) {
//                    logger.error("Rollback failed", rollbackEx);
//                }
//            }
//            logger.error("Error in createPhone", e);
//        } finally {
//            if (session != null && session.isOpen()) {
//                session.close();  // ✅ 確保 Session 在所有操作後才關閉
//            }
//        }
//        return message;
//
//    }
//
//
//    @PutMapping("/apple")
//    public String updatePhone(@RequestBody Apple apple) {
//        Transaction transaction = null;
//        Session session = null;
//        String message = "Success";
//
//        try {
//            session = sessionFactory.openSession();  // ✅ 讓 Session 手動關閉
//            transaction = session.beginTransaction();
//
//            session.update(apple);
//            transaction.commit();  // ✅ 交易成功才 commit
//        } catch (Exception e) {
//
//            if (transaction != null && transaction.getStatus().canRollback()) {
//                try {
//                    transaction.rollback();  // ✅ rollback 之前 Session 仍然有效
//                } catch (Exception rollbackEx) {
//                    logger.error("Rollback failed", rollbackEx);
//                }
//            }
//            logger.error("Error in createPhone", e);
//            message = "不存在此ID";
//        } finally {
//            if (session != null && session.isOpen()) {
//                session.close();  // ✅ 確保 Session 在所有操作後才關閉
//            }
//        }
//        return message;
//
//    }
//
//    @DeleteMapping("/apple/{id}")
//    public String deletePhone(@PathVariable Long id) {
//        Transaction transaction = null;
//        Session session = null;
//        String message = "Success";
//
//        try {
//            session = sessionFactory.openSession();  // ✅ 讓 Session 手動關閉
//            transaction = session.beginTransaction();
//            session.delete(session.get(Apple.class, id));
//            transaction.commit();  // ✅ 交易成功才 commit
//        } catch (Exception e) {
//
//            if (transaction != null && transaction.getStatus().canRollback()) {
//                try {
//                    transaction.rollback();  // ✅ rollback 之前 Session 仍然有效
//                } catch (Exception rollbackEx) {
//                    logger.error("Rollback failed", rollbackEx);
//                }
//            }
//            logger.error("Error in createPhone", e);
//            message = "不存在此ID";
//        } finally {
//            if (session != null && session.isOpen()) {
//                session.close();  // ✅ 確保 Session 在所有操作後才關閉
//            }
//        }
//        return message;
//
//    }

    @GetMapping("/apple/all")
    public List<Apple> getAllApples() {
        return appleService.getAllApples();
    }



    @PostMapping("/apple")
    public String getAllApples(@RequestBody List<Apple> apples) {
        String message = "";
        for(Apple apple : apples) {
            try {
                appleService.saveApple(apple);
            }catch (Exception e) {
                logger.error(e);
            }

        }
        message = appleService.getAllApples().toString();
        return message;
    }



}
