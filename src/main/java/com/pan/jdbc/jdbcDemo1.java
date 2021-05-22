package com.pan.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class jdbcDemo1 {
    public static void main(String[] args) throws Exception{
        //1.注册驱动
        //DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.获取连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/oa?serverTimezone=GMT%2B8&useSSL=false","root","417517");
        //3.获取操作数据库预处理对象
        PreparedStatement pstm = conn.prepareStatement("select * from oa_dept");
        //4,执行SQL，得到结果集
        ResultSet rs = pstm.executeQuery();
        //5.遍历结果集
        while(rs.next()){
            System.out.println(rs.getString("loc"));
        }
        //6.释放资源
        rs.close();
        pstm.close();
        conn.close();
    }
}
