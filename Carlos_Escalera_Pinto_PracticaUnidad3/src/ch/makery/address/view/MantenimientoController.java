package ch.makery.address.view;

import java.util.Iterator;

import ch.makery.address.Main;
import ch.makery.address.model.Entrada;
import ch.makery.address.model.Person;
import ch.makery.address.util.DateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.control.cell.TextFieldTreeCell;
import javafx.util.converter.IntegerStringConverter;

public class MantenimientoController {
	boolean botonBorrarOk = false;
	private Main mainApp;
	// private ObservableList<Entrada> personData = this.mainApp.getPersonData();

	@FXML
	private ToggleGroup descuento;

	@FXML
	private TextField labelApellidos;

	@FXML
	private DatePicker labelfechaEntrada;

    @FXML
    private TextField labelNombre;

	@FXML
	private RadioButton rbDescuentoCinco;

	@FXML
	private RadioButton rbDescuentoQuince;

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
	private TableColumn<Entrada, Integer> NumNi??os;

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
	void botonBorrar(ActionEvent event) {
		int selectedIndex = tableModificar.getSelectionModel().getSelectedIndex();

		// Si no hay ning??n campo seleccionado, se muestra un alert
		if (selectedIndex >= 0) {
			// Si se ha seleccionado una fila, se muestra un pop up de confirmaci??n
			Alert confirm = new Alert(AlertType.CONFIRMATION);

			confirm.setTitle("Confirmaci??n para eliminar");
			// errorAlert.setHeaderText("Va a eliminar la fila seleccionada");
			confirm.setContentText("??Est?? seguro de eliminar la fila actual?");

			// Si el usuario acepta, entonces se lleva a cabo la acci??n correspondiente
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
			errorAlert.setContentText("No se puede eliminar porque no ha seleccionado una fila o la tabla est?? vac??a");

			errorAlert.showAndWait();
		}
	}

	@FXML
	void botonModificar(ActionEvent event) {
		Entrada selectedEntrada = tableModificar.getSelectionModel().getSelectedItem();
		if (selectedEntrada != null) {
			boolean okClicked = mainApp.showEntradaEditDialog(selectedEntrada);
			if (okClicked) {
				mainApp.showInicio();
			}

		} else {
			// Se muestra un alert si no se puede eliminar la fila
			Alert errorAlert = new Alert(AlertType.ERROR);

			errorAlert.setTitle("Error al editar Entrada");
			errorAlert.setHeaderText("No se ha seleccionado ninguna fila");
			errorAlert.setContentText("Por favor, selecciona una Entrada en la tabla");

			errorAlert.showAndWait();
		}
	}

	@FXML
	void eventoA??adir(ActionEvent event) {
		// a??ade un nuevo registro
		int descuentoPorcentaje = 0;
		if (rbDescuentoCinco.isSelected()) {
			descuentoPorcentaje = 5;
		} else if (rbDescuentoQuince.isSelected()) {
			descuentoPorcentaje = 15;
		}else {
			descuentoPorcentaje = 0;
		}
		System.out.println("----numero de adultos----: " + comboNumEntradaAdulto.getSelectionModel().getSelectedItem());
		System.out.println("----numero de ninios----: " + comboNnumEntradaInfantil.getSelectionModel().getSelectedItem());
		//Integer numeroAdultos = comboNumEntradaAdulto.getSelectionModel().getSelectedItem();
		//Integer numeroni??os = comboNnumEntradaInfantil.getSelectionModel().getSelectedItem();
		String formaDePago = (String)ChoiceFormaDePago.getSelectionModel().getSelectedItem();
		tableModificar.getItems()
				.add(new Entrada(labelNombre.getText(),
						labelApellidos.getText() , 
						"20/11/2022",
						"20/11/2022", 
						3, 
						5, 
						descuentoPorcentaje,
						1000000.9, 
						ChoiceFormaDePago.getSelectionModel().getSelectedItem()
						));
		
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
		NumNi??os.setCellValueFactory(new PropertyValueFactory<Entrada, Integer>("sipNumEntradasInfantil"));
		Total.setCellValueFactory(new PropertyValueFactory<Entrada, Double>("sdpPrecioTotal"));
		// Se rellena la tabla con objetos de la clase Person
		tableModificar.setItems(data);

		// Controles de JavaFX a los que se a??aden directamente los items
		// ??tems del ChoiceBox
		ChoiceFormaDePago.getItems().addAll("Efectivo", "Tarjeta de credito", "Transferencia", "Otro");

		// ??tems del ComboBox
		comboNumEntradaAdulto.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9);
		comboNnumEntradaInfantil.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9);

	}

	private void showEntradaDetails(Entrada entrada) {
		if (entrada != null) {
			// Si el campo contiene datos, entonces se rellena la informaci??n
			Apellidos.setText(entrada.getSspApellido());
			Descuento.setText("" + entrada.getSipDescuento());
			FechaEntrada.setText(entrada.getSspFechaEntrada());
			FormaDePago.setText(entrada.getSspFormaDePago());
			Nombre.setText(entrada.getSspNombre());
			NumAdultos.setText("" + entrada.getSipNumEntradasAdulto());
			NumNi??os.setText("" + entrada.getSipNumEntradasInfantil());

		} else {
			// Person is null, remove all the text.
			Apellidos.setText("");
			Descuento.setText("");
			FechaEntrada.setText("");
			FormaDePago.setText("");
			Nombre.setText("");
			NumAdultos.setText("");
			NumNi??os.setText("");
		}
	}
}