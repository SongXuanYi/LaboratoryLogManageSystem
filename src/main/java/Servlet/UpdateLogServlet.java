package Servlet;

import UserBean.Logs;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdateLogServlet", value = "/UpdateLogServlet")
public class UpdateLogServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        UserService service = new UserServiceImpl();
        Logs logs =service.findById(Integer.parseInt(id));
        request.setAttribute("logs",logs);
        request.getRequestDispatcher("update.jsp").forward(request,response);
    }
}
