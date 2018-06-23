package com.dadong.user.domain;

import javax.persistence.*;

/**
 * Created by Xiaodong on 2018/6/23.
 */
@Entity
@Table(name = "t_book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_id")
    private Integer bookId ;
    @Column(name = "name")
    private String name ;
    @Column(name = "ibsn")
    private String ibsn ;
    @Column(name = "price")
    private Double price ;
    @Column(name = "description")
    private String description ;
    @Column(name = "author_name")
    private String authorName ;
    @Column(name = "user_id")
    private Integer userId ;

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIbsn() {
        return ibsn;
    }

    public void setIbsn(String ibsn) {
        this.ibsn = ibsn;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", name='" + name + '\'' +
                ", ibsn='" + ibsn + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", authorName='" + authorName + '\'' +
                ", userId=" + userId +
                '}';
    }
}
