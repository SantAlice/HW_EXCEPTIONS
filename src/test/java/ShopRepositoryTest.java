import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    @Test

    public void removeExistingProductTest() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(32,"Тетрадь",200);
        Product product2 = new Product(21, "Книга",750);
        Product product3 = new Product(113, "Линейка",155);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(32);

        Product[] actual = repo.findAll();
        Product[] expected = {product2, product3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void removeNotExistingProductTest() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(32,"Тетрадь",200);
        Product product2 = new Product(21, "Книга",750);
        Product product3 = new Product(113, "Линейка",155);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);


        Assertions.assertThrows(NotFoundException.class,
                () ->repo.remove(55)
        );
    }
}
