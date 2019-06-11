import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

public class PathTest extends Application {
    public void start(Stage ps) {
        Pane pane = new Pane();

        Polygon path = new Polygon();
        path.setStroke(Color.BLACK);
        path.getPoints().addAll(new Double[] {100.0, 100.0, 100.0, 200.0, 200.0, 100.0, 200.0, 200.0, 300.0, 100.0, 300.0, 200.0});
        pane.getChildren().add(path);

        Scene scene = new Scene(pane);
        ps.setScene(scene);
        ps.show();
    }
}
