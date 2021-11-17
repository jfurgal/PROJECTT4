import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.io.IOException;


public class Stock{

    @FXML
    private Label welcomeText;


    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Stock Manager");
    }

    @FXML
    private ComboBox<String> Stock;

    @FXML
    private TextField Name;

    @FXML
    private TextField Price;

    @FXML
    private TextField Type;

    @FXML
    private Button Save;

    @FXML
    private Button Add;


    @FXML
    private void initialize() {
        Store newstore = new Store();
        try {
            newstore.runStore();
            for(int i=0; i<newstore.Stock.size();i++){
                Stock.getItems().add(newstore.Stock.get(i).getName());
            }

            EventHandler<ActionEvent> box = new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    Name.setText(Stock.getValue());
                    Price.setText(newstore.Stock.get(Stock.getSelectionModel().getSelectedIndex()).price);
                    Type.setText(newstore.Stock.get(Stock.getSelectionModel().getSelectedIndex()).taxibleType);
                }
            };
            Stock.setOnAction(box);
            EventHandler<ActionEvent> saved = new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    newstore.Stock.get(Stock.getSelectionModel().getSelectedIndex()).ItemName = Name.getText();
                    newstore.Stock.get(Stock.getSelectionModel().getSelectedIndex()).price = Price.getText();
                    newstore.Stock.get(Stock.getSelectionModel().getSelectedIndex()).taxibleType = Type.getText();
                }

            };
            Save.setOnAction(saved);

            EventHandler<ActionEvent> added = new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    MerchandiseItem newItem = new MerchandiseItem(Name.getText(),Price.getText(),Type.getText());
                    newstore.Stock.add(newItem);
                    Stock.getItems().add(newItem.getName());
                }
            };
            Add.setOnAction(added);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

