package map.controller;

import map.model.Mitarbeiter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MitarbeiterController {
    private List<Mitarbeiter> listeMitarbeiter;

    public MitarbeiterController(){
        this.listeMitarbeiter = new ArrayList<>();
    }

    public Mitarbeiter addMitarbeiter(int id, String name, int loan){
        Mitarbeiter addedMitarbeiter = new Mitarbeiter(id, name, loan);
        listeMitarbeiter.add(addedMitarbeiter);
        return addedMitarbeiter;
    }

    public void deleteMitarbeiter(int id){
        listeMitarbeiter.removeIf(mitarbeiter -> mitarbeiter.getId() == id);
    }

    public void updateMitarbeiter(int id, String name, int loan){
        for (Mitarbeiter mitarbeiter:
                listeMitarbeiter) {
            if(mitarbeiter.getId() == id){
                mitarbeiter.setName(name);
                mitarbeiter.setLoan(loan);
            }
        }
    }

    public List<Mitarbeiter> getAll() {
        return listeMitarbeiter;
    }

    public Mitarbeiter findById(Integer id) {
        for (Mitarbeiter mitarbeiter:
                listeMitarbeiter) {
            if(mitarbeiter.getId() == id)
                return mitarbeiter;
        }
        return null;
    }

}
