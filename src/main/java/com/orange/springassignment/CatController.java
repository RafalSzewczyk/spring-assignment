package com.orange.springassignment;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@RequestMapping("/cats")
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
class CatController {
    CatService catService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cat register(@RequestBody Cat cat) {
        return catService.register(cat);
    }

    /*
     * TODO #1:
     * Return list of all cats
     * -------------------------------------------
     * TODO #2: GET /cats?name=Tom&age=11
     * Find all cats with given name and/or age
     */
    @GetMapping
    public List<Cat> findCats() {
        return Collections.emptyList();
    }

    /*
     * TODO #3: GET /cats/{id}
     * 1) Return cat with given ID or null
     */
    @GetMapping("/{id}")
    public Optional<Cat> singleCat(@PathVariable UUID id) {
        return Optional.ofNullable(null);
    }

    /*
     * TODO #4: GET /cats/names
     * 1) Find list of unique cat names that are registered in the service
     * 2) Add two optional parameters:
     * - withLetterInName: str -> select only names with given letter (or string)
     * - upper: bool -> transform returned names to UPPERCASE
     * 3) Write test that checks this functionality
     */
    @GetMapping("/names")
    public Iterable<String> catNames() {
        return Collections.emptyList();
    }
}
