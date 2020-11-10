package com.zhangbo.dao.impl;

import com.zhangbo.dao.UserDao;
import com.zhangbo.pojo.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserDaoImpl implements UserDao {


    @Override
    public List<User> findAll() {

        Connection connection = null;
        ResultSet resultSet = null;
        Statement statement = null;
        try {
            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //创建 连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaee02?useUnicode=true&characterEncoding=utf8", "root", "root");
            //创建连接对象
            statement = connection.createStatement();
            //sql的编写
            String sql = "select * from user where 1=1";
            resultSet = statement.executeQuery(sql);
            //声明返回的list
            List userlist = new ArrayList();
            //解析返回值

            while (resultSet.next()) {
                User user = new User();
                user.setName(resultSet.getString("name"));
                user.setId(resultSet.getInt("id"));
                user.setPass(resultSet.getString("pass"));
                user.setGender(resultSet.getString("gender"));
                user.setEmail(resultSet.getString("email"));
                userlist.add(user);
            }
            return userlist;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public User findById(Integer id) {
        //进行数据库连接操作数据库
        //
        Connection connection = null;
        //执行sql
        ResultSet resultSet = null;
        Statement statement = null;
        try {
            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //创建 连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaee02?useUnicode=true&characterEncoding=utf8", "root", "root");
            //创建连接对象
            statement = connection.createStatement();
            //sql的编写
            String sql = "select * from user where id=" + id;

            resultSet = statement.executeQuery(sql);

            //声明返回的对象
            User user = new User();
            //解析返回值

            while (resultSet.next()) {

                user.setName(resultSet.getString("name"));
                user.setId(resultSet.getInt("id"));
                user.setPass(resultSet.getString("pass"));
                user.setGender(resultSet.getString("gender"));
                user.setEmail(resultSet.getString("email"));
            }
            return user;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public Boolean update(User user) {
        //进行数据库连接操作数据库
        //
        Connection connection = null;
        //执行sql
        PreparedStatement preparedStatement = null;
        try {
            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //创建 连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaee02?useUnicode=true&characterEncoding=utf8", "root", "root");
            //创建连接对象
            //statement  = connection.createStatement();
            //sql的编写
            String sql = "update user set name =? , pass = ? , gender =? , email=? where id = ?";

            preparedStatement = connection.prepareStatement(sql);
            //给占位符进行赋值
            preparedStatement.setObject(1, user.getName());
            preparedStatement.setObject(2, user.getPass());
            preparedStatement.setObject(3, user.getGender());
            preparedStatement.setObject(4, user.getEmail());
            preparedStatement.setObject(5, user.getId());
            //执行sql
            int i = preparedStatement.executeUpdate();
            //解析返回值
            if (i > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public Boolean deleteById(Integer id) {
        //进行数据库连接操作数据库
        //
        Connection connection = null;
        //执行sql
        PreparedStatement preparedStatement = null;
        try {
            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //创建 连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaee02?useUnicode=true&characterEncoding=utf8", "root", "root");
            //创建连接对象
            //statement  = connection.createStatement();
            //sql的编写
            String sql = "delete from user where id = ?";

            preparedStatement = connection.prepareStatement(sql);
            //给占位符进行赋值
            preparedStatement.setObject(1, id);

            //执行sql
            int i = preparedStatement.executeUpdate();
            //解析返回值
            if (i > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public Boolean insert(User user) {
        //进行数据库连接操作数据库
        //
        Connection connection = null;
        //执行sql
        PreparedStatement preparedStatement = null;
        try {
            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //创建 连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaee02?useUnicode=true&characterEncoding=utf8", "root", "root");
            //创建连接对象
            //statement  = connection.createStatement();
            //sql的编写
            String sql = "INSERT INTO user (name, pass, gender, email) VALUES (?, ?, ?, ?)";

            preparedStatement = connection.prepareStatement(sql);
            //给占位符进行赋值
            preparedStatement.setObject(1, user.getName());
            preparedStatement.setObject(2, user.getPass());
            preparedStatement.setObject(3, user.getGender());
            preparedStatement.setObject(4, user.getEmail());
            //执行sql
            int i = preparedStatement.executeUpdate();
            //解析返回值
            if (i > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
