package Model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Ornob
 */
public class LeavedStudentDetails {
    // model class holding getters, setters and properties
    private StringProperty id;
    private StringProperty name;
    private StringProperty reg_no;
    private StringProperty email;
    private StringProperty phoneNumber;
    private StringProperty hostel_name;
    private StringProperty address;
    private StringProperty guardName;
    private StringProperty guardTel;
    private StringProperty date;
    
    public LeavedStudentDetails(String id,String name, String reg_no, String email, String phoneNumber, String hostel_name, String address, String guardName, String guardTel,String date)
    {
        this.id = new SimpleStringProperty(id);
        this.name = new SimpleStringProperty(name);
        this.reg_no = new SimpleStringProperty(reg_no);
        this.email = new SimpleStringProperty(email);
        this.phoneNumber = new SimpleStringProperty(phoneNumber);
        this.hostel_name = new SimpleStringProperty(hostel_name);
        this.address = new SimpleStringProperty(address);
        this.guardName = new SimpleStringProperty(guardName);
        this.guardTel = new SimpleStringProperty(guardTel);
        this.date = new SimpleStringProperty(date);
    }
    
    // Getters
    public String getId() {
        return id.get();
    }
    
    public String getName() {
        return name.get();
    }

    public String getreg_no() {
        return reg_no.get();
    }

    public String getEmail() {
        return email.get();
    }

    public String getPhoneNumber() {
        return phoneNumber.get();
    }

    public String gethostel_name() {
        return hostel_name.get();
    }

    public String getAddress() {
        return address.get();
    }

    public String getGuardName() {
        return guardName.get();
    }

    public String getGuardTel() {
        return guardTel.get();
    }
    
    public String getDate() {
        return date.get();
    }

    // Setters
    public void setId(String value) {
        id.set(value);
    }
    
    public void setName(String value) {
        name.set(value);
    }

    public void setreg_no(String value) {
        reg_no.set(value);
    }

    public void setEmail(String value) {
        email.set(value);
    }

    public void setPhoneNumber(String value) {
        phoneNumber.set(value);
    }

    public void sethostel_name(String value) {
        hostel_name.set(value);
    }

    public void setAddress(String value) {
        address.set(value);
    }

    public void setGuardName(String value) {
        guardName.set(value);
    }

    public void setGuardTel(String value) {
        guardTel.set(value);
    }
    
    public void setDate(String value) {
        date.set(value);
    }
    
    // Propert values
    
    public StringProperty idProperty() { return id; }
    
    public StringProperty nameProperty() { return name; }
    
    public StringProperty reg_noProperty() { return reg_no; }
    
    public StringProperty emailProperty() { return email; }
    
    public StringProperty phoneNumberProperty() { return phoneNumber; }
    
    public StringProperty hostel_nameProperty() { return hostel_name; }
    
    public StringProperty addressProperty() { return address; }
    
    public StringProperty guardNameProperty() { return guardName; }
    
    public StringProperty guardTelProperty() { return guardTel; }
    
    public StringProperty DateProperty() { return date; }   
}
