
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
        Arc fire = new Arc(300,groundY+42,75,20,180,180);
        fire.setType(ArcType.CHORD);
        fire.setFill(Color.RED);

        Arc water = new Arc(520,groundY+42,75,20,180,180);
        water.setType(ArcType.CHORD);
        water.setFill(Color.BLUE);

        //Stairs
        Rectangle stair = new Rectangle(620, 430, 200, 500);
        stair.setFill(Color.PALETURQUOISE);
        stair.setStroke(Color.BLACK);

        //jump movement
        KeyValue sKV = new KeyValue(fireboy.yProperty(), fireboy.getY()-125, Interpolator.EASE_BOTH);
        KeyFrame sKF = new KeyFrame(Duration.millis(450), sKV);
        Timeline jump = new Timeline(sKF);


        KeyValue eKV = new KeyValue(fireboy.yProperty(), fireboy.getY(), Interpolator.EASE_BOTH);
        KeyFrame eKF = new KeyFrame(Duration.millis(450), eKV);
        Timeline fall = new Timeline(eKF);
        SequentialTransition ns =  new SequentialTransition(jump, fall);


        //Right and left
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

        //WATERGIRL
        ImageView watergirl = new ImageView("watergirl.png");
        watergirl.setFitWidth(85);
        watergirl.setFitHeight(80);
        watergirl.setX(100);
        watergirl.setY(410);

        //jump movement WGirl
        KeyValue sKV1 = new KeyValue(watergirl.yProperty(), watergirl.getY()-125, Interpolator.EASE_BOTH);
        KeyFrame sKF1 = new KeyFrame(Duration.millis(450), sKV1);
        Timeline jump1 = new Timeline(sKF1);


        KeyValue eKV1 = new KeyValue(watergirl.yProperty(), watergirl.getY(), Interpolator.EASE_BOTH);
        KeyFrame eKF1 = new KeyFrame(Duration.millis(450), eKV1);
        Timeline fall1 = new Timeline(eKF1);
        SequentialTransition ns1 =  new SequentialTransition(jump1, fall1);


        //Right and left WGirl
        Timeline moveR1 = new Timeline();
        moveR1.setCycleCount(1);
        KeyValue kv2 = new KeyValue(watergirl.xProperty(), watergirl.getX()+2000);
        KeyFrame kf2 = new KeyFrame(Duration.millis(4000), kv2);
        moveR1.getKeyFrames().add(kf2);

        Timeline moveL2 = new Timeline();
        moveL2.setCycleCount(1);
        KeyValue kv3 = new KeyValue(watergirl.xProperty(), watergirl.getX()-1000);
        KeyFrame kf3 = new KeyFrame(Duration.millis(4000), kv3);
        moveL2.getKeyFrames().add(kf3);

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
            if (e.getText().equals("w")) {
                ns1.play();
            }
            if (e.getText().equals("a")) {
                moveL2.play();

            }
            if (e.getText().equals("d")) {
                moveR1.play();
            }
        });

        pane.setOnKeyReleased( ev -> {
            if (ev.getCode() == KeyCode.LEFT) {
                moveL.stop();
            }
            if (ev.getCode() == KeyCode.RIGHT) {
                moveR.stop();
            }
            if (ev.getText().equals("a")) {
                moveL2.stop();

            }
            if (ev.getText().equals("d")) {
                moveR1.stop();
            }
        });

        //Death screen
        new AnimationTimer() {
            public void handle (long now) {
                if (water.contains(fireboy.getX()+25, fireboy.getY() + 83)||fire.contains(watergirl.getX()+25, watergirl.getY()+83)) {
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
        new AnimationTimer() {
            public void handle (long now) {
                if(stair.contains(watergirl.getX()+50,watergirl.getY()+83)){
                    if(watergirl.getY()<580){
                        watergirl.setX(550);
                    }
                }
                if(stair.contains(fireboy.getX(), fireboy.getY()+83)){
                    ns.pause();
                    fireboy.setY(fireboy.getY());
                }
                if(stair.contains(watergirl.getX(), watergirl.getY()+83)) {
                    watergirl.setY(watergirl.getY());
                    ns1.pause();
                }
            }
        }.start();

        pane.getChildren().addAll(
                stair, fireboy, watergirl, new FWPane2.hedgePane(0,groundY),new FWPane2.hedgePane(150,groundY),new FWPane2.hedgePane(300,groundY),
                new FWPane2.hedgePane(450,groundY), new FWPane2.hedgePane(600,groundY),new FWPane2.hedgePane(750,groundY),
                fire, water
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
