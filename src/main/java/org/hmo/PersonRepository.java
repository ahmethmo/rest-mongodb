package org.hmo;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import io.quarkus.panache.common.Sort;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class PersonRepository implements PanacheMongoRepository<Person> {

    public Person findByName(String adi){
        return find("adi", adi).firstResult();
    }

    public List<Person> findOrderedAdi(){
        return listAll(Sort.by("ad").ascending());
    }
}