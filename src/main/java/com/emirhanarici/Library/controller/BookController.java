package com.emirhanarici.Library.controller;

import com.emirhanarici.Library.dto.request.SaveBookRequest;
import com.emirhanarici.Library.dto.response.BookListItemResponse;
import com.emirhanarici.Library.dto.response.BookResponse;
import com.emirhanarici.Library.entity.BookStatus;
import com.emirhanarici.Library.entity.CategoryType;
import com.emirhanarici.Library.service.BookListService;
import com.emirhanarici.Library.service.BookSaveService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/book")
@RequiredArgsConstructor
public class BookController {

    private final BookListService bookListService;
    private final BookSaveService bookSaveService;

    @PostMapping("/save")
    public ResponseEntity<BookListItemResponse> saveBook(@RequestBody @Valid SaveBookRequest saveBookRequest) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(bookSaveService.saveBook(saveBookRequest));

    }

    @GetMapping("/search")
    public ResponseEntity<List<BookResponse>> listBook(@RequestParam(name = "size") int size, @RequestParam(name = "page") int page) {
        return ResponseEntity.ok(bookListService.listBooks(size, page));
    }

    @GetMapping("/list/{categoryType}")
    public ResponseEntity<List<BookResponse>> listByCategory(@PathVariable CategoryType categoryType) {
        return ResponseEntity.ok(this.bookListService.searchByCategory(categoryType));
    }

    @GetMapping("/list/{status}")
    public ResponseEntity<List<BookResponse>> listByStatus(@PathVariable BookStatus status) {
        return ResponseEntity.ok(this.bookListService.searchBookStatus(status));
    }

    @GetMapping("/list/{title}")
    public ResponseEntity<List<BookResponse>> listByTitle(@PathVariable String title) {
        return ResponseEntity.ok(this.bookListService.searchByTitle(title));
    }


}
