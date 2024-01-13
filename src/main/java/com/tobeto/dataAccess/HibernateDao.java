package com.tobeto.dataAccess;

public class HibernateDao<T> implements IDao<T> {
    @Override
    public void add(T entities) {
        System.out.println("HIBERNATE ile veritabanına eklendi");
    }
}
