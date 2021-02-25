 /* By: Ricardo L. Ortega | ric623@phoenix.edu | otgcardo@yahoo.com*/
package guiinventoryprogram;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class GUIInventoryProgram extends JFrame implements ActionListener{
    private static DecimalFormat currency = new DecimalFormat("$#,##0.00");

    private GuiLogo guiLogo;
    private JTextArea itemData;
    private JButton firstItem, prevItem;
    private JButton nextItem, lastItem;
    private JButton addItem, removeItem;
    private JButton editItem, saveItems, searchItem;

    private ArrayList<Brand> DVDMovies;
    private int current = 0;

    public static void main(String[] args){
	new GUIInventoryProgram();
    }

    public GUIInventoryProgram(){
	DVDMovies = new ArrayList<Brand>();

	//This DVD movies will be added to the gui
	DVDMovies.add(new Brand(1, "The Walking Dead S1-4", 950, 50.00, "Stargate"));
	DVDMovies.add(new Brand(2, "The Social Network", 625, 13.00, "Trigger Street"));
	DVDMovies.add(new Brand(3, "22 Jump Street", 1024, 30.45, "Lord Miller"));
	DVDMovies.add(new Brand(4, "Bad Neighbors", 1900, 32.23, "Good Universe"));
	DVDMovies.add(new Brand(5, "The Final", 733, 15.25, "Agora Entertainment"));

	// Call your sortArray method to sort the Supplier array.
	sortArray();
	initGUI();
    }

    private void initGUI(){
	setTitle("Rics DVD Collection");
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setSize(690, 330);
	setLocationRelativeTo(null);

	guiLogo = new GuiLogo();
	guiLogo.setPreferredSize(new Dimension(getWidth(), 60));
	guiLogo.setFont(new Font("Times New Roman", Font.BOLD, 32));
	itemData = new JTextArea(12, 40);
	firstItem = new JButton("First");
	firstItem.addActionListener(this);
	prevItem = new JButton("Prev");
	prevItem.addActionListener(this);
	nextItem = new JButton("Next");
	nextItem.addActionListener(this);
	lastItem = new JButton("Last");
	lastItem.addActionListener(this);
	addItem = new JButton("Add");
	addItem.addActionListener(this);
	removeItem = new JButton("Remove");
	removeItem.addActionListener(this);
	editItem = new JButton("Edit");
	editItem.addActionListener(this);
	saveItems = new JButton("Save");
	saveItems.addActionListener(this);
	searchItem = new JButton("Search");
	searchItem.addActionListener(this);

	setLayout(new BorderLayout());

	JPanel jp = new JPanel(new FlowLayout());
	jp.add(firstItem);
	jp.add(prevItem);
	jp.add(nextItem);
	jp.add(lastItem);
	jp.add(addItem);
	jp.add(editItem);
	jp.add(removeItem);
	jp.add(searchItem);
	jp.add(saveItems);

	add(guiLogo, BorderLayout.NORTH);
	add(new JScrollPane(itemData), BorderLayout.CENTER);
	add(jp, BorderLayout.SOUTH);

	setVisible(true);
	displayItem();
    }

    //Calculates entire inventory
    public double calculateInventory(){
	double value = 0;
            for (int x = 0; x < DVDMovies.size(); x++){
		value += DVDMovies.get(x).calculateInventory();
            }
        return value;
    }

    //Sorts DVDMovies by title
    public void sortArray(){
	int dSize = DVDMovies.size(); // size;
	boolean swapped;
	do{
            swapped = false;
            for(int x = 0; x < dSize - 1; x++){
		Brand b1 = DVDMovies.get(x);
		String name1 = b1.getItemTitle();
		Brand b2 = DVDMovies.get(x + 1);
		String name2 = b2.getItemTitle();
		if(name1.compareToIgnoreCase(name2) > 0){
                    Brand b = b1;
                    DVDMovies.set(x, b2);
                    DVDMovies.set(x + 1, b);
                    swapped = true;
		}
            }
	dSize = dSize - 1;
	}while (swapped);
    }

    
    //Logical conditions in here...
    @Override
    public void actionPerformed(ActionEvent e){
	if(firstItem.equals(e.getSource())){
            displayFirstItem();
        }else if(prevItem.equals(e.getSource())){
            displayPreviousItem();
        }else if(nextItem.equals(e.getSource())){
            displayNextItem();
        }else if(lastItem.equals(e.getSource())){
            displayLastItem();
        }else if(addItem.equals(e.getSource())){
            addItem();
        }else if(removeItem.equals(e.getSource())){
            removeItem();
        }else if(editItem.equals(e.getSource())){
            editItem();
        }else if(searchItem.equals(e.getSource())){
            seachItem();
        }else if(saveItems.equals(e.getSource())){
            saveItems();
        }
    }

    private void saveItems(){
	File f;
        f = new File("c:\\data");
	if(!f.exists()){
            f.mkdir(); //mkdir - Make Directory, Create a folder basically...
	}

	f = new File("c:\\data\\inventory.dat");
	if(f.exists()){
            f.delete();
	}

	try{
            f.createNewFile();
	}catch(IOException e){
            JOptionPane.showMessageDialog(null, "Failed to initialize inventory file.");
            return;
	}

	BufferedWriter writer;
	try{
            writer = new BufferedWriter(new FileWriter(f));
	}catch(IOException e){
            JOptionPane.showMessageDialog(null, "Could not initialize inventory file.");
            return;
	}

	String s;
	for(int x = 0; x < DVDMovies.size(); x++){
            Brand brand = DVDMovies.get(x);
            s = brand.getItemTitle() + "\t";
            s += brand.getItemID() + "\t";
            s += brand.getItemQuality() + "\t";
            s += brand.getItemQuantity() + "\t";
            s += brand.getItemBrand() + "\n";

            try{
                writer.write(s);
            }catch(IOException e){
		JOptionPane.showMessageDialog(null, "Could not write in inventory file.");
            }
	}

        try{
            writer.close();
	}catch(IOException e){
            JOptionPane.showMessageDialog(null, "Could not close inventory file.");
	}

	JOptionPane.showMessageDialog(null, "File Saved!");
    }

    private int findByProductName(String name){
        int index = -1;
	for(int x = 0; x < DVDMovies.size(); x++){
            Brand product = DVDMovies.get(x);
		if (product.getItemTitle().equalsIgnoreCase(name)) {
                    index = x;
                    break;
		}
            }
	return index;
    }

    private void seachItem(){
	String productName = JOptionPane.showInputDialog("Enter product name");
        
        //Search dvd array if title exist
        if(productName != null){
            int index = findByProductName(productName);

            if(index != -1){
                current = index;
		displayItem();
            }else{
		JOptionPane.showMessageDialog(null, "Product: " + productName+ " does not exist.");
            }
	}
    }

    private void editItem(){
	if(current != -1){
            String title   = promptString("Enter product name");
            int quantity   = promptInteger("Enter number of units");
            double quality = promptDouble("Enter product price");
            String brand   = promptString("Enter brand name");

            Brand brandType = DVDMovies.get(current);
            brandType.setItemTitle(title);
            brandType.setItemQuantity(quantity);
            brandType.setItemQuality(quality);
            brandType.setItemBrand(brand);

            displayItem();
	}
    }

    private void displayLastItem(){
	current = DVDMovies.size() - 1;
	displayItem();
    }

    //Next item
    private void displayNextItem(){
	current++;
	if(current > DVDMovies.size() - 1){
            current = 0;
	}
        displayItem();
    }

    //Previous item
    private void displayPreviousItem(){
        current--;
	if(current < 0){
            current = DVDMovies.size() - 1;
        }
	displayItem();
    }

    //Show first item
    private void displayFirstItem(){
	current = 0;
	displayItem();
    }

    private String prompt(String message){
	return JOptionPane.showInputDialog(this, message);
    }

    private String promptString(String message){
	String data = null;
            do{
		data = prompt(message);
            }while(data == null);
        return data;
    }

    private int promptInteger(String message){
	int data = 0;
	boolean isValid = false;
	do{
            String dataString = prompt(message);
            if(dataString != null){
		try{
                    data = Integer.parseInt(dataString);
                    isValid = true;
		}catch(Exception e){
                    isValid = false;
		}
            }
	}while (!isValid);
	return data;
    }

    private double promptDouble(String message){
	double data = 0;
            boolean isValid = false;
            do{
		String dataString = prompt(message);
		if(dataString != null){
                    try{
			data = Double.parseDouble(dataString);
                        isValid = true;
                    }catch(Exception e) {
			isValid = false;
                    }
		}
            }while(!isValid);
	return data;
    }

    //Get information
    private void addItem() {
	String title = promptString("Enter product name");
	int quantity = promptInteger("Enter number of units");
	double quality = promptDouble("Enter product price");
	String brand = promptString("Enter product brand");

	Brand b = new Brand();
	b.setItemTitle(title);
	
        if(DVDMovies.size() > 0){
            Brand lastProduct = DVDMovies.get(DVDMovies.size() - 1);
            b.setItemID(lastProduct.getItemID() + 1);
	}else{
            b.setItemID(1);
        }
	
        b.setItemQuality(quality);
	b.setItemQuantity(quantity);
	b.setItemBrand(brand);
	DVDMovies.add(b);

	displayLastItem();
    }

    //Removes the listing
    private void removeItem(){
	if(DVDMovies.size() > 0){
            DVDMovies.remove(current);
            displayLastItem();
	}
    }

    //Display everything to gui now
    private void displayItem(){
	if(current >= 0){
            Brand supplier = DVDMovies.get(current);
            StringBuilder sb = new StringBuilder();
            sb.append("Item Number: " + supplier.getItemID() + "\n");
            sb.append("Product Name: " + supplier.getItemTitle() + "\n");
            sb.append("Units In Stock: " + supplier.getItemQuantity() + "\n");
            sb.append("Unit Price: " + currency.format(supplier.getItemQuality()) + "\n");
            sb.append("Brand Name: " + supplier.getItemBrand() + "\n");
            sb.append("Value of Inventory: " + currency.format(supplier.calculateInventory()) + "\n");
            sb.append("Restock Fee: " + currency.format(supplier.computeRestockFee()) + "\n");
            sb.append("\nValue of entire inventory: " + currency.format(calculateInventory()));
            itemData.setText(sb.toString());
	}else{
            itemData.setText(null);
	}
    }
}
