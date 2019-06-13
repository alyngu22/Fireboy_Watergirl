
import javafx.animation.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.text.*;

import javax.swing.*;

public class MainMenu extends Application {
    private int wGem1;
    private int wGem;
    private int fGem;
    private int fGem1;
    private int fGemCount ;
    private int wGemCount ;
    public void start(Stage menuStage){
        BorderPane bordp = new BorderPane();

        ImageView menuI = new ImageView("menuimage.jpg");
        menuI.setFitWidth(bordp.getWidth());
        menuI.setFitHeight(bordp.getHeight());
        bordp.getChildren().add(menuI);

        Text title = new Text("FIREBOY AND WATERGIRL");
        title.setFont(Font.font("Verdana", FontWeight.BOLD, 75));
        title.setFill(Color.WHITE);
        bordp.getChildren().add(title);
        title.setX(230);
        title.setY(200);

        Button levelOne=  new Button("Level One");
        levelOne.setFont(Font.font("Papyrus", 20));
        levelOne.setMinHeight(150);
        levelOne.setMinWidth(150);
        Button levelTwo=  new Button("Level Two");
        levelTwo.setMinWidth(150);
        levelTwo.setMinHeight(150);
        levelTwo.setFont(Font.font("Papyrus", 20));
        HBox hBox = new HBox(levelOne,levelTwo);
        hBox.setAlignment(Pos.CENTER);

        bordp.setCenter(hBox);
        levelOne.setOnAction(e->{
            menuStage.close();
            Stage oneStage = new Stage();
            levelOne(oneStage);
        });
        levelTwo.setOnAction(ev->{
            menuStage.close();
            Stage twoStage= new Stage();
            levelTwo(twoStage);
        });

        Scene scene = new Scene(bordp,bordp.getWidth(), bordp.getHeight());
        menuStage.setScene(scene);
        menuStage.show();
        bordp.requestFocus();

    }

    public void levelOne(Stage oneStage){
            Pane pane = new Pane();
            pane.setStyle("-fx-background-color: rgb(0,0,0)");

            int groundY = 825;
            ImageView forest = new ImageView("foresty.jpg");
            forest.setFitWidth(1200);
            forest.setFitHeight(850);
            forest.setX(0);
            forest.setY(0);
            ImageView fireboy = new ImageView("fireboy.png");
            fireboy.setFitWidth(85);
            fireboy.setFitHeight(80);
            fireboy.setX(60);
            fireboy.setY(groundY-70);

            Arc fire = new Arc(300,groundY+5,75,20,180,180);
            fire.setType(ArcType.CHORD);
            fire.setFill(Color.RED);

            Arc water = new Arc(900,groundY+5,75,20,180,180);
            water.setType(ArcType.CHORD);
            water.setFill(Color.DEEPSKYBLUE);

            Rectangle stair = new Rectangle(550, 735, 200, 300);
            stair.setStroke(Color.DARKGREEN);
            stair.setFill(Color.DARKGREEN);

            ImageView bGem = new ImageView("blue.png");
            bGem.setFitWidth(30);
            bGem.setFitHeight(30);
            bGem.setX(570);
            bGem.setY(stair.getY()-30);

            ImageView bGem1 = new ImageView("blue.png");
            bGem1.setFitWidth(30);
            bGem1.setFitHeight(30);
            bGem1.setX(30);
            bGem1.setY(groundY-30);

            ImageView rGem = new ImageView("reddish.png");
            rGem.setFitHeight(35);
            rGem.setFitWidth(30);
            rGem.setX(340);
            rGem.setY(735);

            ImageView rGem1 = new ImageView("reddish.png");
            rGem1.setFitHeight(35);
            rGem1.setFitWidth(30);
            rGem1.setX(810);
            rGem1.setY(750);
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

            ImageView watergirl = new ImageView("watergirl.png");
            watergirl.setFitWidth(85);
            watergirl.setFitHeight(80);
            watergirl.setX(100);
            watergirl.setY(groundY-70);

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

            pane.setOnKeyPressed(e -> {
                if (e.getCode() == KeyCode.UP) {
                    ns.play();
                }
                if (e.getCode() == KeyCode.LEFT) {
                    moveL.play();
                }
                if (e.getCode() == KeyCode.RIGHT) {
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
            wGem = 0;
            fGem = 0;
            new AnimationTimer() {
                public void handle (long now) {
                    if (water.contains(fireboy.getX()+25, fireboy.getY() + 83)||fire.contains(watergirl.getX()+25, watergirl.getY()+83)) {
                        Rectangle rectangle = new Rectangle(pane.getWidth(), pane.getHeight());
                        rectangle.setFill(Color.GRAY);
                        DropShadow ds = new DropShadow();
                        ds.setOffsetY(3.0f);
                        ds.setColor(Color.color(0.4f, 0.4f, 0.4f));
                        Text text = new Text(375, 475, "Game Over! You Lose!\nFireboy: " + (fGem + fGem1) + " Points\nWatergirl: " + (wGem + wGem1) + " Points");
                        if(fGem1+fGem==1&&wGem1+wGem==1){
                            text.setText("Game Over! You Lose!\nFireboy: "+ (fGem+fGem1) +" Point\nWatergirl: "+(wGem+wGem1)+ " Point");
                        }
                        else if(fGem1+fGem==1){
                            text.setText("Game Over! You Lose!\nFireboy: "+ (fGem+fGem1) +" Point\nWatergirl: "+(wGem+wGem1)+ " Points");
                        }
                        else if(wGem1+wGem==1){
                            text.setText("Game Over! You Lose!\nFireboy: "+ (fGem+fGem1) +" Points\nWatergirl: "+(wGem+wGem1)+ " Point");
                        }
                        text.setFont(Font.font("Verdana", FontWeight.BOLD, 45));
                        text.setEffect(ds);
                        text.setFill(Color.WHITE);
                        pane.getChildren().addAll(rectangle, text);
                        moveL.stop();
                        moveL2.stop();
                        moveR.stop();
                        moveR1.stop();
                        ns.stop();
                        ns1.stop();
                    }
                    if(fireboy.contains(rGem.getX(), rGem.getY())&&fGem<1){
                        pane.getChildren().remove(rGem);
                        fGem += 1;
                    }
                    if(fireboy.contains(rGem1.getX(), rGem1.getY())&&fGem1<1){
                        pane.getChildren().remove(rGem1);
                        fGem1 +=1;
                    }
                    if(watergirl.contains(bGem.getX(), bGem.getY())&&wGem<1){
                        pane.getChildren().remove(bGem);
                        wGem += 1;
                    }
                    if(watergirl.contains(bGem1.getX(), bGem1.getY())&&wGem1<1){
                        pane.getChildren().remove(bGem1);
                        wGem1 += 1;
                    }
                    //X and Y constraints
                    if (fireboy.getX() < 0) {
                        fireboy.setX(0);
                    }
                    if (watergirl.getX()<0){
                        watergirl.setX(0);
                    }

                    if ((fireboy.getX() >= pane.getWidth() - 85||watergirl.getX()>=pane.getWidth() - 85)) {
                        Rectangle rectangle = new Rectangle(pane.getWidth(), pane.getHeight());
                        rectangle.setFill(Color.GOLDENROD);
                        DropShadow ds = new DropShadow();
                        ds.setOffsetY(3.0f);
                        ds.setColor(Color.color(0.4f, 0.4f, 0.4f));
                        Text text = new Text(355, 475, "Congratulations! You Win!\nFireboy: " + (fGem + fGem1) + " Points\nWatergirl: " + (wGem + wGem1) + " Points");
                        if(fGem1+fGem==1&&wGem1+wGem==1){
                            text.setText("Congratulations! You Wine!\nFireboy: "+ (fGem+fGem1) +" Point\nWatergirl: "+(wGem+wGem1)+ " Point");
                        }
                        else if(fGem1+fGem==1){
                            text.setText("Congratulations! You Win!\nFireboy: "+ (fGem+fGem1) +" Point\nWatergirl: "+(wGem+wGem1)+ " Points");
                        }
                        else if(wGem1+wGem==1){
                            text.setText("Congratulations! You Win!\nFireboy: "+ (fGem+fGem1) +" Points\nWatergirl: "+(wGem+wGem1)+ " Point");
                        }
                        text.setFont(Font.font("Verdana", FontWeight.BOLD, 45));
                        text.setEffect(ds);
                        text.setFill(Color.WHITE);
                        pane.getChildren().add(rectangle);
                        pane.getChildren().add(text);
                        moveR.stop();
                        ns.stop();
                        moveL.stop();
                    }
                    if (watergirl.getX() >= stair.getX()-85 && watergirl.getX() <= stair.getX()+10 && watergirl.getY()>stair.getY()-70) {
                        moveR1.stop();
                        watergirl.setX(stair.getX()-80);
                    }
                    if (watergirl.getX() <= stair.getX()+stair.getWidth() && watergirl.getX() >= stair.getX()+stair.getWidth()-20 && watergirl.getY()>stair.getY()-80) {
                        moveL2.stop();
                        watergirl.setX(740);
                    }
                    if (stair.contains(watergirl.getX()+75, watergirl.getY() + 83)||stair.contains(watergirl.getX()+20, watergirl.getY()+83)) {
                        if (watergirl.getY() <= stair.getY()-10) {
                            watergirl.setY(stair.getY()-80);
                            ns1.pause();
                        }
                    }
                    else{
                        if (watergirl.getY() <= stair.getY()-10) {
                            ns1.play();
                        }
                    }
                    //USE THIS PLEASE
                    if (fireboy.getX() >= stair.getX()-85 && fireboy.getX() <= stair.getX()+10 && fireboy.getY()>stair.getY()-70) {
                        moveR.stop();
                        fireboy.setX(stair.getX()-80);
                    }
                    if (fireboy.getX() <= stair.getX()+stair.getWidth() && fireboy.getX() >= stair.getX()+stair.getWidth()-15 && fireboy.getY()>stair.getY()-80) {
                        moveL.stop();
                        fireboy.setX(stair.getX()+stair.getWidth());
                    }
                    if (stair.contains(fireboy.getX()+75, fireboy.getY() + 83)||stair.contains(fireboy.getX()+30, fireboy.getY()+83)) {
                        if (fireboy.getY() <= stair.getY()-10) {
                            fireboy.setY(stair.getY()-80);
                            ns.pause();
                        }
                    }
                    else{
                        if (fireboy.getY() <= stair.getY()-10) {
                            ns.play();
                        }
                    }

                }
            }.start();

            pane.getChildren().addAll(forest, stair, fireboy, watergirl, new MainMenu.hedgePane(550,725),new MainMenu.hedgePane(0,groundY),new MainMenu.hedgePane(150,groundY),new MainMenu.hedgePane(300,groundY),
                    new MainMenu.hedgePane(450,groundY),new MainMenu.hedgePane(600,groundY), new MainMenu.hedgePane(750,groundY),
                    new MainMenu.hedgePane(900,groundY),new MainMenu.hedgePane(1050,groundY),fire, water, bGem, bGem1,rGem, rGem1);

            Scene scene = new Scene(pane, 1200,950);
            oneStage.setTitle("Level 1");
            oneStage.setScene(scene);
            oneStage.show();
            pane.requestFocus();

        }
        public void levelTwo(Stage twoStage) {
            Pane pane = new Pane();
            pane.setStyle("-fx-background-color: rgb(0,0,0)");

            int ground1 = 825;

            ImageView dungeon = new ImageView("dungeony.png");
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

            ImageView fGem = new ImageView("reddish.png");
            fGem.setFitHeight(30);
            fGem.setFitWidth(30);
            fGem.setX(1240);
            fGem.setY(ground1 - 40);

            ImageView wGem = new ImageView("blue.png");
            wGem.setFitHeight(30);
            wGem.setFitWidth(30);
            wGem.setX(460);
            wGem.setY(ground1 - 40);



            //FIREBOY
            ImageView fireboy = new ImageView("fireboy.png");
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
            ImageView watergirl = new ImageView("watergirl.png");
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

                    new MainMenu.hedgePane(0,ground1),new MainMenu.hedgePane(150,ground1),new MainMenu.hedgePane(300,ground1),
                    new MainMenu.hedgePane(450,ground1),new MainMenu.hedgePane(600,ground1), new MainMenu.hedgePane(750,ground1),
                    new MainMenu.hedgePane(900,ground1),new MainMenu.hedgePane(1050,ground1), new MainMenu.hedgePane(1200,ground1), new MainMenu.hedgePane(1350,ground1),

                    water, fire, water2,fire2,

                    fireboy,watergirl
            );


            Scene scene = new Scene(pane, 1500,950);
            twoStage.setScene(scene);
            twoStage.show();
            pane.requestFocus();
        }
        class hedgePane extends Pane{
            public hedgePane (int x,int y) {
                ImageView hedge = new ImageView("hedgeImage.jpg");
                hedge.setFitHeight(125);
                hedge.setFitWidth(200);
                hedge.setY(y);
                hedge.setX(x);
                getChildren().add(hedge);

            }

        }
    }


