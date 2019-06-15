package FireboyWatergirlLvl;

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
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Level2 extends Application {
    private int fGemCount;
    private int wGemCount;
    @Override
    public void start (Stage firstStage) {
        Pane pane = new Pane();
        pane.setStyle("-fx-background-color: rgb(0,0,0)");

        int ground1 = 825;

        ImageView dungeon = new ImageView("Images/dungeony.png");
        dungeon.setFitWidth(1500);
        dungeon.setFitHeight(850);
        Rectangle wGate = new Rectangle(1400,725,90,115);
        wGate.setFill(Color.DEEPSKYBLUE);

        Rectangle fGate = new Rectangle(850,725,90,115);
        fGate.setFill(Color.RED);


        Arc water = new Arc(300,ground1 + 3,115,50,180,180);
        water.setType(ArcType.ROUND);
        water.setFill(Color.DEEPSKYBLUE);

        Arc water2 = new Arc(650,ground1 + 3,115,50,180,180);
        water2.setType(ArcType.ROUND);
        water2.setFill(Color.DEEPSKYBLUE);

        Arc fire = new Arc (900, ground1 + 3, 115, 50, 180, 180);
        fire.setType(ArcType.ROUND);
        fire.setFill(Color.RED);


        Arc fire2 = new Arc (1250, ground1 + 3, 60, 50, 180, 180);
        fire2.setType(ArcType.ROUND);
        fire2.setFill(Color.RED);

        ImageView fGem = new ImageView("Images/reddish.png");
        fGem.setFitHeight(30);
        fGem.setFitWidth(30);
        fGem.setX(1240);
        fGem.setY(ground1 - 40);

        ImageView wGem = new ImageView("Images/blue.png");
        wGem.setFitHeight(30);
        wGem.setFitWidth(30);
        wGem.setX(460);
        wGem.setY(ground1 - 40);

        fGemCount = 0;
        wGemCount = 0;


 //FIREBOY
        ImageView fireboy = new ImageView("Images/fireboy.png");
        fireboy.setFitWidth(85);
        fireboy.setFitHeight(85);
        fireboy.setX(20);
        fireboy.setY(750);



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
        ImageView watergirl = new ImageView("Images/watergirl.png");
        watergirl.setFitWidth(85);
        watergirl.setFitHeight(85);
        watergirl.setX(80);
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





//CONTACT W/ ELEMENTS
        new AnimationTimer() {
            public void handle (long now) {
                if (water.contains(fireboy.getX() + 60, fireboy.getY() + 85) || fire.contains(watergirl.getX() + 60, watergirl.getY() + 85) ||
                        water2.contains(fireboy.getX() + 60, fireboy.getY() + 85) || fire2.contains(watergirl.getX() + 60, watergirl.getY() + 85)) {

                    pane.getChildren().clear();
                    Rectangle rectangle = new Rectangle(pane.getWidth(), pane.getHeight());
                    rectangle.setFill(Color.BLACK);
                    Text text = new Text(250, pane.getHeight()/2, "Game Over! You Lose!");
                    text.setFont(Font.font("Papyrus", 100));
                    text.setFill(Color.WHITE);

                    pane.getChildren().add(text);

                }


                //LEFT RIGHT BOUNDS
                if (fireboy.getX() < 0) {
                    fireboy.setX(0);
                }

                if (fireboy.getX() > pane.getWidth()-85) {
                    fireboy.setX(pane.getWidth()-85);
                }
                if (watergirl.getX() > pane.getWidth()-85) {
                    watergirl.setX(pane.getWidth()-85);
                }
                if (watergirl.getX() < 0) {
                    watergirl.setX(0);
                }


                if ((wGate.contains(watergirl.getX()+(watergirl.getFitWidth()/2),watergirl.getY() + (watergirl.getFitHeight()/2)))) {
                    wGate.setStroke(Color.WHITE);
                }

                else {
                    wGate.setStroke(Color.DEEPSKYBLUE);
                }

                if (fGate.contains(fireboy.getX() + (fireboy.getFitWidth()/2),fireboy.getY() + (fireboy.getFitHeight()/2))) {
                    fGate.setStroke(Color.WHITE);
                }

                else {
                    fGate.setStroke(Color.RED);
                }

                if (wGate.contains(watergirl.getX()+(watergirl.getFitWidth()/2),watergirl.getY() + (watergirl.getFitHeight()/2))&&(fGate.contains(fireboy.getX() + (fireboy.getFitWidth()/2),fireboy.getY() + (fireboy.getFitHeight()/2)))) {
                    pane.getChildren().clear();

                    Text winT = new Text(289,pane.getHeight()/2,"GAME OVER. YOU WIN!\n Fire Gems Collected: " + fGemCount + " out of 1 \n Water Gems Collected: " + wGemCount + " out of 1");
                    winT.setTextAlignment(TextAlignment.CENTER);
                    winT.setFill(Color.WHITE);
                    winT.setStroke(Color.WHITE);
                    winT.setFont(Font.font("Papyrus",50));
                    pane.getChildren().add( winT);
                }

                if (fireboy.contains(fGem.getX(),fGem.getY())) {
                    pane.getChildren().remove(fGem);
                    fGemCount=1;
                }

                if (watergirl.contains(wGem.getX(),wGem.getY())) {
                    pane.getChildren().remove(wGem);
                    wGemCount=1;
                }



                //STEP
                /*if (fireboy.getX() > 1277) {
                    if (fireboy.getY() <= 705) {
                        fJump.stop();
                        fireboy.setY(ground1a - fireboy.getFitHeight() + 10);
                    }
                        else {
                            fireboy.setX(1277);
                        }
                    } else if (fireboy.getY() == ground1a - fireboy.getFitHeight() + 10) {
                        fireboy.setY(750);
                    }

                    if (watergirl.getX() > 1277) {
                        if (watergirl.getY() <= 705) {
                            wJump.stop();
                            watergirl.setY(ground1a - watergirl.getFitHeight() + 10);
                        }
                        else {
                            watergirl.setX(1277);
                        }
                    } else if (watergirl.getY() == ground1a - watergirl.getFitHeight() + 10) {
                        watergirl.setY(750);
                    }
*/


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
                dungeon,
                wGate,fGate, fGem, wGem,

                new hedgePane(0,ground1),new hedgePane(150,ground1),new hedgePane(300,ground1),
                new hedgePane(450,ground1),new hedgePane(600,ground1), new hedgePane(750,ground1),
                new hedgePane(900,ground1),new hedgePane(1050,ground1), new hedgePane(1200,ground1), new hedgePane(1350,ground1),

                water, fire, water2,fire2,

                fireboy,watergirl
                );


        Scene scene = new Scene(pane, 1500,950);
        firstStage.setScene(scene);
        firstStage.show();
        pane.requestFocus();
}

class hedgePane extends Pane{
      public hedgePane (int x,int y) {
          ImageView hedge = new ImageView("Images/hedgeImage.jpg");
          hedge.setFitHeight(125);
          hedge.setFitWidth(150);
          hedge.setY(y);
          hedge.setX(x);
          getChildren().add(hedge);

      }

}


}
