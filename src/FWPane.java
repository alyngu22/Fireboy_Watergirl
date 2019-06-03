import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Node;
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


        double temp = fireboy.getY();
        pane.setOnKeyTyped(e -> {
            if (e.getCode() == KeyCode.UP){
                    setJumpUp(fireboy);
                }

                if (e.getCode() == KeyCode.LEFT) {
                    setMoveLeft(fireboy);
                }

                if (e.getCode() == KeyCode.RIGHT) {
                    setMoveRight(fireboy);
                }

        });

        double diff = fireboy.getY() - temp;
        pane.setOnKeyReleased(event -> {
            if (event.getCode() == KeyCode.UP) {
                setJumpDown(diff, fireboy);
            }
        });


        pane.getChildren().addAll(fireboy);
        Scene scene = new Scene(pane, 1500,950);
        firstStage.setScene(scene);
        firstStage.show();
        pane.requestFocus();

}

public void setJumpDown (double temp, Node node) {
    TranslateTransition jumpDown = new TranslateTransition();
    jumpDown.setDuration(Duration.millis(750));
    jumpDown.setNode(node);
    jumpDown.setByY(temp);
    jumpDown.setCycleCount(1);
    jumpDown.play();
}

public void setJumpUp(Node node) {
    TranslateTransition jumpUp = new TranslateTransition();
    jumpUp.setDuration(Duration.millis(750));
    jumpUp.setNode(node);
    jumpUp.setByY(75);
    jumpUp.setCycleCount(1);
    jumpUp.play();
}

public void setMoveRight (Node node) {
    TranslateTransition moveRight = new TranslateTransition();
    moveRight.setDuration(Duration.millis(1750));
    moveRight.setNode(node);
    moveRight.setByX(100);
    moveRight.setCycleCount(1);
    moveRight.play();
}

public void setMoveLeft (Node node) {
    TranslateTransition moveLeft = new TranslateTransition();
    moveLeft.setDuration(Duration.millis(1750));
    moveLeft.setNode(node);
    moveLeft.setByX(-100);
    moveLeft.setCycleCount(1);
    moveLeft.play();

}

}
