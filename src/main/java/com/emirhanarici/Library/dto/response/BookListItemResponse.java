package com.emirhanarici.Library.dto.response;

import com.emirhanarici.Library.entity.BookStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.File;

@Data
@Builder
@AllArgsConstructor
public class BookListItemResponse {

    private Long id;
    private String title;
    private String authorName;
    private BookStatus bookStatus;
    private String publisher;
    private Integer lastPageNumber;
    private Integer totalPage;
    private File image;
    private String categoryName;
}
