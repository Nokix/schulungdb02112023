package db.schulung.aop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class ShoppingCartTest {
    @Autowired
    private ShoppingCart shoppingCart;

    Item cola = new Item("Cola", 100);
    Item apfel = new Item("Apfel", 50);
    Item rolex = new Item("Rolex", 100_000);

    @Test
    void noExpensiveItemsAllowed() {
        ShoppingCart shoppingCart1 = shoppingCart.addItem(rolex);
        assertEquals(0, shoppingCart.getCountOfAll());
        assertEquals(0, shoppingCart.getPriceOfAll());
    }

    @Test
    void startEmpty() {
        assertEquals(0, shoppingCart.getCountOfAll());
        assertEquals(0, shoppingCart.getPriceOfAll());
    }

    @Test
    void addItem() {
        shoppingCart.addItem(cola);
        assertEquals(1, shoppingCart.getCountOfAll());
        assertEquals(100, shoppingCart.getPriceOfAll());
    }

    @Test
    void addItem2() {
        shoppingCart.addItem(cola);
        shoppingCart.addItem(cola);
        shoppingCart.addItem(apfel);

        assertEquals(3, shoppingCart.getCountOfAll());
        assertEquals(250, shoppingCart.getPriceOfAll());
    }

    @Test
    void removeItem() {
        shoppingCart.addItem(cola);
        shoppingCart.removeItem(cola);
        assertEquals(0, shoppingCart.getCountOfAll());
        assertEquals(0, shoppingCart.getPriceOfAll());
    }

    @Test
    void remove2Test() {
        shoppingCart.addItem(cola);
        shoppingCart.addItem(cola);
        shoppingCart.removeItem(cola);
        shoppingCart.addItem(cola);
        shoppingCart.addItem(apfel);

        assertEquals(3, shoppingCart.getCountOfAll());
        assertEquals(250, shoppingCart.getPriceOfAll());
    }

    @Test
    void removeMissingItem() {
        shoppingCart.removeItem(cola);
        assertEquals(0, shoppingCart.getCountOfAll());
        assertEquals(0, shoppingCart.getPriceOfAll());
    }
}