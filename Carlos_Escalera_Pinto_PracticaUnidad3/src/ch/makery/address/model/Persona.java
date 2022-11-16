package ch.makery.address.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * 
 * Clase auxiliar que se emplear� para el modelo de datos del TableView
 * 
 * @author SBF
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