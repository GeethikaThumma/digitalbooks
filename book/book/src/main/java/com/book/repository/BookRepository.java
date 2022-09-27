package com.book.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.book.entity.BookEntity;

public interface BookRepository extends JpaRepository<BookEntity, Integer> {

	List<BookEntity> findByName(String name);

	@Query("select D from BookEntity D where D.category=?1 and author=?2 and price=?3 and publisher=?4")
	List<BookEntity> findbycap(String category, String author, double price, String publisher);
	
	
}