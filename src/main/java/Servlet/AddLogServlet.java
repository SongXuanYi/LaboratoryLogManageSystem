package Servlet;

import UserBean.Logs;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddLogServlet", value = "/AddLogServlet")
public class AddLogServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        UserService service = new UserServiceImpl();
        Logs logs = new Logs();

        String username = request.getParameter("username");
        String date = request.getParameter("date");
        String type = request.getParameter("type");
        String event = request.getParameter("event");
        logs.setUsername(username);
        logs.setDate(date);
        logs.setType(type);
        logs.setEvent(event);

        int i = service.addLog(logs);
        if (i>0) {
            request.setAttribute("addLogDone","成功添加日志");
            request.getRequestDispatcher("FindAllServlet").forward(request,response);
        }else{
            request.setAttribute("addLogFailed","添加日志失败");
            request.getRequestDispatcher("/addLog.jsp").forward(request,response);
        }
    }
}
