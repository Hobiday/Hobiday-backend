package com.example.hobiday_backend.domain.profile.repository;

import com.example.hobiday_backend.domain.profile.domain.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

}
