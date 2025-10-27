package com.example.umc_9th_paulo.domain.inquiry.repository;

import com.example.umc_9th_paulo.domain.inquiry.entity.Inquiry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface InquiryRepository extends JpaRepository<Inquiry, Long> {
    @Modifying
    @Query("DELETE FROM Inquiry i WHERE i.user.id = :userId")
    void deleteByUserId(@Param("userId") Long userId);
}
