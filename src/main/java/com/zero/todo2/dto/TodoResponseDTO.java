package com.zero.todo2.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

//데이터베이스에서 받아온 DTO
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TodoResponseDTO {
    private Integer tno;
    private String title;
    private String memo;
    private LocalDateTime regdate;
    private LocalDateTime moddate;
    private LocalDate duedate;
    private boolean complete;
}
