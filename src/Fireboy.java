import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;
import javafx.scene.image.ImageView;
public class Fireboy extends ImageView {
    private Rectangle deathScreen;
    private final double GRAVITY = .17;
    private final double FRICTION = .99;
    private double hSpeed;
    private double vSpeed;
    private double xStart;
    private double yStart;
    private FireboyMain lvl;
    private Timeline animation;

    public Fireboy(double xPos, double yPos) {
        hSpeed = 0;
        vSpeed = 0;
        xStart = xPos;
        yStart = yPos;
        setFitWidth(85);
        setFitHeight(80);
        setX(xPos);
        setY(yPos);
    }

    public void jumpLeft() {
        if (vSpeed < -3) {
            vSpeed = -8;
            hSpeed -= 1.5;
        } else {
            hSpeed -= 1.5;
            if (vSpeed < 0)
                vSpeed -= 5;
            else
                vSpeed = -5;
        }
    }
    public void jumpRight() {
        if (vSpeed < -3) {
            vSpeed = -8;
            hSpeed += 1.5;
        } else {
            hSpeed += 1.5;
            if (vSpeed < 0) {
                vSpeed -= 5;
            }
            else{
                vSpeed = -5;
            }
        }
    }


}
