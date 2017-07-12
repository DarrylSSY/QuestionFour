import java.util.Scanner;
import java.util.LinkedList;

/**
 * Created by ssyda on 2017-07-07.
 */
public class Main
{
    public static void main(String[] args)
    {
        LinkedList list = new LinkedList();

        Scanner sc = new Scanner(System.in);
        DoublyLinkedList deck = new DoublyLinkedList();
        DoublyLinkedList player1 = new DoublyLinkedList();
        DoublyLinkedList player2 = new DoublyLinkedList();
        DoublyLinkedList player3 = new DoublyLinkedList();
        DoublyLinkedList player4 = new DoublyLinkedList();
        String[] suits = {"Spades", "Diamonds", "Clubs", "Hearts"};

        String[] values = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};

        for(int x = 0; x < suits.length; x++)
        {
            for(int y = 0; y < values.length; y++)
            {
                deck.insertFirst(values[y] + " of " + suits[x]);

            }
        }
        for (int loopCount = 0; loopCount < 10; loopCount++) {
            System.out.println("Select choice: ");
            int choice = sc.nextInt();
            //restart and shuffle
            if (choice == 1) {
                deck.shuffle();
                if (!(player1.isEmpty()))
                    returnToDeck(deck, player1);
                if (!(player2.isEmpty()))
                    returnToDeck(deck, player2);
                if (!(player3.isEmpty()))
                    returnToDeck(deck, player3);
                if (!(player4.isEmpty()))
                    returnToDeck(deck, player4);
            }

            //distribute
            if (choice == 2) {
                player1.insertLast(deck.deleteLast().getData().toString());
                player1.insertLast(deck.deleteFirst().getData().toString());
                player2.insertLast(deck.deleteLast().getData().toString());
                player2.insertLast(deck.deleteFirst().getData().toString());
                player3.insertLast(deck.deleteLast().getData().toString());
                player3.insertLast(deck.deleteFirst().getData().toString());
                player4.insertLast(deck.deleteLast().getData().toString());
                player4.insertLast(deck.deleteFirst().getData().toString());
            }

            //show deck and player cards
            if (choice == 3) {
                deck.displayForward();
                player1.displayForward();
                player2.displayForward();
                player3.displayForward();
                player4.displayForward();
            }

            //swap cards
            if (choice == 4) {
                int personA = (int) (Math.random() * 4 + 1);
                int personB = (int) (Math.random() * 4 + 1);
                int swap = (int) (Math.random() * 2 + 0);
                if (personA == 1 && personB == 2) {
                    if (swap == 0) {
                        player1.insertLast(player2.deleteFirst().getData().toString());
                        player2.insertLast(player1.deleteFirst().getData().toString());
                    } else {
                        player1.insertFirst(player2.deleteLast().getData().toString());
                        player2.insertFirst(player1.deleteLast().getData().toString());
                    }
                } else if (personA == 1 && personB == 3) {
                    if (swap == 0) {
                        player1.insertLast(player3.deleteFirst().getData().toString());
                        player3.insertLast(player1.deleteFirst().getData().toString());
                    } else {
                        player1.insertFirst(player3.deleteLast().getData().toString());
                        player3.insertFirst(player1.deleteLast().getData().toString());
                    }
                } else if (personA == 1 && personB == 4) {
                    if (swap == 0) {
                        player1.insertLast(player4.deleteFirst().getData().toString());
                        player4.insertLast(player1.deleteFirst().getData().toString());
                    } else {
                        player1.insertFirst(player4.deleteLast().getData().toString());
                        player4.insertFirst(player1.deleteLast().getData().toString());
                    }
                } else if (personA == 2 && personB == 3) {
                    if (swap == 0) {
                        player2.insertLast(player3.deleteFirst().getData().toString());
                        player3.insertLast(player2.deleteFirst().getData().toString());
                    } else {
                        player2.insertFirst(player3.deleteLast().getData().toString());
                        player3.insertFirst(player2.deleteLast().getData().toString());
                    }
                } else if (personA == 2 && personB == 4) {
                    if (swap == 0) {
                        player2.insertLast(player4.deleteFirst().getData().toString());
                        player4.insertLast(player2.deleteFirst().getData().toString());
                    } else {
                        player2.insertFirst(player4.deleteLast().getData().toString());
                        player4.insertFirst(player2.deleteLast().getData().toString());
                    }
                } else if (personA == 3 && personB == 4) {
                    if (swap == 0) {
                        player3.insertLast(player4.deleteFirst().getData().toString());
                        player4.insertLast(player3.deleteFirst().getData().toString());
                    } else {
                        player3.insertFirst(player4.deleteLast().getData().toString());
                        player4.insertFirst(player3.deleteLast().getData().toString());
                    }
                }
            }
            //find the winner
            if (choice == 5) {
                String player1x = player1.getHead().getData().toString();
                String player1y = player1.getHead().getNext().getData().toString();
                returnToDeck(deck, player1);
                double player1Value = countValue(player1x) + countValue(player1y);

                String player2x = player2.getHead().getData().toString();
                String player2y = player2.getHead().getNext().getData().toString();
                returnToDeck(deck, player2);
                double player2Value = countValue(player2x) + countValue(player2y);

                String player3x = player3.getHead().getData().toString();
                String player3y = player3.getHead().getNext().getData().toString();
                returnToDeck(deck, player3);
                double player3Value = countValue(player3x) + countValue(player3y);

                String player4x = player4.getHead().getData().toString();
                String player4y = player4.getHead().getNext().getData().toString();
                returnToDeck(deck, player4);
                double player4Value = countValue(player4x) + countValue(player4y);

                double max = player1Value;
                String winner = "Player 1";

                if (player2Value > max)
                    winner = "Player 2";
                if (player3Value > max)
                    winner = "Player 3";
                if (player4Value > max)
                    winner = "Player 4";

                System.out.println("Winner is " + winner);
            }
        }





        }
    public static double countValue(String card) {
        double x = 0;
        double y = 0;
        if (card.startsWith("Ace"))
            x = 1;
        else if (card.startsWith("2"))
            x = 2;
        else if (card.startsWith("3"))
            x = 3;
        else if (card.startsWith("4"))
            x = 4;
        else if (card.startsWith("5"))
            x = 5;
        else if (card.startsWith("6"))
            x = 6;
        else if (card.startsWith("7"))
            x = 7;
        else if (card.startsWith("8"))
            x = 8;
        else if (card.startsWith("9"))
            x = 9;
        else if (card.startsWith("10"))
            x = 10;
        else if (card.startsWith("Jack"))
            x = 11;
        else if (card.startsWith("Queen"))
            x = 12;
        else if (card.startsWith("King"))
            x = 13;
        if (card.endsWith("Diamonds"))
            y = 0.1;
        else if (card.endsWith("Clubs"))
            y = 0.2;
        else if (card.endsWith("Hearts"))
            y = 0.3;
        else if (card.endsWith("Spades"))
            y = 0.4;
        double value = x + y;




        return value;
    }

    public static void returnToDeck(DoublyLinkedList deck, DoublyLinkedList holding)
    {
        while (!holding.isEmpty()) {
            System.out.println(holding.getHead().getData());
            deck.insertFirst(holding.deleteFirst().getData().toString());
//


        }
    }

}

