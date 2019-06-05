import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class RealTron extends Application {
    Pane pane = new Pane();

    //Image yellowRight = new Image("YellowRight.gif", 150, 150, true, true);
    Image yellowLeft = new Image("YellowLeft.gif", 150, 150, true, true);
    Image yellowUp = new Image("YellowUp.gif", 150, 150, true, true);
    Image yellowDown = new Image("YellowDown.gif", 150, 150, true, true);

    Image thanosLeft = new Image("ThanosLeft.gif", 150, 150, true, true);
    Image thanosRight = new Image("ThanosRight.gif", 150, 150, true, true);
    Image thanosUp = new Image("ThanosUp.gif", 150, 150, true, true);
    Image thanosDown = new Image("ThanosDown.gif", 150, 150, true, true);

    ImageView p1 = new ImageView(yellowLeft);
    ImageView p2 = new ImageView(thanosLeft);

    boolean wdown = false;

    final int p1_up = 0;
    final int p1_left = 1;
    final int p1_down = 2;
    final int p1_right = 3;

    final int p2_up = 4;
    final int p2_left = 5;
    final int p2_down = 6;
    final int p2_right = 7;

    String[] keys = {"w", "a", "s", "d", "UP", "LEFT", "DOWN", "RIGHT"};
    Boolean[] keyDown = {false, false, false, false, false, false, false, false};

    public void start(Stage ps) {

        p1.setX(750);
        p1.setY(750);

        p2.setX(150);
        p2.setY(150);

        pane.getChildren().addAll(p1, p2);

        pane.setOnKeyPressed(e -> move(e));
        pane.setOnKeyReleased(e -> released(e));



        Scene scene = new Scene(pane, 400, 400);
        ps.setScene(scene);
        ps.show();
        pane.requestFocus();

    }

    public void move(KeyEvent e) {
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                for (int i = 0; i < keys.length; i++) {
                    if (keys[i].equals(e.getText())) {
                        keyDown[i] = true;
                    }
                }

            }
        }.start();
        if (e.getText().equals("a")) {
            while (p1.getX() > 0) {
                p1.setX(p1.getX() - 5);
            }
        } else if (e.getText().equals("w")) {
            //  while (p1.getY() > 0){
            //      p1.setY(p1.getY()-5);
            //  }
            wdown = true;
        } else if (e.getText().equals("d")) {
            while (p1.getX() < 400) {
                p1.setX(p1.getX() + 5);
            }
        } else if (e.getText().equals("s")) {
            while (p1.getY() < 400) {
                p1.setY(p1.getY() + 5);
            }
        }

        while (e.getCode() == KeyCode.LEFT) {
            p2.setX(p2.getX() - 5);
        }
        while (e.getCode() == KeyCode.UP) {
            p2.setY(p2.getY() - 5);
        }
        while (e.getCode() == KeyCode.RIGHT) {
            p2.setX(p2.getX() + 5);
        }
        while (e.getCode() == KeyCode.DOWN) {
            p2.setY(p2.getY() + 5);
        }
    }

    public void released(KeyEvent e) {
        if (e.getText().equals("w")) {
            wdown = false;
        }
    }
}
