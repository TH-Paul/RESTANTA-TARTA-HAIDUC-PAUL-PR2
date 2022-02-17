package map.View;

import map.controller.MitarbeiterController;
import map.controller.TeamController;
import map.model.Mitarbeiter;
import map.model.Team;

import java.io.IOException;
import java.util.Scanner;

public class View {
    private MitarbeiterController mitarbeiterController;
    private TeamController teamController;

    public View(MitarbeiterController mitarbeiterController, TeamController teamController) {
        this.mitarbeiterController = mitarbeiterController;
        this.teamController = teamController;
    }

    public static String readString() {
        Scanner in = new Scanner(System.in);
        return in.next();
    }

    public static int readInt(String toBeRead){
        Scanner in = new Scanner(System.in);
        boolean inputValid = false;
        while(!inputValid){
            System.out.print("Enter " + toBeRead + ": ");

            String input = in.next();

            try{
                int intInput = Integer.parseInt(input);

                if(intInput < 0){
                    System.out.println("Value must be greater than 0!");
                    continue;
                }

                inputValid = true;
                return intInput;
            }
            catch(NumberFormatException e){
                System.out.println("You must enter an integer!\n");
            }

        }
        return -1;
    }

    public void showMitarbeiter(){
        for (Mitarbeiter mitarbeiter : this.mitarbeiterController.getAll()){
            System.out.println(mitarbeiter);
        }
    }

    public void showTeams(){
        for (Team team : this.teamController.getAll()){
            System.out.println(team);
        }
    }

    public void addMitarbeiter(){
        int id = readInt("id");
        System.out.print("\nEnter mitarbeiter name: ");
        String name = readString();
        int loan = readInt("loan");

        mitarbeiterController.addMitarbeiter(id, name, loan);
    }

    public void addTeam(){
        int id = readInt("id");
        System.out.print("\nEnter team name: ");
        String name = readString();
        System.out.print("\nEnter projekt name: ");
        String projektName = readString();

        teamController.addTeam(id, name, projektName);
    }

    public void deleteMitarbeiter(){

        int id = readInt("id");
        if(mitarbeiterController.findById(id) == null){
            System.out.println("\nThere is no mitarbeiter with this id!\n");
            return;
        }

        mitarbeiterController.deleteMitarbeiter(id);
        System.out.println("\nMitarbeiter deleted with success!\n");
    }

    public void deleteTeam(){
        int id = readInt("id");
        if(teamController.findById(id) == null){
            System.out.println("\nThere is no team with this id!\n");
            return;
        }

        teamController.deleteTeam(id);
        System.out.println("\nTeam deleted with success!\n");
    }


    public void updateMitarbeiter(){


        int id = readInt("id");
        System.out.print("\nEnter mitarbeiter new name: ");
        String name = readString();
        int loan = readInt("loan");

        if(mitarbeiterController.findById(id) == null){
            System.out.println("\nThere is no mitarbeiter with this id!\n");
            return;
        }

        mitarbeiterController.updateMitarbeiter(id, name, loan);
        System.out.println("\nMitarbeiter updated with success!\n");
    }

    public void updateTeam(){

        int id = readInt("id");
        System.out.print("\nEnter team new name: ");
        String name = readString();
        System.out.print("\nEnter team new projekt name: ");
        String projetName = readString();

        if(teamController.findById(id) == null){
            System.out.println("\nThere is no team with this id!\n");
            return;
        }

        teamController.updateTeam(id, name, projetName);
        System.out.println("\nTeam updated with success!\n");
    }


    public static void showMenu() {
        System.out.println("\nMenu: ");
        System.out.println(" 0. Exit" + "\t\t\t\t\t\t\t\t\t\t\t\t8. Update team");
        System.out.println(" 1. Show  all mitarbeiter" + "\t\t\t\t\t\t\t\t\t9. Add mitarbeiter to team");
        System.out.println(" 2. Show all teams");
        System.out.println(" 3. Add mitarbeiter");
        System.out.println(" 4. Add team");
        System.out.println(" 5. Delete mitarbeiter");
        System.out.println(" 6. Delete team");
        System.out.println(" 7. Update mitarbeiter");
    }

    public void runMenu() throws IOException {
        boolean done = false;
        int option;

        while(!done) {
            showMenu();

            option = readInt("option");
            if(option >15){
                System.out.println("\nSelect a valid option!\n");
            }

            else if(option == 0){
                done = true;
            }

            else if(option == 1){
                showMitarbeiter();
            }

            else if(option == 2){
                showTeams();
            }

            else if(option == 3){
                addMitarbeiter();
            }

            else if(option == 4){
                addTeam();
            }

            else if(option == 5){
                deleteMitarbeiter();
            }

            else if(option == 6){
                deleteTeam();
            }

            else if(option == 7){
                updateMitarbeiter();
            }

            else if(option == 8){
                updateTeam();
            }
        }
    }
}
