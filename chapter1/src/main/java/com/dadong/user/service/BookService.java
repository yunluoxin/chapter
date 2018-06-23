package com.dadong.user.service;

import com.dadong.common.service.impl.BaseService;
import com.dadong.user.dao.impl.BookDao;
import com.dadong.user.domain.Book;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Xiaodong on 2018/6/23.
 */
@Service
public class BookService extends BaseService<Book, BookDao>{
    public List<Book> getBooksByUserId(Integer userId) {
       return this.getDao().getBooksByUserId(userId) ;
    }
}
