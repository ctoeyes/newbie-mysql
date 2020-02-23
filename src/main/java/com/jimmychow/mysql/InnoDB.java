package com.jimmychow.mysql;

public interface InnoDB {
    void create(String A, Integer B, String C, Integer D);
    void retrieve(Integer B);
    void retrieveByIndex(Integer B);
    Integer getAll();
    void deleteAll();
}