package map;

import map.View.View;
import map.controller.MitarbeiterController;
import map.controller.TeamController;
import map.model.Mitarbeiter;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        MitarbeiterController mitarbeiterController = new MitarbeiterController();
        TeamController teamController = new TeamController(mitarbeiterController);
        View view = new View(mitarbeiterController, teamController);
        view.runMenu();
    }
}
