package com.codegym.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface StudentRepository extends PagingAndSortingRepository<com.codegym.model.Student,Long> {
}
