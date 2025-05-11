package main.service;

import lombok.Getter;
import main.logic.Gadgets;

import java.util.ArrayList;
import java.util.List;

@Getter
public class GadgetsService {
    private static GadgetsService INSTANCE;
    private final List<Gadgets> gadgets = new ArrayList<>();

    public void add(Gadgets gadget) {
        gadgets.add(gadget);
    }

    public void delete(int index) {
        gadgets.remove(index);
    }

    public static synchronized GadgetsService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new GadgetsService();
        }
        return INSTANCE;
    }
}
