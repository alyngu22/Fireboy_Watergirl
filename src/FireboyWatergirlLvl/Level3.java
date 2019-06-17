package FireboyWatergirlLvl;

import Main.MainMenu;
import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Level3 extends Application {
    private int wGemCount;
    private int fGemCount;
    @Override
    public void start (Stage thirdStage) {

        Pane pane = new Pane();
        pane.setStyle("-fx-background-color: rgb(0,0,0)");


        ImageView background = new ImageView("Images/darkTree.jpg");
        background.setFitHeight(pane.getHeight());
        background.setFitWidth(pane.getWidth());

        int ground1 = 825;

        int ground1a = ground1 - 120;

        Rectangle wGate = new Rectangle(1400,ground1a - 100,90,115);
        wGate.setFill(Color.DEEPSKYBLUE);

        Rectangle fGate = new Rectangle(1250,ground1a - 100,90,115);
        fGate.setFill(Color.RED);

        ImageView step1 = new ImageView("Images/hedgeImage.jpg");
        step1.setFitWidth(300);
        step1.setFitHeight(185);
        step1.setX(1200);
        step1.setY(ground1a);


        Arc water2 = new Arc(300,ground1 + 3,115,50,180,180);
        water2.setType(ArcType.ROUND);
        water2.setFill(Color.DEEPSKYBLUE);


        Arc fire2 = new Arc (500, ground1 + 3, 50, 50, 180, 180);
        fire2.setType(ArcType.ROUND);
        fire2.setFill(Color.RED);

        Arc water = new Arc(700,ground1 + 3,115,50,180,180);
        water.setType(ArcType.ROUND);
        water.setFill(Color.DEEPSKYBLUE);


        Arc fire = new Arc (900, ground1 + 3, 50, 50, 180, 180);
        fire.setType(ArcType.ROUND);
        fire.setFill(Color.RED);


        ImageView bGem = new ImageView("Images/blue.png");
        bGem.setFitWidth(30);
        bGem.setFitHeight(30);
        bGem.setX(340);
        bGem.setY(735);

        ImageView bGem1 = new ImageView("Images/blue.png");
        bGem1.setFitWidth(30);
        bGem1.setFitHeight(30);
        bGem1.setX(30);
        bGem1.setY(ground1-30);

        ImageView rGem = new ImageView("Images/reddish.png");
        rGem.setFitHeight(35);
        rGem.setFitWidth(30);
        rGem.setX(570);
        rGem.setY(step1.getY() - 30);

        ImageView rGem1 = new ImageView("Images/reddish.png");
        rGem1.setFitHeight(35);
        rGem1.setFitWidth(30);
        rGem1.setX(810);
        rGem1.setY(750);



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
                if (water.contains(fireboy.getX() + 60, fireboy.getY() + 85) ||
                        fire.contains(watergirl.getX() + 60, watergirl.getY() + 85 )||
                                water2.contains(fireboy.getX() + 60,fireboy.getY() + 85) ||
                                        fire2.contains(watergirl.getX() + 60,watergirl.getY() + 85)) {

                    pane.getChildren().clear();
                    Rectangle rectangle = new Rectangle(pane.getWidth(), pane.getHeight());
                    rectangle.setFill(Color.BLACK);
                    Text text = new Text(250, pane.getHeight()/2, "Game Over! You Lose!");
                    text.setFont(Font.font("Papyrus", 100));
                    text.setFill(Color.WHITE);

                    pane.getChildren().add(text);

                }

                if (watergirl.contains(bGem1.getX(),bGem1.getY())) {
                    pane.getChildren().remove(bGem1);
                    wGemCount = 1;
                }

                if (wGemCount == 1 && watergirl.contains(bGem.getX(),bGem.getY())) {
                    pane.getChildren().remove(bGem);
                    wGemCount = 2;

                }

                if (fireboy.contains(rGem.getX(),rGem.getY())) {
                    pane.getChildren().remove(rGem);
                    fGemCount=1;
                }

                if (fGemCount == 1 && fireboy.contains(rGem1.getX(), rGem1.getY())) {
                    pane.getChildren().remove(rGem1);
                    fGemCount = 2;
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
                    Rectangle rectangle = new Rectangle(pane.getWidth(), pane.getHeight());
                    rectangle.setFill(Color.GOLDENROD);
                    DropShadow ds = new DropShadow();
                    ds.setOffsetY(3.0f);
                    ds.setColor(Color.color(0.4f, 0.4f, 0.4f));
                    Text text = new Text(355, 475,"Congratulations! You Win!\nFireboy: "+ fGemCount +" Point\nWatergirl: "+wGemCount+ " Point");

                    text.setFont(Font.font("Verdana", FontWeight.BOLD, 45));
                    text.setEffect(ds);
                    text.setFill(Color.WHITE);
                    pane.getChildren().add(rectangle);
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

                if (fireboy.getX() > step1.getX() - 83) {
                    if (fireboy.getY() <= 705) {
                        fJump.stop();
                        fireboy.setY(ground1a - fireboy.getFitHeight() + 10);
                    }
                    else {
                        fireboy.setX(step1.getX() - 83);
                    }
                } else if (fireboy.getY() == ground1a - fireboy.getFitHeight() + 10) {
                    fireboy.setY(750);
                }

                if (watergirl.getX() > step1.getX() - 83) {
                    if (watergirl.getY() <= 705) {
                        wJump.stop();
                        watergirl.setY(ground1a - watergirl.getFitHeight() + 10);
                    }
                    else {
                        watergirl.setX(step1.getX() - 83);
                    }
                } else if (watergirl.getY() == ground1a - watergirl.getFitHeight() + 10) {
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
            if (e.getCode()== KeyCode.ESCAPE) {
                thirdStage.close();
                MainMenu as = new MainMenu();
                Stage menuStage = new Stage();
                as.start(menuStage);

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
                background,
                wGate,fGate,
                step1,


                new hedgePane(0,ground1),new hedgePane(150,ground1),new hedgePane(300,ground1),
                new hedgePane(450,ground1),new hedgePane(600,ground1), new hedgePane(750,ground1),
                new hedgePane(900,ground1),new hedgePane(1050,ground1), new hedgePane(1200,ground1), new hedgePane(1350,ground1),

                bGem, rGem, bGem1, rGem1,

                water2, fire2, water, fire,
                fireboy,watergirl
        );


        Scene scene = new Scene(pane, 1500,950);
        thirdStage.setScene(scene);
        thirdStage.show();
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
