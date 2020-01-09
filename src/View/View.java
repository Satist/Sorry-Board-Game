package View;

import Controller.Controller;
import Model.Card.Card;
import Model.Card.SimpleNumberCard;
import Model.Deck.Deck;
import Model.Square.*;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame implements ActionListener {
    static JFrame window;
    static JLabel sorry = new JLabel(new ImageIcon(Controller.path + "sorryImage.png"));
    static JLabel back = new JLabel(new ImageIcon(Controller.path + "background.png"));
    static JMenuBar menuBar;
    static JLabel[] Square = new JLabel[61];
    Deck deck = new Deck();
    Controller controller = new Controller(deck, 1);
    Card card;
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
    static JLabel[] redSafety = new JLabel[6];
    static JLabel[] yellowSafety = new JLabel[6];
    Border red = BorderFactory.createLineBorder(Color.red, 3);
    Border yellow = BorderFactory.createLineBorder(Color.yellow, 3);
    Border squareBorder = BorderFactory.createLineBorder(Color.black, 2);

    public View() {
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
        SwingUtilities.updateComponentTreeUI(window);
    }

    public void createWindow() {
        window = new JFrame("Sorry! Game");
        window.setSize(1024, 768);
        window.setVisible(true);
    }

    /**
     * Creates the Green background
     */
    public void createGreenBackground() {
        window.add(back);
    }

    /**
     * Creates Logo Photo
     */
    public void createLogo() {
        sorry.setBounds(4 * 40, 7 * 40, 417, 121);
        back.add(sorry);
    }

    /**
     * Creates Menu Bar
     */
    public void createMenu() {

    }

    /**
     * Create Squares Area
     */
    public void createSquares() {
        int x = 40 * 5;
        int y = 40;
        for (int i = 1; i <= 60; i++) {
            Square[i] = new JLabel();
            Square[i].setIcon(deck.board[i].getImage());
            Square[i].setBorder(squareBorder);
            if (i <= 12) {
                Square[i].setBounds(x, 0, 40, 40);
                back.add(Square[i]);
                if (i < 12)
                    x = x + 40;
            } else if (i <= 27) {
                Square[i].setBounds(x, y, 40, 40);
                back.add(Square[i]);
                if (i < 27)
                    y = y + 40;
                if (i == 27)
                    x = x - 40;
            } else if (i <= 42) {
                Square[i].setBounds(x, y, 40, 40);
                back.add(Square[i]);
                if (i < 42)
                    x = x - 40;
                if (i == 42)
                    y = y - 40;
            } else if (i <= 57) {
                Square[i].setBounds(x, y, 40, 40);
                back.add(Square[i]);
                if (i < 57)
                    y = y - 40;
                if (i == 57)
                    x = x + 40;
            } else {
                Square[i].setBounds(x, y, 40, 40);
                back.add(Square[i]);
                x = x + 40;
            }
        }
    }


    /**
     * Creates Start Squares
     */
    public void createStart() {
        startRed = new JLabel();
        startRed.setIcon(deck.redStartSquare.getImage());
        startRed.setBorder(red);
        startRed.setText("Start");
        startRed.setVerticalTextPosition(JLabel.CENTER);
        startRed.setHorizontalTextPosition(JLabel.CENTER);
        startRed.setBounds(Square[60].getX() + 15, Square[60].getY() + 40, 100, 100);
        back.add(startRed);
        startYellow = new JLabel();
        startYellow.setIcon(deck.yellowStartSquare.getImage());
        startYellow.setBorder(yellow);
        startYellow.setText("Start");
        startYellow.setVerticalTextPosition(JLabel.CENTER);
        startYellow.setHorizontalTextPosition(JLabel.CENTER);
        startYellow.setBounds(Square[31].getX() - 30, Square[31].getY() - 100, 100, 100);
        back.add(startYellow);
    }

    /**
     * Creates Card Area
     */
    public void createCards() {
        cardBack = new JButton(new ImageIcon(Controller.path + "cards/backCard.png"));
        cardBack.setBounds(721, 200, 100, 152);
        cardBack.addActionListener(this);
        back.add(cardBack);
        cardFront = new JLabel();
        cardFront.setBounds(881, 200, 100, 152);
        back.add(cardFront);
    }

    /**
     * Creates Safety Squares
     */
    public void createSafety() {
        int yRed = 40;
        int yYellow = Square[29].getY() - 40;
        for (int i = 0; i < 5; i++) {
            redSafety[i] = new JLabel();
            redSafety[i].setIcon(deck.redSafetyZoneSquares[i].getImage());
            redSafety[i].setBorder(squareBorder);
            redSafety[i].setBounds(3 * 40, yRed, 40, 40);
            back.add(redSafety[i]);
            yRed = yRed + 40;
            yellowSafety[i] = new JLabel();
            yellowSafety[i].setIcon(deck.yellowSafetyZoneSquares[i].getImage());
            yellowSafety[i].setBorder(squareBorder);
            yellowSafety[i].setBounds(Square[29].getX(), yYellow, 40, 40);
            back.add(yellowSafety[i]);
            yYellow = yYellow - 40;
        }
    }

    /**
     * Creates Home Squares
     */
    public void createHome() {
        redSafety[5]= new JLabel();
        redSafety[5].setIcon(deck.redSafetyZoneSquares[5].getImage());
        redSafety[5].setBorder(red);
        redSafety[5].setText("Home");
        redSafety[5].setVerticalTextPosition(JLabel.CENTER);
        redSafety[5].setHorizontalTextPosition(JLabel.CENTER);
        redSafety[5].setBounds(redSafety[4].getX() - 30, redSafety[4].getY() + 40, 100, 100);
        back.add(redSafety[5]);
        yellowSafety[5] = new JLabel();
        yellowSafety[5] .setIcon(deck.yellowSafetyZoneSquares[5].getImage());
        yellowSafety[5] .setBorder(yellow);
        yellowSafety[5] .setText("Home");
        yellowSafety[5] .setVerticalTextPosition(JLabel.CENTER);
        yellowSafety[5] .setHorizontalTextPosition(JLabel.CENTER);
        yellowSafety[5] .setBounds(yellowSafety[4].getX() - 30, yellowSafety[4].getY() - 100, 100, 100);
        back.add(  yellowSafety[5] );
    }

    /**
     * Creates Pawns
     */
    public void createPawns() {
        //Red Pawn 1
        pawnRed1 = new JButton();
        pawnRed1.setIcon(deck.pawnRed1.getImage());
        pawnRed1.setBounds(5, 5, 40, 40);
        pawnRed1.addActionListener(this);
        startRed.add(pawnRed1);
        //Red Pawn 2
        pawnRed2 = new JButton();
        pawnRed2.setIcon(deck.pawnRed2.getImage());
        pawnRed2.setBounds(55, 5, 40, 40);
        pawnRed2.addActionListener(this);
        startRed.add(pawnRed2);
        //Yellow Pawn 1
        pawnYellow1 = new JButton();
        pawnYellow1.setIcon(deck.pawnYellow1.getImage());
        pawnYellow1.setBounds(5, 55, 40, 40);
        pawnYellow1.addActionListener(this);
        startYellow.add(pawnYellow1);
        //Yellow Pawn 2
        pawnYellow2 = new JButton();
        pawnYellow2.setIcon(deck.pawnYellow2.getImage());
        pawnYellow2.setBounds(55, 55, 40, 40);
        pawnYellow2.addActionListener(this);
        startYellow.add(pawnYellow2);
    }

    /**
     * Creates Fold button
     */
    public void createFold() {
        fold = new JButton();
        fold.setBackground(Color.red);
        fold.setText("Fold");
        fold.setBounds(721, 365, 260, 50);
        fold.addActionListener(this);
        back.add(fold);
    }

    /**
     * Creates Info Box
     */
    public void createInfobox() {
        infobox = new JTextArea();
        infobox.setBounds(721, 460, 260, 150);
        back.add(infobox);
        infobox.setText("Turn Player "+controller.getTurn() +
                "\nCards Left:"+deck.getDECK_SIZE());
    }

    /**
     * Sets the winner
     */
    public void winner(){
        if(deck.pawnYellow1.getSquare().equals(deck.redSafetyZoneSquares[5]) && deck.pawnYellow2.getSquare().equals(deck.redSafetyZoneSquares[5])){
            infobox.setText("THE WINNER IS PLAYER 2 YELLOW!!!!!");
        }
        else if(deck.pawnRed1.getSquare().equals(deck.redSafetyZoneSquares[5]) && deck.pawnRed2.getSquare().equals(deck.redSafetyZoneSquares[5]))
            infobox.setText("THE WINNER IS PLAYER 1 RED!!!!!!!!!!");
    }

    /**
     * Picks Cards
     */
    public void pickCard(){
        card = deck.card_pick();
        System.out.println(card.getNumber());
        cardFront.setIcon(card.getImage());
    }

    /**
     * Update the Pawns
     */
    public void updatePawns(){
        if(deck.pawnRed1.getSquare() instanceof StartSquare){
            startRed.setLayout(new GridBagLayout());
            startRed.add(pawnRed1,new GridBagConstraints());
        }
        if(deck.pawnRed2.getSquare() instanceof StartSquare){
            startRed.setLayout(new GridBagLayout());
            startRed.add(pawnRed2,new GridBagConstraints());
        }
        if(deck.pawnYellow1.getSquare() instanceof StartSquare){
            startYellow.setLayout(new GridBagLayout());
            startYellow.add(pawnYellow1,new GridBagConstraints());
        }
        if(deck.pawnYellow2.getSquare() instanceof StartSquare){
            startYellow.setLayout(new GridBagLayout());
            startYellow.add(pawnYellow2,new GridBagConstraints());
        }

        if(deck.pawnRed1.getSquare() instanceof SafetyZoneSquare ||deck.pawnRed1.getSquare() instanceof HomeSquare){
            redSafety[deck.pawnRed1.getSquare().getPosition()].setLayout(new GridBagLayout());
            redSafety[deck.pawnRed1.getSquare().getPosition()].add(pawnRed1,new GridBagConstraints());
        }
        if(deck.pawnRed2.getSquare() instanceof SafetyZoneSquare || deck.pawnRed2.getSquare() instanceof HomeSquare){
            redSafety[deck.pawnRed2.getSquare().getPosition()].setLayout(new GridBagLayout());
            redSafety[deck.pawnRed2.getSquare().getPosition()].add(pawnRed2,new GridBagConstraints());
        }
        if(deck.pawnYellow1.getSquare() instanceof SafetyZoneSquare || deck.pawnYellow1.getSquare() instanceof HomeSquare){
            yellowSafety[deck.pawnYellow1.getSquare().getPosition()].setLayout(new GridBagLayout());
            yellowSafety[deck.pawnYellow1.getSquare().getPosition()].add(pawnYellow1,new GridBagConstraints());
        }
        if(deck.pawnYellow2.getSquare() instanceof SafetyZoneSquare || deck.pawnYellow2.getSquare() instanceof HomeSquare){
            yellowSafety[deck.pawnYellow2.getSquare().getPosition()].setLayout(new GridBagLayout());
            yellowSafety[deck.pawnYellow2.getSquare().getPosition()].add(pawnYellow2,new GridBagConstraints());
        }

        if(deck.pawnRed1.getSquare() instanceof SimpleSquare || deck.pawnRed1.getSquare() instanceof SlideSquare){
            Square[deck.pawnRed1.getSquare().getPosition()].setLayout(new GridBagLayout());
            Square[deck.pawnRed1.getSquare().getPosition()].add(pawnRed1,new GridBagConstraints());
        }
        if(deck.pawnRed2.getSquare() instanceof SimpleSquare || deck.pawnRed2.getSquare() instanceof SlideSquare){
            Square[deck.pawnRed2.getSquare().getPosition()].setLayout(new GridBagLayout());
            Square[deck.pawnRed2.getSquare().getPosition()].add(pawnRed2,new GridBagConstraints());
        }
        if(deck.pawnYellow1.getSquare() instanceof SimpleSquare || deck.pawnYellow1.getSquare() instanceof SlideSquare){
            Square[deck.pawnYellow1.getSquare().getPosition()].setLayout(new GridBagLayout());
            Square[deck.pawnYellow1.getSquare().getPosition()].add(pawnYellow1,new GridBagConstraints());
        }
        if(deck.pawnYellow2.getSquare() instanceof SimpleSquare || deck.pawnYellow2.getSquare() instanceof SlideSquare){
            Square[deck.pawnYellow2.getSquare().getPosition()].setLayout(new GridBagLayout());
            Square[deck.pawnYellow2.getSquare().getPosition()].add(pawnYellow2,new GridBagConstraints());
        }
    }

    public static void main(String[] view) {
        View sorry = new View();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object click = e.getSource();
        if (click == cardBack) {
            if(controller.getfirstTime()) {
                pickCard();
            }
            controller.setfirstTime();
            return;
        } else if (click == fold) {
           pickCard();
           System.out.println("Pass");
        }
        else if (click == pawnRed1) {
            if (controller.getTurn() == 1) {
                if(card.getNumber()==0){
                    JFrame prompt=new JFrame("Card Sorry");
                    String[] options={"Pawn 1", "Pawn 2"};
                    String in= (String) JOptionPane.showInputDialog(prompt,"Choose which Pawn","Pawn",JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
                    if(in.equals(options[0])) {
                        deck.move(deck.pawnRed1, deck.board, card,deck.pawnYellow1);
                    }
                    else if(in.equals(options[1])){
                        deck.move(deck.pawnRed1,deck.board,card,deck.pawnYellow2);
                    }
                }
                else if(card.getNumber()==7){
                    JFrame prompt= new JFrame("Card 7");
                    int in1= Integer.parseInt(JOptionPane.showInputDialog(prompt,"Please input how to split 7 for Pawn 1:"));
                    int in2= Integer.parseInt(JOptionPane.showInputDialog(prompt,"Please input how to split 7 for Pawn 2:"));
                    deck.move(deck.pawnRed1,deck.board,new SimpleNumberCard(in1," ",null),null);
                    if(in1<7) {
                        deck.move(deck.pawnRed2, deck.board, new SimpleNumberCard(in2, "", null),null);
                    }
                }
                else if(card.getNumber()==11){
                    JFrame prompt=new JFrame("Card 11");
                    String[] options={"Exchange Pawns","11 Front"};
                    String in= (String) JOptionPane.showInputDialog(prompt,"Choose your move","Move",JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
                    if(in.equals(options[0])){
                        String[] options2={"Pawn 1", "Pawn 2"};
                        in= (String) JOptionPane.showInputDialog(prompt,"Choose which Pawn","Pawn",JOptionPane.QUESTION_MESSAGE,null,options2,options2[0]);
                        if(in.equals(options2[0])) {
                            deck.move(deck.pawnRed1, deck.board, new SimpleNumberCard(99,null,null),deck.pawnYellow1);
                        }
                        else if(in.equals(options2[1])){
                            deck.move(deck.pawnRed1,deck.board,new SimpleNumberCard(99,null,null),deck.pawnYellow2);
                        }
                    }
                    else
                        deck.move(deck.pawnRed1, deck.board, card,null);
                }
                else if(card.getNumber()==10){
                    JFrame prompt=new JFrame("Card 10");
                    String[] options={"10 Front","1 Back"};
                    String in= (String) JOptionPane.showInputDialog(prompt,"Choose your move","Move",JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
                    if (in.equals(options[1]))
                        deck.move(deck.pawnRed1,deck.board,new SimpleNumberCard(-1,"",null),null);
                    else
                        deck.move(deck.pawnRed1, deck.board, card,null);
                }
                else if(card.getNumber()==2){
                    deck.move(deck.pawnRed1,deck.board,card,null);
                    JFrame prompt=new JFrame("Card 2");
                    String[] options={"Pawn 1","Pawn 2"};
                    String in= (String) JOptionPane.showInputDialog(prompt,"Choose which Pawn to Move again","Pawn",JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
                    if(in.equals(options[0])) {
                        deck.move(deck.pawnRed1, deck.board, card,null);
                    }
                    else if(in.equals(options[1])){
                        deck.move(deck.pawnRed2, deck.board, card,null);
                    }
                }
                else
                    deck.move(deck.pawnRed1, deck.board, card,null);
                pickCard();
            }
        }
        else if (click == pawnRed2) {
            if (controller.getTurn() == 1) {
                if(card.getNumber()==0){
                    JFrame prompt=new JFrame("Card Sorry");
                    String[] options={"Pawn 1", "Pawn 2"};
                    String in= (String) JOptionPane.showInputDialog(prompt,"Choose which Pawn","Pawn",JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
                    if(in.equals(options[0])) {
                        deck.move(deck.pawnRed2, deck.board, card,deck.pawnYellow1);
                    }
                    else if(in.equals(options[1])){
                        deck.move(deck.pawnRed2,deck.board,card,deck.pawnYellow2);
                    }
                }
              else if(card.getNumber()==7){
                    JFrame prompt= new JFrame("Card 7");
                    int in1= Integer.parseInt(JOptionPane.showInputDialog(prompt,"Please input how to split 7 for Pawn 1:"));
                    int in2= Integer.parseInt(JOptionPane.showInputDialog(prompt,"Please input how to split 7 for Pawn 2:"));
                    deck.move(deck.pawnRed2,deck.board,new SimpleNumberCard(in2," ",null),null);
                    if(in2<7) {
                        deck.move(deck.pawnRed1, deck.board, new SimpleNumberCard(in1, "", null),null);
                    }
                }
                else if(card.getNumber()==11){
                    JFrame prompt=new JFrame("Card 11");
                    String[] options={"Exchange Pawns","11 Front"};
                    String in= (String) JOptionPane.showInputDialog(prompt,"Choose your move","Move",JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
                    if(in.equals(options[0])){
                        String[] options2={"Pawn 1", "Pawn 2"};
                        in= (String) JOptionPane.showInputDialog(prompt,"Choose which Pawn","Pawn",JOptionPane.QUESTION_MESSAGE,null,options2,options2[0]);
                        if(in.equals(options2[0])) {
                            deck.move(deck.pawnRed2, deck.board, new SimpleNumberCard(99,null,null),deck.pawnYellow1);
                        }
                        else if(in.equals(options2[1])){
                            deck.move(deck.pawnRed2,deck.board,new SimpleNumberCard(99,null,null),deck.pawnYellow2);
                        }
                    }
                    else
                        deck.move(deck.pawnRed2, deck.board, card,null);
                }
                else if(card.getNumber()==10){
                    JFrame prompt=new JFrame("Card 10");
                    String[] options={"10 Front","1 Back"};
                    String in= (String) JOptionPane.showInputDialog(prompt,"Choose your move","Move",JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
                    if (in.equals(options[1]))
                        deck.move(deck.pawnRed2,deck.board,new SimpleNumberCard(-1,"",null),null);
                    else
                        deck.move(deck.pawnRed2, deck.board, card,null);
                }
                else if(card.getNumber()==2){
                    deck.move(deck.pawnRed2,deck.board,card,null);
                    JFrame prompt=new JFrame("Card 2");
                    String[] options={"Pawn 1","Pawn 2"};
                    String in= (String) JOptionPane.showInputDialog(prompt,"Choose which Pawn to Move again","Pawn",JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
                    if(in.equals(options[0])) {
                        deck.move(deck.pawnRed1, deck.board, card,null);
                    }
                    else if(in.equals(options[1])){
                        deck.move(deck.pawnRed2, deck.board, card,null);
                    }
                }
                else
                    deck.move(deck.pawnRed2, deck.board, card,null);
                pickCard();
            }
        }
        else if (click == pawnYellow1) {
            if (controller.getTurn() == 2) {
                if(card.getNumber()==0){
                    JFrame prompt=new JFrame("Card Sorry");
                    String[] options={"Pawn 1", "Pawn 2"};
                    String in= (String) JOptionPane.showInputDialog(prompt,"Choose which Pawn","Pawn",JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
                    if(in.equals(options[0])) {
                        deck.move(deck.pawnYellow1, deck.board, card,deck.pawnRed1);
                    }
                    else if(in.equals(options[1])){
                        deck.move(deck.pawnYellow1,deck.board,card,deck.pawnRed2);
                    }
                }
                else if(card.getNumber()==7){
                    JFrame prompt= new JFrame("Card 7");
                    int in1= Integer.parseInt(JOptionPane.showInputDialog(prompt,"Please input how to split 7 for Pawn 1:"));
                    int in2= Integer.parseInt(JOptionPane.showInputDialog(prompt,"Please input how to split 7 for Pawn 2:"));
                    deck.move(deck.pawnYellow1,deck.board,new SimpleNumberCard(in1," ",null),null);
                    if(in1<7) {
                        deck.move(deck.pawnYellow2, deck.board, new SimpleNumberCard(in2, "", null),null);
                    }
                }
                else if(card.getNumber()==11){
                    JFrame prompt=new JFrame("Card 11");
                    String[] options={"Exchange Pawns","11 Front"};
                    String in= (String) JOptionPane.showInputDialog(prompt,"Choose your move","Move",JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
                    if(in.equals(options[0])){
                        String[] options2={"Pawn 1", "Pawn 2"};
                        in= (String) JOptionPane.showInputDialog(prompt,"Choose which Pawn","Pawn",JOptionPane.QUESTION_MESSAGE,null,options2,options2[0]);
                        if(in.equals(options2[0])) {
                            deck.move(deck.pawnYellow1, deck.board, new SimpleNumberCard(99,null,null),deck.pawnRed1);
                        }
                        else if(in.equals(options2[1])){
                            deck.move(deck.pawnYellow1,deck.board,new SimpleNumberCard(99,null,null),deck.pawnRed2);
                        }
                    }
                    else
                        deck.move(deck.pawnYellow1, deck.board, card,null);
                }
                else if(card.getNumber()==10){
                    JFrame prompt=new JFrame("Card 10");
                    String[] options={"10 Front","1 Back"};
                    String in= (String) JOptionPane.showInputDialog(prompt,"Choose your move","Move",JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
                    if (in.equals(options[1]))
                        deck.move(deck.pawnYellow1,deck.board,new SimpleNumberCard(-1,"",null),null);
                    else
                        deck.move(deck.pawnYellow1, deck.board, card,null);
                }
                else if(card.getNumber()==2){
                    deck.move(deck.pawnYellow1,deck.board,card,null);
                    JFrame prompt=new JFrame("Card 2");
                    String[] options={"Pawn 1","Pawn 2"};
                    String in= (String) JOptionPane.showInputDialog(prompt,"Choose which Pawn to Move again","Pawn",JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
                    if(in.equals(options[0])) {
                        deck.move(deck.pawnYellow1, deck.board, card,null);
                    }
                    else if(in.equals(options[1])){
                        deck.move(deck.pawnYellow2, deck.board, card,null);
                    }
                }
                else
                    deck.move(deck.pawnYellow1, deck.board, card,null);
                pickCard();
            }
        }
        else if (click == pawnYellow2) {
            if (controller.getTurn() == 2) {
                if(card.getNumber()==0){
                    JFrame prompt=new JFrame("Card Sorry");
                    String[] options={"Pawn 1", "Pawn 2"};
                    String in= (String) JOptionPane.showInputDialog(prompt,"Choose which Pawn","Pawn",JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
                    if(in.equals(options[0])) {
                        deck.move(deck.pawnYellow2, deck.board, card,deck.pawnRed1);
                    }
                    else if(in.equals(options[1])){
                        deck.move(deck.pawnYellow2,deck.board,card,deck.pawnRed2);
                    }
                }
                else if(card.getNumber()==7){
                    JFrame prompt= new JFrame("Card 7");
                    int in1= Integer.parseInt(JOptionPane.showInputDialog(prompt,"Please input how to split 7 for Pawn 1:"));
                    int in2= Integer.parseInt(JOptionPane.showInputDialog(prompt,"Please input how to split 7 for Pawn 2:"));
                    deck.move(deck.pawnYellow2,deck.board,new SimpleNumberCard(in2," ",null),null);
                    if(in2<7) {
                        deck.move(deck.pawnYellow1, deck.board, new SimpleNumberCard(in1, "", null),null);
                    }
                }
                else if(card.getNumber()==10){
                    JFrame prompt=new JFrame("Card 10");
                    String[] options={"10 Front","1 Back"};
                    String in= (String) JOptionPane.showInputDialog(prompt,"Choose your move","Move",JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
                    if (in.equals(options[1]))
                        deck.move(deck.pawnYellow2,deck.board,new SimpleNumberCard(-1,"",null),null);
                    else
                        deck.move(deck.pawnYellow2, deck.board, card,null);
                }
                else if(card.getNumber()==11){
                    JFrame prompt=new JFrame("Card 11");
                    String[] options={"Exchange Pawns","11 Front"};
                    String in= (String) JOptionPane.showInputDialog(prompt,"Choose your move","Move",JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
                    if(in.equals(options[0])){
                       String[] options2={"Pawn 1", "Pawn 2"};
                        in= (String) JOptionPane.showInputDialog(prompt,"Choose which Pawn","Pawn",JOptionPane.QUESTION_MESSAGE,null,options2,options2[0]);
                        if(in.equals(options2[0])) {
                            deck.move(deck.pawnYellow2, deck.board, new SimpleNumberCard(99,null,null),deck.pawnRed1);
                        }
                        else if(in.equals(options2[1])){
                            deck.move(deck.pawnYellow2,deck.board,new SimpleNumberCard(99,null,null),deck.pawnRed2);
                        }
                    }
                    else
                        deck.move(deck.pawnYellow2, deck.board, card,null);
                }
                else if(card.getNumber()==2){
                    deck.move(deck.pawnYellow2,deck.board,card,null);
                    JFrame prompt=new JFrame("Card 2");
                    String[] options={"Pawn 1","Pawn 2"};
                    String in= (String) JOptionPane.showInputDialog(prompt,"Choose which Pawn to Move again","Pawn",JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
                    if(in.equals(options[0])) {
                        deck.move(deck.pawnYellow1, deck.board, card,null);
                    }
                    else if(in.equals(options[1])){
                        deck.move(deck.pawnYellow2, deck.board, card,null);
                    }
                }
                else
                    deck.move(deck.pawnYellow2, deck.board, card,null);
                pickCard();
            }
        }
       updatePawns();
        if(!controller.getfirstTime()) {
            if (controller.getTurn() == 1)
                controller.setTurn(2);
            else if (controller.getTurn() == 2)
                controller.setTurn(1);
        }
        controller.setfirstTime();
        infobox.setText("Turn Player "+controller.getTurn() +
                "\nCards Left:"+deck.getDECK_SIZE());
        winner();
        SwingUtilities.updateComponentTreeUI(window);
    }
}
