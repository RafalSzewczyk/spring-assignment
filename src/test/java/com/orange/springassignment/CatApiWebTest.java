package com.orange.springassignment;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = CatController.class)
class CatApiWebTest {

    @Autowired
    MockMvc mockMvc;
    @MockBean
    CatService catService;

    @DisplayName("it should register new cat when POST on /cats with JSON data")
    @Test
    void registerCat() throws Exception {
        ArgumentCaptor<Cat> argumentCaptor = ArgumentCaptor.forClass(Cat.class);

        // given
        String catJson = "{ \"name\": \"tom\", \"age\": 4 }";

        // when
        mockMvc.perform(post("/cats")
                .content(catJson)
                .contentType(MediaType.APPLICATION_JSON));

        // then
        verify(catService).register(argumentCaptor.capture());
        Cat cat = argumentCaptor.getValue();
        assertThat(cat.getAge()).isEqualTo(4);
        assertThat(cat.getName()).isEqualTo("tom");
    }

    
    @DisplayName("it should return 200 and a list of cats when GET on /cats")
    @Test
    void findRegisteredAllCats() throws Exception {
    // given
        when(catService.allCats())
                .thenReturn(List.of(
                        new Cat("name0", 5),
                        new Cat("name1", 10),
                        new Cat("name2", 20)
                ));

        // when
        mockMvc.perform(get("/cats"))
                // then
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)));

        verify(catService).allCats();

    }

    /* TODO #4:
    1) Write test that checks if we can retrieve unique cat names on GET /cats/names
     */
    @DisplayName("it should return list of cat names when GET on /cats/names")
    @Test
    void findUniqueNames() throws Exception {
        // given

        // when

        // then      
        assertTrue(Boolean.FALSE);
    }


    /* TODO #4:
    1) Write test that checks if we can retrieve unique cat names with given letter formatted in uppercase on GET /cats/names?withLetterInName=o&upper=true
     */
    @DisplayName("it should return list of cat names in uppercase with given letter when GET on /cats/names?withLetterInName=o&upper=true")
    @Test
    void findUniqueNamesWithLetterInName() throws Exception {
        // given

        // when

        // then
        assertTrue(Boolean.FALSE);
    }
}
