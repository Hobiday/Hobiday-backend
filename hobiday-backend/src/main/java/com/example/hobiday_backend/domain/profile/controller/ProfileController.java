package com.example.hobiday_backend.domain.profile.controller;

import com.example.hobiday_backend.domain.profile.domain.Profile;
import com.example.hobiday_backend.domain.profile.dto.request.AddProfileRequest;
import com.example.hobiday_backend.domain.profile.dto.response.ProfileResponse;
import com.example.hobiday_backend.domain.profile.service.ProfileService;
import com.example.hobiday_backend.domain.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ProfileController {
    private final ProfileService profileService;
    private final UserRepository userRepository;

    // 회원가입: 로그인 성공 후 기존 회원이 아니면 프로필 작성하여 저장 후 응답
    @PostMapping("/api/profile/join")
    public ResponseEntity<ProfileResponse> join(@RequestBody AddProfileRequest addProfileRequest,
//                                        Authentication authentication,
//                                        @AuthenticationPrincipal OAuth2User oauth,
                                                Principal principal,
                                                @AuthenticationPrincipal User user) {

        // 현재 로그인한 사용자 정보 확인용 (Principal principal, @AuthenticationPrincipal User user) 둘 중 하나 선택
        // 여기서 User는 도메인이 아니라 시큐리티에 있는 org.springframework.security.core.userdetails.User를 import해야함
        log.info("현재 로그인한 사용자명(principal): " + principal.getName()); //
//        log.info("현재 로그인한 사용자명(시큐리티user): " + user.getUsername()); // 둘 중 하나 선택

        // 카카오 로그인된 사용자 닉네임과 이메일, dto 받은 정보들을 프로필에 저장 => 서비스쪽에 구현 예정
        Long profileId = userRepository.findByEmail(principal.getName()).get().getId();
        String kakaoEmail = userRepository.findByEmail(principal.getName()).get().getEmail();
        String kakaoNickname = userRepository.findByEmail(principal.getName()).get().getNickname();
        Profile profile = profileService.saveFirst(profileId, kakaoEmail, kakaoNickname, addProfileRequest);

        // 프로필 정보 응답
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ProfileResponse(kakaoNickname, kakaoEmail, addProfileRequest.profileGenre));
    }
}
