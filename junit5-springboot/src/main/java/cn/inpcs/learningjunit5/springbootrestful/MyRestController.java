/*
 * (C) Copyright 2017 Boni Garcia (http://bonigarcia.github.io/)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package cn.inpcs.learningjunit5.springbootrestful;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * The type My rest controller.
 *
 * @author inpcs
 * @version 1.0
 * @date 2020 -04-10 16:27:08
 */
@RestController
public class MyRestController {

    @Autowired
    private LibraryService libraryService;

    /**
     * Gets books.
     *
     * @return the books
     */
    @GetMapping(value = "/books")
    public List<Book> getBooks() {
        return libraryService.getBooks();
    }

    /**
     * Gets team.
     *
     * @param index the index
     * @return the team
     */
    @GetMapping(value = "/book/{index}")
    public Book getTeam(@PathVariable("index") int index) {
        return libraryService.getBook(index);
    }

    /**
     * Add book response entity.
     *
     * @param book the book
     * @return the response entity
     */
    @PostMapping(value = "/book")
    public ResponseEntity<Boolean> addBook(@RequestBody Book book) {
        libraryService.addBook(book);
        return new ResponseEntity<>(true, HttpStatus.CREATED);
    }

}
