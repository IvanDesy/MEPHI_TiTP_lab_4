package main_package;


public class Main {

    public static void main(String[] args) {
        
        Manager manager = new Manager();
        GUI gui = new GUI(manager);
        gui.setTitle("Лабораторная работа №4");
        
        gui.setLocationRelativeTo(null);
        gui.setVisible(true);
    }
}
