package greenplanet.address.view;

import java.io.IOException;

import greenplanet.address.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
//import layout2.Person;

public class MenuController {
	private Main mainApp;
	// Pantalla principal en la que se añade o quita contenido
	// private BorderPane rootLayout;

	@FXML
	private void initialize() {

	}

	@FXML
	public void abrirEditar(ActionEvent event) {
		this.mainApp.showEditar();
	}

	@FXML
	public void abrirInicio(ActionEvent event) {
		this.mainApp.showInicio();
	}

	@FXML
	public void abrirTutorial(ActionEvent event) {
		this.mainApp.showTutorial();
	}

	@FXML
	void abrirGraficos(ActionEvent event) {
		this.mainApp.showGraficos();
	}

	public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;

	}

}
