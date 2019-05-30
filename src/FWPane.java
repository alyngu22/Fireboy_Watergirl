import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class FWPane extends Application {
    @Override
    public void start(Stage firstStage) {
        BorderPane bp = new BorderPane();
        Pane pane = new Pane();


        Scene scene = new Scene(bp, 1500, 950);
        firstStage.setScene(scene);
        firstStage.show();
    }
}
