
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

public class window extends JFrame implements ActionListener
{
    Font samsungSans;
    
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
    JPanel grid;
    
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
        this.toFront();
        
        //jpanel initiator
        JPanel grid = new JPanel();
        grid.setLayout(new GridLayout(4,4));
        grid.setBackground(Color.green);
        
        JPanel title = new JPanel();
        JLabel title2048 = new JLabel("GALAXY S24");
        title2048.setFont(new Font("samsungSans",1,63));
        title.setBackground(Color.blue);
        title.setPreferredSize(new Dimension(0,100));
        title.add(title2048);
        
        grid.add(slotOne);
        grid.add(slotTwo);
        grid.add(slotThree);
        grid.add(slotFour);
        grid.add(slotFive);
        grid.add(slotSix);
        grid.add(slotSeven);
        grid.add(slotEight);
        grid.add(slotNine);
        grid.add(slotTen);
        grid.add(slotEleven);
        grid.add(slotTwelve);
        grid.add(slotThirteen);
        grid.add(slotFourteen);
        grid.add(slotFifteen);
        grid.add(slotSixteen);
        
        slotSixteen.setIcon(tile2048);
        
        //this.setLayout(new BorderLayout());
        this.add(grid, BorderLayout.CENTER);
        this.add(title, BorderLayout.PAGE_START);
        
        this.pack();
        this.setVisible(true);
    }
    
    public void updateIcons(int gridSpot, int tileNumber){
        System.out.println("updated icon for " + gridSpot + " " + tileNumber);
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
            case 3:
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
            case 4:
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
            case 5:
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
            case 6:
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
            case 7:
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
            case 8:
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
            case 9:
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
            case 10:
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
            case 11:
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
            case 12:
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
            case 13:
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
            case 14:
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
            case 15:
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
            case 16:
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
        }
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
}
