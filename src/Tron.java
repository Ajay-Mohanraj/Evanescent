import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Tron extends Application {
    public void start(Stage ps) {
        Pane pane = new Pane();

        Image player1 = new Image("YellowRight.gif", 150, 150, true, true);
        ImageView p1 = new ImageView(player1);
        p1.setX(750);
        p1.setY(750);


        Image player2 = new Image("ThanosLeft.gif", 150, 150, true, true);
        ImageView p2 = new ImageView(player2);
        p2.setX(150);
        p2.setY(150);

        pane.getChildren().addAll(p1, p2);

        Scene scene = new Scene(pane);
        ps.setScene(scene);
        ps.show();
    }
}

