/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package list.csc229_hw5;

/**
 *
 * @author nicholasshah
 */
/**
 * The Purchase class stores information about a purchase
 * at a store.
 * @author nicholasshah
 */
public class Purchase {
    private String itemName;                        
    private double quantity;
    private double itemPrice;
    /**
     * The default constructor assigns null to all member variables.
     */
    public Purchase(){
        itemName = " ";
        quantity = 0.0;
        itemPrice = 0.0;
    }
    /**
     * This constructor accepts a String and two doubles and assigns those values
     * to the item name, price and quantity.
     * @param n - String representing item name.
     * @param q - Double representing the quantity of that item
     * @param p - Double representing the price of the item.
     */ 
    public Purchase(String n, double q, double p){
        itemName = n;
        quantity = q;
        itemPrice = p;
    }
    /**
     * This constructor creates a copy by passing through a purschase object
     * and assigning each member variable to a new copy.
     * @param other - name of old purchase object being copied. 
     */
    public Purchase(Purchase other){
        this.itemName = other.itemName;
        this.quantity = other.quantity;
        this.itemPrice = other.itemPrice;
    }
    /**
     * gets Item name.
     * @return - Name of item
     */
    public String getItemName(){
        return itemName;
    }
    /**
     * Gets quantity.
     * @return - the available number of that object
     */
    public double getQuantity(){
        return quantity;
    }
    /**
     * Gets the price of the item.
     * @return - price value for the object
     */
    public double getItemPrice(){
        return itemPrice;
    }
    /**
     * Sets a passed through string to be the name of object.
     * @param n - String representing item name
     */
    public void setItemName(String n){
        itemName = n;
    }
    /**
     * Sets a passed through number to be quantity of object.
     * @param q - Double representing quantity.
     */
    public void setQuantity(double q){
        quantity = q;
    }
    /**
     * Sets a passed through number to represent price of object.
     * @param p - Double representing Item Price.
     */
    public void setItemPrice(double p){
        itemPrice = p;
    }
    /**
     * This method multiples the price and quantity of the object
     * to calculate the total cost.
     * @return - The product of quantity and itemPrice.
     */
    public double cost(){
        double cost = itemPrice * quantity;
        return cost;
    }
    /**
     * This method compares the values of two objects to see if they
     * are identical to each other.
     * @param p - Old object being passed through
     * @return - Boolean value representing if objects are identical.
     */
    @Override
    public boolean equals(Object p){
      
        if ((!this.itemName.equals(((Purchase)p).getItemName()) || this.quantity !=((Purchase)p).quantity) 
            || this.itemPrice != ((Purchase)p).itemPrice)
                return false;
        else return true;
    }
    /**
     * This method creates a new instance of Purchase and creating it
     * using the current variables from that instance.
     * @return - Copy of original object purchase.
     */
    public Purchase makeCopy(){
        
        Purchase p;
        p = new Purchase(this.itemName,this.quantity,this.itemPrice);
        return p;
    }
}


