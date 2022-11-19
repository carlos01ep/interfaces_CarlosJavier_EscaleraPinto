package ch.makery.address;
	

import java.io.IOException;
import ch.makery.address.model.Persona;
import ch.makery.address.model.Entrada;
import ch.makery.address.model.Person;
import ch.makery.address.view.EntradaController;
import ch.makery.address.view.InicioController;
import ch.makery.address.view.TutorialController;
import ch.makery.address.view.MenuController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
	private BorderPane rootLayout;	
	private Stage primaryStage;
	private ObservableList<Entrada> personData = FXCollections.observableArrayList();
	
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Parque de atracciones");
			
		initRootLayout();
		showInicio();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	public void initRootLayout() {
		try {
			// Carga el XML con el diseño principal
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/Menu.fxml"));
			rootLayout = (BorderPane) loader.load();

			// Se añade el diseño principal a la escena
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);				
			primaryStage.show();
			// Damos al controlador acceso a la aplicaicón principal
	        MenuController controller = loader.getController();
	        controller.setMainApp(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void showTutorial() {
		try {
			// Cargamos el archivo PersonOverview
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/Tutorial.fxml"));
			VBox tutorialLayout = (VBox) loader.load();

			// Se sitúa en el centro del diseño principal
			rootLayout.setCenter(tutorialLayout);
			
			// Damos al controlador acceso a la aplicaicón principal
	        TutorialController controller = loader.getController();
	        controller.setMainApp(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void showEditar() {
		try {
			// Cargamos el archivo PersonOverview
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/Editar.fxml"));
			GridPane inicioLayout = (GridPane) loader.load();

			// Se sitúa en el centro del diseño principal
			rootLayout.setCenter(inicioLayout);
			
			// Damos al controlador acceso a la aplicaicón principal
	        EntradaController controller = loader.getController();
	        controller.setMainApp(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void showInicio() {
		try {
			// Cargamos el archivo PersonOverview
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/inicio.fxml"));
			AnchorPane inicioLayout = (AnchorPane) loader.load();

			// Se sitúa en el centro del diseño principal
			rootLayout.setCenter(inicioLayout);
			
			// Damos al controlador acceso a la aplicaicón principal
	        InicioController controller = loader.getController();
	        controller.setMainApp(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public ObservableList<Entrada> getPersonData() {
		return personData;
	}
	public Main() {
		personData.add(new Entrada("Hans", "Muster","fecha1","fecha1",2,3,5,25.0,"Trjeta"));
		personData.add(new Entrada("Ruth", "Mueller","fecha1","fecha1",2,3,5,25.0,"Trjeta"));
		personData.add(new Entrada("Heinz", "Kurz","fecha1","fecha1",2,3,5,25.0,"Trjeta"));
		personData.add(new Entrada("Cornelia", "Meier","fecha1","fecha1",2,3,5,25.0,"Trjeta"));
		personData.add(new Entrada("Werner", "Meyer","fecha1","fecha1",2,3,5,25.0,"Trjeta"));
		personData.add(new Entrada("Lydia", "Kunz","fecha1","fecha1",2,3,5,25.0,"Trjeta"));
		personData.add(new Entrada("Anna", "Best","fecha1","fecha1",2,3,5,25.0,"Trjeta"));
		personData.add(new Entrada("Stefan", "Meier","fecha1","fecha1",2,3,5,25.0,"Trjeta"));
		personData.add(new Entrada("Martin", "Mueller","fecha1","fecha1",2,3,5,25.0,"Trjeta"));
		
	}
}