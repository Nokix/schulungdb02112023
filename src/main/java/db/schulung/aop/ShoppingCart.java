package db.schulung.aop;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class ShoppingCart {
    private int priceOfAll;
    private int countOfAll;
    private List<Item> cart = new ArrayList<>();

    public ShoppingCart addItem(Item item) {
        if(item != null)
            cart.add(item);
        return this;
    }

    public ShoppingCart removeItem(Item item) {
        cart.remove(item);
        return this;
    }

    void updatePriceOfAll() {
        priceOfAll = cart.stream()
                .mapToInt(Item::getPrice)
                .sum();
    }

    void updateCountOfAll() {
        countOfAll = cart.size();
    }

    public String checkout() {
        return "Your " + countOfAll + " Items cost " + priceOfAll;
    }

}
