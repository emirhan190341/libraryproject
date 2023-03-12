package com.emirhanarici.Library.entity;


public enum CategoryType {

    RESEARCH_HISTORY("Arastirma - Tarih"),
    SCIENCE("Bilim"),
    COMIC("Cizgi Roman"),
    CHILD_AND_YOUTH("Cocuk ve Genclik"),
    LESSON_TEST_BOOKS("Ders / Sinav Kitaplari"),
    RELIGION("Din Tasavvuf"),
    LITERATURE("Ededbiyat"),
    EDUCATION_REFERENCE("Egitim Basvuru");


    private final String value;

    CategoryType(String value) {

        this.value = value;

    }

    public String getValue() {
        return value;
    }


}
