import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.ArrayList;

public class RealTron extends Application {
    Pane pane = new Pane();

    //Image yellowRight = new Image("YellowRight.gif", 150, 150, true, true);
    Image green= new Image("Green.png", 96, 96, true, true);
    Image thanos = new Image("Thanos.png", 96, 96, true, true);

    ImageView p1 = new ImageView(thanos);
    ImageView p2 = new ImageView(green);

    BorderPane end = new BorderPane();
    Text winner = new Text("");

    ArrayList<Rectangle> paths = new ArrayList<Rectangle>();

    int p1Dx = 0;
    int p1Dy = 0;
    int p2Dy = 0;
    int p2Dx = 0;

    final int p1_up = 0;
    final int p1_left = 1;
    final int p1_down = 2;
    final int p1_right = 3;

    final KeyCode P2UP = KeyCode.UP;
    final KeyCode P2LEFT = KeyCode.LEFT;
    final KeyCode P2DOWN = KeyCode.DOWN;
    final KeyCode P2RIGHT = KeyCode.RIGHT;

    KeyCode[] keys = {KeyCode.W, KeyCode.A, KeyCode.S, KeyCode.D, KeyCode.UP, KeyCode.LEFT, KeyCode.DOWN, KeyCode.RIGHT};
    Boolean[] keyDown = {false, false, false, false, false, false, false, false};

    public void start(Stage ps) {

        p1.setX(0);
        p1.setY(0);

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
                        switch (i) {
                            case 0:
                                p1Dx = 0;
                                p1Dy = -5;
                                p1.setRotate(270);
                                break;

                            case 1:
                                p1Dx = -5;
                                p1Dy = 0;
                                p1.setRotate(180);
                                break;

                            case 2:
                                p1Dx = 0;
                                p1Dy = 5;
                                p1.setRotate(90);
                                break;

                            case 3:
                                p1Dx = 5;
                                p1Dy = 0;
                                p1.setRotate(0);
                                break;

                            case 4:
                                p2Dx = 0;
                                p2Dy = -5;
                                p2.setRotate(270);
                                break;

                            case 5:
                                p2Dx = -5;
                                p2Dy = 0;
                                p2.setRotate(180);
                                break;

                            case 6:
                                p2Dx = 0;
                                p2Dy = 5;
                                p2.setRotate(90);
                                break;

                            case 7:
                                p2Dx = 5;
                                p2Dy = 0;
                                p2.setRotate(0);
                                break;
                        }
                        System.out.println(keys[i]);
                        keyDown[i] = false;
                    }
                }
                p1.setX(p1.getX()+p1Dx);
                p1.setY(p1.getY()+p1Dy);
                p2.setX(p2.getX()+p2Dx);
                p2.setY(p2.getY()+p2Dy);
                drawPath(p1, Color.INDIGO);
                drawPath(p2, Color.LIGHTGREEN);

                if (hits(p1, p2)) {
                    winner.setTextAlignment(TextAlignment.CENTER);
                    if (p1.getRotate() == 0 && p2.getRotate() == 180 ||
                        p1.getRotate() == 180 && p2.getRotate() == 0 ||
                        p1.getRotate() == 90 && p2.getRotate() == 270 ||
                        p1.getRotate() == 270 && p2.getRotate() == 90) {
                        winner.setText("YOU BOTH LOSE!");
                    }
                    else if (p1.getRotate() == 0 && p2.getRotate() == 90 && p1.getX() + 9 < p2.getX() + 27 && p2.getX() + 66 < p1.getX() + 84 ||
                            p1.getRotate() == 0 && p2.getRotate() == 270 && p1.getX() + 9 < p2.getX() + 27 && p2.getX() + 66 < p1.getX() + 84 ||
                            p1.getRotate() == 180 && p2.getRotate() == 90 && p1.getX() + 9 < p2.getX() + 27 && p2.getX() + 66 < p1.getX() + 84 ||
                            p1.getRotate() == 180 && p2.getRotate() == 270 && p1.getX() + 9 < p2.getX() + 27 && p2.getX() + 66 < p1.getX() + 84) {
                        winner.setText("ThanosTron WINS!!!\nHALF YOUR RAM IS GONE!!!\nCLICK HERE TO DOWNLOAD MORE RAM");
                    }
                    else if (p2.getRotate() == 0 && p1.getRotate() == 90 && p2.getX() + 9< p1.getX() + 27 && p1.getX() + 66 < p2.getX() + 84 ||
                            p2.getRotate() == 0 && p1.getRotate() == 270 && p2.getX() + 9 < p1.getX() + 27 && p1.getX() + 66 < p2.getX() + 84 ||
                            p2.getRotate() == 180 && p1.getRotate() == 90 && p2.getX() + 9 < p1.getX() + 27 && p1.getX() + 66 < p2.getX() + 84 ||
                            p2.getRotate() == 180 && p1.getRotate() == 270 && p2.getX() + 9 < p1.getX() + 27 && p1.getX() + 66 < p2.getX() + 84) {
                        winner.setText("YOU HAVE SUCCESSFULLY SAVED YOUR RAM");
                    }
                    winner.xProperty().bind(end.widthProperty().divide(2));
                    winner.yProperty().bind(end.heightProperty().divide(2));

                    end.setCenter(winner);

                    Scene endGame = new Scene(end, 1000, 1000);
                    ps.setScene(endGame);
                }
            }
        }.start();

        Scene scene = new Scene(pane, 1000, 1000);
        ps.setScene(scene);
        ps.show();
        pane.requestFocus();
    }

    public void move(KeyEvent e) {
        for (int i = 0; i < 8; i++) {
            if (keys[i] == e.getCode()) {
                keyDown[i] = true;
            }
        }

    }

    public Rectangle2D getBoundary(ImageView player, Image p) {
        if (player.getRotate() == 0 || player.getRotate() == 180) {
            return new Rectangle2D(player.getX() + 9, player.getY() + 30, p.getRequestedWidth() - 18, p.getRequestedHeight() - 51);
        }

        else if (player.getRotate() == 90 || player.getRotate() == 270) {
            return new Rectangle2D(player.getX() + 30, player.getY() + 9, p.getRequestedWidth() - 51, p.getRequestedHeight() - 18);

        }
        return new Rectangle2D(0, 0, 1, 1);
    }

    public void drawPath(ImageView player, Color color) {
        Rectangle path = new Rectangle();

        if (player.getRotate() == 0) {
            path.setX(player.getX() + 6);
            path.setY(player.getY() + 27);
            path.setWidth(5);
            path.setHeight(42);
        }

        else if (player.getRotate() == 180) {
            path.setX(player.getX() + 87);
            path.setY(player.getY() + 27);
            path.setWidth(5);
            path.setHeight(42);
        }

        else if (player.getRotate() == 90) {
            path.setX(player.getX() + 27);
            path.setY(player.getY() + 6);
            path.setWidth(42);
            path.setHeight(5);
        }

        else if (player.getRotate() == 270) {
            path.setX(player.getX() + 27);
            path.setY(player.getY() + 87);
            path.setWidth(42);
            path.setHeight(5);
        }

        paths.add(path);

        for (Rectangle rect : paths) {
            if (rect.intersects(player.getX() + 9, player.getY() + 30, player.getImage().getRequestedWidth() - 18, player.getImage().getRequestedHeight() - 51)) {
                BorderPane pane = new BorderPane();
                pane.setCenter(new Text("It Works"));
            }
        }
        path.setFill(color);
        path.setStroke(color);
        pane.getChildren().add(path);
    }

    public boolean hits(ImageView p1, ImageView p2) {
        return getBoundary(p1, p1.getImage()).intersects(getBoundary(p2, p2.getImage()));
    }
}
