package com.example.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class CalculatorController {
    @FXML
    public TextField textPolje;

    public void sedamClick(ActionEvent actionEvent) {
        textPolje.appendText("7");
    }

    public void osmicaClick(ActionEvent actionEvent) {
        textPolje.appendText("8");
    }

    public void devetkaClick(ActionEvent actionEvent) {
        textPolje.appendText("9");
    }

    public void cetvorkaClick(ActionEvent actionEvent) {
        textPolje.appendText("4");
    }

    public void peticaClick(ActionEvent actionEvent) {
        textPolje.appendText("5");
    }

    public void sesticaClick(ActionEvent actionEvent) {
        textPolje.appendText("6");
    }

    public void jedinicaClick(ActionEvent actionEvent) {
        textPolje.appendText("1");
    }

    public void dvicaClick(ActionEvent actionEvent) {
        textPolje.appendText("2");
    }

    public void tricaClick(ActionEvent actionEvent) {
        textPolje.appendText("3");
    }

    public void nulaClick(ActionEvent actionEvent) {
        textPolje.appendText("0");
    }

    public void modClick(ActionEvent actionEvent) {
        textPolje.appendText("%");
    }

    public void dijeljenjeClick(ActionEvent actionEvent) {
        textPolje.appendText("/");
    }

    public void mnozenjeClick(ActionEvent actionEvent) {
        textPolje.appendText("x");
    }

    public void oduzimanjeClick(ActionEvent actionEvent) {
        textPolje.appendText("-");
    }

    public void sabiranjeClick(ActionEvent actionEvent) {
        textPolje.appendText("+");
    }

    public void tackaClick(ActionEvent actionEvent) {
        textPolje.appendText(".");
    }

    public void jednakoClick(ActionEvent actionEvent) {
        String uneseno = new String(textPolje.getText());
        ArrayList<Double> brojevi = new ArrayList<Double>();
        ArrayList<Character> operacije = new ArrayList<Character>();
        String broj = "";
        //Dodvanje brojeva i operacije u liste
        for (int i = 0; i < uneseno.length(); i++) {
            if(uneseno.charAt(i) == '0' || uneseno.charAt(i) == '1' || uneseno.charAt(i) == '2' || uneseno.charAt(i) == '3' || uneseno.charAt(i) == '4' || uneseno.charAt(i) == '5' || uneseno.charAt(i) == '6' || uneseno.charAt(i) == '7' || uneseno.charAt(i) == '8' || uneseno.charAt(i) == '9') {
                broj = broj + uneseno.charAt(i);
                continue;
            }else {
                brojevi.add(Double.valueOf(broj));
                broj = "";
                operacije.add(uneseno.charAt(i));
            }
        }
        brojevi.add(Double.valueOf(broj));
        //Racunanje rezultat
        double suma = 0;
        for(int i = 0; i<brojevi.size(); i++){
            if(i == 0){
                double a = brojevi.get(i);
                double b = brojevi.get(i+1);
                Character c = operacije.get(i);
                i++;
                if(c == '+'){
                    suma = a + b;
                }
                else if (c == 'x'){
                    suma = a * b;
                }
                else if (c == '/'){
                    suma = a / b;
                }
                else if (c == '%'){
                    suma = a % b;
                }
                else if (c == '-'){
                    suma = a - b;
                }
                else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Alert");
                    alert.setHeaderText("Pogresna operacija pri unosu!!");
                    alert.setContentText("Vratite se na unos ponovno!!");
                    ButtonType okButton = new ButtonType("OK");
                    alert.getButtonTypes().setAll(okButton);
                    alert.showAndWait();
                }
            }
            else if(i < brojevi.size()){
                double a = brojevi.get(i);
                char c = operacije.get(i-1);
                if(c == '+'){
                    suma = suma + a;
                }
                else if (c == 'x'){
                    suma = suma * a;
                }
                else if (c == '/'){
                    suma = suma / a;
                }
                else if (c == '%'){
                    suma = suma % a;
                }
                else if (c == '-'){
                    suma = suma - a;
                }
                else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Alert");
                    alert.setHeaderText("Pogresna operacija pri unosu!!");
                    alert.setContentText("Vratite se na unos ponovno!!");
                    ButtonType okButton = new ButtonType("OK");
                    alert.getButtonTypes().setAll(okButton);
                    alert.showAndWait();
                }
            }
        }
        textPolje.setText("RESULT: " + suma);
    }
}
