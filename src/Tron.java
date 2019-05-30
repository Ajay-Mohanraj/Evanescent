import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.input.KeyCode;

public class Tron extends Application{
    public void start(Stage ps) {
        Pane pane = new Pane();

        Image yellowRight = new Image("YellowRight.gif", 150, 150, true, true);
        Image yellowLeft = new Image("YellowLeft.gif", 150, 150, true, true);
        Image yellowUp = new Image("YellowUp.gif", 150, 150, true, true);
        Image yellowDown = new Image("YellowDown.gif", 150, 150, true, true);

        Image thanosLeft = new Image("ThanosLeft.gif", 150, 150, true, true);
        Image thanosRight  = new Image("ThanosRight.gif", 150, 150, true, true);
        Image thanosUp = new Image("ThanosUp.gif", 150, 150, true, true);
        Image thanosDown = new Image("ThanosDown.gif", 150, 150, true, true);
        ImageView p1 = new ImageView(yellowLeft);
        double p1Speed = 5;

        ImageView p2 = new ImageView(thanosRight);
        double p2Speed = 5;

        p1.setX(750);
        p1.setY(750);
        pane.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.UP) {
                p1.setY(p1.getY() - p1Speed);
            }
            else if (e.getCode() == KeyCode.DOWN) {
                p1.setY(p1.getY() + p1Speed);
            }
            else if (e.getCode() == KeyCode.RIGHT) {
                p1.setX(p1.getX() + p1Speed);
            }
            else if (e.getCode() == KeyCode.LEFT) {
                p1.setX(p1.getX() - p1Speed);
            }
        });

        p2.setX(100);
        p2.setY(100);

        pane.setOnKeyPressed(e -> {
            if (e.getText().equals("W")) {
                p2.setY(p2.getY() - p2Speed);
            }
            else if (e.getCode() == KeyCode.S) {
                p2.setY(p2.getY() + p2Speed);
            }
            else if (e.getCode() == KeyCode.D) {
                p2.setX(p2.getX() + p2Speed);
            }
            else if (e.getCode() == KeyCode.A) {
                p2.setX(p2.getX() - p2Speed);
            }
        });

        pane.getChildren().addAll(p1, p2);

        Scene scene = new Scene(pane);
        ps.setScene(scene);
        ps.show();
    }
}