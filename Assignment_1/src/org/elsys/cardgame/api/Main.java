package org.elsys.cardgame.api;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Card> cards = new ArrayList<Card>();

        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        for(String word : line.split(" ")) {
            final String finalWordSuit = word;
            Suit suit = Arrays.stream(Suit.values())
                    .filter(s -> s.toString().charAt(0) == finalWordSuit.charAt(0))
                    .toList().getFirst();

            word = word.substring(1);

            Rank rank;
            if(word.matches("\\d{1,2}")) {
                int number = Integer.parseInt(word);
                rank = Rank.values()[number - 2];
            }
            else {
                final String finalWordRank = word;
                rank = Arrays.stream(Rank.values())
                        .filter(s -> s.toString().charAt(0) == finalWordRank.charAt(0))
                        .toList().getFirst();
            }

            cards.add(new CardImpl(rank, suit));
        }

        Game game = GameFactory.createTempGame();
        boolean hasDeck = false;
        Set<String> gameOperations = new HashSet<>();
        gameOperations.add("War");
        gameOperations.add("Belote");
        gameOperations.add("Santase");
        while(true) {
            String operation = sc.next();
            if(operation.equals("quit")) {
                break;
            }
            else if(!gameOperations.contains(operation) && !hasDeck) {
                System.out.println("ERROR: No deck");
            }
            else if(gameOperations.contains(operation)) {
                hasDeck = true;
                switch(operation) {
                    case "War":
                        try {
                            game = GameFactory.createWarGame(cards);
                        }
                        catch (CardException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case "Belote":
                        try {
                            game = GameFactory.createBeloteGame(cards);
                        }
                        catch (CardException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case "Santase":
                        try {
                            game = GameFactory.createSantaseGame(cards);
                        }
                        catch (CardException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                }
            }
            else if(game.getOperationNames().contains(operation)) {
                try {
                    game.process(operation);
                }
                catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            else {
                System.out.println("ERROR: Unknown operation");
            }
        }
    }
}