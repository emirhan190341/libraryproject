package com.emirhanarici.Library.service;

import com.emirhanarici.Library.dto.request.BookSearchRequest;
import com.emirhanarici.Library.dto.response.BookResponse;
import com.emirhanarici.Library.entity.Book;
import com.emirhanarici.Library.entity.BookStatus;
import com.emirhanarici.Library.entity.Category;
import com.emirhanarici.Library.entity.CategoryType;
import com.emirhanarici.Library.repository.BookRepository;
import com.emirhanarici.Library.repository.CategoryRepository;
import com.emirhanarici.Library.utilities.mapper.ModelMapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookListService {

    private final CategoryService categoryService;
    private final BookRepository bookRepository;
    private final ModelMapperService modelMapperService;

    //convert request param
    //1.08
    public List<BookResponse> listBooks(int size, int page) {

//        return bookRepository.findAll(PageRequest.of(searchRequest.getPage(), searchRequest.getSize())).getContent()
//                .stream().map(book -> this.modelMapperService.forResponse()
//                        .map(book, BookResponse.class)).collect(Collectors.toList());

        return bookRepository.findAll(PageRequest.of(page,size)).getContent()
                .stream()
                .map(BookListService::convertResponse)
                .collect(Collectors.toList());

    }

    public List<BookResponse> searchByCategory(CategoryType categoryType) {

        Category category = categoryService.findByName(categoryType.getValue());
        return category.getBooks()
                .stream()
                .map(BookListService::convertResponse)
                .collect(Collectors.toList());

    }

    private static BookResponse convertResponse(Book book) {
        return BookResponse.builder()
                .authorName(book.getAuthorName())
                .title(book.getTitle())
                .imageUrl(book.getImage().getImageUrl())
                .build();
    }

    public List<BookResponse> searchBookStatus(BookStatus bookStatus) {
        return bookRepository.findByBookStatus(bookStatus)
                .stream()
                .map(each ->
                        BookResponse.builder()
                                .id(each.getId())
                                .imageUrl(each.getImage().getImageUrl())
                                .build()).collect(Collectors.toList());

    }

    public List<BookResponse> searchByTitle(String title) {
        return bookRepository.findByTitle(title)
                .stream()
                .map(each ->
                        BookResponse.builder()
                                .id(each.getId())
                                .imageUrl(each.getImage().getImageUrl())
                                .build()).collect(Collectors.toList());

    }


}
