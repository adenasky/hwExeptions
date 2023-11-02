import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopRepositoryTest {
    @Test
    public void testProductIsRemoved() {
        ShopRepository shopRepository = new ShopRepository();
        int id = 1512;
        Product product = new Product(id, "Книга", 500);
        shopRepository.add(product);

        shopRepository.removeById(id);

        Product actual = shopRepository.findById(id);
        assertNull(actual);
    }

    @Test
    public void testNotFoundException() {
        ShopRepository shopRepository = new ShopRepository();

        Assertions.assertThrows(NotFoundException.class, () -> {
            shopRepository.removeById(1212);
        });
    }

    @Test
    public void testAddProduct() {
        ShopRepository shopRepository = new ShopRepository();
        int id = 1819;
        Product product = new Product(id, "Книга", 700);
        shopRepository.add(product);

        Product actual = shopRepository.findById(id);
        assertNotNull(actual);
    }

    @Test
    public void testAlreadyExistsException() {
        ShopRepository shopRepository = new ShopRepository();
        int id = 1819;
        Product product = new Product(id, "Книга", 700);
        shopRepository.add(product);

        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            shopRepository.add(product);
        });
    }
}