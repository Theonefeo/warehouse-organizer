package org.pstgu.WarehouseOrganizer.LayoutBuilder;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.effect.Lighting;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class CookbookPane extends BorderPane {
	TitledPane first;
	TitledPane second;
	TitledPane drink;

	public CookbookPane() {
		Button button = new Button("приготовить вкусняшку");
		button.setOnAction((actionEvent) -> createNewStage());

		first = new TitledPane("Первое блюдо", button);
		second = new TitledPane("Второе блюдо", new Text("заходите завтра"));
		drink = new TitledPane("Напиток", new Rectangle(120, 50, Color.RED));

		Accordion accordion = new Accordion();
		accordion.getPanes().addAll(first, second, drink);
		accordion.setMinSize(100, 100);
		accordion.setPrefSize(100, 200);

		setCenter(accordion);
	}

	// variables for initial position of the stage at the beginning of drag
	private double initX;
	private double initY;

	void createNewStage() {
		// INITIALISATION OF THE STAGE/SCENE

		// create stage which has set stage style transparent
		final Stage stage = new Stage(StageStyle.TRANSPARENT);

		// create root node of scene, i.e. group
		Group rootGroup = new Group();

		// create scene with set width, height and color
		Scene scene = new Scene(rootGroup, 200, 200, Color.TRANSPARENT);

		// set scene to stage
		stage.setScene(scene);

		// center stage on screen
		stage.centerOnScreen();

		// show the stage
		stage.show();

		// CREATION OF THE DRAGGER (CIRCLE)

		// create dragger with desired size
		Circle dragger = new Circle(100, 100, 100);

		// fill the dragger with some nice radial background
		dragger.setFill(new RadialGradient(-0.3, 135, 0.5, 0.5, 1, true, CycleMethod.NO_CYCLE,
				new Stop[] { new Stop(0, Color.YELLOW), new Stop(1, Color.RED) }));

		// when mouse button is pressed, save the initial position of screen
		rootGroup.setOnMousePressed((MouseEvent me) -> {
			initX = me.getScreenX() - stage.getX();
			initY = me.getScreenY() - stage.getY();
		});

		// when screen is dragged, translate it accordingly
		rootGroup.setOnMouseDragged((MouseEvent me) -> {
			stage.setX(me.getScreenX() - initX);
			stage.setY(me.getScreenY() - initY);
		});

		// CREATE MIN AND CLOSE BUTTONS
		// create button for closing application
		Button close = new Button("ум-нум-нум");
		close.setOnAction((ActionEvent event) -> {
			stage.close();
		});

		// create button for minimalising application
		Button min = new Button("потом съем");
		min.setOnAction((ActionEvent event) -> {
			stage.setIconified(true);
		});

		// CREATE SIMPLE TEXT NODE
		Text text = new Text("ВКУСНЯШКА"); // 20, 110,
		text.setFill(Color.WHITESMOKE);
		text.setEffect(new Lighting());
		text.setBoundsType(TextBoundsType.VISUAL);
		text.setFont(Font.font(Font.getDefault().getFamily(), 25));

		// USE A LAYOUT VBOX FOR EASIER POSITIONING OF VISUAL NODES ON SCENE
		VBox vBox = new VBox();
		vBox.setSpacing(10);
		vBox.setPadding(new Insets(60, 0, 0, 20));
		vBox.setAlignment(Pos.TOP_CENTER);
		vBox.getChildren().addAll(text, min, close);

		// add all nodes to main root group
		rootGroup.getChildren().addAll(dragger, vBox);
	}

}