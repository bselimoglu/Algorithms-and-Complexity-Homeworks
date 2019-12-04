
package bilgin_selimoglu_hw3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RatMaze implements HW3Maze{
     // C:\Users\User\Desktop\test.txt (my path)
    static int [][] maze;
    static int m;
    static ArrayStack<Position> path ;
           
    @Override
    public void ReadMazeFromFile() {
        boolean isValidPath;
        Scanner sc;
         do{
                 
            System.out.print("Please Enter File Path: ");
            sc = new Scanner(System.in);
            String path = sc.nextLine().trim();  
            
            isValidPath = true;

            try{
                
                File file = new File(path);
                sc = new Scanner(file); 
                 LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(file));
                lineNumberReader.skip(Long.MAX_VALUE);
                int lines = lineNumberReader.getLineNumber();
                lineNumberReader.close();
                m=lines+1;
            }catch(FileNotFoundException e){
           
                isValidPath = false;
                System.out.println("File didn't found: " + e);
            } catch (IOException ex) {
                Logger.getLogger(RatMaze.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } while(isValidPath != true);
         int i=1,j=1;
         
                maze = new int[m+2][m+2];
         do{
                
                String line = sc.nextLine();
                String[] data = line.split(" ");
                for (j=1; j<=m; j++){
			   maze[i][j] = Integer.parseInt(data[j-1]);}
                i++;    
            } while (sc.hasNextLine());
         for ( i=1; i<=m; i++){
		      	for (j=1; j<=m; j++) 
		      		System.out.print(maze[i][j] + " ");
		      	System.out.println("");
	   }
         
    }

    @Override
    public void SolveMaze() {
        System.out.println("************************************");
        for (int i = 0; i <= m+1; i++) {
		      maze[0][i] = maze[m+1][i] = 0; // bottom and top
		      maze[i][0] = maze[i][m+1] = 0; // left and right
		      }

    Position [] offset = new Position[8];	
		for(int i = 0; i <= 7; i++)
			offset[i] = new Position();
		offset[0].row = -1; 
		offset[0].col = -1; // NW
		offset[1].row = 0;
		offset[1].col = -1; // W
		offset[2].row = 1; 
		offset[2].col = -1; // SW
		offset[3].row = 1; 
		offset[3].col = 0; // S    
                offset[4].row = 1; 
		offset[4].col = 1; // SE    
                offset[5].row = 0; 
		offset[5].col = 1; // E
                offset[6].row = -1; 
		offset[6].col = 1; // NE
                offset[7].row = -1; 
		offset[7].col = 0; // N
        Position here = new Position();
	Position next = new Position();
        int option = 0; // next move
	int LastOption = 7;
        int sayi = 0 ;
        path = new ArrayStack<Position>(m);
        boolean GOBACK = true;

        while (sayi<33&& GOBACK)
        {   int i=1;
            int j=1;
            int r = 0;
            int c = 0;

            if(sayi==0)//find 1
            {
                boolean isfind=false;
            for ( i=1; i<=m; i++){
		for ( j=1; j<=m; j++){
                        if (maze[i][j] == 1){
                        here.row=i;
                        here.col=j;
                        maze [i][j]=0;
                        sayi = 1;
                        //path.push(here);
                        isfind=true;
                        break;
                        }
                        else if (i==m && j==m) {System.out.println("There is no 1 which neigbour is 2");
                        GOBACK = false;
                        }
                }
                if (isfind) break;
            }
            }
            else 
            {
                 while (option <= LastOption) {
		         r = here.row + offset[option].row;
		         c = here.col + offset[option].col;
                         if (maze[r][c] == (sayi+1)) {
                             path.push(here); 
                             break;
                         }
		         option++; // next option
		         }
                 if (option <= LastOption) {// move to maze[r][c]
		    	 here = new Position (r,c);
                         here.row = r; 
		         here.col = c;
		         // set to 1 to prevent revisit
		         maze[r][c] = 0;
		         option = 0;
                         sayi++;
                         if(sayi==32){path.push(here); sayi=33;}
		         }
                 else {// no neighbor to move to, back up
                     try
                     {   here=path.pop();
		         sayi = sayi-1;
                         option = 0;
                     }
                     catch(Exception ex)
                     {		         
		         sayi = 0;
                         option = 0;
                     }

		         }
            }
        }
            
    }
        
    

    @Override
    public void PrintSolution() {
            System.out.println("The path is = ");
            Position array[] = new Position[32];      
            try 
            {
                    int i=-1;
                    while (!path.isEmpty()){
                        Position here = path.pop();
                            array[++i]=here;
                    }
                    for (int k=1,j=31;j>=0;k++,j--)
                    {System.out.print(array[j].row+":");
                     System.out.print(array[j].col+" -> ");
                    }
            }
            catch (Exception ex)
                    {
                        System.out.println("There is no path 1 to 32");
                    }
    }
    
    
}
