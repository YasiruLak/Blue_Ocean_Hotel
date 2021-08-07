package Model;

public class Room {
    private String no;
    private String type;
    private String price;

    public Room() {
    }

    public Room(String no, String type, String price) {
        this.setNo(no);
        this.setType(type);
        this.setPrice(price);
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
}

