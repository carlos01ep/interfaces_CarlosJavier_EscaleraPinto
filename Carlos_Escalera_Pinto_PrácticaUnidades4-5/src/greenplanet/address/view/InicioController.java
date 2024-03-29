package greenplanet.address.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

import greenplanet.address.Main;
import greenplanet.address.model.Entrada;
import greenplanet.address.model.Person;
import greenplanet.address.model.Persona;
import greenplanet.address.util.DateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
//import layout2.Person;
import javafx.stage.Stage;
/**
 * Clase controlador de la pantalla inicio
 * 
 * @author CJEP DAM 2
 * @version 1.0
 *
 */
public class InicioController {
	private Main mainApp;
	private ArrayList<Entrada> arrayListEntradasDataAux;
	private ObservableList<Entrada> observableListEntradasDataAux2;
	// Pantalla principal en la que se añade o quita contenido
	//Dinamico
	  @FXML
	    private Label labelApellido;

	    @FXML
	    private Label labelDescuento;

	    @FXML
	    private Label labelFecha;
	    @FXML
	    private TextField textFieldBuscar;
	    @FXML
	    private Label labelFechaEntrada;

	    @FXML
	    private Label labelFormaPago;

	    @FXML
	    private Label labelNombre;

	    @FXML
	    private Label labelNumAdulto;

	    @FXML
	    private Label labelNumInfantil;

	    @FXML
	    private Label labelPrecio;

	
	    @FXML
	    private TableColumn<Entrada, String> colApellido;

	    @FXML
	    private TableColumn<Entrada, String> colNombre;

	    @FXML
	    private TableView<Entrada> table1;
	    
	    @FXML
	    void botonEditar(ActionEvent event) {
	    	mainApp.showEditar();
	    }
		@FXML
		void botonBuscar(ActionEvent event) {
			String nombreBuscar = textFieldBuscar.getText();

			arrayListEntradasDataAux =  (ArrayList<Entrada>) this.mainApp.getPersonData().stream()
					.filter(s->s.getSspNombre()
					.substring(0,nombreBuscar.length()).equals(nombreBuscar))
					.collect(Collectors.toList());
			//System.out.println("Personas cuyo nombre empieza por " +  nombreBuscar);
			
			observableListEntradasDataAux2 = FXCollections.observableArrayList(arrayListEntradasDataAux);
			table1.setItems(observableListEntradasDataAux2);
		}

	    @FXML
	    void botonSalir(ActionEvent event) {
	    	Node source = (Node) event.getSource();
	        Stage stage = (Stage) source.getScene().getWindow();
	        stage.close();
	    }
	    
	    // Lista auxiliar para TableView
	    private ObservableList<Persona> data = FXCollections.observableArrayList(
	    	    new Persona("Jacob", "Smith"),
	    	    new Persona("Isabella", "Johnson"),
	    	    new Persona("Ethan", "Williams"),
	    	    new Persona("Emma", "Jones"),
	    	    new Persona("Michael", "Brown")
	    	);
	    @FXML
	    private void initialize() {
	    	 // Asociamos cada columna del TableView a una propiedad de la clase Person 
		    colNombre.setCellValueFactory(new PropertyValueFactory<Entrada,String>("sspNombre"));
		    colApellido.setCellValueFactory(new PropertyValueFactory<Entrada,String>("sspApellido"));
	        // Se rellena la tabla con objetos de la clase Person
	        //table1.setItems(data);    
		    
		    table1.getSelectionModel().selectedItemProperty().addListener(
	                (observable, oldValue, newValue) -> showEntradaDetails(newValue)); 
	    }
	    /**
	     * asocia mi aplicación main a la varialbe
	     * @param mainApp Parámetro de la clase principal de la aplicación
	     */
	    public void setMainApp(Main mainApp) {
	        this.mainApp = mainApp;

	        table1.setItems(this.mainApp.getPersonData());
	               
	        // TODO Versión con map
	        //personTable.setItems(this.mainApp.getMapData()); 
	    }
	    private void showEntradaDetails(Entrada entrada) {
	        if (entrada != null) {
	        	// Si el campo contiene datos, entonces se rellena la información
	        	labelApellido.setText(entrada.getSspApellido());
	        	labelDescuento.setText(""+entrada.getSipDescuento());
	        	labelFecha.setText(DateUtil.format(entrada.getSspFechaCompra()));
	        	labelFechaEntrada.setText(DateUtil.format(entrada.getSspFechaEntrada()));
	        	labelFormaPago.setText(entrada.getSspFormaDePago());
	        	labelNombre.setText(entrada.getSspNombre());
	        	labelNumAdulto.setText(""+entrada.getSipNumEntradasAdulto());
	        	labelNumInfantil.setText(""+entrada.getSipNumEntradasInfantil());
	        	labelPrecio.setText(""+ entrada.getSdpPrecioTotal());

	        } else {
	            // Person is null, remove all the text.
	        	labelApellido.setText("");
	        	labelDescuento.setText("");
	        	labelFecha.setText("");
	        	labelFechaEntrada.setText("");
	        	labelFormaPago.setText("");
	        	labelNombre.setText("");
	        	labelNumAdulto.setText("");
	        	labelNumAdulto.setText("");
	        	labelPrecio.setText("");
	        }
	    }
}
