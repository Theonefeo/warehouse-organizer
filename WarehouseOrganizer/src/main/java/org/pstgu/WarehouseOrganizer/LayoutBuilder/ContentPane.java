package org.pstgu.WarehouseOrganizer.LayoutBuilder;

import javafx.geometry.Side;
import javafx.scene.Parent;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;

public class ContentPane extends BorderPane {

	private TabPane tabPane;
	private Tab tab1;
	private Tab tab2;

	public ContentPane() {
		tabPane = new TabPane();
		tab1 = new Tab();
		tab2 = new Tab();

		setCenter(createContent());
	}

	public Parent createContent() {

		tabPane.setRotateGraphic(false);
		tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
		tabPane.setSide(Side.TOP);

		tab1.setText("Продукты");
		tab1.setTooltip(new Tooltip("Продукты на складе"));
		tab1.setContent(new ProductPane());
		tabPane.getTabs().add(tab1);

		tab2.setText("Книга рецептов");
		tab2.setContent(new CookbookPane());
		tabPane.getTabs().add(tab2);

		return tabPane;
	}

}