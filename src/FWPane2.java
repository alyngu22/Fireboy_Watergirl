import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class FWPane2 extends Application {
    @Override

    public void start(Stage firstStage) {

        Pane pane = new Pane();
        pane.setStyle("-fx-background-color: rgb(0,0,0)");

        //Fireboy
        ImageView fireboy = new ImageView("fireboy.png");
        fireboy.setFitWidth(85);
        fireboy.setFitHeight(85);
        fireboy.setX(60);
        fireboy.setY(800);

        //Watergirl
        ImageView watergirl = new ImageView("fireboy.png");
        watergirl.setFitWidth(85);
        watergirl.setFitHeight(85);
        watergirl.setX(60);
        watergirl.setY(800);

        //jumpUp

        TranslateTransition jumpUp = new TranslateTransition();
        jumpUp.setDuration(Duration.millis(750));
        jumpUp.setNode(watergirl);
        jumpUp.setByY(-75);
        jumpUp.setCycleCount(1);

        //jumpDown
        TranslateTransition jumpDown = new TranslateTransition();
        jumpDown.setDuration(Duration.millis(750));
        jumpDown.setNode(watergirl);
        jumpDown.setByY(75);
        jumpDown.setCycleCount(1);

        //moveRight
        TranslateTransition moveRight = new TranslateTransition();
        moveRight.setDuration(Duration.millis(1750));
        moveRight.setNode(watergirl);
        moveRight.setByX(100);
        moveRight.setCycleCount(1);


        //moveLeft
        TranslateTransition moveLeft = new TranslateTransition();
        moveLeft.setDuration(Duration.millis(1750));
        moveLeft.setNode(watergirl);
        moveLeft.setByX(-100);
        moveLeft.setCycleCount(1);

        pane.setOnKeyTyped(e -> {
            if (e.getCode() == KeyCode.A) {
                jumpUp.play();
                jumpDown.play();
            }

            if (e.getCode() == KeyCode.LEFT) {
                moveLeft.play();
            }

            if (e.getCode() == KeyCode.RIGHT) {
                moveRight.play();
            }

        });

        pane.getChildren().addAll(fireboy);
        pane.getChildren().addAll(watergirl);
        Scene scene = new Scene(pane, 1500, 950);
        firstStage.setScene(scene);
        firstStage.show();
        pane.requestFocus();

    }
}