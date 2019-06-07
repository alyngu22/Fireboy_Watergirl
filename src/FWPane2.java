
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

public class FWPane2 extends Application {
    @Override
    public void start (Stage firstStage) {

        Pane pane = new Pane();
        pane.setStyle("-fx-background-color: rgb(0,0,0)");

        int groundY = 450;

        //FIREBOY
        ImageView fireboy = new ImageView("fireboy.png");
        fireboy.setFitWidth(85);
        fireboy.setFitHeight(80);
        fireboy.setX(60);
        fireboy.setY(410);

        //Puddle
        Arc fire = new Arc(300,groundY+40,75,20,180,180);
        fire.setType(ArcType.CHORD);
        fire.setFill(Color.BLUE);

        //Stairs
        Rectangle stair = new Rectangle(600, 430, 100, 500);
        stair.setFill(Color.BLUE);
        stair.setStroke(Color.BLUE);
        Rectangle topStair = new Rectangle(600, 345, 100, 85);

        //jump movement
        KeyValue sKV = new KeyValue(fireboy.yProperty(), fireboy.getY()-125, Interpolator.EASE_BOTH);
        KeyFrame sKF = new KeyFrame(Duration.millis(450), sKV);
        KeyValue eKV = new KeyValue(fireboy.yProperty(), fireboy.getY(), Interpolator.EASE_BOTH);
        KeyFrame eKF = new KeyFrame(Duration.millis(450), eKV);
        Timeline jump = new Timeline(sKF);
        Timeline fall = new Timeline(eKF);
        SequentialTransition ns =  new SequentialTransition(jump, fall);

        //Right and left
        Timeline moveR = new Timeline();
        moveR.setCycleCount(1);
        KeyValue kv = new KeyValue(fireboy.xProperty(), fireboy.getX()+1000);
        KeyFrame kf = new KeyFrame(Duration.millis(3000), kv);
        moveR.getKeyFrames().add(kf);

        Timeline moveL = new Timeline();
        moveL.setCycleCount(1);
        KeyValue kv1 = new KeyValue(fireboy.xProperty(), fireboy.getX()-1000);
        KeyFrame kf1 = new KeyFrame(Duration.millis(3000), kv1);
        moveL.getKeyFrames().add(kf1);

        //Key movement
        pane.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.UP) {
                ns.play();
            }
            if (e.getCode() == KeyCode.LEFT) {
                moveL.play();
            }
            if (e.getCode() == KeyCode.RIGHT&&fireboy.getX()<pane.getWidth()-85) {
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

        //Death screen
        new AnimationTimer() {
            public void handle (long now) {
                if (fire.contains(fireboy.getX()+10, fireboy.getY() + 81)) {
                    Rectangle rectangle = new Rectangle(800, 550);
                    rectangle.setFill(Color.BLACK);
                    Text text = new Text(250, 275, "Game Over! You Lose!");
                    text.setFont(Font.font("Papyrus", 36));
                    text.setFill(Color.WHITE);
                    pane.getChildren().add(rectangle);
                    pane.getChildren().add(text);
                }
            }
        }.start();


        pane.getChildren().addAll(
                stair, fireboy, new FWPane2.hedgePane(0,groundY),new FWPane2.hedgePane(150,groundY),new FWPane2.hedgePane(300,groundY),
                new FWPane2.hedgePane(450,groundY), new FWPane2.hedgePane(600,groundY),new FWPane2.hedgePane(750,groundY),
                fire
        );

        Scene scene = new Scene(pane, 800,550);
        firstStage.setScene(scene);
        firstStage.show();
        pane.requestFocus();

    }

    class hedgePane extends Pane{
        public hedgePane (int x,int y) {
            ImageView hedge = new ImageView("hedgeImage.jpg");
            hedge.setFitHeight(105);
            hedge.setFitWidth(150);
            hedge.setY(y);
            hedge.setX(x);
            getChildren().add(hedge);
        }

    }
}
