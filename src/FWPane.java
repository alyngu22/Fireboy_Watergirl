import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.stage.Stage;

public class FWPane extends Application {
    @Override

    public void start (Stage firstStage) {
        BorderPane bp = new BorderPane();
        bp.setStyle("-fx-background-color: rgb(1,50,32)");

        Pane pane = new Pane();
        pane.setStyle("-fx-background-color: rgba(256,256,256,256)");




        Scene scene = new Scene(bp, 1500,950);
        firstStage.setScene(scene);
        firstStage.show();
    }
}

class Fireboy extends Pane {
    Arc mouth = new Arc(300,375,140,100,180,180);

}
