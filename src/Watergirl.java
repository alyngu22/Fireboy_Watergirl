import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
public class Watergirl extends Application{
    public void start(Stage ps){
        Pane pane = new Pane();

        Circle wHead = new Circle(100, 470, 20);
        pane.getChildren().add(wHead);

        Arc wSmile = new Arc();
        wSmile.setRadiusX(10);
        wSmile.setRadiusY(5);
        wSmile.centerYProperty().bind(wHead.centerXProperty().add(4));
        wSmile.centerYProperty().bind(wHead.centerYProperty().subtract(4));
        wSmile.setStartAngle(40);
        wSmile.setRotate(115);
        pane.getChildren().add(wSmile);

        wHead.setFill(Color.LIGHTBLUE);
        wHead.setStroke(Color.LIGHTBLUE);
        wSmile.setFill(Color.BLACK);
        wSmile.setStroke(Color.BLACK);
        wSmile.setType(ArcType.OPEN);

        pane.setOnKeyPressed(e->{
            if(e.getText().equals("a")||e.getText().equals("A")){
                left(wHead, wSmile);
                if(wHead.getCenterX()-wHead.getRadius()==0){
                    wHead.setCenterX(wHead.getCenterX()-20);
                }
            }
            else if(e.getText().equals("d")||e.getText().equals("D")){
                right(wHead, wSmile);
                if(wHead.getCenterX()+wHead.getRadius()==pane.getWidth()){
                    wHead.setCenterX(wHead.getCenterX()+20);
                }
            }
        });

        Scene scene = new Scene(pane, 500, 500);
        ps.setScene(scene);
        ps.show();
    }
    public void left(Circle fHead, Arc smile) {
        smile.centerYProperty().bind(fHead.centerXProperty().add(4));
        smile.centerYProperty().bind(fHead.centerYProperty().subtract(4));
        smile.setStartAngle(40);
        smile.setRotate(115);
    }
    public void right(Circle fHead, Arc smile) {
        smile.centerYProperty().bind(fHead.centerXProperty().add(4));
        smile.centerYProperty().bind(fHead.centerYProperty().subtract(4));
        smile.setStartAngle(40);
        smile.setRotate(115);
    }
}