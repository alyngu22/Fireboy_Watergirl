
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;
import javafx.util.Duration;

public class FWPane extends Application {
    @Override
    public void start (Stage firstStage) {

        Pane pane = new Pane();
        pane.setStyle("-fx-background-color: rgb(0,0,0)");

        int ground1Y = 795;
        
 //FIREBOY       
        ImageView fireboy = new ImageView("fireboy.png");
        fireboy.setFitWidth(85);
        fireboy.setFitHeight(85);
        fireboy.setX(60);
        fireboy.setY(ground1Y);
        
       TranslateTransition jumpFup = new TranslateTransition();
        jumpFup.setDuration(Duration.millis(250));
        jumpFup.setNode(fireboy);
        jumpFup.setByY(-100);
        jumpFup.setCycleCount(1);

        TranslateTransition jumpFDown = new TranslateTransition();
        jumpFDown.setDuration(Duration.millis(250));
        jumpFDown.setNode(fireboy);
        jumpFDown.setByY(100);
        jumpFDown.setCycleCount(1);

        SequentialTransition jumpF = new SequentialTransition(jumpFup,jumpFDown);

        TranslateTransition moveFRight = new TranslateTransition();
        moveFRight.setDuration(Duration.millis(5000));
        moveFRight.setNode(fireboy);
        moveFRight.setByX(1500);
        moveFRight.setCycleCount(1);

        TranslateTransition moveFLeft = new TranslateTransition();
        moveFLeft.setDuration(Duration.millis(5000));
        moveFLeft.setNode(fireboy);
        moveFLeft.setByX(-1500);
        moveFLeft.setCycleCount(1);




//WATERGIRL
        ImageView watergirl = new ImageView("watergirl.png");
        watergirl.setFitWidth(85);
        watergirl.setFitHeight(85);
        watergirl.setX(100);
        watergirl.setY(ground1Y);


        TranslateTransition jumpWup = new TranslateTransition();
        jumpWup.setDuration(Duration.millis(250));
        jumpWup.setNode(watergirl);
        jumpWup.setByY(-100);
        jumpWup.setCycleCount(1);

        TranslateTransition jumpWDown = new TranslateTransition();
        jumpWDown.setDuration(Duration.millis(250));
        jumpWDown.setNode(watergirl);
        jumpWDown.setByY(100);
        jumpWDown.setCycleCount(1);

        SequentialTransition jumpW = new SequentialTransition(jumpWup,jumpWDown);

        TranslateTransition moveWRight = new TranslateTransition();
        moveWRight.setDuration(Duration.millis(5000));
        moveWRight.setNode(watergirl);
        moveWRight.setByX(1500);
        moveWRight.setCycleCount(1);

        TranslateTransition moveWLeft = new TranslateTransition();
        moveWLeft.setDuration(Duration.millis(5000));
        moveWLeft.setNode(watergirl);
        moveWLeft.setByX(-1500);
        moveWLeft.setCycleCount(1);



//KEYBOARD ACTIONS
        pane.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.UP) {
                jumpF.play();
            }
            if (e.getCode() == KeyCode.LEFT) {
                moveFLeft.play();
            }

            if (e.getCode() == KeyCode.RIGHT) {
                moveFRight.play();
            }

            if (e.getText().equals("w")) {
                jumpW.play();
            }
            if (e.getText().equals("a")) {
                moveWLeft.play();

            }
            if (e.getText().equals("d")) {
                moveWRight.play();
            }

        });

        

        pane.setOnKeyReleased( e -> {
            if (e.getCode() == KeyCode.LEFT) {
                moveFLeft.stop();
            }
            else if (e.getCode() == KeyCode.RIGHT) {
                moveFRight.stop();
            }
            else if (e.getText().equals("a")) {
                moveWLeft.stop();
            }
            else if (e.getText().equals("d")) {
                moveWRight.stop();
            }
        });
        
//GROUND2
    int ground2 = 620;
    int ground2a = ground2 + 30;
    


        pane.getChildren().addAll(fireboy,watergirl, new hedgePane(0,825),new hedgePane(150,825),new hedgePane(300,825),
                new hedgePane(450,825),new hedgePane(600,825), new hedgePane(750,825),
                new hedgePane(900,825),new hedgePane(1050,825), new hedgePane(1200,825), new hedgePane(1350,825),
                new hedgePane(1500,825),

                new hedgePane(0,ground2a),new hedgePane(150,ground2a),new hedgePane(300,ground2a),
                new hedgePane(450,ground2a),new hedgePane(600,ground2a), new hedgePane(750,ground2a),
                new hedgePane(900,ground2a),new hedgePane(1050,ground2a),
               

                new firePane(350,875),
                new waterPane(750, 875)
                );


        Scene scene = new Scene(pane, 1500,950);
        firstStage.setScene(scene);
        firstStage.show();
        pane.requestFocus();

}

class hedgePane extends Pane{
      public hedgePane (int x,int y) {
          ImageView hedge = new ImageView("hedgeImage.jpg");
          hedge.setFitHeight(125);
          hedge.setFitWidth(150);
          hedge.setY(y);
          hedge.setX(x);
          getChildren().add(hedge);

      }

}

class firePane extends Pane {
        public firePane (int x, int y) {
            Arc fire = new Arc(x,y,75,25,180,180);
            fire.setType(ArcType.ROUND);
            fire.setFill(Color.RED);
            getChildren().add(fire);
        }
}

class waterPane extends Pane {
        public waterPane (int x, int y) {
            Arc water = new Arc(x,y,75,25,180,180);
            water.setType(ArcType.ROUND);
            water.setFill(Color.DEEPSKYBLUE);
            getChildren().add(water);
        }
}
}
