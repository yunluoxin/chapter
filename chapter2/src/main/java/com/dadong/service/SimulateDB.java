package com.dadong.service;

import com.dadong.model.A;

import java.sql.SQLException;

/**
 * Created by Xiaodong on 2018/6/22.
 */
public class SimulateDB {
    public void deleteOperate(int id){
        throw new RuntimeException("运行异常") ;
    }
    public void insertOperate(A a)throws Exception{
        throw new SQLException("数据库插入异常") ;
    }
}
