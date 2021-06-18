package Servlet;

import UserBean.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        UserService service = new UserServiceImpl();
        int i = service.addUser(user);
        if (i>0){
            request.setAttribute("succeed", "¹§Ï²Äú£¬×¢²á³É¹¦!");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }else{
            request.setAttribute("registerFailed","×¢²áÊ§°Ü£¬ÇëÖØÐÂ×¢²á");
            request.getRequestDispatcher("/register.jsp").forward(request,response);
        }
    }

}
