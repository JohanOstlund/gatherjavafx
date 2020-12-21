package home;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ItemController {

    @FXML
    Label lblName1;
    @FXML
    Label lblNr1;
    @FXML
    Label lblDate1;

    void setContent(String playerName, String queueNr, String timeStamp){
        lblName1.setText(playerName);
        lblNr1.setText(queueNr);
        lblDate1.setText(timeStamp);
    }
}