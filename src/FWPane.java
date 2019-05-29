import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class FWPane extends Application {
    @Override

    public void start (Stage primaryStage) {
        Pane pane = new Pane();

        Scene scene = new Scene(pane, 750,750);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
