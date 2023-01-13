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
	
	
	
	
	@FXML
    private LineChart<String, Number> lineChart;
	
	
	
    @FXML
	private void initialize() {
		
	}

   
    
    // M�todo para inicializar el LineChart
    public void initLineChart() {
    	lineChart.setData(this.dist1);
    }
    
    
	public ObservableList<XYChart.Series<String, Number>> getDist1() {
		return dist1;
	}

	public void setDist1(ObservableList<XYChart.Series<String, Number>> dist1) {
		this.dist1 = dist1;
	}

	

}
