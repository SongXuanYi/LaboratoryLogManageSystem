package Servlet;

import UserBean.Logs;
import UserBean.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FindAllServlet", value = "/FindAllServlet")
public class FindAllServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService service = new UserServiceImpl();
        List<Logs> list = service.findAll();
        request.setAttribute("list",list);
        request.getRequestDispatcher("/logIndex.jsp").forward(request,response);
    }
}
