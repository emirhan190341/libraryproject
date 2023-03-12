package com.emirhanarici.Library.controller;

import com.emirhanarici.Library.dto.request.SaveBookRequest;
import com.emirhanarici.Library.dto.response.BookListItemResponse;
import com.emirhanarici.Library.service.BookListService;
import com.emirhanarici.Library.service.BookSaveService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles(value = "integration")
class BookControllerTest {

    @MockBean
    private BookListService bookListService;
    @MockBean
    private BookSaveService bookSaveService;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;


    @Test
    void itShouldSaveBook_WhenValidBookRequestBody() throws Exception {

        //given
        SaveBookRequest request = SaveBookRequest.builder()
                .title("title")
                .totalPage(100)
                .build();

        BookListItemResponse response = BookListItemResponse.builder()
                .title("title")
                .authorName("authorName")
                .build();

        //when
        when(bookSaveService.saveBook(request)).thenReturn(response);


        //then
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/book/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(serializeJson(request)))
                .andDo(print())
                .andExpect(jsonPath("$.title").value(request.getTitle()));


    }

    private String serializeJson(Object object) throws JsonProcessingException {
        return objectMapper.writeValueAsString(object);
    }


}