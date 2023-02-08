package greenplanet.address;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import greenplanet.address.model.Entrada;
import greenplanet.address.model.Person;
import greenplanet.address.view.EntradaEditDialogController;
import greenplanet.address.view.GraficosController;
import greenplanet.address.view.InicioController;
import greenplanet.address.view.MantenimientoController;
import greenplanet.address.view.MenuController;
import greenplanet.address.view.TutorialController;
import javafx.application.Application;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Clase Main donde se inicia la aplicación
 * 
 * @author CJEP DAM 2
 * @version 1.0
 *
 */
public class Main extends Application {
	private BorderPane rootLayout;
	private Stage primaryStage;
	private ObservableList<Entrada> personData = FXCollections.observableArrayList();

	/**
	 * inicia la aplicación
	 */
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Parque de atracciones");

		initRootLayout();
		showInicio();
	}

	/**
	 * método principal desde donde se lanza la aplicación
	 */
	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * método en el que se asigna el diseño del menú a la escena
	 */
	public void initRootLayout() {
		try {
			// Carga el XML con el diseño principal
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/PantallaMenu.fxml"));
			rootLayout = (BorderPane) loader.load();

			// Se añade el diseño principal a la escena
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			// scene.getStylesheets().add("basico1/css/estilo1.css");

			primaryStage.show();

			// Damos al controlador acceso a la aplicaicón principal
			MenuController controller = loader.getController();
			controller.setMainApp(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * método en el que se asigna el diseño del tutorial a la escena central del
	 * rootlayout
	 */
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

	/**
	 * método en el que se asigna el diseño del Editar a la escena central del
	 * rootlayout
	 */
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

	/**
	 * método en el que se asigna el diseño del Inicio a la escena central del
	 * rootlayout
	 */
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

	/**
	 * método en el que se asigna el diseño del Graficos a la escena central del
	 * rootlayout
	 */
	public void showGraficos() {
		try {
			// Cargamos el archivo PersonOverview
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/Pantalla4Graficos.fxml"));
			BorderPane inicioLayout = (BorderPane) loader.load();

			// Se sitúa en el centro del diseño principal
			rootLayout.setCenter(inicioLayout);

			// Damos al controlador acceso a la aplicaicón principal
			GraficosController controller = loader.getController();
			controller.setMainApp(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ObservableList<Entrada> getPersonData() {
		return personData;
	}

	public Main() {
		SimpleObjectProperty<LocalDate> fecha1 = new SimpleObjectProperty<LocalDate>(LocalDate.of(1999, 2, 21));
		personData.add(new Entrada("Hans", "Muster", fecha1, fecha1, 2, 3, 5, 25.0, "Trjeta"));
		personData.add(new Entrada("Ruth", "Mueller", fecha1, fecha1, 2, 3, 5, 25.0, "Trjeta"));
		personData.add(new Entrada("Heinz", "Kurz", fecha1, fecha1, 2, 3, 5, 25.0, "Trjeta"));
		personData.add(new Entrada("Cornelia", "Meier", fecha1, fecha1, 2, 3, 5, 25.0, "Trjeta"));
		personData.add(new Entrada("Werner", "Meyer", fecha1, fecha1, 2, 3, 5, 25.0, "Trjeta"));
		personData.add(new Entrada("Lydia", "Kunz", fecha1, fecha1, 2, 3, 5, 25.0, "Trjeta"));
		personData.add(new Entrada("Anna", "Best", fecha1, fecha1, 2, 3, 5, 25.0, "Trjeta"));
		personData.add(new Entrada("Stefan", "Meier", fecha1, fecha1, 2, 3, 5, 25.0, "Trjeta"));
		personData.add(new Entrada("Martin", "Mueller", fecha1, fecha1, 2, 3, 5, 25.0, "Trjeta"));

	}

	public ObservableList<PieChart.Data> loadPieData() {
		// Rellenamos los datos del gráfico
		ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
				new PieChart.Data("zona familiar", 5), new PieChart.Data("Zona infantil", 6),
				new PieChart.Data("Zona acuatica", 8), new PieChart.Data("Zona de atracciones mecanicas", 6),
				new PieChart.Data("Zona educativa", 5), new PieChart.Data("Zon de tranquilidad", 4));

		return pieChartData;
	}

	public ObservableList<XYChart.Series<String, Number>> loadDist1() {
		List<XYChart.Series<String, Number>> list = new ArrayList<XYChart.Series<String, Number>>();

		// Se crean dos series con datos
		XYChart.Series<String, Number> series1 = new XYChart.Series<String, Number>();
		series1.setName("Entradas Adulto");
		series1.getData().add(new XYChart.Data<String, Number>("Enero", 60));
		series1.getData().add(new XYChart.Data<String, Number>("Febrero", 50));
		series1.getData().add(new XYChart.Data<String, Number>("Marzo", 45));
		series1.getData().add(new XYChart.Data<String, Number>("Abril", 75));
		series1.getData().add(new XYChart.Data<String, Number>("Mayo", 85));
		series1.getData().add(new XYChart.Data<String, Number>("Junio", 96));
		series1.getData().add(new XYChart.Data<String, Number>("Julio", 94));
		series1.getData().add(new XYChart.Data<String, Number>("Agosto", 111));
		series1.getData().add(new XYChart.Data<String, Number>("Septiembre", 42));
		series1.getData().add(new XYChart.Data<String, Number>("Octubre", 46));
		series1.getData().add(new XYChart.Data<String, Number>("Noviembre", 53));
		series1.getData().add(new XYChart.Data<String, Number>("Diciembre", 67));

		// Se crean dos series con datos
		XYChart.Series<String, Number> series2 = new XYChart.Series<String, Number>();
		series2.setName("Entradas Infantil");
		series2.getData().add(new XYChart.Data<String, Number>("Enero", 76));
		series2.getData().add(new XYChart.Data<String, Number>("Febrero", 54));
		series2.getData().add(new XYChart.Data<String, Number>("Marzo", 67));
		series2.getData().add(new XYChart.Data<String, Number>("Abril", 70));
		series2.getData().add(new XYChart.Data<String, Number>("Mayo", 56));
		series2.getData().add(new XYChart.Data<String, Number>("Junio", 97));
		series2.getData().add(new XYChart.Data<String, Number>("Julio", 94));
		series2.getData().add(new XYChart.Data<String, Number>("Agosto", 124));
		series2.getData().add(new XYChart.Data<String, Number>("Septiembre", 74));
		series2.getData().add(new XYChart.Data<String, Number>("Octubre", 63));
		series2.getData().add(new XYChart.Data<String, Number>("Noviembre", 56));
		series2.getData().add(new XYChart.Data<String, Number>("Diciembre", 80));

		list.add(series1);
		list.add(series2);

		return FXCollections.observableArrayList(list);
	}

	public ObservableList<XYChart.Series<String, Number>> loadDist2() {
		List<XYChart.Series<String, Number>> list = new ArrayList<XYChart.Series<String, Number>>();

		// Se crean dos series con datos
		XYChart.Series<String, Number> series1 = new XYChart.Series<String, Number>();
		series1.setName("Mantenimiento");
		series1.getData().add(new XYChart.Data<String, Number>("Enero", 6000));
		series1.getData().add(new XYChart.Data<String, Number>("Febrero", 5000));
		series1.getData().add(new XYChart.Data<String, Number>("Marzo", 4500));
		series1.getData().add(new XYChart.Data<String, Number>("Abril", 7500));
		series1.getData().add(new XYChart.Data<String, Number>("Mayo", 8500));
		series1.getData().add(new XYChart.Data<String, Number>("Junio", 9600));
		series1.getData().add(new XYChart.Data<String, Number>("Julio", 9400));
		series1.getData().add(new XYChart.Data<String, Number>("Agosto", 11100));
		series1.getData().add(new XYChart.Data<String, Number>("Septiembre", 4200));
		series1.getData().add(new XYChart.Data<String, Number>("Octubre", 4600));
		series1.getData().add(new XYChart.Data<String, Number>("Noviembre", 5300));
		series1.getData().add(new XYChart.Data<String, Number>("Diciembre", 6700));

		// Se crean dos series con datos
		XYChart.Series<String, Number> series2 = new XYChart.Series<String, Number>();
		series2.setName("Suministros");
		series2.getData().add(new XYChart.Data<String, Number>("Enero", 960));
		series2.getData().add(new XYChart.Data<String, Number>("Febrero", 840));
		series2.getData().add(new XYChart.Data<String, Number>("Marzo", 1170));
		series2.getData().add(new XYChart.Data<String, Number>("Abril", 900));
		series2.getData().add(new XYChart.Data<String, Number>("Mayo", 860));
		series2.getData().add(new XYChart.Data<String, Number>("Junio", 1170));
		series2.getData().add(new XYChart.Data<String, Number>("Julio", 1240));
		series2.getData().add(new XYChart.Data<String, Number>("Agosto", 2640));
		series2.getData().add(new XYChart.Data<String, Number>("Septiembre", 940));
		series2.getData().add(new XYChart.Data<String, Number>("Octubre", 830));
		series2.getData().add(new XYChart.Data<String, Number>("Noviembre", 860));
		series2.getData().add(new XYChart.Data<String, Number>("Diciembre", 2700));

		list.add(series1);
		list.add(series2);

		return FXCollections.observableArrayList(list);
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