package controllers;



import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class CustomScene2Controller implements Initializable {



    @FXML
    private Button button;
    @FXML
    private AnchorPane container;
    @FXML private Label pizzaDoughLabel;
    @FXML private Label pizzaSizeLabel;
    @FXML private Label pizzaPriceLabel;
    @FXML private Label pizzaPriceLabel1;
    @FXML
    private Label allExtrasLabel;
    @FXML private CheckBox salami;
    @FXML private CheckBox pineapple;
    @FXML private CheckBox broccoli;
    @FXML private CheckBox onion;
    @FXML private CheckBox garlic;
    @FXML private CheckBox feta;
    @FXML private CheckBox corn;
    @FXML private CheckBox cucumber;
    @FXML private CheckBox olives;
    @FXML private CheckBox chilli;
    @FXML private CheckBox pepperoniPepper;
    @FXML private CheckBox mushrooms;
    @FXML private CheckBox doubleCheese;
    @FXML private CheckBox tomato;
    @FXML private CheckBox parmesan;
    @FXML private CheckBox spinach;
    @FXML private CheckBox ham;
    @FXML private CheckBox bacon;
    @FXML private CheckBox chicken;
    @FXML private CheckBox sausage;
    @FXML private CheckBox prawns;
    @FXML private CheckBox tuna;
    @FXML private CheckBox salmon;





    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        allExtrasLabel.setText("wybrane dodatki:");
        pizzaOrderButtonPushed();


    }

    public void pizzaOrderButtonPushed(){
        String order = "";


        if(salami.isSelected()){
            order += "\n salami";

        }
        if(pineapple.isSelected()){
            order += "\n ananas";

        }
        if(broccoli.isSelected()){
            order += "\n brokuły";

        }
        if(onion.isSelected()){
            order += "\n cebula";

        }
        if(garlic.isSelected()){
            order += "\n czosnek";

        }
        if(feta.isSelected()){
            order += "\n feta";

        }
        if(corn.isSelected()){
            order += "\n kukurydza";

        }
        if(cucumber.isSelected()){
            order += "\n ogórek";

        }
        if(olives.isSelected()){
            order += "\n oliwki";

        }
        if(chilli.isSelected()){
            order += "\n chilli";

        }
        if(pepperoniPepper.isSelected()){
            order += "\n pepperoni";

        }
        if(mushrooms.isSelected()){
            order += "\n pieczarki";

        }
        if(doubleCheese.isSelected()){
            order += "\n ser";

        }
        if(tomato.isSelected()){
            order += "\n pomidor";

        }
        if(parmesan.isSelected()){
            order += "\n pramezan";

        }
        if(spinach.isSelected()){
            order += "\n szpinak";

        }
        if(ham.isSelected()){
            order += "\n szynka";

        }
        if(bacon.isSelected()){
            order += "\n boczek";

        }
        if(chicken.isSelected()){
            order += "\n kurczak";

        }
        if(sausage.isSelected()){
            order += "\n kiełbasa";

        }
        if(prawns.isSelected()){
            order += "\n krewetki";

        }
        if(tuna.isSelected()){
            order += "\n tuńczyk";

        }
        if(salmon.isSelected()){
            order += "\n łosoś";

        }





    this.allExtrasLabel.setText(order);

        pizzaPriceLabel1.setText(Integer.toString(countWordsUsingSplit(order)*3));

    }

    public static int countWordsUsingSplit(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String[] words = input.split("\\s+");
        return words.length-1;
    }

    @FXML
    private void next(ActionEvent event) throws IOException {
        try {
            ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
            FXMLLoader loader=new FXMLLoader(getClass().getResource("/resources/customEndScene.fxml"));
            Parent root = (Parent) loader.load();

            CustomEndSceneController customEndSceneController =loader.getController();
            customEndSceneController.allExtrasLbl(allExtrasLabel.getText());
            customEndSceneController.pizzaSizeLbl(pizzaSizeLabel.getText());
            customEndSceneController.pizzaPriceLbl(pizzaPriceLabel.getText());
            customEndSceneController.pizzaPriceLbl1(pizzaPriceLabel1.getText());
            customEndSceneController.pizzaDoughLbl(pizzaDoughLabel.getText());




            Stage stage=new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void goBackLeft(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/resources/decisionScene.fxml"));
        Scene scene = button.getScene();
        root.translateXProperty().set(-1200);

        StackPane parentContainer = (StackPane) button.getScene().getRoot();

        parentContainer.getChildren().add(root);

        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateXProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished(t -> {
            parentContainer.getChildren().remove(container);
        });
        timeline.play();
    }


    public void setPizzaSizeLbl(String text) {
        pizzaSizeLabel.setText(text);
    }

    public void setPizzaPriceLbl(String text) {


        pizzaPriceLabel.setText("" + text);
    }

    public void setPizzaDoughLbl(String text) {
        pizzaDoughLabel.setText(text);
    }
}
