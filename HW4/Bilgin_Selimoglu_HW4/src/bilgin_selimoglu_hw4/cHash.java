package bilgin_selimoglu_hw4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author bilgin
 */
public class cHash implements HW4_Interface{
     public class Node {
        public Words word;
        public Node next;
        public Node(){
            next = null;
            
        }
    }  

    final  Node[] hashTable;
    int size,size2=0; 
    
    public cHash(int size)
    {                                             
        this.size = size;  
        this.hashTable = new Node[size];
    }
    
    
    public boolean IsEmpty(Node kelime){
        if (kelime == null)  return true;
        else  return false;
    }
    @Override
    
    
    public void BuildHash(String filename, int size) 
    {    File file = new File(filename);
    String fileContent="";
    byte[] bf = new byte[(int)file.length()];
    try {
        new FileInputStream(file).read(bf);
    } catch (FileNotFoundException ex) {
        System.out.println("File didn't found is it in project folder: ");
//        Logger.getLogger(cHash.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
       System.out.println("Errorr!!! "+ ex);
    }
    try {
        fileContent = new String(bf, "UTF-8");
    } catch (UnsupportedEncodingException ex) {
        System.out.println("Errorr!!! "+ ex);
    }
    String[] data = fileContent.split("[\\s\\-\\.\\=\\:\\/\\(|\\)\\?\\,\\_\\@\\[|\\]]+");//"[\\s\\-\\.\\'\\?\\,\\_\\@\\[|\\]]+"   data arrayi kelimeler burda..
    for(int i=0;i<data.length;i++){
        InsertHash(data[i], i);
    }
    }
    @Override
   
    
    public long ConvertInt(String mystring) 
    {
        int intLength = mystring.length() / 4;
        long sum = 0;
        for (int j = 0; j < intLength; j++) 
        {
            char c[] = mystring.substring(j * 4, (j * 4) + 4).toCharArray();
            long multiplier = 1;
            for (int k = 0; k < c.length; k++)
            {
                sum += c[k] * multiplier;
                multiplier *= 256;
            }
        }
        char c[] = mystring.substring(intLength * 4).toCharArray();
        long multiplier = 1;
        for (int k = 0; k < c.length; k++) 
        {
            sum += c[k] * multiplier;
            multiplier *= 256;
        }
        return sum;
    }
    @Override
    
    
    public int FindHash(long myvalue)
    {
        return(int) (Math.abs(myvalue) % size);
    }
    @Override
   
    
    public void InsertHash(String mystring,int order) 
    {
        long getlong = ConvertInt(mystring);
        int getint = FindHash(getlong);
        boolean IsInsert = true;
        Node yeni = new Node();
        Words nword = new Words(mystring,(order+1));
        yeni.word = nword;
        Node pointer = hashTable[getint];
        if(IsEmpty(pointer)){
            hashTable[getint] = yeni;
            yeni.next = null;
            yeni.word = nword ;
            IsInsert = false;
            size2++;
        }
        while(IsInsert)
        {
            if(pointer.word.string.equals(mystring))
            {
                pointer.word.updateword((order+1));
                IsInsert = false;
            }
            else if(!pointer.word.string.equals(mystring) && pointer.next==null)
            {
                pointer.next = yeni;
                yeni.next = null;
                IsInsert = false;
                size2++;
            }
            else 
                pointer = pointer.next;
        }
    }
    @Override
   
    
    public void Display(String Outputfile) 
    {   
        Node[] sirala = new Node[size2];
        for (int j=0,i=0; i<size; i++)
        {   
            Node pointer = hashTable[i];
            for (; pointer!= null; j++)
            {
                sirala[j]=pointer;
                pointer= pointer.next;
            }
        }
        try{
            // Create new file
            String path= "C:\\Users\\User\\Desktop\\New Folder\\Bilgin_Selimoglu_HW4\\"+Outputfile+".txt";
            File file = new File(path);
            // If file doesn't exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            // Write in file
            for (int j=0; j<size2; j++)
        {   
            bw.write((j+1)+"-) "+"'"+sirala[j].word.string+"'"+" , FREQUENCY: "+sirala[j].word.amount+" , POSITION : ");
            for (int k =0 ; k<sirala[j].word.amount-1; k++)
            {
            bw.write((sirala[j].word.order[k])+",  ");
            }
            bw.write((sirala[j].word.order[sirala[j].word.amount-1])+".\n");
            bw.newLine();
            bw.write("==========================================================================================================");
            bw.newLine();
        }

            // Close connection
            bw.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
        for (int j=0; j<size; j++)
        {
             
            Node pointer=hashTable[j];
            while(pointer!=null)
            {
                pointer.word.yazdir();
                pointer=pointer.next;
            }
        }
        
    }
    @Override
    
    
    public int NumofWord(String myword) 
    {
        long getlong = ConvertInt(myword);
        int getint = FindHash(getlong);
        Node pointer=hashTable[getint];
        while(pointer!=null)
        {
            if (pointer.word.string.equals(myword))
            {
                return pointer.word.amount;
            }
            else if (pointer.next == null) 
                break;
            pointer = pointer.next;
        }
        return -1;
    }

    @Override
    public String ShowMax() 
    {   
        String donecek="";
        int dummy = 0;
        for (int j=0; j<size; j++)
        {
             
            Node pointer=hashTable[j];
            
            while(pointer!=null)
            {   
                if (pointer.word.amount>dummy)
                {
                    dummy = pointer.word.amount ;
                    donecek = pointer.word.string;
                }
                else
                    pointer=pointer.next;
            }
        }
        return donecek;
    }

    @Override
    public int[] CheckWord(String myword) 
    {
        long getlong = ConvertInt(myword);
        int getint = FindHash(getlong);
        Node pointer=hashTable[getint];
        while(pointer!=null)
        {
            if (pointer.word.string.equals(myword))
            return (pointer.word.order);
            else if (pointer.next == null) 
                break;
            pointer = pointer.next;
        }
        return new int[]{-1};
    }

    @Override
    public void Sort(String Outfile) 
    {
        Node[] sirala = new Node[size2];
        for (int j=0,i=0; i<size; i++)
        {   
            Node pointer = hashTable[i];
            for (; pointer!= null; j++)
            {
                sirala[j]=pointer;
                pointer= pointer.next;
            }
        }
        sirala = bubbleSort(sirala);
        for (int j=0; j<size2; j++)
        {
             
            System.out.print((j+1)+"  ");
            sirala[j].word.yazdir();
        }
        try{
            // Create new file
            String path="C:\\Users\\User\\Desktop\\New Folder\\Bilgin_Selimoglu_HW4\\"+Outfile+".txt";
            File file = new File(path);

            // If file doesn't exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);

            // Write in file
            for (int j=0; j<size2; j++)
        {
                bw.write((j+1)+"-) "+"'"+sirala[j].word.string+"'"+" , FREQUENCY: "+sirala[j].word.amount+" , POSITION : ");
                for (int k =0 ; k<sirala[j].word.amount-1; k++)
                {
                    bw.write((sirala[j].word.order[k])+",  ");
                }
                bw.write((sirala[j].word.order[sirala[j].word.amount-1])+".\n");
                bw.newLine();
                bw.write("==========================================================================================================");
                bw.newLine();
        }
            // Close connection
            bw.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
        }
    public  Node [] bubbleSort(Node[] data1) {

        for (int i = size2; i > 1; i--) {
            for (int j = 0; j < i - 1; j++) {
                if (data1[j].word.amount > data1[j + 1].word.amount) {

                    /* SORT DATA */
                    Node dummy = data1[j];
                    data1[j] = data1[j + 1];
                    data1[j + 1] = dummy;
                }
            }
        }
        return data1;
    }
}
