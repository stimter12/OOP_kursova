package main.service;

import lombok.Getter;
import main.model.Gadget;

import java.util.ArrayList;
import java.util.List;

@Getter
public class GadgetsService {
    private static GadgetsService INSTANCE;
    private final List<Gadget> gadgets = new ArrayList<>();

    public void add(Gadget gadget) {
        gadgets.add(gadget);
    }

    public void addAll(List<Gadget> gadgets) {
        this.gadgets.addAll(gadgets);
    }

    public void delete(int index) {
        gadgets.remove(index);
    }

    private GadgetsService() {
    }

    public static synchronized GadgetsService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new GadgetsService();
        }
        return INSTANCE;
    }
}
