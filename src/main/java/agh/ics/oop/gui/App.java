package agh.ics.oop.gui;
import agh.ics.oop.*;
import agh.ics.oop.GrassField;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.List;


public class App extends Application implements IPositionChangeObserver {
    private GrassField map;

    GridPane grid = new GridPane();

    VBox box;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.grid.setGridLinesVisible(true);
        this.grid.setAlignment(Pos.BASELINE_CENTER);
        int moveDelay = 300;
        Button btn = new Button();
        btn.setText("Start");
        final TextField textField = new TextField();
        HBox hBox = new HBox(10);
        hBox.getChildren().add(textField);
        hBox.getChildren().add(btn);
        hBox.setAlignment(Pos.BASELINE_CENTER);
        VBox vBox = new VBox(20);
        vBox.getChildren().add(grid);
        vBox.getChildren().add(hBox);
        vBox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vBox, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();

//        Parameters parameters = getParameters();
//        System.out.println(parameters.getRaw());
//        List<String> argsTemp = parameters.getRaw();
//        String[] args = argsTemp.toArray(new String[0]);

        try {
//            OptionParser optionParser=new OptionParser();
//            MoveDirection[] directions=optionParser.parse(args);
            map=new GrassField(10);
            Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
            SimulationEngine engine = new SimulationEngine(this.map, positions,this);
//            engine.run();
//            System.out.println(map);
            engine.setDelay(moveDelay);
            Thread firstThread = new Thread(engine);
            firstThread.start();
            btn.setOnAction((e)->{
                Thread engineThread = new Thread(engine);
                String textFieldText = textField.getText();
                String[] args = textFieldText.split(" ");
                OptionParser optionParser=new OptionParser();
                MoveDirection[] directions=optionParser.parse(args);
                engine.setMoves(directions);
                engineThread.start();
            });
        } catch(IllegalArgumentException ex) {

            System.out.println(ex.toString());
        }
//        GridPane gridPane = new GridPane();
//        gridPane.setGridLinesVisible(true);
//        gridPane.setHgap(0);
//        gridPane.setVgap(0);
//        int cellWidth = 30;
//        int cellHeight = 30;
//
//        int minY = this.map.getLowerLeftDrawLimit().y;
//        int minX = this.map.getLowerLeftDrawLimit().x;
//        int maxY = this.map.getUpperRightDrawLimit().y;
//        int maxX = this.map.getUpperRightDrawLimit().x;
//
//        Label xyLabel = new Label("y\\x");
//        GridPane.setHalignment(xyLabel, HPos.CENTER);
//        gridPane.getColumnConstraints().add(new ColumnConstraints(cellWidth));
//        gridPane.getRowConstraints().add(new RowConstraints(cellHeight));
//        gridPane.add(xyLabel, 0, 0, 1, 1);
//        for (int i = minY; i <= maxY; i++) {
//            Label label2 = new Label(Integer.toString(i));
//            gridPane.add(label2, 0, maxY - i + 1, 1, 1);
//            gridPane.getRowConstraints().add(new RowConstraints(cellHeight));
//            GridPane.setHalignment(label2, HPos.CENTER);
//        }
//        for (int i = minX; i <= maxX; i++) {
//            Label label3 = new Label(Integer.toString(i));
//            gridPane.add(label3, i-minX+1, 0, 1, 1);
//            gridPane.getColumnConstraints().add(new ColumnConstraints(cellWidth));
//            GridPane.setHalignment(label3, HPos.CENTER);
//        }
//
//        for (int x = minX; x <= maxX; x++) {
//            for (int y = minY; y <= maxY; y++) {
//                Vector2d position = new Vector2d(x, y);
//                if (!this.map.isOccupied(position)) {
//                    continue;
//                }
//
//                Object worldMapElement = this.map.objectAt(position);
//                Label label4 = new Label(worldMapElement.toString());
//                GridPane.setHalignment(label4, HPos.CENTER);
//                gridPane.add(label4, position.x - minX + 1, maxY - position.y + 1, 1, 1);
//            }
//        }
//        Scene scene = new Scene(gridPane, 400, 400);
//        primaryStage.setScene(scene);
//        primaryStage.show();
    }
    public void render(){
        Platform.runLater(() -> {
        int cellWidth = 40;
        int cellHeight = 40;
        Node gr = grid.getChildren().get(0);
        grid.getRowConstraints().clear();
        grid.getColumnConstraints().clear();
        grid.getChildren().clear();
        grid.add(gr,0,0);
        grid.setGridLinesVisible(true);
        int minY = this.map.getLowerLeftDrawLimit().y;
        int minX = this.map.getLowerLeftDrawLimit().x;
        int maxY = this.map.getUpperRightDrawLimit().y;
        int maxX = this.map.getUpperRightDrawLimit().x;

        Label xyLabel = new Label("y\\x");
        GridPane.setHalignment(xyLabel, HPos.CENTER);
        grid.getColumnConstraints().add(new ColumnConstraints(cellWidth));
        grid.getRowConstraints().add(new RowConstraints(cellHeight));
        grid.add(xyLabel, 0, 0, 1, 1);
        for (int i = minY; i <= maxY; i++) {
            Label label2 = new Label(Integer.toString(i));
            grid.add(label2, 0, maxY - i + 1, 1, 1);
            grid.getRowConstraints().add(new RowConstraints(cellHeight));
            GridPane.setHalignment(label2, HPos.CENTER);
        }
        for (int i = minX; i <= maxX; i++) {
            Label label3 = new Label(Integer.toString(i));
            grid.add(label3, i-minX+1, 0, 1, 1);
            grid.getColumnConstraints().add(new ColumnConstraints(cellWidth));
            GridPane.setHalignment(label3, HPos.CENTER);
        }
int x=0;
        int y=0;
            for(int a = minX; a <= maxX; a++){
                 x += 1;
                y = 0;
                for (int b = maxY; b >= minY; b--){
                    y += 1;
                    Object obiekt = map.objectAt(new Vector2d(a,b));
                    if(obiekt != null){
                        AbstractWorldMapElement el = (AbstractWorldMapElement) obiekt;
                        box = new GuiElementBox(el).show();
                        grid.add(box,x,y,1,1);
                    }
                }
            }


        });
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        this.render();
    }
}
