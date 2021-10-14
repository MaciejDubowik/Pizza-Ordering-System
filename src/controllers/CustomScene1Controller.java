package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CustomScene1Controller implements Initializable {

    @FXML private Label pizzaSizeLabel;
    @FXML private Label pizzaDoughLabel;
    @FXML private Label pizzaPriceLabel;
    @FXML private RadioButton thinPizzaRadioButton;
    @FXML private RadioButton thickPizzaRadioButton;

    private ToggleGroup pizzaDoughToggleGroup;



    public void radioButtonChangedScene1(){
        int intPrice = Integer.parseInt(pizzaPriceLabel.getText());
        if(this.pizzaDoughToggleGroup.getSelectedToggle().equals(this.thinPizzaRadioButton)){
            pizzaDoughLabel.setText("cienkie");
            if(intPrice == 20 || intPrice == 25 || intPrice == 30){
                pizzaPriceLabel.getText();
            }
            else{
                pizzaPriceLabel.setText(Integer.toString(Integer.parseInt(pizzaPriceLabel.getText())-2));
            }

        }
        if(this.pizzaDoughToggleGroup.getSelectedToggle().equals(this.thickPizzaRadioButton)){

            pizzaDoughLabel.setText("grube");

            pizzaPriceLabel.setText(Integer.toString(Integer.parseInt(pizzaPriceLabel.getText())+2));

        }

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pizzaDoughLabel.setText("");
        pizzaDoughToggleGroup = new ToggleGroup();
        this.thinPizzaRadioButton.setToggleGroup(pizzaDoughToggleGroup);
        this.thickPizzaRadioButton.setToggleGroup(pizzaDoughToggleGroup);

    }

    public void setPizzaSizeLbl(String text) {

        pizzaSizeLabel.setText(text);
    }


    @FXML

    private void next(ActionEvent event) throws IOException {
        try {
            ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
            if(!thinPizzaRadioButton.isSelected() && !thickPizzaRadioButton.isSelected()){
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/customScene1.fxml"));
                Parent root = loader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();

            }else {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/customScene2.fxml"));
                Parent root = loader.load();


                CustomScene2Controller controller2 = loader.getController();

                controller2.setPizzaSizeLbl(pizzaSizeLabel.getText());
                controller2.setPizzaPriceLbl(pizzaPriceLabel.getText());
                controller2.setPizzaDoughLbl(pizzaDoughLabel.getText());


                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setPizzaPriceLbl(String text) {

        pizzaPriceLabel.setText("" + text);
    }
}
