package bilgin_selimoglu_hw1;

import java.io.File; 
import java.io.FileNotFoundException;
import java.util.Scanner; 

public class Bilgin_Selimoglu_HW1 {

    public static void main(String[] args) {
        
        boolean isValidPath;
        Scanner sc;
        
        // C:\Users\User\Desktop\test.txt (my path)
        
        do{
                 
            System.out.print("Please Enter File Path: ");
            sc = new Scanner(System.in);
            String path = sc.nextLine().trim();  
            
            isValidPath = true;

            try{
                
                File file = new File(path);
                sc = new Scanner(file); 
                
            }catch(FileNotFoundException e){
           
                isValidPath = false;
                System.out.println("File didn't found: " + e);
            }
            
        } while(isValidPath != true);
                       
        int numberOfStudents = Integer.parseInt(sc.nextLine());
        
        StudentBase base = new StudentBase(numberOfStudents);

        for(int i= 0; i<numberOfStudents; i++){
            if(sc.hasNextLine()){
                
                String line = sc.nextLine();
                String[] data = line.split(" ");
                
                try{
                    
                    long id = Long.parseLong(data[0]);
                    String name = data[1];
                    String surname = data[2];
                    int age = Integer.parseInt(data[3]);
                    int year = Integer.parseInt(data[4]);

                    Student student = new Student(id, age, year, name, surname);
                    base.addStudent(student, i);
                    
                }catch(NumberFormatException e){
                    
                    System.out.println("Line Error: " + line);
                }
            }
        }
        
        base.sort_ID();
        base.sort_Age();
        base.sort_Year();              
    }  
}
