package com.zero.todo2.controller;

import com.zero.todo2.dao.MyBatisUtil;
import com.zero.todo2.dto.TodoDTO;
import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@Log4j2
@WebServlet(name = "TodoListController", value = "/todo/list")
public class TodoListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*
        * TodoDAO 와 연결하여 jsp 로 출력
        * 
        * try {
            List<TodoResponseDTO> todoResponseDTO = TodoDAO.INSTANCE.selectAllList();
            request.setAttribute("list", todoResponseDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        request.getRequestDispatcher("/WEB-INF/todoList.jsp").forward(request, response);
        * 
        * */
        
        
        //MyBatis 와 연결하여 jsp 로 출력
        SqlSession session
                = MyBatisUtil.INSTANCE.getSqlSessionFactory().openSession(true);

        List<TodoDTO> todoDTOList
                = session.selectList("com.zero.todo2.dao.TodoListMapper.selectAll");

        request.setAttribute("list", todoDTOList);

        request.getRequestDispatcher("/WEB-INF/todoList.jsp")
                .forward(request, response);

        todoDTOList.forEach(todoDTO -> log.info(todoDTO));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
