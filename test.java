
/**
 * Write a description of class test here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;

public class test
{
    int lastMove; // 1 = up, 2 = down, 3 = left, 4 = right
    int grid[][] = new int[4][4];
    ArrayList<Integer> upX = new ArrayList<Integer>(4);
    ArrayList<Integer> upY = new ArrayList<Integer>(4);
        
    ArrayList<Integer> downX = new ArrayList<Integer>(4);
    ArrayList<Integer> downY = new ArrayList<Integer>(4);
        
    ArrayList<Integer> leftX = new ArrayList<Integer>(4);
    ArrayList<Integer> leftY = new ArrayList<Integer>(4);
    
    ArrayList<Integer> rightX = new ArrayList<Integer>(4);
    ArrayList<Integer> rightY = new ArrayList<Integer>(4);
    
    Scanner input = new Scanner(System.in);
    public test(){
        spawnNew();
        drawGrid();
    }
    
    public void chooseNextMove(){
        System.out.println("What would you like to do? u, d. l, r");
        char nextMove = input.next().charAt(0);
        switch (nextMove) {
            case 'u': // up
                calculateUp();
                break;
            case 'd': // down
                lastMove = 2;
                calculateDown();
                break;
            case 'l': // left
                lastMove = 3;
                calculateLeft();
                break;
            case 'r': // right
                lastMove = 4;
                calculateRight();
                break;
            default : // nothing done
                chooseNextMove();
        }
    }
    
    public void calculateUp(){ // takes every position,notes if it is not null
        System.out.println("UP");
        spawnNew();
    }
    
    public void calculateDown(){
        System.out.println("DOWN");
        spawnNew();
    }
    
    public void calculateLeft(){
        System.out.println("LEFT");
        spawnNew();
    }
    
    public void calculateRight(){
        //System.out.println("RIGHT");
    for (int x = 0; x < 4; x++){ // finds things that arent 0 on line one
        if (grid[x][0] != 0){
            rightX.add(x); // adds things that arent 0 to a arraylist
        }
    }
        //moves things on the second line right
        //moves things on the third line right
        //moves things on the fourth line right
        spawnNew();
    }
    
    public void spawnNew(){
        Random rng = new Random();
        int spawnX = rng.nextInt(4);
        int spawnY = rng.nextInt(4);
        if (grid[spawnX][spawnY] != 0){
            spawnNew();
        } else {
            grid[spawnX][spawnY] = 2;
        }
        drawGrid();
    }
    
    public void drawGrid(){
        //System.out.print("\f");
        System.out.println("<-2048->");
        System.out.println();
        for (int x = 0; x < 4; x++){
            for (int y = 0; y < 4; y++){
                System.out.print(grid[x][y]);
            }
            System.out.println();
        }
        chooseNextMove();
    }
}
