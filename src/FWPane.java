import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class FWPane extends Application {
    @Override

    public void start (Stage firstStage) {

        Pane pane = new Pane();
        pane.setStyle("-fx-background-color: rgb(0,0,0)");

        //Fireboy
        ImageView fireboy = new ImageView("fireboy.png");
        fireboy.setFitWidth(85);
        fireboy.setFitHeight(85);
        fireboy.setX(60);
        fireboy.setY(800);

        //jumpUp

        TranslateTransition jumpUp = new TranslateTransition();
        jumpUp.setDuration(Duration.millis(750));
        jumpUp.setNode(fireboy);
        jumpUp.setByY(-75);
        jumpUp.setCycleCount(1);

        //jumpDown
        TranslateTransition jumpDown = new TranslateTransition();
        jumpDown.setDuration(Duration.millis(750));
        jumpDown.setNode(fireboy);
        jumpDown.setByY(75);
        jumpDown.setCycleCount(1);

        //moveRight
        TranslateTransition moveRight = new TranslateTransition();
        moveRight.setDuration(Duration.millis(1750));
        moveRight.setNode(fireboy);
        moveRight.setByX(100);
        moveRight.setCycleCount(1);


        //moveLeft
        TranslateTransition moveLeft = new TranslateTransition();
        moveLeft.setDuration(Duration.millis(1750));
        moveLeft.setNode(fireboy);
        moveLeft.setByX(-100);
        moveLeft.setCycleCount(1);

        pane.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.UP) {
                    jumpUp.play();
                }

                if (e.getCode() == KeyCode.LEFT) {
                    moveLeft.play();
                }

                if (e.getCode() == KeyCode.RIGHT) {
                    moveRight.play();
                }

        });

        pane.setOnKeyReleased(event -> {
            if (event.getCode() == KeyCode.UP) {
                jumpDown.play();
            }
        });


        pane.getChildren().addAll(fireboy);
        Scene scene = new Scene(pane, 1500,950);
        firstStage.setScene(scene);
        firstStage.show();
        pane.requestFocus();

}
}
