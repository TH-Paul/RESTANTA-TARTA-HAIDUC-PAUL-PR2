package map.model;

public class Mitarbeiter {
    private int id;
    private String name;
    private int loan;

    public Mitarbeiter(int id, String name, int loan) {
        this.id = id;
        this.name = name;
        this.loan = loan;
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

    public int getLoan() {
        return loan;
    }

    public void setLoan(int loan) {
        this.loan = loan;
    }

    @Override
    public String toString() {
        return "Mitarbeiter{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", loan=" + loan +
                '}';
    }
}
