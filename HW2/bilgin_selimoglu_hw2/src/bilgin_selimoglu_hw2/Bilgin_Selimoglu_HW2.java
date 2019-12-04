
package bilgin_selimoglu_hw2;

public class Bilgin_Selimoglu_HW2 
{
    public static void main(String[] args) 
    {
                
        Inventory myInventory = new Inventory();
         myInventory.addTransistor("hjFD",15);
        myInventory.printInventory();
        System.out.println("**********************");
         myInventory.addTransistor("ASFD",45);
        myInventory.printInventory();
        System.out.println("**********************");
         myInventory.addInductor("ASFD",15);
        myInventory.printInventory();
        System.out.println("**********************");
         myInventory.addInductor("ASFD",15);
        myInventory.printInventory();
        System.out.println("**********************");
            myInventory.addCapacitor("sgdas","dbfb",15);
        myInventory.printInventory();
        System.out.println("**********************");
            myInventory.addResistor("ghjkjhg",15);
        myInventory.printInventory();
        System.out.println("**********************"); 
        myInventory.addTransistor("ali",15);
        myInventory.printInventory();
        System.out.println("**********************");
        myInventory.addInductor("ASFD",30);
         myInventory.printInventory();
         System.out.println("**********************");
         myInventory.addResistor("516",15);
        myInventory.printInventory();
        System.out.println("**********************");
        myInventory.addInductor("sdfgh",15);
        myInventory.printInventory();
        System.out.println("**********************");
        Integer remain = myInventory.deleteTransistor("ASFD", 31);
            if (remain >= 0)
            {
                System.out.println("There are " + remain + " amount of ASFD transistor in Inventory" );
            }
        
    }
    
}
