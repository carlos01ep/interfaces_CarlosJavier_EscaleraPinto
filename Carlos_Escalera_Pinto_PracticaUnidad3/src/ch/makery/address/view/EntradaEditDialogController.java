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
        /*String errorMessage = "";

        if (firstNameField.getText() == null || firstNameField.getText().length() == 0) {
            errorMessage += "El campo first name est� vac�o\n"; 
        }
        if (lastNameField.getText() == null || lastNameField.getText().length() == 0) {
            errorMessage += "El campo last name est� vac�o\n"; 
        }
        if (streetField.getText() == null || streetField.getText().length() == 0) {
            errorMessage += "El campo street est� vac�o\n"; 
        }

        if (postalCodeField.getText() == null || postalCodeField.getText().length() == 0) {
            errorMessage += "El campo postal code est� vac�o\n"; 
        } else {
            // Se intenta convertir el c�digo postal en entero y si da un error se muestra un mensaje
            try {
                Integer.parseInt(postalCodeField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "Postal code no v�lido. Debe ser un n�mero entero\n"; 
            }
        }

        if (cityField.getText() == null || cityField.getText().length() == 0) {
            errorMessage += "El campo city est� vac�o\n"; 
        }

        if (birthdayField.getText() == null || birthdayField.getText().length() == 0) {
            errorMessage += "El campo birthday est� vac�o\n";
        } else {
            if (!DateUtil.validDate(birthdayField.getText())) {
                errorMessage += "El campo birthday no es v�lido. Usa el formato dd/mm/yyyy\n";
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
            */
   
    	return true;
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