package com.sts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sts.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
