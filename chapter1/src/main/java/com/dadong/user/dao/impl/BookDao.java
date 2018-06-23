package com.dadong.user.dao.impl;

import com.dadong.common.dao.impl.BaseDao;
import com.dadong.user.dao.IBookDao;
import com.dadong.user.domain.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Xiaodong on 2018/6/23.
 */
@Repository
public class BookDao extends BaseDao<Book> implements IBookDao {
    public List<Book> getBooksByUserId(Integer userId) {
        return (List<Book>)this.getTemplate().find("FROM Book b where b.userId = ? ",userId) ;
    }
}
