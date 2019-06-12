
import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class FWPane extends Application {
    @Override
    public void start (Stage firstStage) {

        Pane pane = new Pane();
        pane.setStyle("-fx-background-color: rgb(0,0,0)");

        int ground1Y = 825;



 //FIREBOY
        ImageView fireboy = new ImageView("fireboy.png");
        fireboy.setFitWidth(85);
        fireboy.setFitHeight(85);
        fireboy.setX(60);
        fireboy.setY(750);


        Arc water = new Arc(450,ground1Y + 3,115,50,180,180);
        water.setType(ArcType.ROUND);
        water.setFill(Color.DEEPSKYBLUE);

        Arc fire = new Arc (750, ground1Y + 3, 115, 50, 180, 180);
        fire.setType(ArcType.ROUND);
        fire.setFill(Color.RED);


       //Jump
        KeyValue fJumpUpValue = new KeyValue(fireboy.yProperty(), fireboy.getY()-150, Interpolator.EASE_IN);

        KeyFrame fJumpUpFrame = new KeyFrame(Duration.millis(450), fJumpUpValue);
        KeyValue fJumpDownValue = new KeyValue(fireboy.yProperty(), fireboy.getY(), Interpolator.EASE_OUT);
        KeyFrame fJumpDownFrame = new KeyFrame(Duration.millis(450), fJumpDownValue);
        Timeline fJumpUp = new Timeline(fJumpUpFrame);
        Timeline fJumpDown = new Timeline(fJumpDownFrame);
        SequentialTransition fJump =  new SequentialTransition(fJumpUp, fJumpDown);

        //Right
        Timeline fMoveR = new Timeline();
        fMoveR.setCycleCount(1);
        KeyValue fMoveRValue = new KeyValue(fireboy.xProperty(), fireboy.getX()+2000);
        KeyFrame fMoveRFrame = new KeyFrame(Duration.millis(4000), fMoveRValue);
        fMoveR.getKeyFrames().add(fMoveRFrame);

        //Left
        Timeline fMoveL = new Timeline();
        fMoveL.setCycleCount(1);
        KeyValue fMoveLValue = new KeyValue(fireboy.xProperty(), fireboy.getX()-2000);
        KeyFrame fMoveLFrame = new KeyFrame(Duration.millis(4000), fMoveLValue);
        fMoveL.getKeyFrames().add(fMoveLFrame);




//WATERGIRL
        ImageView watergirl = new ImageView("watergirl.png");
        watergirl.setFitWidth(85);
        watergirl.setFitHeight(85);
        watergirl.setX(175);
        watergirl.setY(750);

        KeyValue wJumpUpValue = new KeyValue(watergirl.yProperty(), watergirl.getY() - 150, Interpolator.EASE_IN);
        KeyFrame wJumpUpFrame = new KeyFrame(Duration.millis(450), wJumpUpValue);
        KeyValue wJumpDownValue = new KeyValue(watergirl.yProperty(), watergirl.getY(), Interpolator.EASE_OUT);
        KeyFrame wJumpDownFrame = new KeyFrame(Duration.millis(450), wJumpDownValue);
        Timeline wJumpUp = new Timeline(wJumpUpFrame);
        Timeline wJumpDown = new Timeline(wJumpDownFrame);
        SequentialTransition wJump =  new SequentialTransition(wJumpUp, wJumpDown);

        //Right
        Timeline wMoveR = new Timeline();
        fMoveR.setCycleCount(1);
        KeyValue wMoveRValue = new KeyValue(watergirl.xProperty(), watergirl.getX()+ 2000);
        KeyFrame wMoveRFrame = new KeyFrame(Duration.millis(4000), wMoveRValue);
        wMoveR.getKeyFrames().add(wMoveRFrame);

        //Left
        Timeline wMoveL = new Timeline();
        fMoveL.setCycleCount(1);
        KeyValue wMoveLValue = new KeyValue(watergirl.xProperty(), watergirl.getX()- 2000);
        KeyFrame wMoveLFrame = new KeyFrame(Duration.millis(4000), wMoveLValue);
        wMoveL.getKeyFrames().add(wMoveLFrame);


//GROUND2
    int ground2 = 550;
    int ground2a = ground2 + 30;

    int ground3 = 275;

    int ground1b = 705;

    ImageView step1 = new ImageView("hedgeImage.jpg");
    step1.setFitWidth(150);
    step1.setFitHeight(185);
    step1.setX(1350);
    step1.setY(ground1b);



//CONTACT W/ ELEMENTS
        new AnimationTimer() {
            public void handle (long now) {
                if (water.contains(fireboy.getX() + 60, fireboy.getY() + 85) || fire.contains(watergirl.getX() + 60, watergirl.getY() + 85)) {
                    Rectangle rectangle = new Rectangle(800, 550);
                    rectangle.setFill(Color.BLACK);
                    Text text = new Text(250, 275, "Game Over! You Lose!");
                    text.setFont(Font.font("Papyrus", 36));
                    text.setFill(Color.WHITE);
                    pane.getChildren().add(rectangle);
                    pane.getChildren().add(text);
                }
                //LEFT RIGHT BOUNDS
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


                //STEP
                if (fireboy.getX() > 1277) {
                    if (fireboy.getY() <= 705) {
                        fJump.stop();
                        fireboy.setY(ground1b - fireboy.getFitHeight() + 10);
                    }
                        else {
                            fireboy.setX(1277);
                        }
                    } else if (fireboy.getY() == ground1b - fireboy.getFitHeight() + 10) {
                        fireboy.setY(750);
                    }

                    if (watergirl.getX() > 1277) {
                        if (watergirl.getY() <= 705) {
                            wJump.stop();
                            watergirl.setY(ground1b - watergirl.getFitHeight() + 10);
                        }
                        else {
                            watergirl.setX(1277);
                        }
                    } else if (watergirl.getY() == ground1b - watergirl.getFitHeight() + 10) {
                        watergirl.setY(750);
                    }



            }
            }.start();

        //KEYBOARD ACTIONS
        pane.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.UP) {
                fJump.play();
                if (fireboy.getY()== 705) {
                    fJump.play();
                }
            }
            if (e.getCode() == KeyCode.LEFT) {
                fMoveL.play();
            }
            if (e.getCode() == KeyCode.RIGHT && fireboy.getX()<pane.getWidth()-85) {
                fMoveR.play();
            }

            if (e.getText().equals("w")) {
                wJump.play();
            }

            if (e.getText().equals("a")) {
                wMoveL.play();
            }

            if (e.getText().equals("d")) {
                wMoveR.play();
            }
        });

        pane.setOnKeyReleased( ev -> {
            if (ev.getCode() == KeyCode.LEFT) {
                fMoveL.stop();
            }
            if (ev.getCode() == KeyCode.RIGHT) {
                fMoveR.stop();
            }
            if (ev.getText().equals("a")) {
                wMoveL.stop();
            }
            if (ev.getText().equals("d")) {
                wMoveR.stop();
            }
        });

        pane.getChildren().addAll(

                step1,

                new hedgePane(0,ground1Y),new hedgePane(150,ground1Y),new hedgePane(300,ground1Y),
                new hedgePane(450,ground1Y),new hedgePane(600,ground1Y), new hedgePane(750,ground1Y),
                new hedgePane(900,ground1Y),new hedgePane(1050,ground1Y), new hedgePane(1200,ground1Y), new hedgePane(1350,ground1Y),

                new hedgePane(0,ground2a),new hedgePane(150,ground2a),new hedgePane(300,ground2a),
                new hedgePane(450,ground2a),new hedgePane(600,ground2a), new hedgePane(750,ground2a),
                new hedgePane(900,ground2a), new hedgePane(1050,ground2a),

                new hedgePane(0,ground3),new hedgePane(150,ground3),new hedgePane(300,ground3),
                new hedgePane(450,ground3),new hedgePane(600,ground3), new hedgePane(750,ground3),
                new hedgePane(900,ground3), new hedgePane(1050,ground3),new hedgePane(1200,ground3),



                water, fire,

                fireboy,watergirl
                );


        Scene scene = new Scene(pane, 1500,950);
        firstStage.setScene(scene);
        firstStage.show();
        pane.requestFocus();
}

class hedgePane extends Pane{
      public hedgePane (int x,int y) {
          ImageView hedge = new ImageView("hedgeImage.jpg");
          hedge.setFitHeight(125);
          hedge.setFitWidth(150);
          hedge.setY(y);
          hedge.setX(x);
          getChildren().add(hedge);

      }

}


}
