package com.sandy.library.repository;

import com.sandy.library.entity.TestTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface TestTableRepository extends JpaRepository<TestTable, Integer> {
    @Query(value = "select convert(uncompress(blob_field) using 'utf8') as blob_field, json_field, text_field, id " +
            "from test_table where id = ?", nativeQuery = true)
    TestTable findByIdCustom(@Param("id") Integer id);
}
