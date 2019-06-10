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
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class RealTron extends Application {
    Pane pane = new Pane();

    //Image yellowRight = new Image("YellowRight.gif", 150, 150, true, true);
    Image green = new Image("Green.png", 150, 150, true, true);
    Image thanos = new Image("Thanos.png", 150, 150, true, true);


    ImageView p1 = new ImageView(green);
    ImageView p2 = new ImageView(thanos);

    int p1Dx = 0;
    int p1Dy = 0;
    int p2Dy = 0;
    int p2Dx = 0;

    ArrayList<Rectangle> linePath = new ArrayList<>(15);

    String[] keys = {"w", "a", "s", "d", "Up", "Left", "Down", "Right"};
    Boolean[] keyDown = {false, false, false, false, false, false, false, false};

    public void start(Stage ps) {

        int up = 270;
        int left = 180;
        int down = 90;
        int right = 0;

        p1.setX(150);
        p1.setY(150);

        p2.setX(650);
        p2.setY(650);
        p2.setRotate(left);


        pane.getChildren().addAll(p1, p2);

        pane.setOnKeyPressed(e -> move(e));
        // pane.setOnKeyReleased(e -> released(e));

        new AnimationTimer() {
            @Override
            public void handle(long now) {


                for (int i = 0; i < keyDown.length; i++) {
                    if (keyDown[i]) {
                        switch (keys[i]){
                            case "w":
                                p1Dx = 0;
                                p1Dy = -5;
                                p1.setRotate(up);
                                break;

                            case "a":
                                p1Dx = -5;
                                p1Dy = 0;
                                p1.setRotate(left);
                                break;

                            case "s":
                                p1Dx = 0;
                                p1Dy = 5;
                                p1.setRotate(down);
                                break;

                            case "d":
                                p1Dx = 5;
                                p1Dy = 0;
                                p1.setRotate(right);
                                break;

                            case "Up":
                                p2Dx = 0;
                                p2Dy = -5;
                                p2.setRotate(up);
                                break;

                            case "Left":
                                p2Dx = -5;
                                p2Dy = 0;
                                p2.setRotate(left);
                                break;

                            case "Down":
                                p2Dx = 0;
                                p2Dy = 5;
                                p2.setRotate(down);
                                break;

                            case "Right":
                                p2Dx = 5;
                                p2Dy = 0;
                                p2.setRotate(right);
                                break;

                            default:
                                break;
                        }

                        //System.out.println(keys[i]);
                       keyDown[i] = false;
                    }
                }
                p1.setX(p1.getX() + p1Dx);
                p1.setY(p1.getY() + p1Dy);

                p2.setX(p2.getX() + p2Dx);
                p2.setY(p2.getY() + p2Dy);

                if ((p1.getRotate() == up && p1.getY() <= 0)
                        || (p1.getRotate() == left && p1.getX() <= 0)
                        || (p1.getRotate() == down && p1.getY() >= pane.getHeight())
                        || (p1.getX() >= pane.getWidth())) {
                    pane.getChildren().remove(p1);
                }
//
                if ((p2.getRotate() == up && p2.getY() <= 0)
                        || (p2.getRotate() == left && p2.getX() <= 0)
                        || (p2.getRotate() == down && p2.getY() >= pane.getHeight())
                        || (p2.getX() >= pane.getWidth())) {
                    pane.getChildren().remove(p2);
                }

                if (hits(p1, p2)) {
                    Pane end = new Pane();
                    Text winner = new Text("YOU BOTH LOSE!");

                    winner.xProperty().bind(end.widthProperty().divide(2));
                    winner.yProperty().bind(end.heightProperty().divide(2));
                    end.getChildren().add(winner);

                    Scene endGame = new Scene(end, 1000, 1000);
                    ps.setScene(endGame);
                    ps.show();
                }



            }


        }.start();

        Scene scene = new Scene(pane, 1000, 1000);
        ps.setScene(scene);
        ps.show();
        pane.requestFocus();

    }

    public void move(KeyEvent e) {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i].equals(e.getText()) || keys[i].equals(e.getCode().getName())) {
                keyDown[i] = true;
            }
        }

    }
//    public void released(KeyEvent e) {
//        for (int i = 0; i < keys.length; i++) {
//            if (keys[i].equals(e.getText()) || keys[i].equals(e.getCode().getName())) {
//                keyDown[i] = false;
//            }
//        }
//    }
    public Rectangle2D getBoundary(ImageView player, Image p) {
        return new Rectangle2D(player.getX(), player.getY(), p.getWidth(), p.getHeight());
    }

    public boolean hits(ImageView p1, ImageView p2) {
        return getBoundary(p1, p1.getImage()).intersects(getBoundary(p2, p2.getImage()));
    }

    public void drawPath() {

    }
}
