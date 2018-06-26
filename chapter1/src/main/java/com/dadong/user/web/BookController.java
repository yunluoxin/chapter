package com.dadong.user.web;

import com.dadong.aop.NeedLogin;
import com.dadong.user.dao.IBookDao;
import com.dadong.user.domain.Book;
import com.dadong.user.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Xiaodong on 2018/6/23.
 */
@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService ;

    @NeedLogin
    @RequestMapping("/add.html")
    public void addBook(Book book){
        this.bookService.save(book) ;
    }

    @NeedLogin
    @RequestMapping("/my-list.html")
    public ModelAndView myBooks(){
        List<Book> bookList = this.bookService.getBooksByUserId(1) ;
        ModelAndView mv = new ModelAndView("myBooks") ;
        mv.getModel().put("books",bookList) ;
        return mv ;
    }
}
