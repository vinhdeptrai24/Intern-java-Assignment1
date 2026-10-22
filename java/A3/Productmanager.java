package A3;
import A3.exception.DuplicateProductException;
import A3.exception.InvalidProductException;
import A3.exception.ProductNotFoundException;

import java.math.BigDecimal;
import java.util.*;

public class Productmanager {
    private List<Product> products = new ArrayList<>();
    public void addProduct(Product sp){
        if(sp==null){
            throw new InvalidProductException("sản phẩm không được rỗng");
        }
        if(findbyID(sp.getId()) != null){
            throw new DuplicateProductException("đã tồn tại sản phẩm có id"+sp.getId());
        }
        products.add(sp);
    }
    public Product findbyID(String id){
        if(id==null){
            return null;
        }
        for(Product s:products){
            if(s.getId().equals(id.trim()))
                return s;
        }
        return null;
    }
    public List<Product> findbyName(String keyword){
        List<Product> kq=new ArrayList<>();
        if(keyword==null||keyword.isBlank()) return kq;
        String k=keyword.trim().toLowerCase();
        for(Product s:products){
            if(s.getName().toLowerCase().contains(k)){
                kq.add(s);
            }
        }
        return  kq;
    }

    public List<Product> findbyCategory(String c) {
        List<Product> kq=new ArrayList<>();
        if(c==null||c.isBlank()) return kq;
        for(Product s:products){
            if(s.getCategory().equalsIgnoreCase(c.trim())){
                kq.add(s);
            }
        }
        return kq;
    }
    public List<Product> sortByPriceAscending(){
        List<Product> kq=new ArrayList<>(products);
        kq.sort(Comparator.comparing(Product::getPrice));
        return kq;
    }

    public List<Product> sortByPriceDescending() {
        List<Product> kq=new ArrayList<>(products);
        kq.sort(Comparator.comparing(Product::getPrice).reversed());
        return kq;
    }
    public BigDecimal calculateInventoryValue(){
        BigDecimal sum=BigDecimal.ZERO;
        for(Product s:products){
            sum=sum.add(s.getPrice().multiply(BigDecimal.valueOf(s.getQuantity())));
        }
        return sum;
    }
    public void updateQuantity(String id,int quantity){
        Product p=findbyID(id);
        if(p==null)
        {
            throw new ProductNotFoundException("không tùm thấy sản phẩm có id: "+id);
        }
        p.setQuantity(quantity);
    }
    public void removeProduct(String id){
        Product p=findbyID(id);
        if(p==null)
        {
            throw new ProductNotFoundException("không tùm thấy sản phẩm có id: "+id);
        }
        products.remove(p);
    }
    public List<Product> getAllProducts(){
        return Collections.unmodifiableList(products);
    }
}
