package com.dadong.common.dao;

import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 * Created by Xiaodong on 2018/6/23.
 */
public interface IBaseDao<T> {
    void insert(T t) ;
    T selectById(Integer id) ;
    void update(T t) ;
    void delete(T t) ;
    HibernateTemplate getTemplate() ;
}
