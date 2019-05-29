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

    public class Watergirl extends Pane {
        public Watergirl{
            Circle head = new Circle(20);
            head.setOnKeyPressed(e->{
                if (e.getCode() == KeyCode.LEFT) {

                }
            });
        }
        public void front(Circle fHead) {
            Arc smile = new Arc();
            smile.setRadiusX(10);
            smile.setRadiusY(5);
            smile.centerYProperty().bind(fHead.centerXProperty().add(4));
            smile.centerYProperty().bind(fHead.centerYProperty().subtract(4));
            smile.setStartAngle(40);
            smile.setType(ArcType.OPEN);
            smile.setRotate(115);
            fHead.setFill(Color.BLUE);
            fHead.setStroke(Color.BLUE);
        }
        public void left() {
            Circle fHead = new Circle(20);
            Arc smile = new Arc();
            smile.setRadiusX(10);
            smile.setRadiusY(5);
            smile.centerYProperty().bind(fHead.centerXProperty().add(4));
            smile.centerYProperty().bind(fHead.centerYProperty().subtract(4));
            smile.setStartAngle(40);
            smile.setType(ArcType.OPEN);
            smile.setRotate(115);
            fHead.setFill(Color.BLUE);
            fHead.setStroke(Color.BLUE);
        }
    }
}
