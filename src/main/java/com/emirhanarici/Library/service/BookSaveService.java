package com.emirhanarici.Library.service;

import com.emirhanarici.Library.dto.request.SaveBookRequest;
import com.emirhanarici.Library.dto.response.BookListItemResponse;
import com.emirhanarici.Library.entity.Book;
import com.emirhanarici.Library.entity.Category;
import com.emirhanarici.Library.repository.BookRepository;
import com.emirhanarici.Library.utilities.mapper.ModelMapperService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookSaveService {

    private final BookRepository bookRepository;
    private final CategoryService categoryService;
    private final ModelMapperService modelMapperService;

    @Transactional
    public BookListItemResponse saveBook(SaveBookRequest saveBookRequest) {

        Category category = categoryService.loadCategory(saveBookRequest.getCategoryId());

        Book book = this.modelMapperService.forRequest().map(saveBookRequest, Book.class);

        Book fromDb = bookRepository.save(book);

        return this.modelMapperService.forResponse().map(fromDb, BookListItemResponse.class);

    }


}
