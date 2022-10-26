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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
//import layout2.Person;

public class MenuController {
	// Pantalla principal en la que se añade o quita contenido
		private BorderPane rootLayout;
	    @FXML
	    private void initialize() {	
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
				loader.setLocation(MenuController.class.getResource("/layout1/inicio.fxml"));
				AnchorPane listadoControles = (AnchorPane) loader.load();

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
				loader.setLocation(MenuController.class.getResource("/layout3/Tutorial.fxml"));
				VBox listadoControles = (VBox) loader.load();

				// Se sitúa en el centro del diseño principal
				rootLayout.setCenter(listadoControles);
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }

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
