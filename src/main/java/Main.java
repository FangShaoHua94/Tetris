import gui.KeyHandler;
import gui.Painter;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Game;

public class Main extends Application {

    private static double HEIGHT=600;
    private static double WIDTH=500;

    @Override
    public void start(Stage stage) {
        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Game game = new Game(gc,canvas);
        Painter.paint(game, gc);
        canvas.setOnKeyPressed(new KeyHandler(game));
        canvas.setFocusTraversable(true);
        Pane root = new Pane();
        root.getChildren().add(canvas);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Tetris");
        stage.show();
        (new Thread(game)).start();
    }
}
