package com.dadong.common.dao.impl;

import com.dadong.common.dao.IBaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

/**
 * Created by Xiaodong on 2018/6/23.
 */
public class BaseDao<T> implements IBaseDao<T> {
    @Autowired
    protected HibernateTemplate hibernateTemplate ;
    private Class entityClass ;
    public void insert(T t) {
        this.hibernateTemplate.save((T)t) ;
    }
    public BaseDao(){
        ParameterizedType type = (ParameterizedType)getClass().getGenericSuperclass() ;
        Class entityClass = (Class)type.getActualTypeArguments()[0] ;
        this.entityClass = entityClass ;
    }
    public T selectById(Integer id) {
        return (T)this.hibernateTemplate.get(this.entityClass, id) ;
    }

    public void update(T t) {
        this.hibernateTemplate.update((T)t);
    }

    public void delete(T t){
        this.hibernateTemplate.delete((T)t);
    }

    public HibernateTemplate getTemplate() {
        return this.hibernateTemplate ;
    }
}
