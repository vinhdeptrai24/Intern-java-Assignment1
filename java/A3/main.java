package A3;
import A3.exception.DuplicateProductException;
import A3.exception.ProductNotFoundException;

import java.util.*;
import java.math.BigDecimal;
public class main {
    static void main(String[] args) {
        Productmanager pm=new Productmanager();
        pm.addProduct(new Product("P001", "Laptop Basic", "Laptop", new BigDecimal("15000000"), 5));
        pm.addProduct(new Product("P002", "Mouse Wireless", "Accessory", new BigDecimal("350000"), 20));
        pm.addProduct(new Product("P003", "Keyboard USB", "Accessory", new BigDecimal("450000"), 12));
        pm.addProduct(new Product("P004", "Monitor 24 inch", "Monitor", new BigDecimal("3200000"), 7));
        pm.addProduct(new Product("P005", "Laptop Office", "Laptop", new BigDecimal("18500000"), 3));

        //2.in ra toan bo sp
        System.out.println("danh sách sản phẩm:");
        for (Product s: pm.getAllProducts()){
            System.out.println(s);
        }
        //3. Tìm sản phẩm theo id P003.
        System.out.println("san pham co id P003:");
        System.out.println(pm.findbyID("P003"));

        //4.tim san pham name la laptop
        System.out.println("san pham co ten la laptop:");
        System.out.println(pm.findbyName("laptop"));

        //5.In danh sách sản phẩm theo giá giảm dần.
        System.out.println("\n5. Danh sách theo giá giảm dần:");
        for (Product p : pm.sortByPriceDescending()) {
            System.out.println(p);
        }

        //6.Tính và in tổng giá trị tồn kho.
        System.out.println("\n6. Tổng giá trị tồn kho: "
                + pm.calculateInventoryValue().toPlainString());

        //7.Cập nhật số lượng P002 thành 25 rồi in lại sản phẩm.
        pm.updateQuantity("P002", 25);
        System.out.println("\n7. Sau khi cập nhật số lượng P002:");
        System.out.println(pm.findbyID("P002"));

        //8.Xóa P004 rồi in danh sách còn lại.
        pm.removeProduct("P004");
        System.out.println("\n8. Danh sách sau khi xóa P004:");
        for (Product p : pm.getAllProducts()) {
            System.out.println(p);
        }

        //9.Thử thêm lại P001 để thể hiện xử lý trùng id.
        System.out.println("\n9. Thêm lại P001:");
        try {
            pm.addProduct(new Product("P001", "Laptop Basic", "Laptop", new BigDecimal("15000000"), 5));
        } catch (DuplicateProductException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }

        //10.Thử cập nhật một id không tồn tại để thể hiện xử lý lỗi.
        System.out.println("\n10. Cập nhật id không tồn tại:");
        try {
            pm.updateQuantity("P999", 10);
        } catch (ProductNotFoundException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
}

