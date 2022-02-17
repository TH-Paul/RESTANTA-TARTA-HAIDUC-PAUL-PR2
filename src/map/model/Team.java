package map.model;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private int id;
    private String name;
    private String projektName;
    private List<Integer> listeMitarbeiter;

    public Team(int id, String name, String projektName) {
        this.id = id;
        this.name = name;
        this.projektName = projektName;
        this.listeMitarbeiter = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProjektName() {
        return projektName;
    }

    public void setProjektName(String projektName) {
        this.projektName = projektName;
    }

    public List<Integer> getListeMitarbeiter() {
        return listeMitarbeiter;
    }

    public void setListeMitarbeiter(List<Integer> listeMitarbeiter) {
        this.listeMitarbeiter = listeMitarbeiter;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", projektName='" + projektName + '\'' +
                ", listeMitarbeiter=" + listeMitarbeiter +
                '}';
    }
}
