package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CustomEndSceneController implements Initializable {
    private CustomScene0Controller customScene0Controller;
    @FXML private Label order1;
    @FXML private Label pizzaSizeLabel;
    @FXML private Label pizzaDoughLabel;
    @FXML private Label pizzaPriceLabel;
    @FXML private Label pizzaPriceLabel1;
    @FXML private Label allExtrasLabel;
    @FXML private Label pizzaTotalCostLabel;
    @FXML private Label fullPriceTextLabel;
    @FXML private Label plnLabel;
    @FXML private Button finalCost;
    @FXML private TextField nameTextField;
    @FXML private TextField streetTextField;
    @FXML private TextField cityTextField;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void finalCost(){
        fullPriceTextLabel.setText("CAŁKOWITA CENA PIZZY WYNOSI: ");
        plnLabel.setText("PLN");
        pizzaTotalCostLabel.setText(Integer.toString(Integer.parseInt(pizzaPriceLabel.getText())+Integer.parseInt(pizzaPriceLabel1.getText())));
    }


    public void pizzaPriceLbl1(String text) {
        pizzaPriceLabel1.setText(text);

    }

    public void pizzaSizeLbl(String text) {
        pizzaSizeLabel.setText(text);
    }



    public void allExtrasLbl(String text) {
        allExtrasLabel.setText(text);
    }

    public void pizzaDoughLbl(String text) {
        pizzaDoughLabel.setText(text);
    }

    public void pizzaPriceLbl(String text) {
        pizzaPriceLabel.setText(text);
    }

    public void pizzaTotalCostLbl(String text) {
        pizzaTotalCostLabel.setText(text);
    }

    @FXML
    private void inSummary(ActionEvent event) throws IOException {
        try {

            ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
            FXMLLoader loader=new FXMLLoader(getClass().getResource("/resources/orderSummaryInScene.fxml"));
            Parent root = (Parent) loader.load();

            OrderSummaryInSceneController orderSummaryInSceneController =loader.getController();
            orderSummaryInSceneController.allExtrasLbl(allExtrasLabel.getText());
            orderSummaryInSceneController.pizzaSizeLbl(pizzaSizeLabel.getText());
            orderSummaryInSceneController.pizzaPriceLbl(pizzaPriceLabel.getText());
            orderSummaryInSceneController.pizzaPriceLbl1(pizzaPriceLabel1.getText());
            orderSummaryInSceneController.pizzaTotalCostLbl(pizzaTotalCostLabel.getText());



            Stage stage=new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void outSummary(ActionEvent event) throws IOException {
        try {
            String nameNsur = nameTextField.getText();
            String streetNnb = streetTextField.getText();
            String postNcity = cityTextField.getText();

            if (nameNsur == null || nameNsur.trim().isEmpty() || streetNnb == null || streetNnb.trim().isEmpty() || postNcity == null || postNcity.trim().isEmpty()) {
                //
            }
            else {

                ((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/orderSummaryOutScene.fxml"));
                Parent root = (Parent) loader.load();
                if(Integer.parseInt(pizzaTotalCostLabel.getText())<=30){
                    pizzaTotalCostLabel.setText(Integer.toString(Integer.parseInt(pizzaTotalCostLabel.getText()) + 16));
                }else {
                    pizzaTotalCostLabel.setText(Integer.toString(Integer.parseInt(pizzaTotalCostLabel.getText()) + 8));
                }
                OrderSummaryOutSceneController orderSummaryOutSceneController = loader.getController();
                orderSummaryOutSceneController.allExtrasLbl(allExtrasLabel.getText());
                orderSummaryOutSceneController.pizzaSizeLbl(pizzaSizeLabel.getText());
                orderSummaryOutSceneController.pizzaPriceLbl(pizzaPriceLabel.getText());
                orderSummaryOutSceneController.pizzaPriceLbl1(pizzaPriceLabel1.getText());
                orderSummaryOutSceneController.pizzaTotalCostLbl(pizzaTotalCostLabel.getText());
                orderSummaryOutSceneController.displayName(nameNsur);
                orderSummaryOutSceneController.displayStreet(streetNnb);
                orderSummaryOutSceneController.displayCity(postNcity);


                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
            }
    }



