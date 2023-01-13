package graficos;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.BubbleChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.StackedAreaChart;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;

public class VentanaGraficosController {
	// Variables para representar los datos de los diferentes gr�ficos
	
	private ObservableList<XYChart.Series<String, Number>> dist1;
	private ObservableList<PieChart.Data> pieData;
	public void setPieData(ObservableList<PieChart.Data> pieData) {
		this.pieData = pieData;
	}
	@FXML
	private PieChart pieChart;
	
	@FXML
    private LineChart<String, Number> lineChart;
	
	@FXML
    private StackedBarChart<String, Number> stackedBarChart;
	
    @FXML
	private void initialize() {
		
	}

   
    
    // M�todo para inicializar el LineChart
    public void initLineChart() {
    	lineChart.setData(this.dist1);
    }
    // Método para inicializar el PieChart
    public void initPieChart() {
		pieChart.setData(pieData);
		
		// Se muestra en cada etiqueta el valor
		for (final PieChart.Data data : pieChart.getData()) {
		    data.setName(data.getName() + "=" + data.getPieValue());
		}
    }
 // Método para inicializar el StackedBarChart
    public void initStackedBarChart() {
    	stackedBarChart.setData(this.dist1);
    }
    
	public ObservableList<XYChart.Series<String, Number>> getDist1() {
		return dist1;
	}

	public void setDist1(ObservableList<XYChart.Series<String, Number>> dist1) {
		this.dist1 = dist1;
	}

	

}
