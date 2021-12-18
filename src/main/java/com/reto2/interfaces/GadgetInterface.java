package com.reto2.interfaces;

import com.reto2.model.Gadget;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GadgetInterface extends MongoRepository<Gadget, Integer> {

}
