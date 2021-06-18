package Servlet;

import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteLogServlet", value = "/DeleteLogServlet")
public class DeleteLogServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        UserService service=new UserServiceImpl();
        int i = service.deleteLog(Integer.parseInt(id));
        if (i>0) {
            request.getRequestDispatcher("FindAllServlet").forward(request,response);
        }
    }
}
