package controllers;


import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class OrderSummaryInSceneController implements Initializable {


    @FXML private Label pizzaSizeLabel;
    @FXML private Label pizzaPriceLabel;
    @FXML private Label pizzaPriceLabel1;
    @FXML private Label allExtrasLabel;
    @FXML private Label pizzaTotalCostLabel;


    public void saveToFile() throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/order.txt", true))) {
            bw.newLine();
            bw.newLine();
            bw.newLine();
            bw.newLine();
            bw.write("NA MIEJSCU");
            bw.newLine();
            bw.write("------------------------------");
            bw.newLine();
            bw.write("Rozmiar:");
            bw.newLine();
            bw.write(pizzaSizeLabel.getText());
            bw.newLine();
            bw.write("Dodatki:");
            bw.write(allExtrasLabel.getText());
            bw.newLine();
            bw.write("------------------------------");
            bw.newLine();
            bw.write("Do zapłaty:");
            bw.newLine();
            bw.write(pizzaTotalCostLabel.getText());

        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @FXML
    private void orderAgain(ActionEvent event) throws IOException {
        try {
            ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
            FXMLLoader loader=new FXMLLoader(getClass().getResource("/resources/startScene.fxml"));
            Parent root = (Parent) loader.load();



            Stage stage=new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    public void pizzaSizeLbl(String text) {
        pizzaSizeLabel.setText(text);
    }



    public void allExtrasLbl(String text) {
        allExtrasLabel.setText(text);
    }


    public void pizzaPriceLbl(String text) {
        pizzaPriceLabel.setText(text + " PLN");
    }

    public void pizzaPriceLbl1(String text) {
        pizzaPriceLabel1.setText(text + " PLN");
    }
    public void pizzaTotalCostLbl(String text) {
        pizzaTotalCostLabel.setText(text + " PLN");
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
