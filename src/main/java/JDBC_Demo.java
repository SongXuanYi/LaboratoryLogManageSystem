/*
��Ŀһ��ʵ������־����ϵͳ��*��D
����ʵ�����ճ������ĸ������飬��¼ϵͳ��
���Խ���ʵ�����ճ��������ݵ���ɾ�Ĳ飬���Խ���������
���԰����ڲ�ѯ��Ҳ���԰�ĳ���ؼ��ʲ�ѯ��
����ͳ�Ƹ��ֹؼ�����ص�����������
���Զ�ĳһ������������һ�·��࣬��Ӹ�������ʱ��ѡ����࣬������ڵ�����ͳ�ƣ�
������Խ��а��¡������Ȼ���ķ�ʽ����ͳ��չ�֡�
ע������Ҫ��¼���ܷ���ϵͳ��һ������Ա�˺š�
����Ҫ��
1.	����JSP�����Բ���JSP+JavaBean���㿪����Ҳ����JSP+JavaBean+Servlet���㿪������
2.	���ݿ���MySQL��

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
