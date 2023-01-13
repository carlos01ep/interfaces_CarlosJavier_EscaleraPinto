package ch.makery.address.view;

import java.util.ArrayList;
import java.util.stream.Collectors;

import ch.makery.address.Main;
import ch.makery.address.model.Entrada;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class MantenimientoController {
	boolean botonBorrarOk = false;
	private Main mainApp;
	private ArrayList<Entrada> arrayListEntradasDataAux;
	private ObservableList<Entrada> observableListEntradasDataAux2;

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
    private TextField textFieldBuscar;
	@FXML
	private TableColumn<Entrada, Double> Total;
	@FXML
	private TableView<Entrada> tableModificar;


	@FXML
	void botonBuscar(ActionEvent event) {
		String nombreBuscar = textFieldBuscar.getText();

		arrayListEntradasDataAux =  (ArrayList<Entrada>) this.mainApp.getPersonData().stream()
				.filter(s->s.getSspNombre()
				.substring(0,nombreBuscar.length()).equals(nombreBuscar))
				.collect(Collectors.toList());
		//System.out.println("Personas cuyo nombre empieza por " +  nombreBuscar);
		
		observableListEntradasDataAux2 = FXCollections.observableArrayList(arrayListEntradasDataAux);
		tableModificar.setItems(observableListEntradasDataAux2);
	}

	@FXML
	void botonBorrar(ActionEvent event) {
		int selectedIndex = tableModificar.getSelectionModel().getSelectedIndex();

		// Si no hay ningún campo seleccionado, se muestra un alert
		if (selectedIndex >= 0) {
			// Si se ha seleccionado una fila, se muestra un pop up de confirmación
			Alert confirm = new Alert(AlertType.CONFIRMATION);

			confirm.setTitle("Confirmación para eliminar");
			// errorAlert.setHeaderText("Va a eliminar la fila seleccionada");
			confirm.setContentText("¿Está seguro de eliminar la fila actual?");

			// Si el usuario acepta, entonces se lleva a cabo la acción correspondiente
			confirm.showAndWait().ifPresent(response -> {
				if (response == ButtonType.OK) {
					tableModificar.getItems().remove(selectedIndex);

				}
			});
		} else {
			// Se muestra un alert si no se puede eliminar la fila
			Alert errorAlert = new Alert(AlertType.ERROR);

			errorAlert.setTitle("Error al eliminar");
			errorAlert.setHeaderText("Se ha producido un error");
			errorAlert.setContentText("No se puede eliminar porque no ha seleccionado una fila o la tabla está vacía");

			errorAlert.showAndWait();
		}
	}

	@FXML
	void botonModificar(ActionEvent event) {
		Entrada selectedEntrada = tableModificar.getSelectionModel().getSelectedItem();
		if (selectedEntrada != null) {
			boolean okClicked = mainApp.showEntradaEditDialog(selectedEntrada);
			if (okClicked) {
				mainApp.showEditar();
				selectedEntrada.calcularTotal(selectedEntrada.getSipNumEntradasAdulto(), selectedEntrada.getSipNumEntradasInfantil());
			}

		} else {
			// Se muestra un alert si no se puede editar la fila
			Alert errorAlert = new Alert(AlertType.ERROR);

			errorAlert.setTitle("Error al editar Entrada");
			errorAlert.setHeaderText("No se ha seleccionado ninguna fila");
			errorAlert.setContentText("Por favor, selecciona una Entrada en la tabla");
			errorAlert.showAndWait();
		}
	}

	@FXML
	void eventoAñadir(ActionEvent event) {
		Entrada selectedEntrada = new Entrada();
		boolean okClicked = mainApp.showEntradaEditDialog(selectedEntrada);
		if (okClicked) {
			mainApp.getPersonData().add(selectedEntrada);
			selectedEntrada.calcularTotal(selectedEntrada.getSipNumEntradasAdulto(), selectedEntrada.getSipNumEntradasInfantil());
		}
	}

	// Lista auxiliar para TableView
	
	public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;

		tableModificar.setItems(this.mainApp.getPersonData());

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

	}

}