/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bilgin_selimoglu_hw3;

/**
 *
 * @author User
 */
public class Bilgin_Selimoglu_HW3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        RatMaze Maze = new RatMaze();
        Maze.ReadMazeFromFile();
        Maze.SolveMaze();
        Maze.PrintSolution();
    }
    
}
