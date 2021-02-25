 /* By: Ricardo L. Ortega | ric623@phoenix.edu | otgcardo@yahoo.com*/
package guiinventoryprogram;

public class Brand extends InventoryProgramGui{
    
    //Private member
    private String itemBrand;

    //Constructor
    public Brand(){}
	
    //Constructor with 5 parameters
    public Brand(int itemID, String itemTitle, int itemQuantity, double itemQuality, String itemBrand) {
	super(itemID, itemTitle, itemQuantity, itemQuality);
        this.itemBrand = itemBrand;
    }

    //Computes re stock fee
    public double computeRestockFee(){
	return super.calculateInventory() * .05;
    }

    //Calculates inventory
    public double calculateInventory(){
	return super.calculateInventory() + computeRestockFee();
    }

    //Gets dvd brand 
    public String getItemBrand(){
	return itemBrand;
    }

    //Sets dvd brand
    public void setItemBrand(String itemBrand){
	this.itemBrand = itemBrand;
    }

}
