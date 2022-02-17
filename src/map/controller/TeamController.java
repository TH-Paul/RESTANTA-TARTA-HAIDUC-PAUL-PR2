package map.controller;

import map.model.Mitarbeiter;
import map.model.Team;

import java.util.ArrayList;
import java.util.List;

public class TeamController {
    private List<Team> listeTeams;
    private MitarbeiterController mitarbeiterController;

    public TeamController(MitarbeiterController mitarbeiterController){
        this.listeTeams = new ArrayList<>();
        this.mitarbeiterController = mitarbeiterController;
    }

    public Team addTeam(int id, String name, String projektName){
        Team addedTeam = new Team(id, name, projektName);
        listeTeams.add(addedTeam);
        return addedTeam;
    }

    public void deleteTeam(int id){
        listeTeams.removeIf(team -> team.getId() == id);
    }

    public void updateTeam(int id, String name, String projektName){
        for (Team team:
                listeTeams) {
            if(team.getId() == id){
                team.setName(name);
                team.setProjektName(projektName);
            }
        }
    }

    public List<Team> getAll() {
        return listeTeams;
    }

    public Team findById(Integer id) {
        for (Team team:
                listeTeams) {
            if(team.getId() == id)
                return team;
        }
        return null;
    }

    public void addMitarbeiterToTeam(int idTeam, int idMitarbeiter){
        for(Team team : listeTeams){
            if(team.getId() == idTeam){
                team.getListeMitarbeiter().add(idMitarbeiter);
            }
        }
    }

    public List<Team> filterByMitarbeiter(int id){
        List<Team> filteredTeams = new ArrayList<>();
        for(Team team : listeTeams){
            for(int mitarbeiterId : team.getListeMitarbeiter()){
                if(mitarbeiterId == id){
                    filteredTeams.add(team);
                }
            }
        }
        return filteredTeams;
    }
}
