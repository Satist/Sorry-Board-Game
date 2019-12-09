package View;

import Model.Card.Card;
import Model.Deck.Deck;
import Model.Square.SafetyZoneSquare;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame implements ActionListener {
    static JFrame window;
    static JLabel sorry=new JLabel(new ImageIcon("C:\\Users\\glamprou\\IdeaProjects\\Project Sorry!\\src\\images\\sorryImage.png"));
    static JLabel back=new JLabel(new ImageIcon("C:\\Users\\glamprou\\IdeaProjects\\Project Sorry!\\src\\images\\background.png"));
    static JMenuBar menuBar;
    static JLabel[] Square=new JLabel[61];
    Deck deck =new Deck();
    static JLabel startRed;
    static JLabel startYellow;
    static JLabel homeRed;
    static JLabel homeYellow;
    static JButton pawnRed1;
    static JButton pawnRed2;
    static JButton pawnYellow1;
    static JButton pawnYellow2;
    static JLabel cardFront;
    static JButton cardBack;
    static JLabel underCards;
    static JTextArea infobox;
    static JButton fold;
    static JLabel[] redSafety=new JLabel[5];
    static JLabel[] yellowSafety=new JLabel[5];
    Border red=BorderFactory.createLineBorder(Color.red,3);
    Border yellow= BorderFactory.createLineBorder(Color.yellow,3);
    Border squareBorder=BorderFactory.createLineBorder(Color.black,2);

    public View(){
        createWindow();
        createGreenBackground();
        createCards();
        createFold();
        createInfobox();
        createSquares();
        createSafety();
        createHome();
        createStart();
        createLogo();
        createPawns();
    }

    public void createWindow(){
        window=new JFrame("Sorry! Game");
        window.setSize(1024,768);
        window.setVisible(true);
    }
    /**
     * Creates the Green background
     */
    public void createGreenBackground(){
        window.add(back);
    }
    /**
     * Creates Logo Photo
     */
    public void createLogo(){
        sorry.setBounds(4*40,7*40,417,121);
        back.add(sorry);
    }

    /**
     * Creates Menu Bar
     */
    public void createMenu(){

    }

    /**
     * Create Squares Area
     */
    public void createSquares(){
        int x=40*5;
        int y=40;
        for (int i=1;i<=60;i++){
            Square[i]=new JLabel();
            Square[i].setIcon(deck.board[i].getImage());
            Square[i].setBorder(squareBorder);
            if(i<=12){
                Square[i].setBounds(x,0,40,40);
                back.add(Square[i]);
                if(i<12)
                    x=x+40;
            }
            else if(i<=27){
                Square[i].setBounds(x,y,40,40);
                back.add(Square[i]);
                if(i<27)
                    y=y+40;
                if(i==27)
                    x=x-40;
            }
            else if(i<=42){
                Square[i].setBounds(x,y,40,40);
                back.add(Square[i]);
                if(i<42)
                    x=x-40;
                if(i==42)
                    y=y-40;
            }
            else if(i<=57){
                Square[i].setBounds(x,y,40,40);
                back.add(Square[i]);
                if(i<57)
                    y=y-40;
                if(i==57)
                    x=x+40;
            }
            else {
                Square[i].setBounds(x,y,40,40);
                back.add(Square[i]);
                x=x+40;
            }
        }
    }


    /**
     * Creates Start Squares
     */
    public void createStart(){
        startRed=new JLabel();
        startRed.setIcon(deck.redStartSquare.getImage());
        startRed.setBorder(red);
        startRed.setText("Start");
        startRed.setVerticalTextPosition(JLabel.CENTER);
        startRed.setHorizontalTextPosition(JLabel.CENTER);
        startRed.setBounds(Square[60].getX()+15,Square[60].getY()+40,100,100);
        back.add(startRed);
        startYellow=new JLabel();
        startYellow.setIcon(deck.yellowStartSquare.getImage());
        startYellow.setBorder(yellow);
        startYellow.setText("Start");
        startYellow.setVerticalTextPosition(JLabel.CENTER);
        startYellow.setHorizontalTextPosition(JLabel.CENTER);
        startYellow.setBounds(Square[31].getX()-30,Square[31].getY()-100,100,100);
        back.add(startYellow);
    }
    /**
     * Creates Card Area
     */
    public void createCards(){
        cardBack=new JButton(new ImageIcon("C:\\Users\\glamprou\\IdeaProjects\\Project Sorry!\\src\\images\\cards\\backCard.png"));
        cardBack.setBounds(721,200,100,152);
        cardBack.addActionListener(this);
        back.add(cardBack);
        cardFront=new JLabel();
        cardFront.setBounds(881,200,100,152);
        back.add(cardFront);
    }

    /**
     * Creates Safety Squares
     */
    public void createSafety(){
        int yRed=40;
        int yYellow=Square[29].getY()-40;
        for(int i=0;i<5;i++){
            redSafety[i]=new JLabel();
            redSafety[i].setIcon(deck.redSafetyZoneSquares[i].getImage());
            redSafety[i].setBorder(squareBorder);
            redSafety[i].setBounds(3*40,yRed,40,40);
            back.add(redSafety[i]);
            yRed=yRed+40;
            yellowSafety[i]=new JLabel();
            yellowSafety[i].setIcon(deck.yellowSafetyZoneSquares[i].getImage());
            yellowSafety[i].setBorder(squareBorder);
            yellowSafety[i].setBounds(Square[29].getX(),yYellow,40,40);
            back.add(yellowSafety[i]);
            yYellow=yYellow-40;
        }
    }

    /**
     * Creates Home Squares
     */
    public void createHome(){
        homeRed=new JLabel();
        homeRed.setIcon(deck.redHomeSquare.getImage());
        homeRed.setBorder(red);
        homeRed.setText("Home");
        homeRed.setVerticalTextPosition(JLabel.CENTER);
        homeRed.setHorizontalTextPosition(JLabel.CENTER);
        homeRed.setBounds(redSafety[4].getX()-30,redSafety[4].getY()+40,100,100);
        back.add(homeRed);
        homeYellow=new JLabel();
        homeYellow.setIcon(deck.yellowHomeSquare.getImage());
        homeYellow.setBorder(yellow);
        homeYellow.setText("Home");
        homeYellow.setVerticalTextPosition(JLabel.CENTER);
        homeYellow.setHorizontalTextPosition(JLabel.CENTER);
        homeYellow.setBounds(yellowSafety[4].getX()-30,yellowSafety[4].getY()-100,100,100);
        back.add(homeYellow);
    }

    /**
     * Creates Pawns
     */
    public void createPawns(){
        pawnRed1=new JButton();
        pawnRed1.setIcon(deck.pawnRed1.getImage());
        pawnRed1.setBounds(5,5,40,40);
        startRed.add(pawnRed1);
        pawnRed2=new JButton();
        pawnRed2.setIcon(deck.pawnRed2.getImage());
        pawnRed2.setBounds(55,5,40,40);
        startRed.add(pawnRed2);
        pawnYellow1=new JButton();
        pawnYellow1.setIcon(deck.pawnYellow1.getImage());
        pawnYellow1.setBounds(5,55,40,40);
        startYellow.add(pawnYellow1);
        pawnYellow2=new JButton();
        pawnYellow2.setIcon(deck.pawnYellow2.getImage());
        pawnYellow2.setBounds(55,55,40,40);
        startYellow.add(pawnYellow2);
    }

    /**
     * Creates Text under Cards
     */
    public void createCardText(){

    }

    /**
     * Creates Fold button
     */
    public void createFold(){
        fold=new JButton();
        fold.setBackground(Color.red);
        fold.setText("Fold");
        fold.setBounds(721,365,260,50);
        fold.addActionListener(this);
        back.add(fold);
    }

    /**
     * Creates Info Box
     */
    public void createInfobox(){
        infobox=new JTextArea();
        infobox.setBounds(721,460,260,150);
        back.add(infobox);
    }
    public static void main(String stringkaki[]){
        View skata=new View();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object click=e.getSource();
        if(click==cardBack){
            Card card= deck.card_pick();
            System.out.println(card.getNumber());
            cardFront.setIcon(card.getImage());
        }
        else if(click==fold){
            System.out.println("Pass");
        }
    }
}
