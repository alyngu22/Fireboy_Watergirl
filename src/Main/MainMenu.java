package Main;

import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.Scene;
import FireboyWatergirlLvl.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.text.*;

public class MainMenu extends Application {
    public void start(Stage menuStage){
        BorderPane bordp = new BorderPane();
        bordp.setStyle("-fx-background-color: rgb(0,90,100)");

        Text title = new Text("FIREBOY AND WATERGIRL");
        title.setFont(Font.font("Verdana", FontWeight.BOLD, 75));
        title.setFill(Color.WHITE);
        bordp.getChildren().add(title);
        title.setX(230);
        title.setY(200);

        Image l1 = new Image("Images/waterdrop.png");
        Image l2 = new Image("Images/fire-cartoon.png");
        for (int i = 0; i < 3; i++) {
            ImageView lOne = new ImageView(l1);
            if(i==0){
                lOne.setImage(l2);
                lOne.setOnMousePressed(e->{
                    menuStage.close();
                    Stage oneStage = new Stage();
                    Level1 yea = new Level1();
                    yea.start(oneStage);
                });
            }
            else if(i==1){
                lOne.setImage(l1);
                lOne.setOnMousePressed(e -> {
                    menuStage.close();
                    Stage twoStage = new Stage();
                    Level2 no = new Level2();
                    no.start(twoStage);
                });
            }
            else{
                lOne.setImage(l2);
                lOne.setOnMousePressed(e->{
                    menuStage.close();
                    Stage threeStage = new Stage();
                    Level3 whoops = new Level3();
                    whoops.start(threeStage);
                });
            }
            lOne.setFitHeight(100);
            lOne.setFitWidth(100);
            lOne.setX(450 + i * 250);
            lOne.setY(250);

            Text levelTxt = new Text("" + (i + 1));
            levelTxt.setFont(Font.font("comic sans ms", FontWeight.BOLD, 30));
            levelTxt.setX(lOne.getX() + 40);
            levelTxt.setY(lOne.getY() + 50);
            levelTxt.setFill(Color.BLACK);
            bordp.getChildren().addAll(lOne, levelTxt);
        }
        Scene scene = new Scene(bordp,bordp.getWidth(), bordp.getHeight());
        menuStage.setScene(scene);
        menuStage.show();
        bordp.requestFocus();

    }
}


