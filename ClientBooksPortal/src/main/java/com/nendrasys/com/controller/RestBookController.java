package com.nendrasys.com.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.nendrasys.com.model.BooksInfo;
import com.nendrasys.com.model.BooksList;
import com.nendrasys.com.services.RestCallToServer;
import com.nendrasys.com.services.UserRegistrationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestBookController {

    @Autowired
    RestCallToServer restCallToServer;
    @Autowired
    UserRegistrationServiceImpl userRegistrationService;

    // getting the server data list
    @RequestMapping(value = "/getBooksDataInXml",produces = {"application/xml"})
    public BooksList getRestBooks() throws JsonProcessingException {
        return  restCallToServer.getServerBooksDataList();
    }

    // getting the server data by id
    @RequestMapping(value = "/getBookByIdInXml/{bookId}",produces = "application/xml")
    public ResponseEntity<BooksInfo> getBookById (@PathVariable("bookId") int bookId)
    {
        if (bookId != 0) {
            BooksInfo booksInfoServer = restCallToServer.getServerBooksDataInXmlById(bookId);
            return new ResponseEntity<BooksInfo>(booksInfoServer, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
  }
