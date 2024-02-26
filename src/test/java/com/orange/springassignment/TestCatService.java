package com.orange.springassignment;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
class TestCatService {

    CatRepository catRepository;

    void cleanRepo() {
        catRepository.deleteAll();
    }
}
