package Model.Deck;

import Model.Card.*;
import Model.Pawn.Pawn;
import Model.Player.Player;
import Model.Square.*;

import javax.swing.*;
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
                if(card==3 || card==5 || card==8 || card==12) {
                    if(card==3)
                        deck.add(new SimpleNumberCard(card, "No special ability",new ImageIcon("C:\\Users\\glamprou\\IdeaProjects\\Project Sorry!\\src\\images\\cards\\card3.png")));
                    else if(card==5)
                        deck.add(new SimpleNumberCard(card, "No special ability",new ImageIcon("C:\\Users\\glamprou\\IdeaProjects\\Project Sorry!\\src\\images\\cards\\card5.png")));
                    else if(card==8)
                        deck.add(new SimpleNumberCard(card, "No special ability",new ImageIcon("C:\\Users\\glamprou\\IdeaProjects\\Project Sorry!\\src\\images\\cards\\card8.png")));
                    else
                        deck.add(new SimpleNumberCard(card, "No special ability",new ImageIcon("C:\\Users\\glamprou\\IdeaProjects\\Project Sorry!\\src\\images\\cards\\card12.png")));

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
        board[1]= new EndSlideSquare(1,"red",new ImageIcon("C:\\Users\\glamprou\\IdeaProjects\\Project Sorry!\\src\\images\\slides\\redSlideEnd.png"));
        board[60]= new InternalSlideSquare(60,"red",new ImageIcon("C:\\Users\\glamprou\\IdeaProjects\\Project Sorry!\\src\\images\\slides\\redSlideMedium.png"));
        board[59]= new InternalSlideSquare(59,"red",new ImageIcon("C:\\Users\\glamprou\\IdeaProjects\\Project Sorry!\\src\\images\\slides\\redSlideMedium.png"));
        board[58]= new StartSlideSquare(58,"red",new ImageIcon("C:\\Users\\glamprou\\IdeaProjects\\Project Sorry!\\src\\images\\slides\\redSlideStart.png"));
        board[6]= new StartSlideSquare(6,"red",new ImageIcon("C:\\Users\\glamprou\\IdeaProjects\\Project Sorry!\\src\\images\\slides\\redSlideStart.png"));
        board[7]= new InternalSlideSquare(7,"red",new ImageIcon("C:\\Users\\glamprou\\IdeaProjects\\Project Sorry!\\src\\images\\slides\\redSlideMedium.png"));
        board[8]= new InternalSlideSquare(8,"red",new ImageIcon("C:\\Users\\glamprou\\IdeaProjects\\Project Sorry!\\src\\images\\slides\\redSlideMedium.png"));
        board[9]= new InternalSlideSquare(9,"red",new ImageIcon("C:\\Users\\glamprou\\IdeaProjects\\Project Sorry!\\src\\images\\slides\\redSlideMedium.png"));
        board[10]= new EndSlideSquare(10,"red",new ImageIcon("C:\\Users\\glamprou\\IdeaProjects\\Project Sorry!\\src\\images\\slides\\redSlideEnd.png"));
        //Blue Slides
        board[13]= new StartSlideSquare(13,"blue",new ImageIcon("C:\\Users\\glamprou\\IdeaProjects\\Project Sorry!\\src\\images\\slides\\blueSlideStart.png"));
        board[14]= new InternalSlideSquare(14,"blue",new ImageIcon("C:\\Users\\glamprou\\IdeaProjects\\Project Sorry!\\src\\images\\slides\\blueSlideMedium.png"));
        board[15]= new InternalSlideSquare(15,"blue",new ImageIcon("C:\\Users\\glamprou\\IdeaProjects\\Project Sorry!\\src\\images\\slides\\blueSlideMedium.png"));
        board[16]= new EndSlideSquare(16,"blue",new ImageIcon("C:\\Users\\glamprou\\IdeaProjects\\Project Sorry!\\src\\images\\slides\\blueSlideEnd.png"));
        board[21]= new StartSlideSquare(21,"blue",new ImageIcon("C:\\Users\\glamprou\\IdeaProjects\\Project Sorry!\\src\\images\\slides\\blueSlideStart.png"));
        board[22]= new InternalSlideSquare(22,"blue",new ImageIcon("C:\\Users\\glamprou\\IdeaProjects\\Project Sorry!\\src\\images\\slides\\blueSlideMedium.png"));
        board[23]= new InternalSlideSquare(23,"blue",new ImageIcon("C:\\Users\\glamprou\\IdeaProjects\\Project Sorry!\\src\\images\\slides\\blueSlideMedium.png"));
        board[24]= new InternalSlideSquare(24,"blue",new ImageIcon("C:\\Users\\glamprou\\IdeaProjects\\Project Sorry!\\src\\images\\slides\\blueSlideMedium.png"));
        board[25]= new EndSlideSquare(25,"blue",new ImageIcon("C:\\Users\\glamprou\\IdeaProjects\\Project Sorry!\\src\\images\\slides\\blueSlideEnd.png"));
        //Yellow Slides
        board[28]= new StartSlideSquare(28,"yellow",new ImageIcon("C:\\Users\\glamprou\\IdeaProjects\\Project Sorry!\\src\\images\\slides\\yellowSlideStart.png"));
        board[29]= new InternalSlideSquare(29,"yellow",new ImageIcon("C:\\Users\\glamprou\\IdeaProjects\\Project Sorry!\\src\\images\\slides\\yellowSlideMedium.png"));
        board[30]= new InternalSlideSquare(30,"yellow",new ImageIcon("C:\\Users\\glamprou\\IdeaProjects\\Project Sorry!\\src\\images\\slides\\yellowSlideMedium.png"));
        board[31]= new EndSlideSquare(31,"yellow",new ImageIcon("C:\\Users\\glamprou\\IdeaProjects\\Project Sorry!\\src\\images\\slides\\yellowSlideEnd.png"));
        board[36]= new StartSlideSquare(36,"yellow",new ImageIcon("C:\\Users\\glamprou\\IdeaProjects\\Project Sorry!\\src\\images\\slides\\yellowSlideStart.png"));
        board[37]= new InternalSlideSquare(37,"yellow",new ImageIcon("C:\\Users\\glamprou\\IdeaProjects\\Project Sorry!\\src\\images\\slides\\yellowSlideMedium.png"));
        board[38]= new InternalSlideSquare(38,"yellow",new ImageIcon("C:\\Users\\glamprou\\IdeaProjects\\Project Sorry!\\src\\images\\slides\\yellowSlideMedium.png"));
        board[39]= new InternalSlideSquare(39,"yellow",new ImageIcon("C:\\Users\\glamprou\\IdeaProjects\\Project Sorry!\\src\\images\\slides\\yellowSlideMedium.png"));
        board[40]= new EndSlideSquare(40,"yellow",new ImageIcon("C:\\Users\\glamprou\\IdeaProjects\\Project Sorry!\\src\\images\\slides\\yellowSlideEnd.png"));
        //Green Slides
        board[43]= new StartSlideSquare(43,"green",new ImageIcon("C:\\Users\\glamprou\\IdeaProjects\\Project Sorry!\\src\\images\\slides\\greenSlideStart.png"));
        board[44]= new InternalSlideSquare(44,"green",new ImageIcon("C:\\Users\\glamprou\\IdeaProjects\\Project Sorry!\\src\\images\\slides\\greenSlideMedium.png"));
        board[45]= new InternalSlideSquare(45,"green",new ImageIcon("C:\\Users\\glamprou\\IdeaProjects\\Project Sorry!\\src\\images\\slides\\greenSlideMedium.png"));
        board[46]= new EndSlideSquare(46,"green",new ImageIcon("C:\\Users\\glamprou\\IdeaProjects\\Project Sorry!\\src\\images\\slides\\greenSlideEnd.png"));
        board[51]= new StartSlideSquare(51,"green",new ImageIcon("C:\\Users\\glamprou\\IdeaProjects\\Project Sorry!\\src\\images\\slides\\greenSlideStart.png"));
        board[52]= new InternalSlideSquare(52,"green",new ImageIcon("C:\\Users\\glamprou\\IdeaProjects\\Project Sorry!\\src\\images\\slides\\greenSlideMedium.png"));
        board[53]= new InternalSlideSquare(53,"green",new ImageIcon("C:\\Users\\glamprou\\IdeaProjects\\Project Sorry!\\src\\images\\slides\\greenSlideMedium.png"));
        board[54]= new InternalSlideSquare(54,"green",new ImageIcon("C:\\Users\\glamprou\\IdeaProjects\\Project Sorry!\\src\\images\\slides\\greenSlideMedium.png"));
        board[55]= new EndSlideSquare(55,"green",new ImageIcon("C:\\Users\\glamprou\\IdeaProjects\\Project Sorry!\\src\\images\\slides\\greenSlideEnd.png"));
        //initialize the simple square tiles
        for (int i=1;i<=60;i++){
            if(board[i]!=null)
                board[i]=new SimpleSquare(i,"white");
        }
        //Init Start Squares
        redStartSquare=new StartSquare(0,"red",new ImageIcon(""));
        yellowStartSquare= new StartSquare(0,"yellow",new ImageIcon(""));
        //Init Home Squares
        redHomeSquare= new HomeSquare(0,"red",new ImageIcon(""));
        yellowHomeSquare= new HomeSquare(0,"yellow",new ImageIcon(""));
        //Init Safety Zone Squares
        redSafetyZoneSquares=new SafetyZoneSquare[5];
        yellowSafetyZoneSquares=new SafetyZoneSquare[5];
        for (int i=0;i<5;i++){
            redSafetyZoneSquares[i]=new SafetyZoneSquare(i,"red",new ImageIcon(""));
            yellowSafetyZoneSquares[i]=new SafetyZoneSquare(i,"yellow", new ImageIcon(""));
        }
    }

    /**
     * Initializing the pawns and the players
     */
    public void init_pawnsnplayers(){
        //Init Pawns
        pawnRed1=new Pawn("red",redStartSquare,new ImageIcon("C:\\Users\\glamprou\\IdeaProjects\\Project Sorry!\\src\\images\\pawns\\redPawn1.png"));
        pawnRed2=new Pawn("red",redStartSquare,new ImageIcon("C:\\Users\\glamprou\\IdeaProjects\\Project Sorry!\\src\\images\\pawns\\redPawn2.png"));
        pawnYellow1=new Pawn("yellow",yellowStartSquare,new ImageIcon("C:\\Users\\glamprou\\IdeaProjects\\Project Sorry!\\src\\images\\pawns\\yellowPawn1.png"));
        pawnYellow2=new Pawn("yellow",yellowStartSquare,new ImageIcon("C:\\Users\\glamprou\\IdeaProjects\\Project Sorry!\\src\\images\\pawns\\yellowPawn2.png"));
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
