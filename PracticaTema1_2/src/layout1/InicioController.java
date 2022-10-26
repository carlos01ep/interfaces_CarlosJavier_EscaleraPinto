package layout1;

import java.io.IOException;

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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
//import layout2.Person;

public class InicioController {
	// Pantalla principal en la que se añade o quita contenido
		private BorderPane archorPane;
	//Dinamico
		
		
	    @FXML
	    private TableColumn<Persona, String> colApellido;

	    @FXML
	    private TableColumn<Persona, String> colNombre;

	    @FXML
	    private TableView<Persona> table1;
	    
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
		    colNombre.setCellValueFactory(new PropertyValueFactory<Persona,String>("firstName"));
		    colApellido.setCellValueFactory(new PropertyValueFactory<Persona,String>("lastName"));
	        // Se rellena la tabla con objetos de la clase Person
	        table1.setItems(data);     
	    }

}
