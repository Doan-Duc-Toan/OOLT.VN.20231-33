package GUI.mainmenu;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.File;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class Intro implements Initializable {
    private Parent root;
    private double x=0;
    private double y=0;
    private Stage stage;
    private Scene scene;
    @FXML
    private Media media;
    @FXML
    private MediaView mediaView;
    @FXML
    private File file;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        this.file = new File("src/GUI/mainmenu/media/video.mp4");
        media = new Media(file.toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        Duration a = mediaPlayer.getStartTime();
        Duration b = mediaPlayer.getStopTime();

        mediaView.setMediaPlayer(mediaPlayer);
        mediaPlayer.setOnReady(new Runnable() {
            @Override
            public void run() {
                EventHandler event = new EventHandler() {
                    @Override
                    public void handle(Event event) {
                        try {
                            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/GUI/mainmenu/FXML/mainFxml.fxml")));
                            stage = (Stage) ((Node) Intro.this.mediaView).getScene().getWindow();
                            scene = new Scene(root);
                            stage.setScene(scene);
                            stage.show();

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                };
                Double duration = Double.valueOf(mediaPlayer.getStopTime().toMillis());
                mediaPlayer.play();
                Timeline tm0 = new Timeline(new KeyFrame(Duration.millis(500),new KeyValue(mediaView.opacityProperty(),  0.0)));
                tm0.setDelay(Duration.millis(duration));
                tm0.play();
                Timeline tm = new Timeline(new KeyFrame(Duration.millis(500), event));
                tm.setDelay(Duration.millis(duration));
                tm.play();
            }
        });

    }
    @FXML
    void dragged(MouseEvent event) {
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setX(event.getScreenX()-x);
        stage.setY(event.getScreenY()-y);



    }
    @FXML
    void pressed(MouseEvent event) {
        x = event.getSceneX();
        y = event.getSceneY();

    }
}
