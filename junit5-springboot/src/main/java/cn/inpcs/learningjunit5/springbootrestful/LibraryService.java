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

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

/**
 * The type Library service.
 *
 * @author inpcs
 * @version 1.0
 * @date 2020 -04-10 16:27:01
 */
@Service
public class LibraryService {

    /**
     * The constant YEAR_1937.
     */
    public static final int YEAR_1937 = 1937;
    /**
     * The constant YEAR_1980.
     */
    public static final int YEAR_1980 = 1980;
    /**
     * The constant YEAR_1996.
     */
    public static final int YEAR_1996 = 1996;
    /**
     * The constant MONTH_2.
     */
    public static final int MONTH_2 = 2;
    /**
     * The constant MONTH_4.
     */
    public static final int MONTH_4 = 4;
    /**
     * The constant MONTH_1.
     */
    public static final int MONTH_1 = 1;
    /**
     * The constant DAY_OF_MONTH_21.
     */
    public static final int DAY_OF_MONTH_21 = 21;
    /**
     * The constant DAY_OF_MONTH.
     */
    public static final int DAY_OF_MONTH = 1;

    private List<Book> books = new ArrayList<>();

    @PostConstruct
    private void populateLibrary() {
        addBook(new Book("The Hobbit", "J. R. R. Tolkien", LocalDate.of(YEAR_1937, MONTH_2, DAY_OF_MONTH_21)));
        addBook(new Book("A Confederacy of Dunces", "John Kennedy Toole", LocalDate.of(YEAR_1980, MONTH_4, DAY_OF_MONTH)));
        addBook(new Book("A Game of Thrones (A Song of Ice and Fire)", "George R.R. Martin", LocalDate.of(YEAR_1996, MONTH_1, DAY_OF_MONTH)));
    }

    /**
     * Gets books.
     *
     * @return the books
     */
    public List<Book> getBooks() {
        return books;
    }

    /**
     * Gets book.
     *
     * @param index the index
     * @return the book
     */
    public Book getBook(int index) {
        return books.get(index);
    }

    /**
     * Add book.
     *
     * @param book the book
     */
    public void addBook(Book book) {
        books.add(book);
    }

    /**
     * Remove book.
     *
     * @param index the index
     */
    public void removeBook(int index) {
        books.remove(index);
    }

}
