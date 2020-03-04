package com.sandy.library.entity;

import org.json.JSONObject;

import javax.persistence.*;
import java.sql.Blob;

@Entity
@Table(name = "test_table")
public class TestTable {
    @Column(name = "blob_field")
    private String blobField;

    @Column(name ="json_field")
    private String jsonField;

    @Column(name = "text_field")
    private String textField;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJsonField() {
        return jsonField;
    }

    public void setJsonField(String jsonField) {
        this.jsonField = jsonField;
    }

    public String getBlobField() {
        return blobField;
    }

    public void setBlobField(String blobField) {
        this.blobField = blobField;
    }

    public String getTextField() {
        return textField;
    }

    public void setTextField(String textField) {
        this.textField = textField;
    }
}
