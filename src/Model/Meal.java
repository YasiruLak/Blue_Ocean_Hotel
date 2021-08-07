package Model;

public class Meal {
    String code;
    String name;
    String catogry;
    String price;

    public Meal() {
    }

    public Meal(String code, String name, String catogry, String price) {
        this.code = code;
        this.name = name;
        this.catogry = catogry;
        this.price = price;
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
}
