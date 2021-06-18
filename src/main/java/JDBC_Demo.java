/*
题目一、实验室日志管理系统【*】D
管理实验室日常发生的各种事情，登录系统后
可以进行实验室日常工作内容的增删改查，可以进行搜索；
可以按日期查询、也可以按某个关键词查询，
可以统计各种关键词相关的事情数量。
可以对某一个工作类型做一下分类，添加各种事情时先选择分类，方便后期的数据统计，
比如可以进行按月、按季度或按年的方式进行统计展现。
注：必须要登录才能访问系统，一个管理员账号。
技术要求：
1.	采用JSP【可以采用JSP+JavaBean两层开发，也可以JSP+JavaBean+Servlet三层开发】；
2.	数据库用MySQL。

 */

import java.sql.*;

public class JDBC_Demo {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/JSPdb?serverTimezone=UTC","root","");
        Statement s = conn.createStatement();
        s.execute("insert into test(name) values ('Ge')");
    }
}
