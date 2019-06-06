import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RealTron extends Application {
    Pane pane = new Pane();

    //Image yellowRight = new Image("YellowRight.gif", 150, 150, true, true);
    Image green= new Image("Green.png", 150, 150, true, true);
    Image thanos = new Image("Thanos.png", 150, 150, true, true);

    ImageView p1 = new ImageView(green);
    ImageView p2 = new ImageView(thanos);

    int p1Dx = 5;
    int p1Dy = 0;
    int p2Dy = 0;
    int p2Dx = -5;

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

        p1.setX(150);
        p1.setY(150);

        p2.setX(650);
        p2.setY(650);

        pane.getChildren().addAll(p1, p2);

        pane.setOnKeyPressed(e -> move(e));
        // pane.setOnKeyReleased(e -> released(e));

        new AnimationTimer() {
            @Override
            public void handle(long now) {
                for (int i = 0; i < 8; i++) {
                    if (keyDown[i]) {
                        switch (keys[i]){
                            case "w": p1Dx = 0;p1Dy = -5;p1.setRotate(90);

                            case "a": p1Dx = -5;p1Dy = 0;p1.setRotate(180);

                            case "s": p1Dx = 0; p1Dy = 5;p1.setRotate(270);

                            case "d": p1Dx = 5; p1Dy = 0;p1.setRotate(0);

                        }

                        System.out.println(keys[i]);
                        keyDown[i] = false;
                    }
                }
                p1.setX(p1.getX() + p1Dx);
                p1.setY(p1.getY() + p1Dy);

            }

        }.start();

        Scene scene = new Scene(pane, 1000, 1000);
        ps.setScene(scene);

        if (hits(p1, p2)) {
            Pane end = new Pane();
            Text winner = new Text("YOU BOTH LOSE!");

            winner.xProperty().bind(end.widthProperty().divide(2));
            winner.yProperty().bind(end.heightProperty().divide(2));

            Scene endGame = new Scene(pane, 1000, 1000);
            ps.setScene(endGame);
        }

        ps.show();
        pane.requestFocus();

    }

    public void move(KeyEvent e) {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i].equals(e.getText())) {
                keyDown[i] = true;
            }
        }

    }
    public void released(KeyEvent e) {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i].equals(e.getText())) {
                keyDown[i] = false;
            }
        }
    }
    public Rectangle2D getBoundary(ImageView player, Image p) {
        return new Rectangle2D(player.getX(), player.getY(), p.getRequestedWidth(), p.getRequestedHeight());
    }

    public boolean hits(ImageView p1, ImageView p2) {
        return getBoundary(p1, p1.getImage()).intersects(getBoundary(p2, p2.getImage()));
    }
}
