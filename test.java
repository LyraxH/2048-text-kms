
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
    Random rng = new Random();
    public test(){
        /*
        grid[0][0] = 1;
        grid[0][1] = 2;
        grid[0][2] = 3;
        grid[0][3] = 4;
        grid[1][0] = 5;
        grid[1][1] = 6;
        grid[1][2] = 7;
        grid[1][3] = 8;
        grid[2][0] = 9;
        grid[2][1] = 10;
        grid[2][2] = 11;
        grid[2][3] = 12;
        grid[3][0] = 13;
        grid[3][1] = 14;
        grid[3][2] = 15;
        grid[3][3] = 16;
        */
        spawnNew();
        drawGrid();
    }
    
    public void chooseNextMove(){
        //System.out.println("What would you like to do? u, d. l, r");
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
    
    public void calculateUp(){ // calculates moves up
        System.out.println("UP");
        spawnNew();
    }
    
    public void calculateDown(){ // calculates moves down
        System.out.println("DOWN");
        spawnNew();
    }
    
    public void calculateLeft(){ // calculates moves to the left
        System.out.println("LEFT");
        spawnNew();
    }
    
    public void calculateRight(){ // calculates moves to the right
        // top line
        checkNumbers(0,2, 0,3);
        checkNumbers(0,1, 0,3);
        checkNumbers(0,0, 0,3);
        checkNumbers(0,1, 0,2);
        checkNumbers(0,0, 0,2);
        checkNumbers(0,0, 0,1);
        // second line
        checkNumbers(1,2, 1,3);
        checkNumbers(1,1, 1,3);
        checkNumbers(1,0, 1,3);
        checkNumbers(1,1, 1,2);
        checkNumbers(1,0, 1,2);
        checkNumbers(1,0, 1,1);
        // third line
        checkNumbers(2,2, 2,3);
        checkNumbers(2,1, 2,3);
        checkNumbers(2,0, 2,3);
        checkNumbers(2,1, 2,2);
        checkNumbers(2,0, 2,2);
        checkNumbers(2,0, 2,1);
        // fourth line
        checkNumbers(3,2, 3,3);
        checkNumbers(3,1, 3,3);
        checkNumbers(3,0, 3,3);
        checkNumbers(3,1, 3,2);
        checkNumbers(3,0, 3,2);
        checkNumbers(3,0, 3,1);
        
        checkZeros(0);
        spawnNew();
    }
    
    public void checkZeros(int line){
    }
    
    public void checkNumbers(int prevX, int prevY, int nextX, int nextY){
        int current = grid[prevX][prevY];
        int checking = grid[nextX][nextY];
        if (current == checking){ // checking is the same as the next one over
            switch (checking){ // merge
                case 2:
                    System.out.println("merging 2");
                    grid[prevX][prevY] = 0;
                    grid[nextX][nextY] = 4;
                    break;
                case 4:
                    System.out.println("merging 4");
                    grid[prevX][prevY] = 0;
                    grid[nextX][nextY] = 8;
                    break;
                case 8:
                    System.out.println("merging 8");
                    grid[prevX][prevY] = 0;
                    grid[nextX][nextY] = 16;
                    break;
                case 16:
                    System.out.println("merging 16");
                    grid[prevX][prevY] = 0;
                    grid[nextX][nextY] = 32;
                    break;
                case 32:
                    System.out.println("merging 32");
                    grid[prevX][prevY] = 0;
                    grid[nextX][nextY] = 64;
                    break;
                case 64:
                    break;
                case 128:
                    break;
                case 256:
                    break;
                case 512:
                    break;
                case 1024:
                    break;
                case 2048:
                    //winGame();
                    break;
                case 0:
                    
                    break;
            }
        } else { // IF THEY are different
            switch (checking){
                case 0: // and the checking is a 0
                    grid[nextX][nextY] = grid[prevX][prevY]; // set the 0 to the previous one
                    grid[prevX][prevY] = 0; // set the pervious one to 0
                    break;
            }
        }
    }
    
    public void spawnNew(){
        int spawnX = rng.nextInt(4);
        int spawnY = rng.nextInt(4);
        if (grid[spawnX][spawnY] != 0){
            try {
                 spawnNew();
            } catch (Exception e){
                gameOver();
            }
        } else {
            grid[spawnX][spawnY] = 2;
            System.out.println("Spawned in " + spawnX + ", " + spawnY);
        }
        drawGrid();
    }
    
    public void gameOver(){
        System.out.println("Game Over");
        return;
    }
    
    public void drawGrid(){
        //System.out.print("\f");
        //System.out.println("<-2048->");
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
