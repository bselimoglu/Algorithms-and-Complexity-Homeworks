package bilgin_selimoglu_hw4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author bilgin
 */
public class Bilgin_Selimoglu_HW4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        boolean isValidPath,isValidSize;
        Scanner sc;
        String path,filename="";
        int size = 0;
        // C:\Users\User\Desktop\New Folder\Bilgin_Selimoglu_HW4\1.txt (my path)
        
        do{
            System.out.print("Please Enter The File Path or File Name \"In The Project Folder\"  : ");
            sc = new Scanner(System.in);
            path = sc.nextLine().trim();  
            isValidPath = true;
            try{
                File file = new File(path);
                sc = new Scanner(file); 
                filename = file.getName();
            }catch(FileNotFoundException e){
                isValidPath = false;
                System.out.println("File didn't found: " + e);
            }
        } while(isValidPath != true);
        do {
            System.out.print("Please enter a integer between 500 and 550 for HashTable Size: ");
            sc = new Scanner(System.in);
                try{
                    size = Integer.parseInt(sc.nextLine());
                    isValidSize = true;
                    if(500>size || size>550)
                    isValidSize = false;
                }catch(NumberFormatException e){
                    isValidSize = false;
                    System.out.println("Line error, because of size: " + size);
                }

        } while(isValidSize != true);
        
        cHash as = new cHash(size);
        as.BuildHash(filename, size);
        String bilgin="";
//      
        boolean cont = true;
        while(cont)
        {   String choice="";
            try
            {
            System.out.println("\nReady, What do you want ?");
            System.out.println("To display the words data in a text file ================press>*1*\n"
                             + "To see the most repeated word ===========================press>*2*\n"
                             + "To sort the words in the text in increasing order =======press>*3*\n"
                             + "To get any data about a word ============================press>*4*\n"
                             + "To quit please ==========================================press>*5*");
            sc = new Scanner(System.in);
            choice = sc.nextLine().trim();
            
            if(Integer.parseInt(choice) == 1)
            {

                System.out.print("Please enter the text file name which will be created:  ");
                bilgin = sc.nextLine().trim();
                as.Display(bilgin);
            }
            else if((Integer.parseInt(choice) == 2))
            {
                if("".equals(as.ShowMax())){System.out.println("text is empty!");} 
                else 
                    System.out.println(as.ShowMax());
            }
            else if((Integer.parseInt(choice) == 3))
            {
                System.out.print("Please enter the text file name which will be created:  ");
                bilgin = sc.nextLine().trim(); 
                as.Sort(bilgin);
            }
            else if ((Integer.parseInt(choice) == 4)) {
                System.out.print("Please enter the word that is searced : ");
                sc = new Scanner(System.in);
                String wordd = (sc.nextLine().trim());
                int a[]= as.CheckWord(wordd);
                if(a[0]!=-1)
                {
                    System.out.print("\n"+wordd+ " is found at position(s): ");
                    for (int t=0;t<(as.NumofWord(wordd)-1);t++){System.out.print(a[t]+",  ");}System.out.print(a[as.NumofWord(wordd)-1]+".");
                    System.out.print( " Number of repetition = "+as.NumofWord(wordd)+".\n"); 
                }
                else
                    System.out.println("\n"+wordd+ " is not found. ");
            }
            else if((Integer.parseInt(choice) == 5)){cont = false;}
            }catch(NumberFormatException e){
                     System.out.println("\nLine error, because of entered value it must be integer, entered word is: " + choice);
            }
        }
    }
    
}
