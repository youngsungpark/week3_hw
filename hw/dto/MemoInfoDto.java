package com.sparta.hw.dto;

import com.sparta.hw.entity.Memo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class MemoInfoDto {

    private String username;
    private String title;
    private String contents;
    private LocalDateTime createdAt;
    private String pw;


    public MemoInfoDto(Memo entity) {
        this.title = entity.getTitle();
        this.username = entity.getUsername();
        this.createdAt = entity.getCreatedAt();
        this.contents = entity.getContents();
        this.pw = entity.getPw();
    }
}