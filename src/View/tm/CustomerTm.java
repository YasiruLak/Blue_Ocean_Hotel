package View.tm;

import javafx.scene.control.Button;

public class CustomerTm {
    private String id;
    private String name;
    private String contact;
    private String email;
    private String nic;
    private String address;
    private String meal;
    private String room;
    private Button btn;

    public CustomerTm(String id, String name, String contact, String email, String nic, String address, String meal, String room, Button btn) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.email = email;
        this.nic = nic;
        this.address = address;
        this.meal = meal;
        this.room = room;
        this.btn = btn;
    }

    public CustomerTm() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMeal() {
        return meal;
    }

    public void setMeal(String meal) {
        this.meal = meal;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }
}
