package org.hmo;

import io.quarkus.mongodb.panache.PanacheMongoEntity;

public class Person extends PanacheMongoEntity {
    public String ad;
    public String soyad;
    public String adres;
}