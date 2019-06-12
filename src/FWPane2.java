
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

        //Set to ground
        int groundY = 480;

        //Water and Fire ponds
        Arc fire = new Arc(300,groundY+5,75,20,180,180);
        fire.setType(ArcType.CHORD);
        fire.setFill(Color.RED);

        Arc water = new Arc(520,groundY+5,75,20,180,180);
        water.setType(ArcType.CHORD);
        water.setFill(Color.BLUE);

        //Stairs
        Rectangle stair = new Rectangle(620, 430, 200, 500);
        stair.setFill(Color.PALETURQUOISE);
        stair.setStroke(Color.BLACK);

        //Fireboy
        ImageView fireboy = new ImageView("fireboy.png");
        fireboy.setFitWidth(85);
        fireboy.setFitHeight(80);
        fireboy.setX(60);
        fireboy.setY(410);

        //jump movement Fireboy
        KeyValue sKV = new KeyValue(fireboy.yProperty(), fireboy.getY()-125, Interpolator.EASE_BOTH);
        KeyFrame sKF = new KeyFrame(Duration.millis(450), sKV);
        Timeline jump = new Timeline(sKF);


        KeyValue eKV = new KeyValue(fireboy.yProperty(), fireboy.getY(), Interpolator.EASE_BOTH);
        KeyFrame eKF = new KeyFrame(Duration.millis(450), eKV);
        Timeline fall = new Timeline(eKF);
        SequentialTransition ns =  new SequentialTransition(jump, fall);


        //Right and left Fireboy
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

        //Watergirl
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
                if(watergirl.getY()==430){
                    ns1.play();
                }
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

        new AnimationTimer() {
            public void handle (long now) {
                //Death Screen
                if (water.contains(fireboy.getX()+25, fireboy.getY() + 83)||fire.contains(watergirl.getX()+25, watergirl.getY()+83)) {
                    //Rectangle rectangle = new Rectangle(800, 550);
                    //rectangle.setFill(Color.BLACK);
                    //Text text = new Text(250, 275, "Game Over! You Lose!");
                    Text text = new Text(50, 75, "Game Over! You Lose!");
                    text.setFont(Font.font("Papyrus", 36));
                    text.setFill(Color.WHITE);
                    //pane.getChildren().add(rectangle);
                    pane.getChildren().add(text);
                }
                //X and Y constraints
                if (fireboy.getX() < 0) {
                    fireboy.setX(0);
                }

                if (fireboy.getX() > pane.getWidth() - 85) {
                    fireboy.setX(pane.getWidth() - 85);
                }

                if (watergirl.getX() < 0) {
                    watergirl.setX(0);
                }

                if (watergirl.getX() > pane.getWidth() - 85) {
                    watergirl.setX(pane.getWidth() - 85);
                }
                //Stair constraints; cannot enter rectangle area.
                if (watergirl.getX() > 550&&watergirl.getY()>400) {
                    watergirl.setX(550);
                }
                if (fireboy.getX() > 550&&fireboy.getY()>400) {
                    fireboy.setX(550);
                }
                //jump onto the stairs
                if (stair.contains(watergirl.getX() + 50, watergirl.getY() + 83)) {
                    if (watergirl.getY() <= 430) {
                        watergirl.setY(watergirl.getY());
                        ns1.pause();
                    }
                }
                else{
                    if (watergirl.getY() <= 400) {
                        ns1.play();
                    }
                }
                if (stair.contains(fireboy.getX()+50, fireboy.getY() + 83)) {
                    if (fireboy.getY() <= 400) {
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
            hedge.setFitHeight(95);
            hedge.setFitWidth(150);
            hedge.setY(y);
            hedge.setX(x);
            getChildren().add(hedge);
        }

    }
}
