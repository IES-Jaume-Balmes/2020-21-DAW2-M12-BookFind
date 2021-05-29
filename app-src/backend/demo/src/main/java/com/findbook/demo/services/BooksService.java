package com.findbook.demo.services;

import com.findbook.demo.dao.BookRepository;
import com.findbook.demo.entities.Book;
import com.findbook.demo.entities.Category;
import com.findbook.demo.exception.BookExistsException;
import com.findbook.demo.exception.NotEnoughProductsInStockException;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class BooksService {
    //TODO: Validation --> github proyect example (ALL CRUD CONTROLLERS/METHODS)
    @Autowired
    BookRepository bookRepository;

    @SneakyThrows
    public Book findOne(Long productId) {
        // .orElseThrow(() -> new EntityNotFoundException(id)
        // Optional<Book> bookInfo = bookRepository.findById(productId);

        return bookRepository.findById(productId).orElseThrow(() -> new BookExistsException("The book does not exists"));
    }


 /*   public Optional<Book> findOneById(Long productId) {
        return bookRepository.findById(productId);
    }*/

    public Page<Book> getBooksPage(Pageable page) {
        return bookRepository.findAll(page);
    }


    @SneakyThrows
    public ResponseEntity createBook(Book book) {
        boolean bookExists = bookRepository.findByIsbn(book.getIsbn()).isPresent();
        if (bookExists) {
            throw new BookExistsException();
        }
        bookRepository.save(book);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @SneakyThrows
    @Transactional
    public Book updateBook(Book book) {
        Book existingBook = bookRepository.findById(book.getBookid()).orElse(null);
        if (existingBook == null) throw new BookExistsException("The book you'ere trying to edit does not exists");
        existingBook.setIsbn(book.getIsbn());
        existingBook.setImage(book.getImage());
        existingBook.setTitle(book.getTitle());
        existingBook.setPublishedDate(book.getPublishedDate());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setDescription(book.getDescription());
        existingBook.setPrice(book.getPrice());
        return bookRepository.save(existingBook);
    }

    public ResponseEntity deleteBook(Long id) {
        bookRepository.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @SneakyThrows
    @Transactional //All or any
    public void delateFromStock(Long bookId, Integer quantityOfBooks) {
        Book bookToUpdate = findOne(bookId);
        int updateStock = bookToUpdate.getProductStock() - quantityOfBooks;
        //TODO: Error, not enoug products in stock
        if (updateStock <= 0) throw new NotEnoughProductsInStockException();
        bookToUpdate.setProductStock(updateStock);
        bookRepository.save(bookToUpdate);

    }

    public List<Book> findByCategories(Category category) {
        return bookRepository.findByCategories(category);
    }

    public List<Book> findByTitle(String bookId) {
        return bookRepository.findByTitleContainingIgnoreCase(bookId);
    }
}
