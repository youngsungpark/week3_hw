package com.sparta.hw.dto;

import com.sparta.hw.entity.Memo;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
public class MemoListRequestDto {
    private String username;
    private String title;
    private LocalDateTime createdAt;

    public MemoListRequestDto(String title, String username, LocalDateTime createdAt) {
        this.title = title;
        this.username = username;
        this.createdAt = createdAt;
    }
}
