import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

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

        pane.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.UP){
                fireboy.setY(fireboy.getY()-15);
            }

            if (e.getCode() == KeyCode.LEFT) {
                fireboy.setX(fireboy.getX()+15);
            }

            if (e.getCode() == KeyCode.RIGHT) {
                fireboy.setX(fireboy.getX()-15);
            }
        });

        pane.getChildren().add(fireboy);
        Scene scene = new Scene(pane, 1500,950);
        firstStage.setScene(scene);
        firstStage.show();
    }
}



