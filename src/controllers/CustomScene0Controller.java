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

public class CustomScene0Controller implements Initializable {



    @FXML private RadioButton smallPizza;
    @FXML private RadioButton mediumPizza;
    @FXML private RadioButton bigPizza;
    @FXML private Label pizzaSizeLabel;
    @FXML private Label pizzaPriceLabel;
    private ToggleGroup pizzaSizeToggleGroup;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pizzaSizeLabel.setText("");



        pizzaSizeToggleGroup = new ToggleGroup();
        this.smallPizza.setToggleGroup(pizzaSizeToggleGroup);
        this.mediumPizza.setToggleGroup(pizzaSizeToggleGroup);
        this.bigPizza.setToggleGroup(pizzaSizeToggleGroup);

    }



    public void radioButtonChangedScene0(){
        if(this.pizzaSizeToggleGroup.getSelectedToggle().equals(this.smallPizza)){
            pizzaSizeLabel.setText("mała");

            pizzaPriceLabel.setText("20");
        }
        if(this.pizzaSizeToggleGroup.getSelectedToggle().equals(this.mediumPizza)){
            pizzaSizeLabel.setText("średnia");

            pizzaPriceLabel.setText("25");


        }
        if(this.pizzaSizeToggleGroup.getSelectedToggle().equals(this.bigPizza)){
            pizzaSizeLabel.setText("duża");

            pizzaPriceLabel.setText("30");
        }


    }

    @FXML

    private void next(ActionEvent event) throws IOException {
        try {
            ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
            if(!smallPizza.isSelected() && !mediumPizza.isSelected() && !bigPizza.isSelected()){
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/customScene0.fxml"));
                Parent root = (Parent) loader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();
            }else {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/customScene1.fxml"));
                Parent root = (Parent) loader.load();


                CustomScene1Controller controller1 = loader.getController();

                controller1.setPizzaSizeLbl(pizzaSizeLabel.getText());
                controller1.setPizzaPriceLbl(pizzaPriceLabel.getText());


                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
