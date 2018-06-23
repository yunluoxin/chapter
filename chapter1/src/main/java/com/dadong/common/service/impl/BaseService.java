package com.dadong.common.service.impl;

import com.dadong.common.dao.impl.BaseDao;
import com.dadong.common.service.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Xiaodong on 2018/6/23.
 */
public class BaseService<T, D extends BaseDao> implements IBaseService<T>{
    @Autowired
    private D baseDao ;

    public void save(T t){
        this.baseDao.insert(t) ;
    }
    public void delete(T t){
        this.baseDao.delete(t) ;
    }
    public T get(Integer id){
        return (T)this.baseDao.selectById(id) ;
    }
    public void update(T t){
        this.baseDao.update(t) ;
    }

    public D getDao(){
        return this.baseDao ;
    }
}
