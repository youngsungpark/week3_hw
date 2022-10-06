package com.sparta.hw.controller;

import com.sparta.hw.dto.MemoInfoDto;
import com.sparta.hw.dto.MemoListRequestDto;
import com.sparta.hw.dto.MemoRequestDto;
import com.sparta.hw.entity.Memo;
import com.sparta.hw.repository.MemoRepository;
import com.sparta.hw.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MemoController {

    private final MemoRepository memoRepository;
    private final MemoService memoService;

    //게시글 전체 조회
    @GetMapping("/api/memos")
    public List<MemoListRequestDto> findAllMemo(MemoListRequestDto requestDto) {
        return memoService.findAllMemo();
    }

    //게시글 작성
    @PostMapping("/api/memos")
    public Memo createMemo(@RequestBody MemoInfoDto requestDto) {
        Memo memo = new Memo(requestDto);
        return memoRepository.save(memo);
    }

    //게시글 삭제
    @DeleteMapping("/api/memos/{id}")
    public Long deleteMemo(@PathVariable Long id) {
        memoRepository.deleteById(id);
        return id;
    }

    //게시글 수정
    @PutMapping("/api/memos/{id}")
    public Long update(@PathVariable Long id, @RequestBody MemoInfoDto requestDto) throws Exception {
        memoService.update(id, requestDto);
        return id;
    }

    //게시글 하나 조회
    @GetMapping("/api/memos/{id}")
    public MemoRequestDto searchById(@PathVariable Long id){
        return memoService.searchById(id);
    }
}