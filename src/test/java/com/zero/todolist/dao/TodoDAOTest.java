package com.zero.todolist.dao;

import com.zero.todo2.dao.MyBatisUtil;
import com.zero.todo2.dto.TodoDTO;
import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

@Log4j2
class TodoDAOTest {

    @Test
    void selectAllTest() throws SQLException {
/*        String SELECT = "SELECT * FROM tbl_todo WHERE tno > 0 ORDER BY tno";

        Connection connection = ConnectionUtil.INSTANCE.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT);

        ResultSet resultSet = preparedStatement.executeQuery();

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
        todoDTOList.forEach(System.out::println);*/

        SqlSession session
                = MyBatisUtil.INSTANCE.getSqlSessionFactory().openSession(true);

        List<TodoDTO> todoDTOList
                = session.selectList("com.zero.todoList.dao.TodoListMapper.selectAll");

        todoDTOList.forEach(todoDTO -> log.info(todoDTO));
    }
}