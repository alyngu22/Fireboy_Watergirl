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
    private int wGem;
    private int fGem;
    public void start(Stage firstStage) {
        wGem = 0;
        fGem = 0;
        Pane pane = new Pane();
        pane.setStyle("-fx-background-color: rgb(0,0,0)");

        int groundY = 825;

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
        water.setFill(Color.BLUE);

        Rectangle stair = new Rectangle(550, 735, 200, 300);
        stair.setStroke(Color.WHITE);

        ImageView bGem = new ImageView("bluegem.png");
        bGem.setFitWidth(30);
        bGem.setFitHeight(30);
        bGem.setX(570);
        bGem.setY(stair.getY()-30);

        ImageView bGem1 = new ImageView("bluegem.png");
        bGem1.setFitWidth(30);
        bGem1.setFitHeight(30);
        bGem1.setX(30);
        bGem1.setY(groundY-30);

        ImageView rGem = new ImageView("rGem.png");
        rGem.setFitHeight(35);
        rGem.setFitWidth(30);
        rGem.setX(340);
        rGem.setY(735);

        ImageView rGem1 = new ImageView("rGem.png");
        rGem1.setFitHeight(35);
        rGem1.setFitWidth(30);
        rGem1.setX(810);
        rGem1.setY(745);
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

        new AnimationTimer() {
            public void handle (long now) {
                if (water.contains(fireboy.getX()+25, fireboy.getY() + 83)||fire.contains(watergirl.getX()+25, watergirl.getY()+83)) {
                    Rectangle rectangle = new Rectangle(pane.getWidth(), pane.getHeight());
                    rectangle.setFill(Color.BLACK);
                    Text text = new Text(450, 275, "Game Over! You Lose!");
                    text.setFont(Font.font("Times New Roman", 36));
                    text.setFill(Color.WHITE);
                    pane.getChildren().addAll(rectangle, text);
                    moveL.stop();
                    moveL2.stop();
                    moveR.stop();
                    moveR1.stop();
                    ns.stop();
                    ns1.stop();
                }
                if(fireboy.contains(rGem.getX(), rGem.getY())){
                    pane.getChildren().remove(rGem);
                    fGem += 1;
                }
                if(fireboy.contains(rGem1.getX(), rGem1.getY())){
                    pane.getChildren().remove(rGem1);
                    fGem +=1;
                }
                if(watergirl.contains(bGem.getX(), bGem.getY())){
                    pane.getChildren().remove(bGem);
                    wGem += 1;
                }
                if(watergirl.contains(bGem1.getX(), bGem1.getY())){
                    pane.getChildren().remove(bGem1);
                    wGem += 1;
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
                    rectangle.setFill(Color.BLACK);
                    Text text = new Text(450, 325, "Congrats! You Win!\nFireboy: %d Points\nWatergirl:"+wGem+ " Points");
                    text.setFont(Font.font("Times New Roman", 36));
                    text.setFill(Color.WHITE);
                    pane.getChildren().add(rectangle);
                    pane.getChildren().add(text);
                    moveR.stop();
                    ns.stop();
                    moveL.stop();
                }
                if (watergirl.getX() >= stair.getX()-85 && watergirl.getX() <= stair.getX()+10 && watergirl.getY()>stair.getY()-80) {
                    moveR1.stop();
                    watergirl.setX(stair.getX()-80);
                }
                if (watergirl.getX() <= stair.getX()+stair.getWidth() && watergirl.getX() >= stair.getX()+stair.getWidth()-10 && watergirl.getY()>stair.getY()-80) {
                    moveL2.stop();
                    watergirl.setX(stair.getX()+stair.getWidth());
                }
                if (stair.contains(watergirl.getX()+50, watergirl.getY() + 83)) {
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
                if (fireboy.getX() >= stair.getX()-85 && fireboy.getX() <= stair.getX()+10 && fireboy.getY()>stair.getY()-80) {
                    moveR.stop();
                    fireboy.setX(stair.getX()-80);
                }
                if (fireboy.getX() <= stair.getX()+stair.getWidth() && fireboy.getX() >= stair.getX()+stair.getWidth()-10 && fireboy.getY()>stair.getY()-80) {
                    moveL.stop();
                    fireboy.setX(stair.getX()+stair.getWidth());
                }
                if (stair.contains(fireboy.getX()+50, fireboy.getY() + 83)) {
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

        pane.getChildren().addAll(stair, fireboy, watergirl, new FWPaneFinal.hedgePane(0,groundY),new FWPaneFinal.hedgePane(150,groundY),new FWPaneFinal.hedgePane(300,groundY),
                new FWPaneFinal.hedgePane(450,groundY),new FWPaneFinal.hedgePane(600,groundY), new FWPaneFinal.hedgePane(750,groundY),
                new FWPaneFinal.hedgePane(900,groundY),new FWPaneFinal.hedgePane(1050,groundY),fire, water, bGem, bGem1,rGem, rGem1);

        Scene scene = new Scene(pane, 1200,950);
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
