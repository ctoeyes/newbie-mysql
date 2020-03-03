package com.jimmychow.mysql;

public interface MyISAM {
    void create(String A, Integer B, String C, Integer D);
    void retrieve(Integer D);
    void retrieveByIndex(Integer B);
    Integer getAll();
    void deleteAll();
}
