public class ShoppingCart {

    private Item list;

    public ShoppingCart() {
        list = new Item(6);
    }

    public Item get_list() {
        return list;
    }
}