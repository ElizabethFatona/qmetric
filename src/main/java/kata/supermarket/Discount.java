package kata.supermarket;

import java.util.List;

public class Discount {


    private String discountName;
    private List<Item> applicableItems;

    public Discount(String discountName, List<Item>  applicableItems){
        this.discountName = discountName;
        this.applicableItems = applicableItems;
    }


    public List<Item> getApplicableItems() {
        return applicableItems;
    }
}
