package com.sparta.hw.service;

import com.sparta.hw.dto.MemoInfoDto;
import com.sparta.hw.dto.MemoListRequestDto;
import com.sparta.hw.dto.MemoRequestDto;
import com.sparta.hw.entity.Memo;
import com.sparta.hw.repository.MemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service //스프링에게 이 클래스는 서비스임을 명시
public class MemoService {

    //final : 서비스에게 꼭 필요한 녀석임을 명시
    private final MemoRepository memoRepository;

    //게시글 수정
    @Transactional
    public Long update(Long id, MemoInfoDto requestDto) throws Exception {
        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );

        if (!requestDto.getPw().equals(memo.getPw())){
            throw new Exception("비밀번호가 일치하지 않습니다.");
        }
        memo.update(requestDto.getUsername(), requestDto.getTitle(), requestDto.getContents());
        return memo.getId();
    }

    //게시글 전체 조회
    public List<MemoListRequestDto> findAllMemo() {
        List<Memo> memos = memoRepository.findAllByOrderByCreatedAtDesc();

        List<MemoListRequestDto> result = new ArrayList<>();
        for (Memo memo : memos) {
            MemoListRequestDto memoListRequestDto = new MemoListRequestDto(memo.getTitle(), memo.getUsername(), memo.getCreatedAt());
            result.add(memoListRequestDto);
        }
        return result;
    }


    //게시글 하나 조회
    @Transactional
    public MemoRequestDto searchById(Long id) {
        Memo entity = memoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("존재하지않는 글입니다.")
        );
        return new MemoRequestDto(entity);
    }


}