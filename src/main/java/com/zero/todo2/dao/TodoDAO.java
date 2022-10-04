package com.zero.todo2.dao;

import com.zero.todo2.dto.TodoResponseDTO;
import lombok.Cleanup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public enum TodoDAO {

    INSTANCE;

    private final String SELECT = "SELECT * FROM tbl_todo WHERE tno > 0 ORDER BY tno";


    public List<TodoResponseDTO> selectAllList() throws Exception {
       String SELECT = "SELECT * FROM tbl_todo WHERE tno > 0 ORDER BY tno";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(SELECT);

        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();

        List<TodoResponseDTO> todoDTOList = new ArrayList<>();

        while (resultSet.next()) {
            TodoResponseDTO todoResponseDTO = TodoResponseDTO.builder()
                    .tno(resultSet.getInt(1))
                    .title(resultSet.getString(2))
                    .memo(resultSet.getString(3))
                    .regdate(resultSet.getTimestamp(4).toLocalDateTime())
                    .moddate(resultSet.getTimestamp(5).toLocalDateTime())
                    .duedate(resultSet.getDate(6).toLocalDate())
                    .complete(resultSet.getBoolean(7))
                    .build();
            todoDTOList.add(todoResponseDTO);
        }
        return todoDTOList;
    }

}
