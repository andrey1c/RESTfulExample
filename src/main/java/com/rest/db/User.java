package com.rest.db;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by andrey on 09.08.2017.
 */
@Entity
public class User {
    @Id
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
