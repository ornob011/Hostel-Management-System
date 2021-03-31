package Model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Ornob
 */

public class EmployeeDetails {
    // model class holding getters, setters and properties
    private StringProperty id;
    private StringProperty name;
    private StringProperty hostel_name;
    private StringProperty tel;
    private StringProperty emgTel;
    
    public EmployeeDetails(String id,String name, String hostel_name, String tel, String emgTel) {
        this.id = new SimpleStringProperty(id);
        this.name = new SimpleStringProperty(name);
        this.hostel_name = new SimpleStringProperty(hostel_name);
        this.tel = new SimpleStringProperty(tel);
        this.emgTel = new SimpleStringProperty(emgTel);
    }
    
     // Getters
    public String getId() {
        return id.get();
    }
    
    public String getName() {
        return name.get();
    }

    public String gethostel_name() {
        return hostel_name.get();
    }

    public String getTel() {
        return tel.get();
    }

    public String getEmgTel() {
        return emgTel.get();
    }
    
    // Setters
    public void setId(String value) {
        id.set(value);
    }
    
    public void setName(String value) {
        name.set(value);
    }

    public void sethostel_name(String value) {
        hostel_name.set(value);
    }

    public void setTel(String value) {
        tel.set(value);
    }

    public void seEmgTel(String value) {
        emgTel.set(value);
    }
    
    // Propert values
    
    public StringProperty idProperty() { return id; }
    
    public StringProperty nameProperty() { return name; }
    
    public StringProperty hostel_nameProperty() { return hostel_name; }
    
    public StringProperty telProperty() { return tel; }
    
    public StringProperty emgTelProperty() { return emgTel; }
}
