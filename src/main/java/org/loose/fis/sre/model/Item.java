package org.loose.fis.sre.model;

public class Item {
    private String name;
    private int price;

    private String size; //atribut setat la add to cart

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Item(String name, int price, String size) {
        this.name = name;
        this.price = price;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        if(!item.name.equals(name)) return false;
        return item.price == price;
    }

    @Override
    public int hashCode() {
        int result = 31*price;
        return 31*result + name.hashCode();
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
