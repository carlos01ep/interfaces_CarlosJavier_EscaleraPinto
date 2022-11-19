package ch.makery.address.view;

import java.util.Iterator;

import ch.makery.address.Main;
import ch.makery.address.model.Entrada;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.control.cell.TextFieldTreeCell;
import javafx.util.converter.IntegerStringConverter;

public class EntradaController {

	private Main mainApp;
	// private ObservableList<Entrada> personData = this.mainApp.getPersonData();
	@FXML
	private TableColumn<Entrada, String> Apellidos;

	@FXML
	private TableColumn<Entrada, Integer> Descuento;

	@FXML
	private TableColumn<Entrada, String> FechaEntrada;

	@FXML
	private TableColumn<Entrada, String> FormaDePago;

	@FXML
	private TableColumn<Entrada, String> Nombre;

	@FXML
	private TableColumn<Entrada, Integer> NumAdultos;

	@FXML
	private TableColumn<Entrada, Integer> NumNiños;

	@FXML
	private TableColumn<Entrada, Double> Total;

	@FXML
	private ComboBox<Integer> comboNnumEntradaInfantil;

	@FXML
	private ComboBox<Integer> comboNumEntradaAdulto;
	@FXML
	private TableView<Entrada> tableModificar;
	@FXML
	private ChoiceBox<String> ChoiceFormaDePago;

	@FXML
	void eventoAñadir(ActionEvent event) {
		// añade un nuevo registro
		mainApp.getPersonData()
				.add(new Entrada("Carlos", "Escalera", "01/02/2022", "01/02/2022", 1, 1, 5, 100.9, "Tarjeta"));
		// rediracciona a la pantalla de inicio
		mainApp.showInicio();
	}

	// Lista auxiliar para TableView
	private ObservableList<Entrada> data = FXCollections.observableArrayList(
			new Entrada("Jacob", "Smith", "01/02/2022", "01/02/2022", 1, 1, 5, 100.9, "Tarjeta"),
			new Entrada("Isabella", "Johnson", "01/02/2022", "01/02/2022", 1, 1, 5, 100.9, "Tarjeta"),
			new Entrada("Ethan", "Williams", "01/02/2022", "01/02/2022", 1, 1, 5, 100.9, "Tarjeta"),
			new Entrada("Emma", "Jones", "01/02/2022", "01/02/2022", 1, 1, 5, 100.9, "Tarjeta"),
			new Entrada("Michael", "Brown", "01/02/2022", "01/02/2022", 1, 1, 5, 100.9, "Tarjeta"));

	public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;

		tableModificar.setItems(this.mainApp.getPersonData());

		// TODO Versión con map
		// personTable.setItems(this.mainApp.getMapData());
	}

	@FXML
	private void initialize() {
		// Asociamos cada columna del TableView a una propiedad de la clase Person
		Nombre.setCellValueFactory(new PropertyValueFactory<Entrada, String>("sspNombre"));
		Apellidos.setCellValueFactory(new PropertyValueFactory<Entrada, String>("sspApellido"));
		FechaEntrada.setCellValueFactory(new PropertyValueFactory<Entrada, String>("sspFechaEntrada"));
		FormaDePago.setCellValueFactory(new PropertyValueFactory<Entrada, String>("sspFormaDePago"));
		Descuento.setCellValueFactory(new PropertyValueFactory<Entrada, Integer>("sipDescuento"));
		NumAdultos.setCellValueFactory(new PropertyValueFactory<Entrada, Integer>("sipNumEntradasAdulto"));
		NumNiños.setCellValueFactory(new PropertyValueFactory<Entrada, Integer>("sipNumEntradasInfantil"));
		Total.setCellValueFactory(new PropertyValueFactory<Entrada, Double>("sdpPrecioTotal"));
		// Se rellena la tabla con objetos de la clase Person
		tableModificar.setItems(data);

		// Controles de JavaFX a los que se añaden directamente los items
		// Ítems del ChoiceBox
		ChoiceFormaDePago.getItems().addAll("Efectivo", "Tarjeta de credito", "Transferencia", "Otro");

		// Ítems del ComboBox
		comboNumEntradaAdulto.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9);
		comboNnumEntradaInfantil.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9);

		// hacer editable la tabla modificar
		Nombre.setCellFactory(TextFieldTableCell.forTableColumn());
		Apellidos.setCellFactory(TextFieldTableCell.forTableColumn());
		FechaEntrada.setCellFactory(TextFieldTableCell.forTableColumn());
		FormaDePago.setCellFactory(TextFieldTableCell.forTableColumn());
		Descuento.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
		NumAdultos.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
		NumNiños.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

		tableModificar.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> borrarCompra(newValue));
	}

	private void borrarCompra(Entrada entrada) {
		if (entrada != null) {
			// Si el campo contiene datos, entonces se rellena la información
			/*
			 * Nombre.setText(entrada.getSspNombre());
			 * Apellidos.setText(entrada.getSspApellido());
			 * FechaEntrada.setText(entrada.getSspFechaEntrada());
			 * FormaDePago.setText(entrada.getSspFechaCompra());
			 * Descuento.setText(""+entrada.getSipDescuento());
			 * NumAdultos.setText(""+entrada.getSipNumEntradasAdulto());
			 * NumNiños.setText(""+entrada.getSipNumEntradasInfantil());
			 */
			Nombre.setText("");
			Apellidos.setText("");
			FechaEntrada.setText("");
			FormaDePago.setText("");
			Descuento.setText("");
			NumAdultos.setText("");
			NumNiños.setText("");
			if (mainApp.getPersonData().contains(entrada)) {
				mainApp.getPersonData().remove(entrada);
			}

		} else {
			// Person is null, remove all the text.
			Nombre.setText("");
			Apellidos.setText("");
			FechaEntrada.setText("");
			FormaDePago.setText("");
			Descuento.setText("");
			NumAdultos.setText("");
			NumNiños.setText("");
		}
	}
}