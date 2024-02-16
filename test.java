
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
    boolean moveMade = true;
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
        spawnNew();
        moveMade = true;
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
        // first column
        checkNumbers(2,0, 3,0); // checking down to up
        checkNumbers(1,0, 3,0); // 3,0 starts from the
        checkNumbers(0,0, 3,0); // bottom left most tile
        checkNumbers(1,0, 2,0); // 2,0 starts from the second to bottom most tile
        checkNumbers(0,0, 2,0); // and scans up
        checkNumbers(0,0, 1,0); // second from the top most tile, scans the top most tile
        // second column
        checkNumbers(2,1, 3,1);
        checkNumbers(1,1, 3,1);
        checkNumbers(0,1, 3,1);
        checkNumbers(1,1, 2,1);
        checkNumbers(0,1, 2,1);
        checkNumbers(0,1, 1,1);
        // third column
        checkNumbers(2,2, 3,2);
        checkNumbers(1,2, 3,2);
        checkNumbers(0,2, 3,2);
        checkNumbers(1,2, 2,2);
        checkNumbers(0,2, 2,2);
        checkNumbers(0,2, 1,2);
        // third column
        checkNumbers(2,3, 3,3);
        checkNumbers(1,3, 3,3);
        checkNumbers(0,3, 3,3);
        checkNumbers(1,3, 2,3);
        checkNumbers(0,3, 2,3);
        checkNumbers(0,3, 1,3);
        spawnNew();
    }
    
    public void calculateLeft(){ // calculates moves to the left
        // top line
        checkNumbers(0,1, 0,0); // checking left to right
        checkNumbers(0,2, 0,0); // 0,0 starts from the
        checkNumbers(0,3, 0,0); // top left most tile
        checkNumbers(0,2, 0,1); // 0,1 starts from the second to the left most tile,
        checkNumbers(0,3, 0,1); // and scans right
        checkNumbers(0,3, 0,2); // second from the right most tile, and scans the top right tile
        // second line
        checkNumbers(1,1, 1,0);
        checkNumbers(1,2, 1,0);
        checkNumbers(1,3, 1,0);
        checkNumbers(1,2, 1,1);
        checkNumbers(1,3, 1,1);
        checkNumbers(1,3, 1,2);
        // third line
        checkNumbers(2,1, 2,0);
        checkNumbers(2,2, 2,0);
        checkNumbers(2,3, 2,0);
        checkNumbers(2,2, 2,1);
        checkNumbers(2,3, 2,1);
        checkNumbers(2,3, 2,2);
        // fouth line
        checkNumbers(3,1, 3,0);
        checkNumbers(3,2, 3,0);
        checkNumbers(3,3, 3,0);
        checkNumbers(3,2, 3,1);
        checkNumbers(3,3, 3,1);
        checkNumbers(3,3, 3,2);
        spawnNew();
    }
    
    public void calculateRight(){ // calculates moves to the right
        // top line
        checkNumbers(0,2, 0,3); // starts checking right to left
        checkNumbers(0,1, 0,3); // 0,3 starts from the
        checkNumbers(0,0, 0,3); // top right most tile
        checkNumbers(0,1, 0,2); // 0,2 starts from the second to the right most tile,
        checkNumbers(0,0, 0,2); // and scans left
        checkNumbers(0,0, 0,1); // second to the left most tile, and scans the top left
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
        
        spawnNew();
    }
    
    public void checkNumbers(int prevX, int prevY, int nextX, int nextY){
        // prev (x,y) = what 
        // next (x,y) = 
        int current = grid[prevX][prevY];
        int checking = grid[nextX][nextY];
        if (current == checking){ // checking is the same as the next one over
            switch (checking){ // merge
                case 2:
                    System.out.println("merging 2");
                    grid[prevX][prevY] = 0;
                    grid[nextX][nextY] = 4;
                    moveMade = true;
                    break;
                case 4:
                    System.out.println("merging 4");
                    grid[prevX][prevY] = 0;
                    grid[nextX][nextY] = 8;
                    moveMade = true;
                    break;
                case 8:
                    System.out.println("merging 8");
                    grid[prevX][prevY] = 0;
                    grid[nextX][nextY] = 16;
                    moveMade = true;
                    break;
                case 16:
                    System.out.println("merging 16");
                    grid[prevX][prevY] = 0;
                    grid[nextX][nextY] = 32;
                    moveMade = true;
                    break;
                case 32:
                    System.out.println("merging 32");
                    grid[prevX][prevY] = 0;
                    grid[nextX][nextY] = 64;
                    moveMade = true;
                    break;
                case 64:
                    System.out.println("merging 64");
                    grid[prevX][prevY] = 0;
                    grid[nextX][nextY] = 128;
                    moveMade = true;
                    break;
                case 128:
                    System.out.println("merging 128");
                    grid[prevX][prevY] = 0;
                    grid[nextX][nextY] = 256;
                    moveMade = true;
                    break;
                case 256:
                    System.out.println("merging 256");
                    grid[prevX][prevY] = 0;
                    grid[nextX][nextY] = 512;
                    moveMade = true;
                    break;
                case 512:
                    System.out.println("merging 512");
                    grid[prevX][prevY] = 0;
                    grid[nextX][nextY] = 1024;
                    moveMade = true;
                    break;
                case 1024:
                    System.out.println("merging 2048");
                    grid[prevX][prevY] = 0;
                    grid[nextX][nextY] = 2048;
                    moveMade = true;
                    //winGame();
                    break;
                default :
                    System.out.println("how the fuck did you make it here?");
            }
        } else { // IF THEY are different
            switch (checking){
                case 0: // and the checking is a 0
                    grid[nextX][nextY] = grid[prevX][prevY]; // set the 0 to the previous one
                    grid[prevX][prevY] = 0; // set the pervious one to 0
                    moveMade = true;
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
            if (moveMade){
                grid[spawnX][spawnY] = 2;
                //System.out.println("Spawned in " + spawnX + ", " + spawnY); //commenting out because we no longer need this clutter
                moveMade = false;
            } else {
                System.out.println("Tile cannot be spawned as move has not been made");
            }
            drawGrid();
        }
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
