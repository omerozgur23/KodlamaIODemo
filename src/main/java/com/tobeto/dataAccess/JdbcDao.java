package com.tobeto.dataAccess;

public class JdbcDao<T> implements IDao<T> {
    @Override
    public void add(T entities) {
        System.out.println("JDBC ile veritabanına eklendi");
    }
}
