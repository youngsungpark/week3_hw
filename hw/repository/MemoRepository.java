package com.sparta.hw.repository;

import com.sparta.hw.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemoRepository extends JpaRepository<Memo, Long> {

    //작성날짜 기준으로 내림차순 정렬(createdAt)
    List<Memo> findAllByOrderByCreatedAtDesc();
}