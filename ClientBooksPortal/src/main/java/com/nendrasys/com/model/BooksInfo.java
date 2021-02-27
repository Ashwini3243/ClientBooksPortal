package com.nendrasys.com.model;

public class BooksInfo {

    private int bookId;

    private String bookName;

    private String bookAuthor;

    private String bookDesc;

    private Double inPrice;

    private Double usPrice;


    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookDesc() {
        return bookDesc;
    }

    public void setBookDesc(String bookDesc) {
        this.bookDesc = bookDesc;
    }

    public Double getInPrice() {
        return inPrice;
    }

    public void setInPrice(Double inPrice) {
        this.inPrice = inPrice;
    }

    public Double getUsPrice() {
        return usPrice;
    }

    public void setUsPrice(Double usPrice) {
        this.usPrice = usPrice;
    }

    @Override
    public String toString() {
        return "BooksInfo{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookDesc='" + bookDesc + '\'' +
                ", inPrice='" + inPrice + '\'' +
                ", usPrice='" + usPrice + '\'' +
                '}';
    }
}
