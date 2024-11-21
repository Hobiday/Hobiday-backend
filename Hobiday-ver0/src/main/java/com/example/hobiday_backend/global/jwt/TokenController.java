package com.example.hobiday_backend.global.jwt;

import com.example.hobiday_backend.global.jwt.dto.CreateAccessTokenRequest;
import com.example.hobiday_backend.global.jwt.dto.CreateAccessTokenResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class TokenController {
    private final TokenService tokenService;

    // 토큰을 발급해주는 api
    @Tag(name="액세스 토큰 재발급 API", description = "요청 받은 리프레시 토큰을 기반으로 새로운 액세스 토큰을 발급해줍니다.")
    @PostMapping("/api/token")
    public ResponseEntity<CreateAccessTokenResponse> createNewAccessToken
            (@RequestBody CreateAccessTokenRequest request){
        String newAccessToken = tokenService.createNewAccessToken(request.getRefreshToken());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new CreateAccessTokenResponse(newAccessToken));
    }
}
