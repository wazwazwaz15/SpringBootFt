package org.example.springbootft;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  AppleRepository extends JpaRepository<Apple,Long> {

}
