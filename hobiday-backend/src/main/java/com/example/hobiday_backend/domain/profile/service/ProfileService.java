package com.example.hobiday_backend.domain.profile.service;

import com.example.hobiday_backend.domain.profile.dto.request.AddProfileRequest;
import com.example.hobiday_backend.domain.profile.domain.Profile;
import com.example.hobiday_backend.domain.profile.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProfileService {
    private final ProfileRepository profileRepository;


    // 회원가입 (처음 정보 입력)
    public Profile saveFirst(Long userId, String email, String nickname, AddProfileRequest profile){
        return profileRepository.save(Profile.builder()
                .userId(userId)
                .profileEmail(email)
                .profileName(nickname)
                .profileGenre(profile.profileGenre)
                .build());
    }

}
