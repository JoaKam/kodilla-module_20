package com.kodilla.kodillapatterns2.adapter.company.oldhrsystem;

public class Workers {

    private String[][] workers = {
            {"492981", "John", "Smith"},
            {"498921", "Jan", "Sith"},
            {"499782", "Jyn", "Smniith"},
            {"492427", "Jun", "Small"}
    };

    private double[] salaries = {
            100.00,
            200.00,
            300.00,
            400.00,
    };

    public String getWorker(int n) {
        if (n > salaries.length) {
            return "";
        }
        return workers[n][0] + ", " + workers[n][1] + ", " + workers[n][2] + ", " + salaries[n];
    }

    public String[][] getWorkers() {
        return workers;
    }

    public double[] getSalaries() {
        return salaries;
    }
}
