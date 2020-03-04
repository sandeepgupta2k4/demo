package com.sandy.library.repository;

import com.sandy.library.entity.TestTable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class TestTableCustomImpl implements TestTableCustomRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    @Override
    public void insertWithQuery(TestTable t) {
        entityManager.createNativeQuery("insert into test_table (blob_field, json_field, text_field, id) values " +
                "(compress(?),?, ?, ?)").setParameter(1, t.getBlobField()).setParameter(2, t.getJsonField()).setParameter(3, t.getTextField()).setParameter(4, t.getId()).executeUpdate();

    }

}
