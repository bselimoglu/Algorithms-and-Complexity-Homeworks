
package bilgin_selimoglu_hw2;

public interface InventoryInterface {
        public void addResistor(String val, Integer cnt );
        public void addCapacitor(String val, String typ, Integer cnt );
        public void addInductor(String val, Integer cnt );
        public void addTransistor(String typ, Integer cnt );
        public int deleteResistor(String val, Integer cnt ); //returns amount of
        //resistors in the inventory otherwise returns -1
        public int deleteCapacitor(String val, String typ, Integer cnt);
        //returns amount of capacitors in the inventory otherwise returns -1
        public int deleteInductor(String val, Integer cnt ); //returns amount of
        //inductors in the inventory otherwise returns -1
        public int deleteTransistor(String typ, Integer cnt ); //returns amount
        // of Transistors in the inventory otherwise returns -1
        public void printInventory(); // Prints the every device with their
        // types /values/count in group of chunks
}
