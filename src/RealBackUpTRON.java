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

public class RealBackUpTRON extends Application {
    Pane pane = new Pane();

    //Image yellowRight = new Image("YellowRight.gif", 150, 150, true, true);
    Image green = new Image("Green.png", 150, 150, true, true);

    Image thanos = new Image("Thanos.png", 150, 150, true, true);

    ImageView p1 = new ImageView(green);
    ImageView p2 = new ImageView(thanos);

    boolean wdown = false;

    final int p1_up = 0;
    final int p1_left = 1;
    final int p1_down = 2;
    final int p1_right = 3;

    final int p2_up = 4;
    final int p2_left = 5;
    final int p2_down = 6;
    final int p2_right = 7;

    String[] keys = {"w", "a", "s", "d", "Up", "Left", "Down", "Right"};
    Boolean[] keyDown = {false, false, false, false, false, false, false, false};

    public void start(Stage ps) {

        p1.setX(750);
        p1.setY(750);

        p2.setX(150);
        p2.setY(150);

        pane.getChildren().addAll(p1, p2);

        pane.setOnKeyPressed(e -> move(e));
        pane.setOnKeyReleased(e -> released(e));

        new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (wdown) {
                    p1.setY(p1.getY()-5);
                }
            }
        }.start();

        Scene scene = new Scene(pane, 750, 750);
        ps.setScene(scene);
        ps.show();
        pane.requestFocus();

    }

    public void move(KeyEvent e) {
    	for (int i = 0; i < keys.length; i++) {
    		if (keys[i].equals(e.getText()) || keys[i].equals(e.getCode().getName())) {
				System.out.println(keys[i]);
				// make value true
                keyDown[i] = true;
			}
		}
//		if (e.getText().equals("w")) {
//			wdown = true;
//		}
    }

    public void released(KeyEvent e) {
        if (e.getText().equals("w")) {
            wdown = false;
        }
    }
}
