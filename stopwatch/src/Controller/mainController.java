package Controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import java.net.URL;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.animation.Animation;


public class mainController implements Initializable {

    @FXML
    private Label time;

    Timeline timeline;
    LocalTime Time = LocalTime.parse("00:00:00");
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
@Override
    public void initialize(URL location, ResourceBundle resources) {
        timeline = new Timeline(new KeyFrame(Duration.millis(1000), ae -> incrementTime()));
        timeline.setCycleCount(Animation.INDEFINITE);

    }

   private void incrementTime() {
        Time = Time.plusSeconds(1);
       time.setText(Time.format(dtf));
    }

    @FXML
    private void startTimer() {
        timeline.play();
    }
    @FXML
    private void pauseTimer(MouseEvent event) {
        if (timeline.getStatus().equals(Animation.Status.PAUSED)) {
            timeline.play();
        } else if (timeline.getStatus().equals(Animation.Status.RUNNING)) {
            timeline.pause();
        }
    }

    @FXML
    private void endTimer(MouseEvent mouseEvent) {
        timeline.stop();
        Time = LocalTime.parse("00:00:00");
        time.setText(Time.format(dtf));
    }

//
    public void closeSys(MouseEvent mouseEvent) {
        System.exit(0);
    }


}
