import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.input.KeyCode;

public class Evanescent extends Application {
    public void start (Stage ps){
        Pane pane = new Pane();

        Image green = new Image("Green.png", 150, 150, true, true);
        Image thanos = new Image("Thanos.png", 150, 150, true, true);

        ImageView p1 = new ImageView(green);
        ImageView p2 = new ImageView(thanos);
    }
}