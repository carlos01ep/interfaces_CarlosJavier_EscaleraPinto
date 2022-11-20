package ch.makery.address.view;

import ch.makery.address.model.Entrada;
import ch.makery.address.model.Person;
import ch.makery.address.util.DateUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EntradaEditDialogController {


    
    // Este componente ser� un di�logo. Campos auxiliares para su gesti�n
    private Stage dialogStage;
    private Entrada entrada;
    private boolean okClicked = false;
    @FXML
    private TextField Apellidos;

    @FXML
    private TextField Descuento;

    @FXML
    private TextField FechaEntrada;

    @FXML
    private TextField FormaDePago;

    @FXML
    private TextField Nombre;

    @FXML
    private TextField NumAdultos;

    @FXML
    private TextField NumNiños;


    /**
     * M�todo para inicializar el controlador que se llama cuando se carga el FXML
     */
    @FXML
    private void initialize() {
    	
    }
    
    /**
     * Rellena los datos de la persona que va a ser a�adida o modificada en el di�logo
     * 
     * @param person
     */
    public void setEntrada(Entrada entrada) {
        this.entrada = entrada;
    	Apellidos.setText(entrada.getSspApellido());
    	Descuento.setText(""+entrada.getSipDescuento());
    	FechaEntrada.setText(entrada.getSspFechaEntrada());
    	FormaDePago.setText(entrada.getSspFormaDePago());
    	Nombre.setText(entrada.getSspNombre());
    	NumAdultos.setText(""+entrada.getSipNumEntradasAdulto());
    	NumNiños.setText(""+entrada.getSipNumEntradasInfantil());
    	
    }

    /**
     * Devuelve true si el usuario hace click en el bot�n "OK"
     * 
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }

    /**
     * Manejador del bot�n "OK"
     */
    @FXML
    private void handleOk() {
        if (isInputValid()) {
        	entrada.setSspNombre(Nombre.getText());
        	entrada.setSspApellido(Apellidos.getText());
        	entrada.setSipDescuento(Integer.parseInt(Descuento.getText()));
        	entrada.setSspFechaEntrada(FechaEntrada.getText());
        	entrada.setSspFormaDePago(FormaDePago.getText());
        	entrada.setSipNumEntradasAdulto(Integer.parseInt(NumAdultos.getText()));
        	entrada.setSipNumEntradasInfantil(Integer.parseInt(NumNiños.getText()));
            okClicked = true;
            dialogStage.close();
        }
    }

    /**
     * Manejador del bot�n "Cancel" 
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    /**
     * Valida los campos de texto del usuario
     * 
     * @return true si los campos son v�lidos
     */
    private boolean isInputValid() {
        String errorMessage = "";

        if (Nombre.getText() == null || Nombre.getText().length() == 0) {
            errorMessage += "El campo Nombre está vacío\n"; 
        }
        if (Apellidos.getText() == null || Apellidos.getText().length() == 0) {
            errorMessage += "El campo Apellidos  está vacío\n"; 
        }
        if (FechaEntrada.getText() == null || FechaEntrada.getText().length() == 0) {
            errorMessage += "El campo FechaEntrada está vacío\n"; 
        }
        if (FormaDePago.getText() == null || FormaDePago.getText().length() == 0) {
            errorMessage += "El campo FormaDePago está vacío\n"; 
        }
        if (Descuento.getText() == null || Descuento.getText().length() == 0) {
            errorMessage += "El campo Descuento está vacío\n"; 
        } else {
            // Se intenta convertir el c�digo postal en entero y si da un error se muestra un mensaje
            try {
                Integer.parseInt(Descuento.getText());
            } catch (NumberFormatException e) {
                errorMessage += "Descuento no válido. Debe ser un número entero\n"; 
            }
        }
        if (NumAdultos.getText() == null || NumAdultos.getText().length() == 0) {
            errorMessage += "El campo Número Adultos está vacío\n"; 
        } else {
            // Se intenta convertir el c�digo postal en entero y si da un error se muestra un mensaje
            try {
                Integer.parseInt(NumAdultos.getText());
            } catch (NumberFormatException e) {
                errorMessage += "Número Adultos no válido. Debe ser un número entero\n"; 
            }
        }
        if (NumNiños.getText() == null || NumNiños.getText().length() == 0) {
            errorMessage += "El Número Niños está vacío\n"; 
        } else {
            // Se intenta convertir el c�digo postal en entero y si da un error se muestra un mensaje
            try {
                Integer.parseInt(NumNiños.getText());
            } catch (NumberFormatException e) {
                errorMessage += "Número Niños no válido. Debe ser un número entero\n"; 
            }
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
        	// Se muestra un alert si no se puede eliminar la fila
    		Alert errorAlert = new Alert(AlertType.ERROR);
        	
    		errorAlert.setTitle("Hay campos incorrectos");
    		errorAlert.setHeaderText("Por favor, rellena correctamente los campos");
    		errorAlert.setContentText(errorMessage);
    		
    		errorAlert.showAndWait();
            return false; }

    }
    
    /**
     * M�todo set de la propiedad dialogStage
     * 
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

}