package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
	private BorderPane rootLayout;	
	@Override
	public void start(Stage primaryStage) {
		try {
			// Carga el dise�o del archivo FXML en la variable rootLayout
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("Menu.fxml"));
			rootLayout = (BorderPane) loader.load();
			
			// Pasamos al controlador de menu el objeto con el BorderPane principal
			MenuController menuController = loader.getController();
			menuController.setRootLayout(rootLayout);
			menuController.abrirInicio(null);//carga el layout de inicio al empezar
			
			// Mostramos la escena del BorderPane de la variable rootLayot
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Parque de Atracciones - Venta de entradas");
			//primaryStage.setMaximized(true); //checkBox "Leído" de Tutorial descuadrado
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}