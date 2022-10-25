package layout2;

import application.Persona;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

public class ListController {

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

	// Lista auxiliar para TableView
	    private ObservableList<Entrada> data = FXCollections.observableArrayList(
	    	    new Entrada("Jacob", "Smith", "01/02/2022","01/02/2022",1,1,5,100.9, "Tarjeta"),
	    	    new Entrada("Isabella", "Johnson", "01/02/2022","01/02/2022",1,1,5,100.9,"Tarjeta"),
	    	    new Entrada("Ethan", "Williams", "01/02/2022","01/02/2022",1,1,5,100.9,"Tarjeta"),
	    	    new Entrada("Emma", "Jones", "01/02/2022","01/02/2022",1,1,5,100.9,"Tarjeta"),
	    	    new Entrada("Michael", "Brown", "01/02/2022","01/02/2022",1,1,5,100.9,"Tarjeta")
	    	);
	@FXML
	private void initialize() {
		// Asociamos cada columna del TableView a una propiedad de la clase Person 
		Nombre.setCellValueFactory(new PropertyValueFactory<Entrada,String>("sspNombre"));
	    Apellidos.setCellValueFactory(new PropertyValueFactory<Entrada,String>("sspApellido"));
	    FechaEntrada.setCellValueFactory(new PropertyValueFactory<Entrada,String>("sspFechaEntrada"));
	    FormaDePago.setCellValueFactory(new PropertyValueFactory<Entrada,String>("sspFormaDePago"));
	    Descuento.setCellValueFactory(new PropertyValueFactory<Entrada,Integer>("sipDescuento"));
	    NumAdultos.setCellValueFactory(new PropertyValueFactory<Entrada,Integer>("sipNumEntradasAdulto"));
	    NumNiños.setCellValueFactory(new PropertyValueFactory<Entrada,Integer>("sipNumEntradasInfantil"));
	    Total.setCellValueFactory(new PropertyValueFactory<Entrada,Double>("sdpPrecioTotal"));
        // Se rellena la tabla con objetos de la clase Person
	    tableModificar.setItems(data);     
		
		
		 // Controles de JavaFX a los que se añaden directamente los items 
    	// Ítems del ChoiceBox
		ChoiceFormaDePago.getItems().addAll("Efectivo", "Tarjeta de credito", "Transferencia", "otro");      
        
        // Ítems del ComboBox
		comboNumEntradaAdulto.getItems().addAll(1,2,3,4,5,6,7,8,9);
		comboNnumEntradaInfantil.getItems().addAll(1,2,3,4,5,6,7,8,9);
		
		//hacer editable la tabla modificar
		Nombre.setCellFactory(TextFieldTableCell.forTableColumn());
		Apellidos.setCellFactory(TextFieldTableCell.forTableColumn());
		FechaEntrada.setCellFactory(TextFieldTableCell.forTableColumn());
		FormaDePago.setCellFactory(TextFieldTableCell.forTableColumn());
		/*Descuento.setCellFactory(TextFieldTableCell.forTableColumn());
		NumAdultos.setCellFactory(TextFieldTableCell.forTableColumn());
		NumNiños.setCellFactory(TextFieldTableCell.forTableColumn());
		Total.setCellFactory(TextFieldTableCell.forTableColumn());*/
	}
}
