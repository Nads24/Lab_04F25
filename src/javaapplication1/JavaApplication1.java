/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication1;



import static java.lang.Double.parseDouble;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *https://github.com/Nads24
 * @author 2368301
 */
public class JavaApplication1 extends Application {
 // Declare text fields to store the user input
    TextField num_days, num_air, num_carfee, num_miles, num_parkfees, num_taxicharges, num_registration, num_lodging;
    Label total_expenses, total_allowable, excess, saved;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        Scene scene = new Scene(grid, 400, 400);
        stage.setTitle("Travel Expense Calculator");
        stage.setScene(scene);
        scene.getStylesheets().add(getClass().getResource("mystyles.css").toExternalForm());

        Label days = new Label("Number of days on the trip:");
        num_days = new TextField();
        grid.add(days, 0, 1);
        grid.add(num_days, 1, 1);

        Label airfare = new Label("Amount of airfare:");
        num_air = new TextField();
        grid.add(airfare, 0, 2);
        grid.add(num_air, 1, 2);

        Label car_rental_fees = new Label("Amount of car rental fees:");
        num_carfee = new TextField();
        grid.add(car_rental_fees, 0, 3);
        grid.add(num_carfee, 1, 3);

        Label miles = new Label("Number of miles driven (private vehicle only):");
        num_miles = new TextField();
        grid.add(miles, 0, 4);
        grid.add(num_miles, 1, 4);

        Label parking_fees = new Label("Amount of parking fees:");
        num_parkfees = new TextField();
        grid.add(parking_fees, 0, 5);
        grid.add(num_parkfees, 1, 5);

        Label taxi_charges = new Label("Amount of taxi charges:");
        num_taxicharges = new TextField();
        grid.add(taxi_charges, 0, 6);
        grid.add(num_taxicharges, 1, 6);

        Label registration = new Label("Conference or seminar registration fees:");
        num_registration = new TextField();
        grid.add(registration, 0, 7);
        grid.add(num_registration, 1, 7);

        Label lodging = new Label("Lodging charges per night:");
        num_lodging = new TextField();
        grid.add(lodging, 0, 8);
        grid.add(num_lodging, 1, 8);

  
        total_expenses = new Label("Total expenses incurred by the business person: $");
        total_allowable = new Label("Total allowable expenses for the trip: $");
        grid.add(total_expenses, 0, 9);
        grid.add(total_allowable, 0, 10);

        excess = new Label("Excess that must be paid by the business person: $");
        saved = new Label("Amount saved by the business person: $");
        grid.add(excess, 0, 11);
        grid.add(saved, 0, 12);

   
        Button calc = new Button("Calculate");
        Button reset = new Button("Clear");

        calc.setOnAction(e -> calculateExpenses());
        reset.setOnAction(e -> clearFields());

        grid.add(calc, 0, 13);
        grid.add(reset, 1, 13);

 
        stage.show();
    }
     private void calculateExpenses() {
        try {
            int days = Integer.parseInt(num_days.getText());
            double airfare = parseDouble(num_air.getText());
            double carRental = parseDouble(num_carfee.getText());
            double miles = parseDouble(num_miles.getText());
            double parking = parseDouble(num_parkfees.getText());
            double taxi = parseDouble(num_taxicharges.getText());
            double regestration = parseDouble(num_registration.getText());
            double lodgingChargesPerNight = parseDouble(num_lodging.getText());

            double totalMeals = 37.00 * days;
            double totalParking = Math.min(parking, 10.00) * days;
            double totalTaxi = Math.min(taxi, 20.00) * days;
            double totalLodging = Math.min(lodgingChargesPerNight, 95.00) * days;
            double totalMiles = miles * 0.27;
            double totalExpenses = totalMeals + airfare + carRental + totalMiles + totalParking + taxi + regestration + totalLodging;

            double totalAllowable = (37.00 * days) + (10.00 * days) + (20.00 * days) + (95.00 * days) + (0.27 * miles);
            double excessAmount = totalExpenses - totalAllowable;
            double amountSaved = totalAllowable - totalExpenses;

            total_expenses.setText("Total expenses incurred by the business person: $" + totalExpenses);
            total_allowable.setText("Total allowable expenses for the trip: $" + totalAllowable);
            if(excessAmount>0){
            excess.setText("Excess that must be paid by the business person: $" + excessAmount);
            }else{
            excess.setText("Excess that must be paid by the business person: $" + 0);
            }   
            saved.setText("Amount saved by the business person: $" + amountSaved);

        } catch (NumberFormatException e) {
            showError("Invalid input. Please enter valid numbers.");
            total_expenses.setText("Invalid input. Please enter valid numbers." );
            total_allowable.setText("Invalid input. Please enter valid numbers.");
            excess.setText("Invalid input. Please enter valid numbers.");
            saved.setText("Invalid input. Please enter valid numbers.");
        }
    }

    private void showError(String message) {
        System.out.println("Error: " + message);
    }
     private void clearFields() {
        num_days.clear();
        num_air.clear();
        num_carfee.clear();
        num_miles.clear();
        num_parkfees.clear();
        num_taxicharges.clear();
        num_registration.clear();
        num_lodging.clear();
        total_expenses.setText("Total expenses incurred by the business person: $");
        total_allowable.setText("Total allowable expenses for the trip: $");
        excess.setText("Excess that must be paid by the business person: $");
        saved.setText("Amount saved by the business person: $");
    
}
}
