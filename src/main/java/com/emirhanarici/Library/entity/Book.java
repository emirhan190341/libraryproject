package com.emirhanarici.Library.entity;

import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "book")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Book extends BaseEntity {

    private String title;
    private String authorName;
    @Enumerated(EnumType.STRING)
    private BookStatus bookStatus;
    private String publisher;
    private Integer lastPageNumber;
    private Integer totalPage;
    @OneToOne
    private Image image;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    private Long userId;


}
