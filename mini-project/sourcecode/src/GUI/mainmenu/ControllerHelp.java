package GUI.mainmenu;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ControllerHelp {
    double x=0,y=0;
    @FXML
    private AnchorPane parent;

    @FXML
    void minimize_stage(ActionEvent e) {
    	((Stage) (((Button) e.getSource()).getScene().getWindow())).setIconified(true);
    }

    @FXML
    void close_app(ActionEvent e) {
    	((Stage) (((Button) e.getSource()).getScene().getWindow())).close();
    }
    @FXML
    void dragged(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setX(event.getScreenX() - x);
        stage.setY(event.getScreenY() - y);


    }

    @FXML
    void pressed(MouseEvent event) {
        x = event.getSceneX();
        y = event.getSceneY();

    }
}
