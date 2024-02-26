package com.orange.springassignment;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
class CatService {

    CatRepository catRepository;

    public List<Cat> allCats() {
        return catRepository.findAll();
    }

    public Cat register(Cat cat) {
        return catRepository.save(cat);
    }
}
