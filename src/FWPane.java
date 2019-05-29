import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class FWPane extends Application {
    @Override

    public void start (Stage primaryStage) {
        BorderPane pane = new BorderPane();

        Scene scene = new Scene(pane, 1500,950);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
