/**
 * Class for item.
 */
class Item {
    /**
     * { item name }.
     */
    String item;
    int quantity;
    float price;
    /**
     * Constructs the object.
     *
     * @param      item      The item
     * @param      quantity  The quantity
     * @param      price     The price
     */
    Item(String item, int quantity, float price) {
        this.item = item;
        this.quantity = quantity;
        this.price = price;

    }
    /**
     * Constructs the object.
     *
     * @param      item      The item
     * @param      quantity  The quantity
     */
    Item(String item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }
    /**
     * { returns item }.
     *
     * @return     { description_of_the_return_value }
     */
    public String getitem() {
        return this.item;
    }
    /**
     * { returns quantity }.
     *
     * @return     { description_of_the_return_value }
     */
    public int getquantity() {
        return this.quantity;
    }
    /**
     * { returns price }.
     *
     * @return     { description_of_the_return_value }
     */
    public double getprice() {
        return this.price;
    }
    /**
     * { returns string format }
     *
     * @return     { description_of_the_return_value }.
     */
    public String display() {
        return (this.item + " " + this.quantity + " " + this.price);
    }
    /**
     * { returns string format }.
     *
     * @return     { description_of_the_return_value }
     */
    public String tostring() {
        return (this.item + " " + this.quantity);
    }
}