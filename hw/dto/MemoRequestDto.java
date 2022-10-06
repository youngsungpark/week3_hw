package com.sparta.hw.dto;

import com.sparta.hw.entity.Memo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class MemoRequestDto {

    private String username;
    private String title;
    private String contents;
    private LocalDateTime createdAt;

    public MemoRequestDto(Memo entity) {
        this.title = entity.getTitle();
        this.username = entity.getUsername();
        this.createdAt = entity.getCreatedAt();
        this.contents = entity.getContents();
    }
}
