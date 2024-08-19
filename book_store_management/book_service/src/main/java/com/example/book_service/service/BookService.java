package com.example.book_service.service;

import com.example.book_service.exceptions.BookNotFoundException;
import com.example.book_service.repository.BookRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.List;
import com.example.book_service.domain.Book;
@Service
@Slf4j
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public Book createBook(Book book) {
        log.debug("Creating book :{}", book);
        return bookRepository.save(book);
    }

    public Book getBook(long id){
        log.debug("Get all books, id:{}",id);
        return bookRepository.findById(id).orElseThrow(()-> new BookNotFoundException("Book not found, id:"+id));
    }
    public List<Book> getAllBooks(){
        log.debug("Get all the books");
        return List.copyOf(bookRepository.findAll());
    }

public Book updateBook(long id, Book book){
    if (!bookRepository.existsById(id)) {
        throw new RuntimeException("Book not found");
    }
    book.setId(id);
    return bookRepository.save(book);

}

public void deleteBook(long id){
        log.debug("Deleting the books, id:{}", id);
        var book=bookRepository.findById(id).orElseThrow(()-> new BookNotFoundException("Book not found, id: "+ id));
        bookRepository.delete(book);
}


}
