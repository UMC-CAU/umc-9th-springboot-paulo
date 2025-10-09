package com.example.umc_9th_paulo.domain.user.repository;

import com.example.umc_9th_paulo.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
