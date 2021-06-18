package Servlet;

import UserBean.Logs;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdateServlet", value = "/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String id = request.getParameter("hid");
        String username = request.getParameter("username");
        String date = request.getParameter("date");
        String type = request.getParameter("type");
        String event = request.getParameter("event");


        Logs logs = new Logs();
        logs.setId(Integer.parseInt(id));
        logs.setUsername(username);
        logs.setDate(date);
        logs.setType(type);
        logs.setEvent(event);
        
        UserService service = new UserServiceImpl();
        int i =service.Update(logs);
        if (i>0) {
            request.setAttribute("updateLogDone","成功修改日志");
            request.getRequestDispatcher("FindAllServlet").forward(request,response);
        }else{
            request.setAttribute("updateLogFailed","修改日志失败");
            request.getRequestDispatcher("/update.jsp").forward(request,response);
        }
    }
}
