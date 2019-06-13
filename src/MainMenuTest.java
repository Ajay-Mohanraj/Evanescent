import javafx.animation.AnimationTimer;
import javafx.application.Application;
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
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.ArrayList;

public class MainMenuTest extends Application {
    Pane pane = new Pane();
    BorderPane mainMenuPane = new BorderPane();

    Text menuText = new Text();

    Image green= new Image("Green.png", 96, 96, true, true);
    Image thanos = new Image("Thanos.png", 96, 96, true, true);

    ImageView p1 = new ImageView(thanos);
    ImageView p2 = new ImageView(green);

    BorderPane end = new BorderPane();
    Text winner = new Text("");
    Scene endGame = new Scene(end, 1000, 1000);


    ArrayList<Rectangle> paths = new ArrayList<Rectangle>();

    int p1Dx = 5;
    int p1Dy = 0;
    int p2Dy = 0;
    int p2Dx = -5;

    KeyCode[] keys = {KeyCode.W, KeyCode.A, KeyCode.S, KeyCode.D, KeyCode.UP, KeyCode.LEFT, KeyCode.DOWN, KeyCode.RIGHT};
    Boolean[] keyDown = {false, false, false, false, false, false, false, false};

    public void start(Stage ps) {
        menuText.setFont(Font.font("TR2N", 100));
        menuText.setText("Evanescent");
        mainMenuPane.setCenter(menuText);

        pane.setStyle("-fx-background-color: #000000");
        end.setStyle("-fx-background-color: #000000");
        winner.setStyle("-fx-background-color: #FFFFFF");

        p1.setX(0);
        p1.setY(0);

        p2.setX(1834);
        p2.setY(924);
        p2.setRotate(180);

        pane.getChildren().addAll(p1, p2);

        pane.setOnKeyPressed(e -> move(e));
        // pane.setOnKeyReleased(e -> released(e));

        // request focus problem / maybe wrong pane?

        Scene scene = new Scene(pane, 1920, 1080);
        Scene scene1 = new Scene(mainMenuPane, 1920, 1080);

        ps.setScene(scene1);
        mainMenuPane.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER){
                ps.setScene(scene);
                new AnimationTimer() {
                    @Override
                    public void handle(long now) {
                        for (int i = 0; i < 8; i++) {
                            if (keyDown[i]) {
                                switch (i) {
                                    case 0:
                                        if (p1.getRotate() == 90) {
                                            break;
                                        }
                                        if (p1.getRotate() == 0) {
                                            p1.setX(p1.getX() - 21);
                                            p1.setY(p1.getY() - 21);
                                        }
                                        if (p1.getRotate() == 180) {
                                            p1.setX(p1.getX() + 21);
                                            p1.setY(p1.getY() - 21);
                                        }

                                        p1Dx = 0;
                                        p1Dy = -5;

                                        p1.setRotate(270);
                                        break;

                                    case 1:
                                        if (p1.getRotate() == 0) {
                                            break;
                                        }
                                        if (p1.getRotate() == 90) {
                                            p1.setX(p1.getX() - 21);
                                            p1.setY(p1.getY() - 21);
                                        }
                                        if(p1.getRotate() == 270) {
                                            p1.setX(p1.getX() - 21);
                                            p1.setY(p1.getY() + 21);
                                        }
                                        p1Dx = -5;
                                        p1Dy = 0;

                                        p1.setRotate(180);
                                        break;

                                    case 2:
                                        if (p1.getRotate() == 270) {
                                            break;
                                        }
                                        if (p1.getRotate() == 0) {
                                            p1.setX(p1.getX() - 21);
                                            p1.setY(p1.getY() + 21);
                                        }
                                        if(p1.getRotate() == 180) {
                                            p1.setX(p1.getX() + 21);
                                            p1.setY(p1.getY() + 21);
                                        }
                                        p1Dx = 0;
                                        p1Dy = 5;

                                        p1.setRotate(90);
                                        break;

                                    case 3:
                                        if (p1.getRotate() == 180) {
                                            break;
                                        }
                                        if (p1.getRotate() == 90) {
                                            p1.setX(p1.getX() + 21);
                                            p1.setY(p1.getY() - 21);
                                        }
                                        if(p1.getRotate() == 270) {
                                            p1.setX(p1.getX() + 21);
                                            p1.setY(p1.getY() + 21);
                                        }
                                        p1Dx = 5;
                                        p1Dy = 0;
                                        p1.setRotate(0);
                                        break;

                                    case 4:
                                        if (p2.getRotate() == 90) {
                                            break;
                                        }
                                        if (p2.getRotate() == 0) {
                                            p2.setX(p2.getX() - 21);
                                            p2.setY(p2.getY() - 21);
                                        }
                                        if (p2.getRotate() == 180) {
                                            p2.setX(p2.getX() + 21);
                                            p2.setY(p2.getY() - 21);
                                        }

                                        p2Dx = 0;
                                        p2Dy = -5;

                                        p2.setRotate(270);
                                        break;

                                    case 5:
                                        if (p2.getRotate() == 0) {
                                            break;
                                        }
                                        if (p2.getRotate() == 90) {
                                            p2.setX(p2.getX() - 21);
                                            p2.setY(p2.getY() - 21);
                                        }
                                        if(p2.getRotate() == 270) {
                                            p2.setX(p2.getX() - 21);
                                            p2.setY(p2.getY() + 21);
                                        }
                                        p2Dx = -5;
                                        p2Dy = 0;
                                        p2.setRotate(180);
                                        break;

                                    case 6:
                                        if (p2.getRotate() == 270) {
                                            break;
                                        }
                                        if (p2.getRotate() == 0) {
                                            p2.setX(p2.getX() - 21);
                                            p2.setY(p2.getY() + 21);
                                        }
                                        if(p2.getRotate() == 180) {
                                            p2.setX(p2.getX() + 21);
                                            p2.setY(p2.getY() + 21);
                                        }
                                        p2Dx = 0;
                                        p2Dy = 5;
                                        p2.setRotate(90);
                                        break;

                                    case 7:
                                        if (p2.getRotate() == 180) {
                                            break;
                                        }
                                        if (p2.getRotate() == 90) {
                                            p2.setX(p2.getX() + 21);
                                            p2.setY(p2.getY() - 21);
                                        }
                                        if(p2.getRotate() == 270) {
                                            p2.setX(p2.getX() + 21);
                                            p2.setY(p2.getY() + 21);
                                        }
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

                        Color thanosColor = new Color(0.97254902, 0.011764, 1.0, 1.0);

                        drawPath(p1, thanosColor);
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

                            BorderPane bp = new BorderPane();
                            bp.setCenter(winner);

                            Scene endGame = new Scene(bp, 1000, 1000);
                            ps.setScene(endGame);
                            this.stop();
                        }
                        for (int i = 0; i < paths.size(); i++) {
                            if (hits(p1, paths.get(i))) {
                                winner.setText("YOU HAVE SUCCESSFULLY SAVED YOUR RAM");
                                winner.xProperty().bind(end.widthProperty().divide(2));
                                winner.yProperty().bind(end.heightProperty().divide(2));

                                end.setCenter(winner);
                                ps.setScene(endGame);
                                this.stop();
                            }
                            else if (hits(p2, paths.get(i))) {
                                winner.setText("ThanosTron WINS!!!\nHALF YOUR RAM IS GONE!!!\nCLICK HERE TO DOWNLOAD MORE RAM");
                                winner.xProperty().bind(end.widthProperty().divide(2));
                                winner.yProperty().bind(end.heightProperty().divide(2));

                                end.setCenter(winner);
                                ps.setScene(endGame);
                                this.stop();
                            }
                        }
                        pane.requestFocus();
                    }
                }.start();
            }
        });

        ps.setResizable(true);
        ps.setMaximized(true);
        ps.setFullScreen(true);
        ps.setTitle("Evanescent");
        ps.show();
        mainMenuPane.requestFocus();

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
            //return new Rectangle2D(player.getX() + 9, player.getY() + 30, p.getRequestedWidth() - 18, p.getRequestedHeight() - 51);
            return new Rectangle2D(player.getX() + 9, player.getY() + 27, 78, 42);
        }
        else if (player.getRotate() == 90 || player.getRotate() == 270) {
            return new Rectangle2D(player.getX() + 27, player.getY() + 9, 42, 78);

        }
        return new Rectangle2D(0, 0, 1, 1);
    }

    public Rectangle2D getBoundary(Rectangle r) {
        return new Rectangle2D(r.getX(), r.getY(), r.getWidth(), r.getHeight());
    }

    public void drawPath(ImageView player, Color color) {
        Rectangle path = new Rectangle();

        if (player.getRotate() == 0) {
            path.setX(player.getX() + 1);
            path.setY(player.getY() + 27);
            path.setWidth(5);
            path.setHeight(42);
        }

        else if (player.getRotate() == 180) {
            path.setX(player.getX() + 90);
            path.setY(player.getY() + 27);
            path.setWidth(5);
            path.setHeight(42);
        }

        else if (player.getRotate() == 90) {
            path.setX(player.getX() + 27);
            path.setY(player.getY() + 1);
            path.setWidth(42);
            path.setHeight(5);
        }

        else if (player.getRotate() == 270) {
            path.setX(player.getX() + 27);
            path.setY(player.getY() + 90);
            path.setWidth(42);
            path.setHeight(5);
        }

        paths.add(path);
        path.setFill(color);
        path.setStroke(color);
        pane.getChildren().add(path);
    }

    public boolean hits(ImageView p1, ImageView p2) {
        return getBoundary(p1, p1.getImage()).intersects(getBoundary(p2, p2.getImage()));
    }
    public boolean hits(ImageView player, Rectangle r) {
        return getBoundary(player, player.getImage()).intersects(getBoundary(r));
    }
}