package bilgin_selimoglu_hw4;

/**
 *
 * @author bilgin
 */
import java.lang.Integer;
public class Words 
{ 
        String string;
        Integer amount = 1;
        int order[];
        int arrayindex = 0;
        
        public Words(String x, int o)
        {
        this.order = new int[10000];
            this.string = x ;
            this.order[0]=o ;
        }
        
        public void updateword(int norder)
        {
            try{    
            arrayindex = arrayindex+1;
            amount = amount+1;
            order[arrayindex] = norder;
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Array size not enough..");
            }   
        }
        
        public void yazdir()
        {
            System.out.print("Word Name, Frequency and Order :" + string + " | " + amount + " | "/* + (order+1)*/);
            for (int j =0 ; j<amount-1; j++)
            {
                System.out.print(order[j]+",  ");
            }
            System.out.print(order[amount-1]+".\n");
        }
}
