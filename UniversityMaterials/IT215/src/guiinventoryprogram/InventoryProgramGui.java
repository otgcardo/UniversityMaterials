 /* By: Ricardo L. Ortega | ric623@phoenix.edu | otgcardo@yahoo.com*/
package guiinventoryprogram;

/*
    Ricardo L. Ortega
    University of Phoenix
    Inventory Program Part 6
*/

//This is where the members and objects are declared...

public class InventoryProgramGui{
    private int    itemID;
    private String itemTitle;
    private int    itemQuantity;
    private double itemQuality;

    //Default constructor
    public InventoryProgramGui(){}

    //Constructor with paramters
    public InventoryProgramGui(int itemID, String itemTitle, int itemQuantity, double itemQuality) {
	this.itemID       = itemID;
	this.itemTitle    = itemTitle;
	this.itemQuantity = itemQuantity;
	this.itemQuality  = itemQuality;
    }

    //Get value of inventory
    public double calculateInventory() {
        return this.itemQuantity * this.itemQuality;
    }

    //Get item id
    public int getItemID() {
        return itemID;
    }

    //Get item title
    public String getItemTitle() {
	return itemTitle;
    }

    //Get item quantity
    public int getItemQuantity() {
	return itemQuantity;
    }

    //Set item quality
    public double getItemQuality() {
	return itemQuality;
    }

    //Set item id
    public void setItemID(int itemID) {
	this.itemID = itemID;
    }

    //Set item title
    public void setItemTitle(String itemTitle) {
	this.itemTitle = itemTitle;
    }

    //Set item quantity
    public void setItemQuantity(int itemQuantity) {
	this.itemQuantity = itemQuantity;
    }

    //Set item price
    public void setItemQuality(double itemQuality) {
        this.itemQuality = itemQuality;
    }
}
