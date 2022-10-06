package com.sparta.hw.entity;

import com.sparta.hw.dto.MemoInfoDto;
import com.sparta.hw.dto.MemoRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor // 기본생성자를 만듭니다.
@Getter
@Entity // 테이블과 연계됨을 스프링에게 알려줍니다.
public class Memo extends Timestamped { // Timestamped를 상속받아 생성,수정 시간을 자동으로 만들어줍니다.
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    //0)각각의 게시글 구분을 위해 id 생성
    private Long id;

    //블로그 게시글은 1)제목(title), 2)작성자명(username), 3)비밀번호(password), 4)작성내용(contents)로 이루어져있습니다.
    //1)제목
    @Column(nullable = false)
    private String title;

    //2)작성자명
    @Column(nullable = false)
    private String username;

    //3) 비밀번호
    @Column(nullable = false)
    private String pw;

    //4)작성내용
    @Column(nullable = false)
    private String contents;


    //게시글 생성하기
    public Memo(String title, String username, String contents, String pw) {
        this.title = title;
        this.username = username;
        this.contents = contents;
        this.pw = pw;
    }

    //게시글 하나보기
    public Memo(MemoInfoDto requestDto) {
        this.title = requestDto.getTitle();
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
        this.pw = requestDto.getPw();
    }

    //게시글 수정
    public void update(String username, String title, String contents) {
        this.title = title;
        this.username = username;
        this.contents = contents;
    }
}