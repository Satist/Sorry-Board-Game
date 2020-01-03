package Model.Deck;

import Model.Card.*;
import Model.Pawn.Pawn;
import Model.Player.Player;
import Model.Square.*;
import Controller.Controller;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {
    public static final int[] CARD_RANK = {0, 1, 2, 3, 4, 5, 7, 8, 10, 11, 12};
    public final int DECK_SIZE = 44;
    protected List<Card> deck;
    public Square[] board;
    public StartSquare redStartSquare,yellowStartSquare;
    public HomeSquare redHomeSquare,yellowHomeSquare;
    public Square[] redSafetyZoneSquares,yellowSafetyZoneSquares;
    public Player player1,player2;
    public Pawn pawnRed1,pawnRed2,pawnYellow1,pawnYellow2;
    /**
     * <b>Constructor</b>
     */
    public Deck(){
        createDeck();
        init_table();
        init_pawnsnplayers();
    }

    /**
     * Creates deck, initializes deck cards, players and pawns
     */
    private void createDeck(){
        deck= new ArrayList<Card>(DECK_SIZE);
        for (int i = 0; i < 4; i++){
            for (int card : CARD_RANK) {
                if(card==3 || card==5 || card==8 || card==12) {
                    if(card==3)
                        deck.add(new SimpleNumberCard(card, "No special ability",new ImageIcon(Controller.path+"cards/card3.png")));
                    else if(card==5)
                        deck.add(new SimpleNumberCard(card, "No special ability",new ImageIcon(Controller.path+"cards/card5.png")));
                    else if(card==8)
                        deck.add(new SimpleNumberCard(card, "No special ability",new ImageIcon(Controller.path+"cards/card8.png")));
                    else
                        deck.add(new SimpleNumberCard(card, "No special ability",new ImageIcon(Controller.path+"cards/card12.png")));

                }
                else if(card==1)
                    deck.add(new NumberOneCard(card));
                else if(card==2)
                    deck.add(new NumberTwoCard(card));
                else if(card==4)
                    deck.add(new NumberFourCard(card));
                else if(card==7)
                    deck.add(new NumberSevenCard(card));
                else if(card==10)
                    deck.add(new NumberTenCard(card));
                else if(card==11)
                    deck.add(new NumberElevenCard(card));
                else if(card==0)
                    deck.add(new SorryCard(0));
            }
        }
        ((ArrayList) deck).trimToSize();
        shuffle();

    }

    /**
     * Setting up the board
     */
    public void init_table(){
        board=new Square[61];
        //Red Slides
        board[1]= new EndSlideSquare(1,"red",new ImageIcon(Controller.path+"slides/redSlideEnd.png"));
        board[60]= new InternalSlideSquare(60,"red",new ImageIcon(Controller.path+"slides/redSlideMedium.png"));
        board[59]= new InternalSlideSquare(59,"red",new ImageIcon(Controller.path+"slides/redSlideMedium.png"));
        board[58]= new StartSlideSquare(58,"red",new ImageIcon(Controller.path+"slides/redSlideStart.png"));
        board[6]= new StartSlideSquare(6,"red",new ImageIcon(Controller.path+"slides/redSlideStart.png"));
        board[7]= new InternalSlideSquare(7,"red",new ImageIcon(Controller.path+"slides/redSlideMedium.png"));
        board[8]= new InternalSlideSquare(8,"red",new ImageIcon(Controller.path+"slides/redSlideMedium.png"));
        board[9]= new InternalSlideSquare(9,"red",new ImageIcon(Controller.path+"slides/redSlideMedium.png"));
        board[10]= new EndSlideSquare(10,"red",new ImageIcon(Controller.path+"slides/redSlideEnd.png"));
        //Blue Slides
        board[13]= new StartSlideSquare(13,"blue",new ImageIcon(Controller.path+"slides/blueSlideStart.png"));
        board[14]= new InternalSlideSquare(14,"blue",new ImageIcon(Controller.path+"slides/blueSlideMedium.png"));
        board[15]= new InternalSlideSquare(15,"blue",new ImageIcon(Controller.path+"slides/blueSlideMedium.png"));
        board[16]= new EndSlideSquare(16,"blue",new ImageIcon(Controller.path+"slides/blueSlideEnd.png"));
        board[21]= new StartSlideSquare(21,"blue",new ImageIcon(Controller.path+"slides/blueSlideStart.png"));
        board[22]= new InternalSlideSquare(22,"blue",new ImageIcon(Controller.path+"slides/blueSlideMedium.png"));
        board[23]= new InternalSlideSquare(23,"blue",new ImageIcon(Controller.path+"slides/blueSlideMedium.png"));
        board[24]= new InternalSlideSquare(24,"blue",new ImageIcon(Controller.path+"slides/blueSlideMedium.png"));
        board[25]= new EndSlideSquare(25,"blue",new ImageIcon(Controller.path+"slides/blueSlideEnd.png"));
        //Yellow Slides
        board[28]= new StartSlideSquare(28,"yellow",new ImageIcon(Controller.path+"slides/yellowSlideStart.png"));
        board[29]= new InternalSlideSquare(29,"yellow",new ImageIcon(Controller.path+"slides/yellowSlideMedium.png"));
        board[30]= new InternalSlideSquare(30,"yellow",new ImageIcon(Controller.path+"slides/yellowSlideMedium.png"));
        board[31]= new EndSlideSquare(31,"yellow",new ImageIcon(Controller.path+"slides/yellowSlideEnd.png"));
        board[36]= new StartSlideSquare(36,"yellow",new ImageIcon(Controller.path+"slides/yellowSlideStart.png"));
        board[37]= new InternalSlideSquare(37,"yellow",new ImageIcon(Controller.path+"slides/yellowSlideMedium.png"));
        board[38]= new InternalSlideSquare(38,"yellow",new ImageIcon(Controller.path+"slides/yellowSlideMedium.png"));
        board[39]= new InternalSlideSquare(39,"yellow",new ImageIcon(Controller.path+"slides/yellowSlideMedium.png"));
        board[40]= new EndSlideSquare(40,"yellow",new ImageIcon(Controller.path+"slides/yellowSlideEnd.png"));
        //Green Slides
        board[43]= new StartSlideSquare(43,"green",new ImageIcon(Controller.path+"slides/greenSlideStart.png"));
        board[44]= new InternalSlideSquare(44,"green",new ImageIcon(Controller.path+"slides/greenSlideMedium.png"));
        board[45]= new InternalSlideSquare(45,"green",new ImageIcon(Controller.path+"slides/greenSlideMedium.png"));
        board[46]= new EndSlideSquare(46,"green",new ImageIcon(Controller.path+"slides/greenSlideEnd.png"));
        board[51]= new StartSlideSquare(51,"green",new ImageIcon(Controller.path+"slides/greenSlideStart.png"));
        board[52]= new InternalSlideSquare(52,"green",new ImageIcon(Controller.path+"slides/greenSlideMedium.png"));
        board[53]= new InternalSlideSquare(53,"green",new ImageIcon(Controller.path+"slides/greenSlideMedium.png"));
        board[54]= new InternalSlideSquare(54,"green",new ImageIcon(Controller.path+"slides/greenSlideMedium.png"));
        board[55]= new EndSlideSquare(55,"green",new ImageIcon(Controller.path+"slides/greenSlideEnd.png"));
        //initialize the simple square tiles
        for (int i=1;i<=60;i++){
            if(board[i]==null)
                board[i]=new SimpleSquare(i,"white");
        }
        //Init Start Squares
        redStartSquare=new StartSquare(6,"red",new ImageIcon(Controller.path+"HomeSquare.png"));
        yellowStartSquare= new StartSquare(6,"yellow",new ImageIcon(Controller.path+"HomeSquare.png"));
        //Init Safety Zone Squares
        redSafetyZoneSquares=new Square[6];
        yellowSafetyZoneSquares=new Square[6];
        for (int i=0;i<5;i++){
            redSafetyZoneSquares[i]=new SafetyZoneSquare(i,"red",new ImageIcon(Controller.path+"redSafetySquare.png"));
            yellowSafetyZoneSquares[i]=new SafetyZoneSquare(i,"yellow", new ImageIcon(Controller.path+"yellowSafetySquare.png"));
        }
        //Init Home Squares
        redSafetyZoneSquares[5]= new HomeSquare(5,"red",new ImageIcon(Controller.path+"HomeSquare.png"));
        yellowSafetyZoneSquares[5]= new HomeSquare(5,"yellow",new ImageIcon(Controller.path+"HomeSquare.png"));
    }

    /**
     * Initializing the pawns and the players
     */
    public void init_pawnsnplayers(){
        //Init Pawns
        pawnRed1=new Pawn("red",redStartSquare,new ImageIcon(Controller.path+"pawns/redPawn1.png"));
        pawnRed2=new Pawn("red",redStartSquare,new ImageIcon(Controller.path+"pawns/redPawn2.png"));
        pawnYellow1=new Pawn("yellow",yellowStartSquare,new ImageIcon(Controller.path+"pawns/yellowPawn1.png"));
        pawnYellow2=new Pawn("yellow",yellowStartSquare,new ImageIcon(Controller.path+"pawns/yellowPawn2.png"));
        //Init Players
        player1=new Player(pawnRed1,pawnRed2,"red");
        player2=new Player(pawnYellow1,pawnYellow2,"yellow");
    }

    /**
     * Shuffles the cards using Random
     */
    public void shuffle() {
        Random random = new Random();
        for (int i = deck.size(); i > 0; i--) {
            int movedCardIndex = random.nextInt(i);
            Card card = deck.get(movedCardIndex);
            deck.add((i), card);
            deck.remove(movedCardIndex);
        }
    }

    /**
     * Picks card and deletes element from list
     * @param
     * @return the card pick
     */
    public Card card_pick(){
        Card cardPick;
        cardPick=deck.get(0);
        deck.remove(0);
        ((ArrayList)deck).trimToSize();
        check_emptyDeck(deck);
        return cardPick;
    }

    public int getDECK_SIZE(){
        return deck.size();
    }
    /**
     * Checks if deck is empty
     * @param deck
     */
    public void check_emptyDeck(List<Card> deck){
        if (deck.size() == 0){
            createDeck();
        }
    }



    /**
     * Moves the pawn
     * @param pawn
     * @param board
     */
    public void move(Pawn pawn,Square[] board,Card card,Pawn exc) {
        if(pawn.getSquare()==redStartSquare || pawn.getSquare()==yellowStartSquare) {
            if (card.getNumber() == 0) {
                if (!((exc.getSquare() instanceof SafetyZoneSquare) && (exc.getSquare() instanceof HomeSquare) && (exc.getSquare() instanceof StartSquare))) {
                    pawn.setSquare(exc.getSquare());
                    if (exc.getColor().equals("red"))
                        exc.setSquare(redStartSquare);
                    else
                        exc.setSquare(yellowStartSquare);
                }
            }
            if (pawn.getSquare() == redStartSquare) {
                if (card.getNumber() == 1 || card.getNumber() == 2) {
                    pawn.setSquare(board[1]);
                }
            }
            if (pawn.getSquare() == yellowStartSquare) {
                if (card.getNumber() == 1 || card.getNumber() == 2) {
                    pawn.setSquare(board[31]);
                }
            }
        }
        else if(pawn.getSquare() instanceof SafetyZoneSquare){
            if(pawn.getColor().equals("red")){
                if(card.getNumber()<6-pawn.getSquare().getPosition())
                    pawn.setSquare(redSafetyZoneSquares[pawn.getSquare().getPosition()+card.getNumber()]);
                else
                    return;
            }
            else if(pawn.getColor().equals("yellow")){
                if(card.getNumber()<6-pawn.getSquare().getPosition())
                    pawn.setSquare(yellowSafetyZoneSquares[pawn.getSquare().getPosition()+card.getNumber()]);
                else
                    return;
            }
        }
        else {
            if(card.getNumber()==99){
                if(!((exc.getSquare() instanceof SafetyZoneSquare) && (exc.getSquare() instanceof HomeSquare) && (exc.getSquare() instanceof StartSquare))) {
                    if(!(pawn.getSquare() instanceof StartSquare)) {
                        pawn.setSquare(exc.getSquare());
                        if (exc.getColor().equals("red"))
                            exc.setSquare(redStartSquare);
                        else
                            exc.setSquare(yellowStartSquare);
                    }
                }
            }
           else if(card.getNumber()==4){
               for (int i=1;i<=4;i++) {
                   if(pawn.getSquare().getPosition()==1)
                       pawn.setSquare(board[60]);
                   else
                       pawn.setSquare(board[pawn.getSquare().getPosition() - 1]);
               }
            }
            else {
                for (int i=1;i<=card.getNumber();i++) {
                    if(pawn.getSquare().getPosition()==60) {
                        pawn.setSquare(board[1]);
                        i++;
                    }
                  else if(pawn.getColor().equals("yellow") && pawn.getSquare().getPosition()==29) {
                        if (card.getNumber() - i+1 < 6) {
                            for (int j = 0; j < card.getNumber() - i+1; j++) {
                                pawn.setSquare(yellowSafetyZoneSquares[j]);
                            }
                            break;
                        }
                        else {
                            pawn.setSquare(board[pawn.getSquare().getPosition() - i+1]);
                            break;
                        }
                    }
                  else if (pawn.getColor().equals("red") && pawn.getSquare().getPosition() == 59) {
                            if (card.getNumber() - i +1< 6) {
                                for (int j = 0; j < card.getNumber() - i+1; j++) {
                                    pawn.setSquare(redSafetyZoneSquares[j]);
                                }
                                break;
                            }
                            else {
                                pawn.setSquare(board[pawn.getSquare().getPosition() - i+1]);
                                break;
                            }
                        }
                    else
                        pawn.setSquare(board[pawn.getSquare().getPosition() + 1]);
                }
            }
        }
        if(pawn.getSquare().getPosition()==58 || pawn.getSquare().getPosition()==13 || pawn.getSquare().getPosition()==28 ||
        pawn.getSquare().getPosition()==43){
            if(!pawn.getColor().equals(pawn.getSquare().getColor())) {
                for (int i=1;i<3;i++){
                    if(pawnRed1.getSquare().equals(board[pawn.getSquare().getPosition()+i]))
                        pawnRed1.setSquare(redStartSquare);
                    if(pawnRed2.getSquare().equals(board[pawn.getSquare().getPosition()+i]))
                        pawnRed2.setSquare(redStartSquare);
                    if(pawnYellow1.getSquare().equals(board[pawn.getSquare().getPosition()+i]))
                        pawnYellow1.setSquare(yellowStartSquare);
                    if(pawnYellow2.getSquare().equals(board[pawn.getSquare().getPosition()+i]))
                        pawnYellow2.setSquare(yellowStartSquare);
                }
                pawn.setSquare(board[pawn.getSquare().getPosition() + 3]);
            }
        }
        else if(pawn.getSquare().getPosition()==6 || pawn.getSquare().getPosition()==21 || pawn.getSquare().getPosition()==36 ||
        pawn.getSquare().getPosition()==51) {
            if (!pawn.getColor().equals(pawn.getSquare().getColor())) {
                for (int i=1;i<4;i++){
                    if(pawnRed1.getSquare().equals(board[pawn.getSquare().getPosition()+i]))
                        pawnRed1.setSquare(redStartSquare);
                    if(pawnRed2.getSquare().equals(board[pawn.getSquare().getPosition()+i]))
                        pawnRed2.setSquare(redStartSquare);
                    if(pawnYellow1.getSquare().equals(board[pawn.getSquare().getPosition()+i]))
                        pawnYellow1.setSquare(yellowStartSquare);
                    if(pawnYellow2.getSquare().equals(board[pawn.getSquare().getPosition()+i]))
                        pawnYellow2.setSquare(yellowStartSquare);
                }
                pawn.setSquare(board[pawn.getSquare().getPosition() + 4]);
            }
        }
        if(pawn.getColor().equals("red")){
            if(pawn.getSquare().equals(pawnYellow1.getSquare()))
                pawnYellow1.setSquare(yellowStartSquare);
            else if(pawn.getSquare().equals(pawnYellow2.getSquare()))
                pawnYellow2.setSquare(yellowStartSquare);
        }
        else {
            if (pawn.getSquare().equals(pawnRed1.getSquare()))
                pawnRed1.setSquare(redStartSquare);
            else if (pawn.getSquare().equals(pawnRed2.getSquare()))
                pawnRed2.setSquare(redStartSquare);
        }
    }
}
