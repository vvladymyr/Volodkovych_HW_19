package org.example.uitests.pages.shop_main;

public enum SortDirection {
    NAME_A_TO_Z("name:asc"),
    NAME_Z_TO_A("name:desc"),
    PRICE_LOW_TO_HIGH("price:asc"),
    PRICE_HIGH_TO_LOW("price:desc");

    private String value;
    SortDirection(String value) {
        this.value = value;
    }

    String getValue() {
        return this.value;
    }
}
