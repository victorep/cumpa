package me.vepu.cumpa.app.datamodel;

import java.util.Scanner;

public class GroceryItem implements IGroceryItem{
    private  String name;
    private  int units;

    static Scanner  scanner = new Scanner(System.in);

    public GroceryItem() {
    }

    public GroceryItem(String name, int units) {
        this.name = name;
        this.units = units;
    }

    public String getName() {
        return name;
    }

    public void setName(String itemName) {
        this.name = itemName;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public  void getItemDetailsCLI(){
        System.out.println("=== Input item details ===");
        System.out.print("Name: ");
        setName( scanner.nextLine());
        System.out.print("Units : ");
        setUnits(scanner.nextInt());
        scanner.nextLine();
        System.out.println("======= End input ========");
    }

    @Override
    public String toString() {
        String output=new String();
        output+=(getName() + " x " + getUnits());
        return output;
    }
}
