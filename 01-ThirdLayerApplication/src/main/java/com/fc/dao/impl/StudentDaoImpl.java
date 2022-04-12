package com.fc.dao.impl;

import com.fc.dao.StudentDao;
import com.fc.entity.Student;
import com.fc.util.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    QueryRunner queryRunner = new QueryRunner();

    Connection connection = DruidUtil.getConnection();

    //获取总数据量
    @Override
    public int getTotalCount(){
        String sql = "select * from student";

        List<Student> list = null;
        try {
            queryRunner.query(connection,sql,new BeanHandler<>(Student.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (list != null){
            return list.size();
        }

        return 0;
    }

    @Override
    public List<Student> getList(int pageNo, int pageSize){
        String sql = "select * from student limit ?,?";

        //从哪开始
        int start = (pageNo-1) * pageSize;

        //查多少条pageSize

        List<Student> list = null;

        try {
            queryRunner.query(connection,sql,new BeanHandler<>(Student.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
