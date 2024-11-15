package com.example.hobiday_backend.domain.profile.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class ProfileResponse {
    public String profileName;
    public String profileEmail;
    public String profileGenre;

}
