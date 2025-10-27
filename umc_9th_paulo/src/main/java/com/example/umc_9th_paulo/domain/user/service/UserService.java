package com.example.umc_9th_paulo.domain.user.service;

import com.example.umc_9th_paulo.domain.inquiry.repository.InquiryRepository;
import com.example.umc_9th_paulo.domain.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final InquiryRepository inquiryRepository;
    private final UserRepository userRepository;

    @Transactional
    public void deleteUser(Long userId) {
        inquiryRepository.deleteById(userId);
        userRepository.deleteById(userId);
    }
}
