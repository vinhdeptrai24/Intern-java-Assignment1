package A3;
import A3.exception.InvalidProductException;

import java.math.BigDecimal;
public class Product {
    private String id;
    private String name;
    private String category;
    private BigDecimal price;
    private int quantity;

    public Product(String id, String name, String category, BigDecimal price, int quantity) {
        checktext(id,"id");
        checktext(name,"name");
        checktext(category,"category");
        checkprice(price);
        checkquantity(quantity);
        this.id = id.trim();
        this.name = name.trim();
        this.category = category.trim();
        this.price = price;
        this.quantity = quantity;
    }

    private void checktext(String value, String field){
        if(value==null||value.isBlank())
            throw new InvalidProductException(field+"sản phẩm không được null/rỗng");
    }
    private void checkprice(BigDecimal value){
        if(value==null||value.compareTo(BigDecimal.ZERO)<=0){
            throw new InvalidProductException("price phải lớn hơn 0");
        }
    }
    private void checkquantity(int value){
        if(value<0){
            throw new InvalidProductException("số lượng sản phẩm phải lớn hơn hoặc bằng ");
        }
    }

    public String getId() {return id;}

    public void setId(String id) {
        checktext(id,"id");
        this.id = id.trim();
    }

    public String getName() {return name;}

    public void setName(String name) {
        checktext(name,"name");
        this.name = name.trim();
    }

    public String getCategory() {return category;}

    public void setCategory(String category) {
        checktext(category,"category");
        this.category = category.trim();
    }

    public BigDecimal getPrice() {return price;}

    public void setPrice(BigDecimal price) {
        checkprice(price);
        this.price = price;
    }

    public int getQuantity() {return quantity;}

    public void setQuantity(int quantity) {
        checkquantity(quantity);
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return String.format("Product{id=%s, name=%s, category=%s, price=%s, quantity=%d}",
                id, name, category, price.toPlainString(), quantity);
    }
}