package com.zero.todo2.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class TodoDTO {

    //todo 제목과 내용
    private String title, memo;

    //todo 생성시간, 수정시간
    private LocalDateTime regdate, moddate;
    
    //todo 완료날짜
    private LocalDate duedate;
    
    //todo 완료여부
    private boolean complete;
}
