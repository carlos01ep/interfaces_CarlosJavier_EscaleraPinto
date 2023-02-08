package greenplanet.address.view;

import greenplanet.address.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.control.cell.TextFieldTreeCell;
/**
 * Clase controlador de la pantalla tutorial
 * 
 * @author CJEP DAM 2
 * @version 1.0
 *
 */
public class TutorialController {
	private Main mainApp;
    @FXML
    private void initialize() {   
       
    }
    public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;

	}
}
