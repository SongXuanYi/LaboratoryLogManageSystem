package util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UsersFilter implements Filter {
    public void destroy() {
        // TODO Auto-generated method stub

    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        // ����������ַ�����
        request.setCharacterEncoding("UTF-8");
        // ���÷���������ַ�����
        response.setCharacterEncoding("UTF-8");
        // ת��ServletRequestΪ HttpServletRequest
        HttpServletRequest req = (HttpServletRequest) request;
        // ת��ServletResponseΪHttpServletRequest
        HttpServletResponse res = (HttpServletResponse) response;
        // ��ȡSession
        HttpSession session = req.getSession();
        // ��ȡSession�д洢�Ķ���
        Object o = session.getAttribute("user");
        // ��ȡ��ǰ�����URI
        String url = req.getRequestURI();
        // �ж�Session�еĶ����Ƿ�Ϊ�գ��ж������URI�Ƿ�Ϊ��������˵�URI
        if (o == null
                && !url.endsWith("login.jsp")     // ��URL��ַΪ�˽�β���ļ�������
                && url.indexOf("login.do") < 0    // ��URL��ַ�а������ַ������ļ�������
                && url.indexOf("/images/") < 0) {
            res.sendRedirect(req.getContextPath() + "/login.jsp");
        } else {
            chain.doFilter(request, response);
            res.setHeader("Cache-Control", "no-store");
            res.setDateHeader("Expires", 0);
            res.setHeader("Pragma", "no-cache");
            res.flushBuffer();
        }

    }

    public void init(FilterConfig filterConfig) throws ServletException {
        // TODO Auto-generated method stub

    }

}

