import javafx.application.Application;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
public class Watergirl extends Pane {
    public Watergirl(){
        Circle head = new Circle(20);
        head.setOnKeyPressed(e->{
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