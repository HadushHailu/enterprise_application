package customers;

public class Supplier {
    private int productNumber;
    private String name;
    private String phone;

    public Supplier(int productNumber, String name, String phone) {
        this.productNumber = productNumber;
        this.name = name;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "productNumber=" + productNumber +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public int getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(int productNumber) {
        this.productNumber = productNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
