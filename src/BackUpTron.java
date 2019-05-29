import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class BackUpTron extends Application {
    Pane pane = new Pane();

    Image yellowRight = new Image("YellowRight.gif", 150, 150, true, true);
    Image yellowLeft = new Image("YellowLeft.gif", 150, 150, true, true);
    Image yellowUp = new Image("YellowUp.gif", 150, 150, true, true);
    Image yellowDown = new Image("YellowDown.gif", 150, 150, true, true);

    Image thanosLeft = new Image("ThanosLeft.gif", 150, 150, true, true);
    Image thanosRight  = new Image("ThanosRight.gif", 150, 150, true, true);
    Image thanosUp = new Image("ThanosUp.gif", 150, 150, true, true);
    Image thanosDown = new Image("ThanosDown.gif", 150, 150, true, true);
    ImageView p1 = new ImageView(yellowRight);
    ImageView p2 = new ImageView(thanosLeft);
    public void start(Stage ps) {
        p1.setX(750);
        p1.setY(750);

        p2.setX(150);
        p2.setY(150);

        pane.getChildren().addAll(p1, p2);

        Scene scene = new Scene(pane);
        ps.setScene(scene);
        ps.show();
    }
}

