package View.tm;

import javafx.scene.control.Button;

public class RoomTm{
     private String no;
     private String type;
     private String price;
     private Button btn;

    public RoomTm(String no,String type,String price) {
    }

    public RoomTm(String no, String type, String price, Button btn) {
        this.setNo(no);
        this.setType(type);
        this.setPrice(price);
        this.setBtn(btn);
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }
}
