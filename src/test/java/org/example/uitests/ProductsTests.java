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
    public void changeItemsPerPage() throws InterruptedException {
        ProductPageShop productPageShop = new ProductPageShop();
        productPageShop.setItemsPerPage(60);

        List<Product> productList = productPageShop.getProducts();
        Assert.assertEquals(productList.size(), 30);
    }

    @Test
    public void checkSortingTest() throws InterruptedException {
        ProductPageShop productPageShop = new ProductPageShop();
        List<Product> productsAsIs = productPageShop.getProducts();

        List<Product> productsAfterSorting = productPageShop.sortBy(SortDirection.PRICE_LOW_TO_HIGH).getProducts();

        Collections.sort(productsAsIs, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getPrice().compareTo(o2.getPrice());
            }
        });

        Assert.assertEquals(productsAsIs, productsAfterSorting);
    }

    @Test
    public void customSortingTest() throws InterruptedException {
        ProductPageShop productPageShop = new ProductPageShop();
        List<Product> productsAsIs = productPageShop.getProducts();

        List<Product> productsAfterSorting = productPageShop.sortBy(SortDirection.PRICE_HIGH_TO_LOW).getProducts();

        Collections.sort(productsAsIs, Product.getComparatorForSorting(SortDirection.PRICE_HIGH_TO_LOW));

        Assert.assertEquals(productsAsIs, productsAfterSorting);
    }

}