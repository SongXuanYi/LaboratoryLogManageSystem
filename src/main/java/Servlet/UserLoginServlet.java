package Servlet;

import UserBean.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserLoginServlet", value = "/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");

        UserService service = new UserServiceImpl();
        User user = service.findByNameAndPassword(name, pwd);

        if (user != null) {
                request.getRequestDispatcher("/FindAllServlet").forward(request, response);
        } else {
            request.setAttribute("passwordError", "用户名或密码错误");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

}

