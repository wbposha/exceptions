package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    @Test
    public void shouldRemoveIfProductExist() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(11, "phone", 30_000);
        Product product2 = new Product(22, "book", 300);
        Product product3 = new Product(33, "car", 3_000_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(22);
        Product[] actual = repo.findAll();
        Product[] expected = {product1, product3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveIfProductIsNotExist() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(11, "phone", 30_000);
        Product product2 = new Product(22, "book", 300);
        Product product3 = new Product(33, "car", 3_000_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);


        Assertions.assertThrows(NotFoundException.class,
                () -> repo.remove(3)
                );
    }
}
