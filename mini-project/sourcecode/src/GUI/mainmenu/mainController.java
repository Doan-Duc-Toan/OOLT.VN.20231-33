package GUI.mainmenu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;

public class mainController implements Initializable {
    private Parent root;
    private double x = 0;
    private double y = 0;
    private Stage stage;
    private Scene scene;
    private MediaPlayer music;
    private File file;
    private boolean envelopeVirusStatus = false;
    private boolean nonEnvelopeVirusStatus = false;
    @FXML
    private MediaView mediaView;
    @FXML
    private Button helpButton;
    @FXML
    private Button hepatitisDButton;
    @FXML
    private VBox envelopeVirusView;
    @FXML
    private VBox nonEnvelopeVirusView;
    @FXML
    private ImageView rhinoVirusView;
    @FXML
    private ImageView noroVirusView;
    @FXML
    private ImageView polioVirusView;
    @FXML
    private ImageView coronaVirusView;
    @FXML
    private ImageView hepatitisDVirusView;
    @FXML
    private ImageView hivView;


    public void initialize(URL arg0, ResourceBundle arg1) {
        file = new File("src/GUI/mainmenu/media/background_music.mp3");
        Media media = new Media(file.toURI().toString());
        music = new MediaPlayer(media);
        music.setCycleCount(1000);
        music.play();
    }


    @FXML
    void hepatitisDScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/GUI/envelope/hepatitisd/FXML/HepatitisD.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        music.stop();
        stage.show();

    }

    @FXML
    void hivScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/GUI/envelope/hiv/FXML/hivFxml.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        music.stop();
        stage.show();

    }

    @FXML
    void rhinoScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/GUI/nonenvelope/rhino/FXML/rhinoFxml.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        music.stop();
        stage.show();

    }

    @FXML
    void noroScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/GUI/nonenvelope/noro/FXML/noroFxml.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        music.stop();
        stage.show();

    }

    @FXML
    void polioScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/GUI/nonenvelope/polio/FXML/polioFxml.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        music.stop();
        stage.show();

    }

    @FXML
    void covidScene(ActionEvent event) throws IOException {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/GUI/envelope/covid/FXML/covidFxml.fxml")));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            scene.setRoot(root);
            stage.setScene(scene);
            music.stop();
            stage.show();
    }

    @FXML
    void nonEnvelopeVirus(ActionEvent e) {
        if (!nonEnvelopeVirusStatus) {
            nonEnvelopeVirusView.setVisible(true);
            nonEnvelopeVirusStatus = true;
            envelopeVirusView.setVisible(false);
            envelopeVirusStatus = false;

        } else {
            nonEnvelopeVirusView.setVisible(false);
            nonEnvelopeVirusStatus = false;
        }
    }

    @FXML
    void envelopeVirus(ActionEvent e) {

        if (!envelopeVirusStatus) {
            envelopeVirusView.setVisible(true);
            envelopeVirusStatus = true;
            nonEnvelopeVirusView.setVisible(false);
            nonEnvelopeVirusStatus = false;

        } else {
            envelopeVirusView.setVisible(false);
            envelopeVirusStatus = false;
        }


    }

    @FXML
    void help(ActionEvent e) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/GUI/mainmenu/FXML/help.fxml")));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e1) {
        }
    }

    @FXML
    void exit(ActionEvent e) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("EXIT");
        alert.setHeaderText("DO YOU SURE TO EXIT?");
        alert.setContentText("Choose your option");
        alert.initStyle(StageStyle.UNDECORATED);
        ImageView icon = new ImageView(new File("src/GUI/mainmenu/media/icon.png").toURI().toString());
        icon.setFitHeight(50);
        icon.setFitWidth(50);
        alert.getDialogPane().setGraphic(icon);

        ButtonType buttonTypeYes = new ButtonType("YES", ButtonBar.ButtonData.OK_DONE);
        ButtonType buttonTypeNo = new ButtonType("NO", ButtonBar.ButtonData.CANCEL_CLOSE);

        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add(new File("src/GUI/mainmenu/css/myDialogs.css").toURI().toString());
        dialogPane.getStyleClass().add("myDialog");


        alert.getButtonTypes().setAll(buttonTypeYes,buttonTypeNo);
        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == buttonTypeYes) {
            System.exit(0);
        }
    }

    @FXML
    void minimize(ActionEvent e) {
        ((Stage) (((Button) e.getSource()).getScene().getWindow())).setIconified(true);
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
