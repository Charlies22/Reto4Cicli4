package com.reto2.service;

import com.reto2.model.Gadget;
import com.reto2.repository.GadgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GadgetService {
    @Autowired
    private GadgetRepository clotheRepository;

    public List<Gadget> getAll() {
        return clotheRepository.getAll();
    }

    public Optional<Gadget> getClothe(Integer id) {
        return clotheRepository.getClothe(id);
    }

    public Gadget create(Gadget gadget) {
        if (gadget.getId() == null) {
            return gadget;
        } else {
            return clotheRepository.create(gadget);
        }
    }

    public Gadget update(Gadget gadget) {

        if (gadget.getId() != null) {
            Optional<Gadget> dbGadget = clotheRepository.getClothe(gadget.getId());
            if (!dbGadget.isEmpty()) {

                if (gadget.getBrand()!= null) {
                    dbGadget.get().setBrand(gadget.getBrand());
                }

                if (gadget.getCategory() != null) {
                    dbGadget.get().setCategory(gadget.getCategory());
                }

                if (gadget.getName() != null) {
                    dbGadget.get().setName(gadget.getName());
                }

                if (gadget.getDescription() != null) {
                    dbGadget.get().setDescription(gadget.getDescription());
                }

                if (gadget.getPrice() != 0.0) {
                    dbGadget.get().setPrice(gadget.getPrice());
                }

                if (gadget.getQuantity() != 0) {
                    dbGadget.get().setQuantity(gadget.getQuantity());
                }

                if (gadget.getPhotography() != null) {
                    dbGadget.get().setPhotography(gadget.getPhotography());
                }

                dbGadget.get().setAvailability(gadget.isAvailability());
                clotheRepository.update(dbGadget.get());
                return dbGadget.get();
            } else {
                return gadget;
            }
        } else {
            return gadget;
        }
    }

    public boolean delete(Integer reference) {
        Boolean aBoolean = getClothe(reference).map(gadget -> {
            clotheRepository.delete(gadget);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
