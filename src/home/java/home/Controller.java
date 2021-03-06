package home;

import home.backend.Player;
    import javafx.event.ActionEvent;
    import javafx.fxml.FXML;
    import javafx.fxml.FXMLLoader;
    import javafx.fxml.Initializable;
    import javafx.scene.Node;
    import javafx.scene.control.Button;
    import javafx.scene.control.Label;
    import javafx.scene.control.TextField;
    import javafx.scene.layout.Pane;
    import javafx.scene.layout.VBox;

import java.io.IOException;

import static home.Main.gatherQueue;

    public class Controller {

        @FXML
        private Pane containerPane;
        @FXML
        private VBox pnItems = null;

        @FXML
        private TextField player;



        @FXML
        private Button btnFirstFromQueue;

        @FXML
        private Button btnEmptyQueue;

        @FXML
        private Pane pnlOverview;

        @FXML
        private Button btnLeaveQueue;



    /*    @Override
        public void initialize(URL location, ResourceBundle resources) {

        }
    */
        @FXML
        public void onEnter(ActionEvent ae) {
            if (!player.getText().isEmpty()) {
                gatherQueue.add(new Player(player.getText()));
            }
            showQueue();
            player.clear();
        }

        public void handleClicks(ActionEvent actionEvent) {
            if (actionEvent.getSource() == btnFirstFromQueue) {
                pnlOverview.setStyle("-fx-background-color : #02030A");
                pnlOverview.toFront();

                if (gatherQueue.isEmpty()) {
                    return;
                }
                else if(gatherQueue.size()>1) {
                    gatherQueue.get(0).getQueueTicket().updateInstanceNr();
                    gatherQueue.remove(0);
                    for(int i=0;i<gatherQueue.size();i++){
                        gatherQueue.get(i).getQueueTicket().updateQueueNr();
                    }
                    showQueue();
                }
                else{
                    gatherQueue.get(0).getQueueTicket().resetInstanceNr();
                    gatherQueue.clear();
                    showQueue();
                }
            }
            if (actionEvent.getSource() == btnEmptyQueue) {
                if (gatherQueue.isEmpty()) {
                    return;
                } else {
                    gatherQueue.get(0).getQueueTicket().resetInstanceNr();
                    gatherQueue.clear();
                    showQueue();
                }
            }
        }

        public void showQueue() {
            containerPane.getChildren().clear();
            for (Player p : gatherQueue) {

                FXMLLoader loader = new FXMLLoader();

                try {

                    Node node = loader.load(getClass().getResource("home/Item.fxml").openStream());
                    node.setOnMouseEntered(event -> {
                        node.setStyle("-fx-background-color : #0A0E3F");
                    });
                    node.setOnMouseExited(event -> {
                        node.setStyle("-fx-background-color : #02030A");
                    });

                    containerPane.getChildren().add(node);
                    //get the controller

                    home.ItemController controller = (home.ItemController) loader.getController();


                    controller.setContent(p.getName(), p.getQueueTicketNr() + "", p.getQueueTimeStamp()); //set label

                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }

        }
    }

