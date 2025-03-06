import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Monkey {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    // Card constants
    static final String[] SUITS = {"♣", "♦", "♥", "♠"}; 
    static final String[] RANKS = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    static final String[] SUIT_NAMES = {"Clubs", "Diamonds", "Hearts", "Spades"};
    static String[][] players = new String[4][13]; // Max 13 cards per player
    static int[] playerCardCount = {0, 0, 0, 0}; // Track card count per player
    static String[] deck = new String[52];

    static void Title() {
        System.out.println("  █████████████████████████████████████████████████████████████████████████████");
        System.out.println("");
        System.out.println("███╗   ███╗ ██████╗ ███╗   ██╗██╗  ██╗███████╗██╗   ██╗    ");
        System.out.println("████╗ ████║██╔═══██╗████╗  ██║██║ ██╔╝██╔════╝╚██╗ ██╔╝    ");
        System.out.println("██╔████╔██║██║   ██║██╔██╗ ██║█████╔╝ █████╗   ╚████╔╝     ");
        System.out.println("██║╚██╔╝██║██║   ██║██║╚██╗██║██╔═██╗ ██╔══╝    ╚██╔╝      ");
        System.out.println("██║ ╚═╝ ██║╚██████╔╝██║ ╚████║██║  ██╗███████╗   ██║       ");
        System.out.println("╚═╝     ╚═╝ ╚═════╝ ╚═╝  ╚═══╝╚═╝  ╚═╝╚══════╝   ╚═╝       ");
        System.out.println("                                                           ");
        System.out.println("███╗   ███╗ ██████╗ ███╗   ██╗██╗  ██╗███████╗██╗   ██╗    ");
        System.out.println("████╗ ████║██╔═══██╗████╗  ██║██║ ██╔╝██╔════╝╚██╗ ██╔╝    ");
        System.out.println("██╔████╔██║██║   ██║██╔██╗ ██║█████╔╝ █████╗   ╚████╔╝     ");
        System.out.println("██║╚██╔╝██║██║   ██║██║╚██╗██║██╔═██╗ ██╔══╝    ╚██╔╝      ");
        System.out.println("██║ ╚═╝ ██║╚██████╔╝██║ ╚████║██║  ██╗███████╗   ██║       ");
        System.out.println("╚═╝     ╚═╝ ╚═════╝ ╚═╝  ╚═══╝╚═╝  ╚═╝╚══════╝   ╚═╝       ");
        System.out.println("                                                           ");
        System.out.println("");
        System.out.println("  █████████████████████████████████████████████████████████████████████████████");
    }

    static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    } 

    public static void main(String[] args) {
        Title();
        System.out.println("1. Start Game");
        System.out.println("2. How to Play");
        System.out.println("Enter your choice:");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                clearScreen();
                
                break;
            case 2:
                clearScreen();
                System.out.println("How to Play");
                System.out.println("The game is played by 4 players. Each player is dealt 13 cards.");
                System.out.println("The player with the highest card wins the round.");
                System.out.println("The game continues until all 52 cards are played.");
                System.out.println("The player with the most number of rounds won is the winner.");
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
        // Define card suits and ranks
        String[] SUITS = {"♣", "♠", "♥", "♦"};
        String[] SUIT_NAMES = {"Clubs", "Spades", "Hearts", "Diamonds"};
        String[] RANKS = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

        // Print suit names
        for (String suitName : SUIT_NAMES) {
            System.out.printf("%-10s", suitName);
        }
        System.out.println("\n");

        // Create and display the deck
        String[] deck = new String[52];
        int cardIndex = 0;
        
        for (String rank : RANKS) {
            // Top border
            for (String suit : SUITS) {
                System.out.print("+----+\t");
            }
            System.out.println();

            // Rank
            for (String suit : SUITS) {
                System.out.printf("| %-2s |\t", rank);
                deck[cardIndex++] = rank + suit;
            }
            System.out.println();

            // Suit
            for (String suit : SUITS) {
                System.out.printf("|  %s |\t", suit);
            }
            System.out.println();

            // Bottom border
            for (String suit : SUITS) {
                System.out.print("+----+\t");
            }
            System.out.println();
        }

        // Pick a random card from the deck
        Random rand = new Random();
        String chosenCard = deck[rand.nextInt(52)];
        System.out.println("\nRandomly Picked Card: ");

        // Display the chosen card in ASCII art
        System.out.println("+----+");
        System.out.printf("| %-2s |\n", chosenCard.substring(0, chosenCard.length() - 1));
        System.out.printf("|  %s |\n", chosenCard.substring(chosenCard.length() - 1));
        System.out.println("+----+");

        System.out.println("Enter any key to shuffle the cards:");
        scanner.next();
        // Remove the chosen card from the deck
        for (int i = 0; i < deck.length; i++) {
            if (deck[i].equals(chosenCard)) {
            deck[i] = deck[deck.length - 1];
            deck = Arrays.copyOf(deck, deck.length - 1);
            break;
            }
        }
        System.out.println("Deck after removing the chosen card:");
        System.out.println("\n");

        // Shuffle the deck after removing the chosen card
        for (int i = deck.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            String temp = deck[i];
            deck[i] = deck[j];
            deck[j] = temp;
        }

        // Visual representation of the deck after shuffling and removing the chosen card
        for (int i = 0; i < deck.length; i += 4) {
            // Top border
            for (int j = i; j < i + 4 && j < deck.length; j++) {
            System.out.print("+----+\t");
            }
            System.out.println();

            // Rank
            for (int j = i; j < i + 4 && j < deck.length; j++) {
            System.out.printf("| %-2s |\t", deck[j].substring(0, deck[j].length() - 1));
            }
            System.out.println();

            // Suit
            for (int j = i; j < i + 4 && j < deck.length; j++) {
            System.out.printf("|  %s |\t", deck[j].substring(deck[j].length() - 1));
            }
            System.out.println();

            // Bottom border
            for (int j = i; j < i + 4 && j < deck.length; j++) {
            System.out.print("+----+\t");
            }
            System.out.println();
        }
        System.out.println("Enter any key to distribute the cards to the players and 4 computers:");
        scanner.next();
        // Reset card index
        cardIndex = 0;

        // Distribute the cards
        String[] humanHand = new String[11];
        String[][] botHands = new String[4][10];

        // Assign 11 cards to the human player
        for (int i = 0; i < 11; i++) {
            humanHand[i] = deck[cardIndex++];
        }

        // Assign 10 cards to each bot
        for (int b = 0; b < 4; b++) {
            for (int i = 0; i < 10; i++) {
                botHands[b][i] = deck[cardIndex++];
            }
        }

       // Display hands    
        System.out.println("\nHuman Player's Hand:");
            printPlayerHand(humanHand, true);
        
        // Display bot hands
        for (int b = 0; b < 4; b++) {
            System.out.println("Bot " + (b + 1) + "'s Hand:");
            printPlayerHand(botHands[b], false);
        }
        // Final line break for spacing
        System.out.println();


        // Hidden card remains secret
        System.out.println("A card is hidden for game mechanics.");
        System.out.println(("Checking Duplicate Cards..."));

        // Check for duplicate cards
        boolean hasDuplicates = false;
        String[] seenCards = new String[52];
        int seenIndex = 0;
        String[] duplicates = new String[52];
        int duplicateIndex = 0;

        // Check human hand for duplicates
        for (String card : humanHand) {
            boolean isDuplicate = false;
            for (int i = 0; i < seenIndex; i++) {
            if (seenCards[i].equals(card)) {
                duplicates[duplicateIndex++] = card;
                isDuplicate = true;
                hasDuplicates = true;
                break;
            }
            }
            if (!isDuplicate) {
            seenCards[seenIndex++] = card;
            }
        }

        // Check bot hands for duplicates
        for (String[] botHand : botHands) {
            for (String card : botHand) {
            boolean isDuplicate = false;
            for (int i = 0; i < seenIndex; i++) {
                if (seenCards[i].equals(card)) {
                duplicates[duplicateIndex++] = card;
                isDuplicate = true;
                hasDuplicates = true;
                break;
                }
            }
            if (!isDuplicate) {
                seenCards[seenIndex++] = card;
            }
            }
        }

        if (hasDuplicates) {
            System.out.print("Duplicate cards found: ");
            for (int i = 0; i < duplicateIndex; i++) {
             System.out.print(getCardASCII(duplicates[i]) + " ");
            }
            System.out.println();
        } else {
            System.out.println("No duplicate cards found.");
        }

        // Remove duplicates from human hand
        String[] newHumanHand = new String[11];
        int newHumanIndex = 0;
        for (String card : humanHand) {
            boolean isDuplicate = false;
            for (int i = 0; i < duplicateIndex; i++) {
            if (duplicates[i].equals(card)) {
                isDuplicate = true;
                break;
            }
            }
            if (!isDuplicate) {
            newHumanHand[newHumanIndex++] = card;
            }
        }
        humanHand = Arrays.copyOf(newHumanHand, newHumanIndex);

        // Remove duplicates from bot hands
        for (int b = 0; b < botHands.length; b++) {
            String[] newBotHand = new String[10];
            int newBotIndex = 0;
            for (String card : botHands[b]) {
            boolean isDuplicate = false;
            for (int i = 0; i < duplicateIndex; i++) {
                if (duplicates[i].equals(card)) {
                isDuplicate = true;
                break;
                }
            }
            if (!isDuplicate) {
                newBotHand[newBotIndex++] = card;
            }
            }
            botHands[b] = Arrays.copyOf(newBotHand, newBotIndex);
        }

        // Display remaining cards for each player
        System.out.println("\nHuman Player's Hand after removing duplicates:");
         printPlayerHand(humanHand, true);
        
        System.out.println("\n");

        for (int b = 0; b < botHands.length; b++) {
            System.out.println("Bot " + (b + 1) + "'s Hand after removing duplicates:");
            printPlayerHand(botHands[b], false);
            System.out.println("\n");
        }
        int firstPlayer = runCoinFlipGame();
        
        if (firstPlayer == 0) {
            System.out.println("You go first in the Monkey Card Game!");
        } else {
            System.out.println("Monkey " + firstPlayer + " goes first in the Monkey Card Game!");
        }

    }
      // Print player hands in horizontal format
    static void printPlayerHand(String[] hand, boolean reveal) {
        if (hand.length == 0) {
            System.out.println("No cards left.");
            return;
        }

        String[][] cardLines = new String[hand.length][7];

        for (int i = 0; i < hand.length; i++) {
            cardLines[i] = reveal ? getCardASCII(hand[i]).split("\n") : backCard();
        }

        // Print each row of all cards side by side
        for (int line = 0; line < 7; line++) {
            for (int i = 0; i < hand.length; i++) {
                System.out.print(cardLines[i][line] + "  ");
            }
            System.out.println();
        }
        System.out.println();
    }
    static String getCardASCII(String card) {
        String rank = card.substring(0, card.length() - 1); // Extract rank (e.g., "A" from "A♠")
        String suit = card.substring(card.length() - 1); // Extract suit (e.g., "♠" from "A♠")
        
        // Padding for ranks to ensure proper alignment
        String paddedRank = rank.length() == 1 ? rank + " " : rank;
        
        return String.format(
            "┌───────┐\n" +
            "│ %s    │\n" +
            "│       │\n" +
            "│   %s   │\n" +
            "│       │\n" +
            "│    %s │\n" +
            "└───────┘", 
            paddedRank, suit, paddedRank);
    }
    static String[] backCard() {
        String cardASCII = 
            "┌───────┐\n" +
            "│░░░░░░░│\n" +
            "│░░░░░░░│\n" +
            "│░░░░░░░│\n" +
            "│░░░░░░░│\n" +
            "│░░░░░░░│\n" +
            "└───────┘";
        
        return cardASCII.split("\n");
    }
    
 static String getSuitName(String suit) {
        switch (suit) {
            case "♣": return "Clubs";
            case "♦": return "Diamonds";
            case "♥": return "Hearts";
            case "♠": return "Spades";
            default: return "";
        }
    }


public static int runCoinFlipGame() {
    int userChoice;
    int[] botChoices = new int[3];
    boolean validSelection;
    
    do {
        System.out.println("╔══════════════════════════════╗");
        System.out.println("║       COIN FLIP GAME         ║");
        System.out.println("╚══════════════════════════════╝");
        System.out.println("Choose: 0 for Heads | 1 for Tails");
        
        // Get user choice
        do {
            System.out.print("Your choice (0 or 1): ");
            userChoice = scanner.nextInt();
        } while (userChoice != 0 && userChoice != 1);
        
        // Bots make random choices
        for (int i = 0; i < 3; i++) {
            botChoices[i] = random.nextInt(2);
        }
        
        // Check if all players made the same choice
        validSelection = !(userChoice == botChoices[0] && userChoice == botChoices[1] && userChoice == botChoices[2]);
        
        if (!validSelection) {
            System.out.println("All players chose the same! Re-selecting choices...");
        }
    } while (!validSelection);
    
    System.out.println("You chose: " + (userChoice == 0 ? "HEADS" : "TAILS"));
    for (int i = 0; i < 3; i++) {
        System.out.println("Bot " + (i + 1) + " chose: " + (botChoices[i] == 0 ? "HEADS" : "TAILS"));
    }
    
    int round = 1;
    int[] players = {userChoice, botChoices[0], botChoices[1], botChoices[2]};
    boolean[] stillInGame = {true, true, true, true};
    String[] playerNames = {"You", "Bot 1", "Bot 2", "Bot 3"};
    
    while (true) {
        System.out.println("\n═══════════════════════════");
        System.out.println("       ROUND " + round);
        System.out.println("═══════════════════════════");
        
        // Allow players to choose again if it's round 2
        if (round > 1) {
            System.out.println("\nSecond round - new choices!");
            
            boolean allSame;
        do {
            allSame = true;
            
            // Get user's new choice if still in game
            if (stillInGame[0]) {
                do {
                    System.out.print("Your new choice (0 for Heads, 1 for Tails): ");
                    userChoice = scanner.nextInt();
                } while (userChoice != 0 && userChoice != 1);
                players[0] = userChoice;
            }

            // Bots make new random choices if still in game
            for (int i = 0; i < 3; i++) {
                if (stillInGame[i+1]) {
                    botChoices[i] = random.nextInt(2);
                    players[i+1] = botChoices[i];
                }
            }

            // Check if all remaining players picked the same option
            int firstChoice = -1;
            for (int i = 0; i < players.length; i++) {
                if (stillInGame[i]) {
                    if (firstChoice == -1) {
                        firstChoice = players[i];
                    } else if (players[i] != firstChoice) {
                        allSame = false;
                        break;
                    }
                }
            }

            if (allSame) {
                System.out.println("\nAll remaining players picked the same! Re-selecting choices...");
            }

        } while (allSame);
        
        System.out.println("\nChoices confirmed:");
        for (int i = 0; i < 4; i++) {
            if (stillInGame[i]) {
                System.out.println("• " + playerNames[i] + " chose: " + (players[i] == 0 ? "HEADS" : "TAILS"));
            }
        }
            System.out.println("\nPress Enter to flip the coin...");
            scanner.nextLine(); // Consume potential leftover newline
            scanner.nextLine(); // Wait for player to press enter
        }
        
        int coinResult = flipCoinAnimation();
        System.out.println("\nCoin showed: " + (coinResult == 0 ? "HEADS" : "TAILS"));
        
        // Display who's still in before eliminations
        System.out.println("\nPlayers still in the game:");
        for (int i = 0; i < players.length; i++) {
            if (stillInGame[i]) {
                System.out.println("• " + playerNames[i] + " (" + (players[i] == 0 ? "HEADS" : "TAILS") + ")");
            }
        }
        
        // Eliminate players with wrong choice
        System.out.println("\nResults:");
        int remainingPlayers = 0;
        for (int i = 0; i < players.length; i++) {
            if (stillInGame[i]) {
                if (players[i] != coinResult) {
                    stillInGame[i] = false;
                    System.out.println("✗ " + playerNames[i] + " is eliminated");
                } else {
                    System.out.println("✓ " + playerNames[i] + " stays in the game");
                    remainingPlayers++;
                }
            }
        }
        
        // Stop the game when only one player remains
        if (remainingPlayers == 1) break;
           // If everyone is eliminated, reset for a new round
    if (remainingPlayers == 0) {
        System.out.println("\nAll players eliminated! Everyone returns for the next round.");
        for (int i = 0; i < stillInGame.length; i++) {
            stillInGame[i] = true;
        }
    }

    round++;
    System.out.println("\nPress Enter to continue...");
    scanner.nextLine(); // Wait for player to press enter
}

// Determine the winner
System.out.println("\n╔══════════════════════════════╗");
System.out.println("║        GAME RESULT           ║");
System.out.println("╚══════════════════════════════╝");

for (int i = 0; i < players.length; i++) {
    if (stillInGame[i]) {
        System.out.println("🏆 " + playerNames[i] + " won the coin flip!");
        return i;
    }
}
return -1;
}

   

public static int flipCoinAnimation() {
    String[] coinFrames = {
        "    ___________\n   /           \\\n  /   HEADS     \\\n |   ⊙     ⊙     |\n |       ◡       |\n  \\             /\n   \\___________/",
        "        ▄▄▄\n      ▄█████▄\n    ▄███████▄\n    ▀█████▀\n      ▀▀▀",
        "    ___________\n   /           \\\n  /   TAILS     \\\n |    ◠   ◠      |\n |      ▿        |\n  \\             /\n   \\___________/",
        "      ▄▄▄\n    ▄█████▄\n  ▄███████▄\n  ▀█████▀\n    ▀▀▀"
    };
    
    for (int i = 0; i < 12; i++) {
        System.out.println(coinFrames[i % coinFrames.length]);
        try {
            Thread.sleep(100 + (i * 15));
        } catch (InterruptedException e) {}
        System.out.println("\n");
    }
    
    int result = random.nextInt(2);
    System.out.println(result == 0 ? coinFrames[0] : coinFrames[2]);
    return result;
}

}

    

