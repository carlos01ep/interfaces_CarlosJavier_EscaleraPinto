package ch.makery.address;
	

import java.io.IOException;
import ch.makery.address.model.Persona;
import ch.makery.address.model.Entrada;
import ch.makery.address.model.Person;
import ch.makery.address.view.MantenimientoController;
import ch.makery.address.view.InicioController;
import ch.makery.address.view.TutorialController;
import ch.makery.address.view.MenuController;
import ch.makery.address.view.EntradaEditDialogController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Modality;
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
			loader.setLocation(Main.class.getResource("view/PantallaMenu.fxml"));
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
			loader.setLocation(Main.class.getResource("view/Pantalla3Tutorial.fxml"));
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
			loader.setLocation(Main.class.getResource("view/Pantalla2Mantenimiento.fxml"));
			GridPane inicioLayout = (GridPane) loader.load();

			// Se sitúa en el centro del diseño principal
			rootLayout.setCenter(inicioLayout);
			
			// Damos al controlador acceso a la aplicaicón principal
	        MantenimientoController controller = loader.getController();
	        controller.setMainApp(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void showInicio() {
		try {
			// Cargamos el archivo PersonOverview
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/Pantalla1Inicio.fxml"));
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
	public boolean showEntradaEditDialog(Entrada entrada) {
	    try {
	        // Cargamos el diseño del diálogo desde un XML
	        FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(Main.class.getResource("view/PantallaEntradaEditDialog.fxml"));
	        AnchorPane page = (AnchorPane) loader.load();

	        // Se crea un nuevo Stage para mostrar el diálogo
	        Stage dialogStage = new Stage();
	        dialogStage.setTitle("Editar Entrada");
	        dialogStage.initModality(Modality.WINDOW_MODAL);
	        dialogStage.initOwner(primaryStage);
	        Scene scene = new Scene(page);
	        dialogStage.setScene(scene);

	        // Carga la Entrada en el controlador
	        EntradaEditDialogController controller = loader.getController();
	        controller.setDialogStage(dialogStage);
	        controller.setEntrada(entrada);

	        // Muestra el diálogo y no continúa el código hasta que lo cierra el usuario
	        dialogStage.showAndWait();

	        return controller.isOkClicked();
	    } catch (IOException e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	
}