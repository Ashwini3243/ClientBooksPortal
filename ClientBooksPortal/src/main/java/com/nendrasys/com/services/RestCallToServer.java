package com.nendrasys.com.services;

import com.nendrasys.com.model.BooksInfo;
import com.nendrasys.com.model.BooksList;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;

public class RestCallToServer {

    private RestTemplate restTemplate;

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public BooksList getServerBooksDataList() {
        BooksInfo booksInfo = new BooksInfo();
        String url ="http://localhost:8083/ServerBooksPortal_war_exploded/getBooksListInXml";
        ResponseEntity<BooksInfo[]> obj = restTemplate.getForEntity(url, BooksInfo[].class);
        BooksList  booksList= new BooksList();
        booksList.setBooksInfoList(Arrays.asList(obj.getBody()));
        return booksList;
    }

    public BooksInfo getServerBooksDataInXmlById(int bookId){
        final String uri = "http://localhost:8083/ServerBooksPortal_war_exploded/getBookByIdInXml/{bookId}";
        RestTemplate restTemplate = new RestTemplate();
        BooksInfo booksInfo = restTemplate.getForObject(uri, BooksInfo.class,bookId);
        return booksInfo;
    }
}
