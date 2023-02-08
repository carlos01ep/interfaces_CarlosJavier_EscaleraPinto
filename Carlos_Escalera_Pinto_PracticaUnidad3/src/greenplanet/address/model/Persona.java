package greenplanet.address.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
/**
 * Clase auxiliar para mostrar la lista en la pantalla de inico de persona
 * 
 * @author CJEP DAM 2
 * @version 1.0
 *
 */

public class Persona {
    private final SimpleStringProperty firstName;
    private final SimpleStringProperty lastName;

 
    public Persona(String fName, String lName) {
        this.firstName = new SimpleStringProperty(fName);
        this.lastName = new SimpleStringProperty(lName);

    }
 
    public String getFirstName() {
        return firstName.get();
    }
    
    public void setFirstName(String fName) {
        firstName.set(fName);
    }
        
    public String getLastName() {
        return lastName.get();
    }
    public void setLastName(String fName) {
        lastName.set(fName);
    }
    
        
}