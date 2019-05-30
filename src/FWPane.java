import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class FWPane extends Application {
    @Override

    public void start (Stage firstStage) {

        Pane pane = new Pane();
        pane.setStyle("-fx-background-color: rgb(0,0,0)");

        //Fireboy


        Circle head = new Circle(100,825,40);
        head.setFill(Color.RED);
        head.setStroke(Color.RED);






        pane.getChildren().addAll(head);

        Scene scene = new Scene(pane, 1500,950);
        firstStage.setScene(scene);
        firstStage.show();
    }
}



