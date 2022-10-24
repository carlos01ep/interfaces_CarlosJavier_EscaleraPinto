package application;

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
import layout2.Person;

public class MenuController {
	// Pantalla principal en la que se añade o quita contenido
		private BorderPane rootLayout;
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

	    @FXML
	    void abrirEditar(ActionEvent event) {
	    	try {
				// Cargamos el archivo Controles Dinámicos
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(MenuController.class.getResource("/layout2/Editar.fxml"));
				GridPane listadoControles = (GridPane) loader.load();

				// Se sitúa en el centro del diseño principal
				rootLayout.setCenter(listadoControles);
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }
	    @FXML
	    void abrirInicio(ActionEvent event) {
	    	try {
				// Cargamos el archivo Controles Dinámicos
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(MenuController.class.getResource("/layout2/Menu.fxml"));
				GridPane listadoControles = (GridPane) loader.load();

				// Se sitúa en el centro del diseño principal
				rootLayout.setCenter(listadoControles);
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }

	    @FXML
	    void abrirTutorial(ActionEvent event) {
	    	try {
				// Cargamos el archivo Controles Dinámicos
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(MenuController.class.getResource("/layout2/Prueba1.fxml"));
				GridPane listadoControles = (GridPane) loader.load();

				// Se sitúa en el centro del diseño principal
				rootLayout.setCenter(listadoControles);
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }

	    
	   /* @FXML
	    private void abrirFormulario(ActionEvent event) {
	    	try {
				// Cargamos el archivo Controles Dinámicos
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(MenuController.class.getResource("/basicoDinamico/ControlesDinamicos.fxml"));
				GridPane listadoControles = (GridPane) loader.load();

				// Se sitúa en el centro del diseño principal
				rootLayout.setCenter(listadoControles);
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }*/
	    
	    
	    @FXML
	    private void cerrarListado(ActionEvent event) {    	
	    	// Se elimina el contenido del nodo central
	    	rootLayout.setCenter(null);	
	    }

		public BorderPane getRootLayout() {
			return rootLayout;
		}

		public void setRootLayout(BorderPane rootLayout) {
			this.rootLayout = rootLayout;
		}	
		
	
	    

}
