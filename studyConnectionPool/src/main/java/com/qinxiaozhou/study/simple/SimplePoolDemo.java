package com.qinxiaozhou.study.simple;

import com.qinxiaozhou.study.dbcp.DBCPUtils;

import java.sql.Connection;
import java.util.LinkedList;

/**
 * Create by qxz on 2018/2/2
 * Description:
 */
public class SimplePoolDemo {
    //创建一个连接池
    private static LinkedList<Connection> pool = new LinkedList<Connection>();

    //初始化10个连接
    static{
        try {
            for (int i = 0; i < 10; i++) {
                Connection conn = DBCPUtils.getConnection();//得到一个连接
                pool.add(conn);
            }
        } catch (Exception e) {
            throw new ExceptionInInitializerError("数据库连接失败，请检查配置");
        }
    }
    //从池中获取一个连接
    public static Connection getConnectionFromPool(){
        return pool.removeFirst();//移除一个连接对象
    }
    //释放资源
    public static void release(Connection conn){
        pool.addLast(conn);
    }
}