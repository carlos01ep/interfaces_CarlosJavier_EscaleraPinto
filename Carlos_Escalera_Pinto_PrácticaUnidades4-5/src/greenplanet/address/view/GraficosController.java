package greenplanet.address.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
//import layout2.Person;
import javafx.stage.Stage;
import graficos.VentanaGraficosController;
import greenplanet.address.Main;
import greenplanet.address.model.Entrada;
import greenplanet.address.model.Person;
import greenplanet.address.util.DateUtil;
/**
 * Clase controlador de la pantalla graficos
 * 
 * @author CJEP DAM 2
 * @version 1.0
 *
 */
public class GraficosController {
	private Main mainApp;
	private FXMLLoader loader;
	private Stage dialogStage;

	@FXML
	void botonLineChart(ActionEvent event) {
		try {
			// Se crea un nuevo diálogo para mostar el gráfico
			crearDialogo("/graficos/LineChart.fxml");

			// Se pasa como parámetro el listado de calificaciones
			VentanaGraficosController controller = this.loader.getController();
			controller.setDist1(mainApp.loadDist1());
			controller.initLineChart();

			this.dialogStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void crearDialogo(String ruta) throws IOException {
		// Carga el fichero XML con el pop up de las estadísticas
		this.loader = new FXMLLoader();
		this.loader.setLocation(Main.class.getResource(ruta));

		// Se carga el diálogo en el objeto Scene y posteriormente en Stage
		AnchorPane page = (AnchorPane) loader.load();
		this.dialogStage = new Stage();
		this.dialogStage.setTitle("Estadísticas de calificaciones");
		this.dialogStage.initModality(Modality.APPLICATION_MODAL);
		Scene scene = new Scene(page);
		this.dialogStage.setScene(scene);
	}

	public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;

	}
	 @FXML
	    private void botonPieChart(ActionEvent event) {
	    	try {
	    		// Se crea un nuevo diálogo para mostar el gráfico
	    		crearDialogo("/graficos/PieChart.fxml");

		        // Se pasa como parámetro el listado de calificaciones
		        VentanaGraficosController controller = this.loader.getController();
		        controller.setPieData(mainApp.loadPieData());
		        controller.initPieChart();
		        
		        this.dialogStage.show();
		    } catch (IOException e) {
		        e.printStackTrace();
		    }    	
	    }
	 @FXML
	    private void botonStackedBarChart(ActionEvent event) {
	    	try {
	    		// Se crea un nuevo diálogo para mostar el gráfico
	    		crearDialogo("/graficos/StackedBarChart.fxml");

		        // Se pasa como parámetro el listado de calificaciones
		        VentanaGraficosController controller = this.loader.getController();
		        controller.setDist1(mainApp.loadDist2());
		        controller.initStackedBarChart();
		        
		        this.dialogStage.show();
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
	    }

}
