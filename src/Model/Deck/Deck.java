package Model.Deck;

import Model.Card.*;
import Model.Pawn.Pawn;
import Model.Player.Player;
import Model.Square.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {
    public static final int[] CARD_RANK = {0, 1, 2, 3, 4, 5, 7, 8, 10, 11, 12};
    public final int DECK_SIZE = 44;
    protected List<Card> deck;
    protected Square[] board;
    protected StartSquare redStartSquare,yellowStartSquare;
    protected HomeSquare redHomeSquare,yellowHomeSquare;
    protected SafetyZoneSquare[] redSafetyZoneSquares,yellowSafetyZoneSquares;
    protected Player player1,player2;
    protected Pawn pawnRed1,pawnRed2,pawnYellow1,pawnYellow2;
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
                if(card==3 || card==5 || card==8 || card==12)
                    deck.add(new SimpleNumberCard(card,"No special ability"));
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
        board[1]= new EndSlideSquare(1,"red");
        board[60]= new InternalSlideSquare(60,"red");
        board[59]= new InternalSlideSquare(59,"red");
        board[58]= new StartSlideSquare(58,"red");
        board[6]= new StartSlideSquare(6,"red");
        board[7]= new InternalSlideSquare(7,"red");
        board[8]= new InternalSlideSquare(8,"red");
        board[9]= new InternalSlideSquare(9,"red");
        board[10]= new EndSlideSquare(10,"red");
        //Blue Slides
        board[13]= new StartSlideSquare(13,"blue");
        board[14]= new InternalSlideSquare(14,"blue");
        board[15]= new InternalSlideSquare(15,"blue");
        board[16]= new EndSlideSquare(16,"blue");
        board[21]= new StartSlideSquare(21,"blue");
        board[22]= new InternalSlideSquare(22,"blue");
        board[23]= new InternalSlideSquare(23,"blue");
        board[24]= new InternalSlideSquare(24,"blue");
        board[25]= new EndSlideSquare(25,"blue");
        //Yellow Slides
        board[28]= new StartSlideSquare(28,"yellow");
        board[29]= new InternalSlideSquare(29,"yellow");
        board[30]= new InternalSlideSquare(30,"yellow");
        board[31]= new EndSlideSquare(31,"yellow");
        board[36]= new StartSlideSquare(36,"yellow");
        board[37]= new InternalSlideSquare(37,"yellow");
        board[38]= new InternalSlideSquare(38,"yellow");
        board[39]= new InternalSlideSquare(39,"yellow");
        board[40]= new EndSlideSquare(40,"yellow");
        //Green Slides
        board[43]= new StartSlideSquare(43,"green");
        board[44]= new InternalSlideSquare(44,"green");
        board[45]= new InternalSlideSquare(45,"green");
        board[46]= new EndSlideSquare(46,"green");
        board[51]= new StartSlideSquare(51,"green");
        board[52]= new InternalSlideSquare(52,"green");
        board[53]= new InternalSlideSquare(53,"green");
        board[54]= new InternalSlideSquare(54,"green");
        board[55]= new EndSlideSquare(55,"green");
        //initialize the simple square tiles
        for (int i=1;i<=60;i++){
            if(board[i]!=null)
                board[i]=new SimpleSquare(i,"white");
        }
        //Init Start Squares
        redStartSquare=new StartSquare(0,"red");
        yellowStartSquare= new StartSquare(0,"yellow");
        //Init Home Squares
        redHomeSquare= new HomeSquare(0,"red");
        yellowHomeSquare= new HomeSquare(0,"yellow");
        //Init Safety Zone Squares
        redSafetyZoneSquares=new SafetyZoneSquare[5];
        yellowSafetyZoneSquares=new SafetyZoneSquare[5];
        for (int i=0;i<5;i++){
            redSafetyZoneSquares[i]=new SafetyZoneSquare(i,"red");
            yellowSafetyZoneSquares[i]=new SafetyZoneSquare(i,"yellow");
        }
    }

    /**
     * Initializing the pawns and the players
     */
    public void init_pawnsnplayers(){
        //Init Pawns
        pawnRed1=new Pawn("red",redStartSquare);
        pawnRed2=new Pawn("red",redStartSquare);
        pawnYellow1=new Pawn("yellow",yellowStartSquare);
        pawnYellow2=new Pawn("yellow",yellowStartSquare);
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
     * @param deck
     * @return the card pick
     */
    public Card card_pick(List<Card> deck){
        Card cardPick;
        cardPick=deck.get(0);
        deck.remove(0);
        return cardPick;
    }

    /**
     * Checks if deck is empty
     * @param deck
     * @return True if the deck is empty
     */
    public void check_emptyDeck(List<Deck> deck){
        if (deck.size() == 0){
            createDeck();
        }
    }

    /**
     * Moves the pawn
     * @param pawn
     * @param board
     */
    public void move(Pawn pawn,Square[] board,Card card){

    }

    /**
     * Checks if player can fold
     * @return
     */
    public boolean check_fold(){
        return true;
    }
}
