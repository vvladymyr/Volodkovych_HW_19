package org.example.uitests;

import org.example.uitests.driver.WebDriverHolder;
import org.example.uitests.pages.shop_main.Product;
import org.example.uitests.pages.shop_main.ProductPageShop;
import org.example.uitests.pages.shop_main.SortDirection;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class ProductsTests extends BaseTests {

    @BeforeClass
    public void beforeClass() {

        goToPart("8-dresses");
    }

    @Test
    public void allProductsTest() throws InterruptedException {
            ProductPageShop productPageShop = new ProductPageShop();
            productPageShop.setItemsPerPage(60);
            List<Product> productList = productPageShop.getProducts();
            Assert.assertEquals(productList.size(), 30);
        }

    @Test
    public void sortByPriceAscendingWith60ItemsPerPage() throws InterruptedException {
        ProductPageShop productPageShop = new ProductPageShop();
        productPageShop.setItemsPerPage(60);

        List<Product> productsAsIs = productPageShop.getProducts();

        List<Product> productsAfterSorting = productPageShop.sortBy(SortDirection.PRICE_LOW_TO_HIGH).getProducts();

        Collections.sort(productsAsIs, Comparator.comparing(Product::getPrice));

        Assert.assertEquals(productsAsIs, productsAfterSorting);
    }

    @Test
    public void sortByPriceDescendingWith60ItemsPerPage() throws InterruptedException {
        ProductPageShop productPageShop = new ProductPageShop();
        productPageShop.setItemsPerPage(60);

        List<Product> productsAsIs = productPageShop.getProducts();

        List<Product> productsAfterSorting = productPageShop.sortBy(SortDirection.PRICE_HIGH_TO_LOW).getProducts();

        Collections.sort(productsAsIs, Comparator.comparing(Product::getPrice).reversed());

        Assert.assertEquals(productsAsIs, productsAfterSorting);
    }

    @Test
    public void sortByNameAscendingWith60ItemsPerPage() throws InterruptedException {
        ProductPageShop productPageShop = new ProductPageShop();
        productPageShop.setItemsPerPage(60);

        List<Product> productsAsIs = productPageShop.getProducts();

        List<Product> productsAfterSorting = productPageShop.sortBy(SortDirection.NAME_A_TO_Z).getProducts();

        Collections.sort(productsAsIs, Comparator.comparing(Product::getName));

        Assert.assertEquals(productsAsIs, productsAfterSorting);
    }

    @Test
    public void sortByNameDescendingWith60ItemsPerPage() throws InterruptedException {
        ProductPageShop productPageShop = new ProductPageShop();
        productPageShop.setItemsPerPage(60);

        List<Product> productsAsIs = productPageShop.getProducts();

        List<Product> productsAfterSorting = productPageShop.sortBy(SortDirection.NAME_Z_TO_A).getProducts();

        Collections.sort(productsAsIs, Comparator.comparing(Product::getName).reversed());

        Assert.assertEquals(productsAsIs, productsAfterSorting);
    }
}