
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;
import javafx.util.Duration;

public class FWPane2 extends Application {
    @Override
    public void start (Stage firstStage) {

        Pane pane = new Pane();
        pane.setStyle("-fx-background-color: rgb(0,0,0)");

        int groundY = 450;


        //Fireboy
        ImageView fireboy = new ImageView("fireboy.png");
        fireboy.setFitWidth(85);
        fireboy.setFitHeight(85);
        fireboy.setX(60);
        fireboy.setY(groundY);


        TranslateTransition jumpUp = new TranslateTransition();
        jumpUp.setDuration(Duration.millis(500));
        jumpUp.setNode(fireboy);
        jumpUp.setByY(-150);
        jumpUp.setCycleCount(1);

        TranslateTransition jumpDown = new TranslateTransition();
        jumpDown.setDuration(Duration.millis(500));
        jumpDown.setNode(fireboy);
        jumpDown.setByY(150);
        jumpDown.setCycleCount(1);

        SequentialTransition jump = new SequentialTransition(jumpUp,jumpDown);

        TranslateTransition moveRight = new TranslateTransition();
        moveRight.setDuration(Duration.millis(550));
        moveRight.setNode(fireboy);
        moveRight.setByX(150);
        moveRight.setCycleCount(1);

        TranslateTransition moveLeft = new TranslateTransition();
        moveLeft.setDuration(Duration.millis(550));
        moveLeft.setNode(fireboy);
        moveLeft.setByX(-150);
        moveLeft.setCycleCount(1);


        pane.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.UP) {
                jump.play();
            }
            if (e.getCode() == KeyCode.LEFT) {
                moveLeft.play();
            }

            if (e.getCode() == KeyCode.RIGHT) {
                moveRight.play();
            }
        });

        pane.setOnKeyReleased( ev -> {
            if (ev.getCode() == KeyCode.LEFT) {
                moveLeft.pause();
            }
            if (ev.getCode() == KeyCode.RIGHT) {
                moveRight.pause();
            }
        });


        pane.getChildren().addAll(fireboy, new firePane(150, 490));

        Scene scene = new Scene(pane, 500,550);
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

    class firePane extends Pane {
        public firePane (int x, int y) {
            Arc fire = new Arc(x,y,75,25,180,180);
            fire.setType(ArcType.ROUND);
            fire.setFill(Color.RED);
            getChildren().add(fire);
        }
    }
}
