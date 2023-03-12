package com.emirhanarici.Library.dto.request;

import com.emirhanarici.Library.entity.BookStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


import java.io.File;

@Data
@Builder
@AllArgsConstructor
public class SaveBookRequest {

    @NotBlank
    private String title;
    @NotBlank
    private String authorName;
    @NotNull
    private BookStatus bookStatus;
    @NotBlank
    private String publisher;
    @NotNull
    private Integer lastPageNumber;
    @NotNull
    private Integer totalPage;
    private File image;
    @NotNull
    private Long categoryId;

}
