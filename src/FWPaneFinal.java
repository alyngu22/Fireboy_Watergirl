import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.text.*;
public class FWPaneFinal extends Application {
    public void start(Stage firstStage) {

        Pane pane = new Pane();
        pane.setStyle("-fx-background-color: rgb(0,0,0)");

        int groundY = 480;
        int ground2 = 200;
        int ground2a = ground2 + 30;
        ImageView fireboy = new ImageView("fireboy.png");
        fireboy.setFitWidth(85);
        fireboy.setFitHeight(80);
        fireboy.setX(60);
        fireboy.setY(410);

        Rectangle stair = new Rectangle(620, 430, 200, 500);
        stair.setStroke(Color.WHITE);

        //jump movement Fireboy
        KeyValue sKV = new KeyValue(fireboy.yProperty(), fireboy.getY()-125, Interpolator.EASE_BOTH);
        KeyFrame sKF = new KeyFrame(Duration.millis(450), sKV);
        Timeline jump = new Timeline(sKF);

        KeyValue eKV = new KeyValue(fireboy.yProperty(), fireboy.getY(), Interpolator.EASE_BOTH);
        KeyFrame eKF = new KeyFrame(Duration.millis(450), eKV);
        Timeline fall = new Timeline(eKF);
        SequentialTransition ns =  new SequentialTransition(jump, fall);

        Timeline moveR = new Timeline();
        moveR.setCycleCount(1);
        KeyValue kv = new KeyValue(fireboy.xProperty(), fireboy.getX()+2000);
        KeyFrame kf = new KeyFrame(Duration.millis(4000), kv);
        moveR.getKeyFrames().add(kf);

        Timeline moveL = new Timeline();
        moveL.setCycleCount(1);
        KeyValue kv1 = new KeyValue(fireboy.xProperty(), fireboy.getX()-1000);
        KeyFrame kf1 = new KeyFrame(Duration.millis(4000), kv1);
        moveL.getKeyFrames().add(kf1);

        pane.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.UP) {
                ns.play();
            }
            if (e.getCode() == KeyCode.LEFT) {
                moveL.play();
            }
            if (e.getCode() == KeyCode.RIGHT && fireboy.getX() < pane.getWidth() - 85) {
                moveR.play();
            }
        });
        pane.setOnKeyReleased( ev -> {
            if (ev.getCode() == KeyCode.LEFT) {
                moveL.stop();
            }
            if (ev.getCode() == KeyCode.RIGHT) {
                moveR.stop();
            }
        });

        new AnimationTimer() {
            public void handle (long now) {
                //X and Y constraints
                if (fireboy.getX() < 0) {
                    fireboy.setX(0);
                }

                if (fireboy.getX() > pane.getWidth() - 85) {
                    fireboy.setX(pane.getWidth() - 85);
                }
                if (fireboy.getX() >= 550 && fireboy.getY()>360) {
                    fireboy.setX(550);
                }
                if (stair.contains(fireboy.getX()+50, fireboy.getY() + 83)) {
                    if (fireboy.getY() <= 400) {
                        fireboy.setY(350);
                        ns.pause();
                    }
                }
                else{
                    if (fireboy.getY() <= 400) {
                        ns.play();
                    }
                }

            }
        }.start();

        pane.getChildren().addAll(stair, fireboy);

        Scene scene = new Scene(pane, 800,550);
        firstStage.setScene(scene);
        firstStage.show();
        pane.requestFocus();

    }
}
