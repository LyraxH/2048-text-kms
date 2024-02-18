
/**
 * Write a description of class window here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class window extends JFrame implements ActionListener, KeyListener
{
    Font samsungSans;
    
    int grid[][] = new int[4][4];
    boolean moveMade = true;
    Random rng = new Random();
    ArrayList<Integer> gridTransfer = new ArrayList<Integer>(16);
    
    JLabel slotOne = new JLabel(); // 0,0
    JLabel slotTwo = new JLabel(); // 0,1
    JLabel slotThree = new JLabel(); // 0,2
    JLabel slotFour = new JLabel(); // 0,3
    JLabel slotFive = new JLabel(); // 1,0
    JLabel slotSix = new JLabel(); // 1,1
    JLabel slotSeven = new JLabel(); // 1,2
    JLabel slotEight = new JLabel(); // 1,3
    JLabel slotNine = new JLabel(); // 2,0
    JLabel slotTen = new JLabel(); // 2,1
    JLabel slotEleven = new JLabel(); // 2,2
    JLabel slotTwelve = new JLabel(); // 2,3
    JLabel slotThirteen = new JLabel(); // 3,0
    JLabel slotFourteen = new JLabel(); // 3,1
    JLabel slotFifteen = new JLabel(); // 3,2
    JLabel slotSixteen = new JLabel(); // 3,3
    
    ImageIcon tile0 = new ImageIcon("Icons/0.png");
    ImageIcon tile2 = new ImageIcon("Icons/2.png");
    ImageIcon tile4 = new ImageIcon("Icons/4.png");
    ImageIcon tile8 = new ImageIcon("Icons/8.png");
    ImageIcon tile16 = new ImageIcon("Icons/16.png");
    ImageIcon tile32 = new ImageIcon("Icons/32.png");
    ImageIcon tile64 = new ImageIcon("Icons/64.png");
    ImageIcon tile128 = new ImageIcon("Icons/128.png");
    ImageIcon tile256 = new ImageIcon("Icons/256.png");
    ImageIcon tile512 = new ImageIcon("Icons/512.png");
    ImageIcon tile1024 = new ImageIcon("Icons/1024.png");
    ImageIcon tile2048 = new ImageIcon("Icons/2048.png");
    
    JMenuBar menuBar = new JMenuBar();
    JMenu file = new JMenu("File");
    JMenu settings = new JMenu("Settings");
    JMenu help = new JMenu("Help");
    JPanel gridPanel = new JPanel();
    
    // file
    JMenuItem saveItem = new JMenuItem("Save High Score");
    JMenuItem quitItem = new JMenuItem("Quit");
    ImageIcon quitIcon = new ImageIcon("Images/PowerOff22.png");
    // settings
    JMenuItem colorItem = new JMenuItem("Change Color Palette");
    ImageIcon colorIcon = new ImageIcon("Images/OntarioScienceCentre22.png");
    JMenuItem iconItem = new JMenuItem("Change Icon Pack");
    ImageIcon iconIcon = new ImageIcon("Images/IconPack22.png");
    JMenuItem soundItem = new JMenuItem("Toggle Sound");
    // help
    JMenuItem helpItem = new JMenuItem("Help");
    ImageIcon helpIcon = new ImageIcon("Images/help22.png");
    public window(){
        doFont();
        // add menus
        this.setJMenuBar(menuBar);
        menuBar.add(file);
        menuBar.add(settings);
        menuBar.add(help);
        
        // add things to menus
        file.add(saveItem);
        file.addSeparator();
        file.add(quitItem);
        quitItem.setIcon(quitIcon);
        
        settings.add(colorItem);
        colorItem.setIcon(colorIcon);
        settings.addSeparator();
        settings.add(iconItem);
        iconItem.setIcon(iconIcon);
        settings.addSeparator();
        settings.add(soundItem);
        
        help.add(helpItem);
        helpItem.setIcon(helpIcon);
        
        //initialize actionlistners
        // file section
        saveItem.addActionListener(this);
        quitItem.addActionListener(this);
        
        // settings section
        colorItem.addActionListener(this);
        iconItem.addActionListener(this);
        soundItem.addActionListener(this);
        
        //help section
        helpItem.addActionListener(this);
    
        //window initializer
        this.setTitle("2048 2");
        this.getContentPane().setPreferredSize(new Dimension(800,800));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.addKeyListener(this);
        this.toFront();
        
        JPanel title = new JPanel();
        JLabel title2048 = new JLabel("GALAXY S2048");
        title2048.setFont(new Font("samsungSans",1,63));
        title.setBackground(Color.blue);
        title.setPreferredSize(new Dimension(0,100));
        title.add(title2048);
        
        gridPanel.add(slotOne);
        gridPanel.add(slotTwo);
        gridPanel.add(slotThree);
        gridPanel.add(slotFour);
        gridPanel.add(slotFive);
        gridPanel.add(slotSix);
        gridPanel.add(slotSeven);
        gridPanel.add(slotEight);
        gridPanel.add(slotNine);
        gridPanel.add(slotTen);
        gridPanel.add(slotEleven);
        gridPanel.add(slotTwelve);
        gridPanel.add(slotThirteen);
        gridPanel.add(slotFourteen);
        gridPanel.add(slotFifteen);
        gridPanel.add(slotSixteen);
        
        //this.setLayout(new BorderLayout());
        this.add(gridPanel, BorderLayout.CENTER);
        this.add(title, BorderLayout.PAGE_START);
        
        gridPanel.setVisible(true);
        this.pack();
        this.setVisible(true);
        spawnNew();
        drawGrid();
    }
    
    public void updateIcons(int gridSpot, int tileNumber){
        //jpanel initiator
        gridPanel.setLayout(new GridLayout(4,4));
        gridPanel.setBackground(Color.green);
        //System.out.println("updated icon for " + gridSpot + " " + tileNumber);
        switch (gridSpot){ // what tile spot to update
            case 1: // 0,0
                switch (tileNumber){ // what to update it with
                    case 0:
                        slotOne.setIcon(tile0);
                        break;
                    case 2:
                        slotOne.setIcon(tile2);
                        break;
                    case 4:
                        slotOne.setIcon(tile4);
                        break;
                    case 8:
                        slotOne.setIcon(tile8);
                        break;
                    case 16:
                        slotOne.setIcon(tile16);
                        break;
                    case 32:
                        slotOne.setIcon(tile32);
                        break;
                    case 64:
                        slotOne.setIcon(tile64);
                        break;
                    case 128:
                        slotOne.setIcon(tile128);
                        break;
                    case 256:
                        slotOne.setIcon(tile256);
                        break;
                    case 512:
                        slotOne.setIcon(tile512);
                        break;
                    case 1024:
                        slotOne.setIcon(tile1024);
                        break;
                    case 2048:
                        slotOne.setIcon(tile2048);
                        break;
                }
                break;
            case 2:
                switch (tileNumber){ // what to update it with
                    case 0:
                        slotTwo.setIcon(tile0);
                        break;
                    case 2:
                        slotTwo.setIcon(tile2);
                        break;
                    case 4:
                        slotTwo.setIcon(tile4);
                        break;
                    case 8:
                        slotTwo.setIcon(tile8);
                        break;
                    case 16:
                        slotTwo.setIcon(tile16);
                        break;
                    case 32:
                        slotTwo.setIcon(tile32);
                        break;
                    case 64:
                        slotTwo.setIcon(tile64);
                        break;
                    case 128:
                        slotTwo.setIcon(tile128);
                        break;
                    case 256:
                        slotTwo.setIcon(tile256);
                        break;
                    case 512:
                        slotTwo.setIcon(tile512);
                        break;
                    case 1024:
                        slotTwo.setIcon(tile1024);
                        break;
                    case 2048:
                        slotTwo.setIcon(tile2048);
                        break;
                }
                break;
            case 3:
                switch (tileNumber){ // what to update it with
                    case 0:
                        slotThree.setIcon(tile0);
                        break;
                    case 2:
                        slotThree.setIcon(tile2);
                        break;
                    case 4:
                        slotThree.setIcon(tile4);
                        break;
                    case 8:
                        slotThree.setIcon(tile8);
                        break;
                    case 16:
                        slotThree.setIcon(tile16);
                        break;
                    case 32:
                        slotThree.setIcon(tile32);
                        break;
                    case 64:
                        slotThree.setIcon(tile64);
                        break;
                    case 128:
                        slotThree.setIcon(tile128);
                        break;
                    case 256:
                        slotThree.setIcon(tile256);
                        break;
                    case 512:
                        slotThree.setIcon(tile512);
                        break;
                    case 1024:
                        slotThree.setIcon(tile1024);
                        break;
                    case 2048:
                        slotThree.setIcon(tile2048);
                        break;
                }
                break;
            case 4:
                switch (tileNumber){ // what to update it with
                    case 0:
                        slotFour.setIcon(tile0);
                        break;
                    case 2:
                        slotFour.setIcon(tile2);
                        break;
                    case 4:
                        slotFour.setIcon(tile4);
                        break;
                    case 8:
                        slotFour.setIcon(tile8);
                        break;
                    case 16:
                        slotFour.setIcon(tile16);
                        break;
                    case 32:
                        slotFour.setIcon(tile32);
                        break;
                    case 64:
                        slotFour.setIcon(tile64);
                        break;
                    case 128:
                        slotFour.setIcon(tile128);
                        break;
                    case 256:
                        slotFour.setIcon(tile256);
                        break;
                    case 512:
                        slotFour.setIcon(tile512);
                        break;
                    case 1024:
                        slotFour.setIcon(tile1024);
                        break;
                    case 2048:
                        slotFour.setIcon(tile2048);
                        break;
                }
                break;
            case 5:
                switch (tileNumber){ // what to update it with
                    case 0:
                        slotFive.setIcon(tile0);
                        break;
                    case 2:
                        slotFive.setIcon(tile2);
                        break;
                    case 4:
                        slotFive.setIcon(tile4);
                        break;
                    case 8:
                        slotFive.setIcon(tile8);
                        break;
                    case 16:
                        slotFive.setIcon(tile16);
                        break;
                    case 32:
                        slotFive.setIcon(tile32);
                        break;
                    case 64:
                        slotFive.setIcon(tile64);
                        break;
                    case 128:
                        slotFive.setIcon(tile128);
                        break;
                    case 256:
                        slotFive.setIcon(tile256);
                        break;
                    case 512:
                        slotFive.setIcon(tile512);
                        break;
                    case 1024:
                        slotFive.setIcon(tile1024);
                        break;
                    case 2048:
                        slotFive.setIcon(tile2048);
                        break;
                }
                break;
            case 6:
                switch (tileNumber){ // what to update it with
                    case 0:
                        slotSix.setIcon(tile0);
                        break;
                    case 2:
                        slotSix.setIcon(tile2);
                        break;
                    case 4:
                        slotSix.setIcon(tile4);
                        break;
                    case 8:
                        slotSix.setIcon(tile8);
                        break;
                    case 16:
                        slotSix.setIcon(tile16);
                        break;
                    case 32:
                        slotSix.setIcon(tile32);
                        break;
                    case 64:
                        slotSix.setIcon(tile64);
                        break;
                    case 128:
                        slotSix.setIcon(tile128);
                        break;
                    case 256:
                        slotSix.setIcon(tile256);
                        break;
                    case 512:
                        slotSix.setIcon(tile512);
                        break;
                    case 1024:
                        slotSix.setIcon(tile1024);
                        break;
                    case 2048:
                        slotSix.setIcon(tile2048);
                        break;
                }
                break;
            case 7:
                switch (tileNumber){ // what to update it with
                    case 0:
                        slotSeven.setIcon(tile0);
                        break;
                    case 2:
                        slotSeven.setIcon(tile2);
                        break;
                    case 4:
                        slotSeven.setIcon(tile4);
                        break;
                    case 8:
                        slotSeven.setIcon(tile8);
                        break;
                    case 16:
                        slotSeven.setIcon(tile16);
                        break;
                    case 32:
                        slotSeven.setIcon(tile32);
                        break;
                    case 64:
                        slotSeven.setIcon(tile64);
                        break;
                    case 128:
                        slotSeven.setIcon(tile128);
                        break;
                    case 256:
                        slotSeven.setIcon(tile256);
                        break;
                    case 512:
                        slotSeven.setIcon(tile512);
                        break;
                    case 1024:
                        slotSeven.setIcon(tile1024);
                        break;
                    case 2048:
                        slotSeven.setIcon(tile2048);
                        break;
                }
                break;
            case 8:
                switch (tileNumber){ // what to update it with
                    case 0:
                        slotEight.setIcon(tile0);
                        break;
                    case 2:
                        slotEight.setIcon(tile2);
                        break;
                    case 4:
                        slotEight.setIcon(tile4);
                        break;
                    case 8:
                        slotEight.setIcon(tile8);
                        break;
                    case 16:
                        slotEight.setIcon(tile16);
                        break;
                    case 32:
                        slotEight.setIcon(tile32);
                        break;
                    case 64:
                        slotEight.setIcon(tile64);
                        break;
                    case 128:
                        slotEight.setIcon(tile128);
                        break;
                    case 256:
                        slotEight.setIcon(tile256);
                        break;
                    case 512:
                        slotEight.setIcon(tile512);
                        break;
                    case 1024:
                        slotEight.setIcon(tile1024);
                        break;
                    case 2048:
                        slotEight.setIcon(tile2048);
                        break;
                }
                break;
            case 9:
                switch (tileNumber){ // what to update it with
                    case 0:
                        slotNine.setIcon(tile0);
                        break;
                    case 2:
                        slotNine.setIcon(tile2);
                        break;
                    case 4:
                        slotNine.setIcon(tile4);
                        break;
                    case 8:
                        slotNine.setIcon(tile8);
                        break;
                    case 16:
                        slotNine.setIcon(tile16);
                        break;
                    case 32:
                        slotNine.setIcon(tile32);
                        break;
                    case 64:
                        slotNine.setIcon(tile64);
                        break;
                    case 128:
                        slotNine.setIcon(tile128);
                        break;
                    case 256:
                        slotNine.setIcon(tile256);
                        break;
                    case 512:
                        slotNine.setIcon(tile512);
                        break;
                    case 1024:
                        slotNine.setIcon(tile1024);
                        break;
                    case 2048:
                        slotNine.setIcon(tile2048);
                        break;
                }
                break;
            case 10:
                switch (tileNumber){ // what to update it with
                    case 0:
                        slotTen.setIcon(tile0);
                        break;
                    case 2:
                        slotTen.setIcon(tile2);
                        break;
                    case 4:
                        slotTen.setIcon(tile4);
                        break;
                    case 8:
                        slotTen.setIcon(tile8);
                        break;
                    case 16:
                        slotTen.setIcon(tile16);
                        break;
                    case 32:
                        slotTen.setIcon(tile32);
                        break;
                    case 64:
                        slotTen.setIcon(tile64);
                        break;
                    case 128:
                        slotTen.setIcon(tile128);
                        break;
                    case 256:
                        slotTen.setIcon(tile256);
                        break;
                    case 512:
                        slotTen.setIcon(tile512);
                        break;
                    case 1024:
                        slotTen.setIcon(tile1024);
                        break;
                    case 2048:
                        slotTen.setIcon(tile2048);
                        break;
                }
                break;
            case 11:
                switch (tileNumber){ // what to update it with
                    case 0:
                        slotEleven.setIcon(tile0);
                        break;
                    case 2:
                        slotEleven.setIcon(tile2);
                        break;
                    case 4:
                        slotEleven.setIcon(tile4);
                        break;
                    case 8:
                        slotEleven.setIcon(tile8);
                        break;
                    case 16:
                        slotEleven.setIcon(tile16);
                        break;
                    case 32:
                        slotEleven.setIcon(tile32);
                        break;
                    case 64:
                        slotEleven.setIcon(tile64);
                        break;
                    case 128:
                        slotEleven.setIcon(tile128);
                        break;
                    case 256:
                        slotEleven.setIcon(tile256);
                        break;
                    case 512:
                        slotEleven.setIcon(tile512);
                        break;
                    case 1024:
                        slotEleven.setIcon(tile1024);
                        break;
                    case 2048:
                        slotEleven.setIcon(tile2048);
                        break;
                }
                break;
            case 12:
                switch (tileNumber){ // what to update it with
                    case 0:
                        slotTwelve.setIcon(tile0);
                        break;
                    case 2:
                        slotTwelve.setIcon(tile2);
                        break;
                    case 4:
                        slotTwelve.setIcon(tile4);
                        break;
                    case 8:
                        slotTwelve.setIcon(tile8);
                        break;
                    case 16:
                        slotTwelve.setIcon(tile16);
                        break;
                    case 32:
                        slotTwelve.setIcon(tile32);
                        break;
                    case 64:
                        slotTwelve.setIcon(tile64);
                        break;
                    case 128:
                        slotTwelve.setIcon(tile128);
                        break;
                    case 256:
                        slotTwelve.setIcon(tile256);
                        break;
                    case 512:
                        slotTwelve.setIcon(tile512);
                        break;
                    case 1024:
                        slotTwelve.setIcon(tile1024);
                        break;
                    case 2048:
                        slotTwelve.setIcon(tile2048);
                        break;
                }
                break;
            case 13:
                switch (tileNumber){ // what to update it with
                    case 0:
                        slotThirteen.setIcon(tile0);
                        break;
                    case 2:
                        slotThirteen.setIcon(tile2);
                        break;
                    case 4:
                        slotThirteen.setIcon(tile4);
                        break;
                    case 8:
                        slotThirteen.setIcon(tile8);
                        break;
                    case 16:
                        slotThirteen.setIcon(tile16);
                        break;
                    case 32:
                        slotThirteen.setIcon(tile32);
                        break;
                    case 64:
                        slotThirteen.setIcon(tile64);
                        break;
                    case 128:
                        slotThirteen.setIcon(tile128);
                        break;
                    case 256:
                        slotThirteen.setIcon(tile256);
                        break;
                    case 512:
                        slotThirteen.setIcon(tile512);
                        break;
                    case 1024:
                        slotThirteen.setIcon(tile1024);
                        break;
                    case 2048:
                        slotThirteen.setIcon(tile2048);
                        break;
                }
                break;
            case 14:
                switch (tileNumber){ // what to update it with
                    case 0:
                        slotFourteen.setIcon(tile0);
                        break;
                    case 2:
                        slotFourteen.setIcon(tile2);
                        break;
                    case 4:
                        slotFourteen.setIcon(tile4);
                        break;
                    case 8:
                        slotFourteen.setIcon(tile8);
                        break;
                    case 16:
                        slotFourteen.setIcon(tile16);
                        break;
                    case 32:
                        slotFourteen.setIcon(tile32);
                        break;
                    case 64:
                        slotFourteen.setIcon(tile64);
                        break;
                    case 128:
                        slotFourteen.setIcon(tile128);
                        break;
                    case 256:
                        slotFourteen.setIcon(tile256);
                        break;
                    case 512:
                        slotFourteen.setIcon(tile512);
                        break;
                    case 1024:
                        slotFourteen.setIcon(tile1024);
                        break;
                    case 2048:
                        slotFourteen.setIcon(tile2048);
                        break;
                }
                break;
            case 15:
                switch (tileNumber){ // what to update it with
                    case 0:
                        slotFifteen.setIcon(tile0);
                        break;
                    case 2:
                        slotFifteen.setIcon(tile2);
                        break;
                    case 4:
                        slotFifteen.setIcon(tile4);
                        break;
                    case 8:
                        slotFifteen.setIcon(tile8);
                        break;
                    case 16:
                        slotFifteen.setIcon(tile16);
                        break;
                    case 32:
                        slotFifteen.setIcon(tile32);
                        break;
                    case 64:
                        slotFifteen.setIcon(tile64);
                        break;
                    case 128:
                        slotFifteen.setIcon(tile128);
                        break;
                    case 256:
                        slotFifteen.setIcon(tile256);
                        break;
                    case 512:
                        slotFifteen.setIcon(tile512);
                        break;
                    case 1024:
                        slotFifteen.setIcon(tile1024);
                        break;
                    case 2048:
                        slotFifteen.setIcon(tile2048);
                        break;
                }
                break;
            case 16:
                switch (tileNumber){ // what to update it with
                    case 0:
                        slotSixteen.setIcon(tile0);
                        break;
                    case 2:
                        slotSixteen.setIcon(tile2);
                        break;
                    case 4:
                        slotSixteen.setIcon(tile4);
                        break;
                    case 8:
                        slotSixteen.setIcon(tile8);
                        break;
                    case 16:
                        slotSixteen.setIcon(tile16);
                        break;
                    case 32:
                        slotSixteen.setIcon(tile32);
                        break;
                    case 64:
                        slotSixteen.setIcon(tile64);
                        break;
                    case 128:
                        slotSixteen.setIcon(tile128);
                        break;
                    case 256:
                        slotSixteen.setIcon(tile256);
                        break;
                    case 512:
                        slotSixteen.setIcon(tile512);
                        break;
                    case 1024:
                        slotSixteen.setIcon(tile1024);
                        break;
                    case 2048:
                        slotSixteen.setIcon(tile2048);
                        break;
                }
                break;
        }
        gridPanel.revalidate();
        gridPanel.repaint();
    }
    
    public void actionPerformed(ActionEvent e){
        String cmd = e.getActionCommand();
        switch (cmd){
            case "Save High Score" :
                // do the thing where you save a file to desktop
                System.out.println("Save Game");
                break;
            case "Quit":
                System.out.println("quitted");
                System.exit(0);
                break;
            case "Change Color Palette":
                System.out.println("change color palette");
                break;
            case "Change Icon Pack":
                System.out.println("change icon pack");
                break;
            case "Toggle Sound":
                System.out.println("toggle sound");
                break;
            case "Help":
                createDialogBox("Helping you out", "its 2048.. up down left right, merge blocks till you hit BIG Number");
                System.out.println("Help");
                break;
        }
    }
    
    public void doFont(){
         try { // initialize font
            Font samsungSans = Font.createFont(Font.TRUETYPE_FONT,new File("samsungsharpsans-bold.ttf"));
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(samsungSans);
        } catch (IOException|FontFormatException e) {
             System.out.println(e);
        }
    }
    
    public void createDialogBox(String title,String text){
        JDialog box = new JDialog(this);
        TextArea area = new TextArea(text);
        area.setEditable(false);
        box.add(area);
        box.setBounds(200,400, 400,400);
        box.toFront();
        box.setVisible(true);
        box.setTitle(title);
    }
    
    public void keyPressed(KeyEvent e){
        int keyCode = e.getKeyCode();
        switch (keyCode){
            case 38:
                //System.out.println("up");
                calculateUp();
                break;
            case 40:
                //System.out.println("down");
                calculateDown();
                break;
            case 37:
                //System.out.println("left");
                calculateLeft();
                break;
            case 39:
                //System.out.println("right");
                calculateRight();
                break;
        }
    }
    
    public void keyReleased(KeyEvent e){
        
    }
    
    public void keyTyped(KeyEvent e){
        
    }
    
        public void calculateUp(){ // calculates moves up
        // first column
        checkNumbers(1,0, 0,0); // checking down to up
        checkNumbers(2,0, 0,0); // 3,0 starts from the
        checkNumbers(3,0, 0,0); // bottom left most tile
        checkNumbers(1,0, 1,0); // 2,0 starts from the second to bottom most tile
        checkNumbers(2,0, 1,0); // and scans up
        checkNumbers(1,0, 2,0); // second from the top most tile, scans the top most tile
        // second column
        checkNumbers(1,1, 0,1);
        checkNumbers(2,1, 0,1);
        checkNumbers(3,1, 0,1);
        checkNumbers(1,1, 1,1);
        checkNumbers(2,1, 1,1);
        checkNumbers(1,1, 2,1);
        // third column
        checkNumbers(1,2, 0,2);
        checkNumbers(2,2, 0,2);
        checkNumbers(3,2, 0,2);
        checkNumbers(1,2, 1,2);
        checkNumbers(2,2, 1,2);
        checkNumbers(1,2, 2,2);
        // fourth column
        checkNumbers(1,3, 0,3);
        checkNumbers(2,3, 0,3);
        checkNumbers(3,3, 0,3);
        checkNumbers(1,3, 1,3);
        checkNumbers(2,3, 1,3);
        checkNumbers(1,3, 2,3);
        spawnNew();
    }
    
    public void calculateDown(){ // calculates moves down
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
        // fourth column
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
                System.out.println("Spawned in " + spawnX + ", " + spawnY); //commenting out because we no longer need this clutter
                moveMade = false;
            } else {
                System.out.println("Tile cannot be spawned as move has not been made");
            }
            drawGrid();
        }
    }
    
    public void gameOver(){
        System.exit(0);
        System.out.println("Game over");
    }
    
    public void drawGrid(){
        int gridLocation = 0;
        gridTransfer.clear();
        for (int x = 0; x < 4; x++){
            for (int y = 0; y < 4; y++){
                System.out.print(grid[x][y]);
                gridTransfer.add(grid[x][y]);
            }
            System.out.println();
        }
        while (gridLocation < gridTransfer.size()){
            updateIcons((gridLocation + 1),gridTransfer.get(gridLocation));
            gridLocation++;
        }
    }
}
