package View.tm;

import javafx.scene.control.Button;

public class MealTm {
    private String code;
    private String name;
    private String catogry;
    private String price;
    private Button btn;

    public MealTm(String code, String name, String catogry, String price) {
    }

    public MealTm(String code, String name, String catogry, String price, Button btn) {
        this.code = code;
        this.name = name;
        this.catogry = catogry;
        this.price = price;
        this.btn = btn;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getCatogry() {
        return catogry;
    }

    public String getPrice() {
        return price;
    }

    public Button getBtn() {
        return btn;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCatogry(String catogry) {
        this.catogry = catogry;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }
}
