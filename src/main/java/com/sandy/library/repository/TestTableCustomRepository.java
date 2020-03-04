package com.sandy.library.repository;

import com.sandy.library.entity.TestTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface TestTableCustomRepository {
    void insertWithQuery(TestTable t);
}
