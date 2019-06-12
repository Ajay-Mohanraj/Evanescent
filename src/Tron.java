import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.input.KeyCode;


public class Tron extends Application {
    public double p1Dx = 5;
    public double p1Dy = 0;
    public double p2Dx = -5;
    public double p2Dy = 0;

    public void start(Stage ps) {
        Pane pane = new Pane();

        Image thanos = new Image("Thanos(OLD).png", 150, 150, true, true);
        ImageView p1 = new ImageView(thanos);
        p1.setX(150);
        p1.setX(150);


        Image yellow = new Image("Yellow.png", 150, 150, true, true);
        ImageView p2 = new ImageView(yellow);
        p2.setX(600);
        p2.setY(650);

        pane.setOnKeyPressed(e -> {
                if(e.getCode() == KeyCode.UP) {
                    p1Dx = 0;
                    p1Dy = -5;
                }
                if(e.getCode() == KeyCode.DOWN) {
                    p1Dx = 0;
                    p1Dy = 5;
                }
                if(e.getCode() == KeyCode.RIGHT) {
                    p1Dx = 5;
                    p1Dy = 0;
                }
                if(e.getCode() == KeyCode.LEFT) {
                p1Dx = -5;
                p1Dy = 0;
            }
        });

        p1.setX(p1.getX() + p1Dx);
        p1.setY(p1.getY() + p1Dy);

        pane.getChildren().add(p1);
        pane.getChildren().add(p2);

        Scene scene = new Scene(pane, 750, 750);
        ps.setScene(scene);

        if (hits(p1, p2)) {
            Pane end = new Pane();
            Text winner = new Text("YOU BOTH LOSE!");

            winner.xProperty().bind(end.widthProperty().divide(2));
            winner.yProperty().bind(end.heightProperty().divide(2));

            Scene endGame = new Scene(pane, 500, 500);
            ps.setScene(endGame);
        }

        ps.show();

        pane.requestFocus();
    }

    public Rectangle2D getBoundary(ImageView player, Image p) {
        return new Rectangle2D(player.getX(), player.getY(), p.getRequestedWidth(), p.getRequestedHeight());
    }

    public boolean hits(ImageView p1, ImageView p2) {
        return getBoundary(p1, p1.getImage()).intersects(getBoundary(p2, p2.getImage()));
    }
}
