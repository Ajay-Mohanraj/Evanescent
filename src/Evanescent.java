import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Evanescent extends Application {
    public void start (Stage ps){
        Pane pane = new Pane();

        Image green = new Image("Green.png", 150, 150, true, true);
        Image thanos = new Image("Thanos(OLD).png", 150, 150, true, true);

        ImageView p1 = new ImageView(green);
        ImageView p2 = new ImageView(thanos);
    }
}