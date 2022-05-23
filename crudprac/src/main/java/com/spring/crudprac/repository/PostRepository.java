package com.spring.crudprac.repository;

import com.spring.crudprac.model.Posting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Posting, Long> {
}
