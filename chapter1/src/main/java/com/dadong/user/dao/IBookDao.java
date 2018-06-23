package com.dadong.user.dao;

import com.dadong.common.dao.IBaseDao;
import com.dadong.user.domain.Book;

import java.util.List;

/**
 * Created by Xiaodong on 2018/6/23.
 */
public interface IBookDao extends IBaseDao<Book> {
    List<Book> getBooksByUserId(Integer userId) ;
}
