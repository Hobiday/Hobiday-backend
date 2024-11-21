package com.example.hobiday_backend.domain.profile.repository;

import com.example.hobiday_backend.domain.profile.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
    Optional<Profile> findByUserId(Long userId); // users의 id로 찾기
}
