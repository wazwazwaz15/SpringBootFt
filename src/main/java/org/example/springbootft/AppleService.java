package org.example.springbootft;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppleService {

    @Autowired
    private AppleRepository appleRepository;

    public List<Apple> getAllApples() {
        return appleRepository.findAll();  // ✅ 直接調用 Repository，省去 SQL
    }

    public Apple getAppleById(Long id) {
        return appleRepository.findById(id).orElse(null);
    }

    public Apple saveApple(Apple apple) {
        return appleRepository.save(apple);  // ✅ 自動處理 INSERT / UPDATE
    }

    public void deleteApple(Long id) {
        appleRepository.deleteById(id);  // ✅ 自動處理 DELETE
    }
}



