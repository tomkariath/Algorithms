package problems;

import java.util.*;

/**
 * Moist has a hobby -- collecting figure skating trading cards.
 * His card collection has been growing, and it is now too large to keep in one disorganized pile.
 * Moist needs to sort the cards in alphabetical order,
 * so that he can find the cards that he wants on short notice whenever it is necessary.
 *
 * The problem is -- Moist can't actually pick up the cards because they keep sliding out his hands,
 * and the sweat causes permanent damage. Some of the cards are rather expensive, mind you. To facilitate the sorting,
 * Moist has convinced Dr. Horrible to build him a sorting robot. However, in his rather horrible style,
 * Dr. Horrible has decided to make the sorting robot charge Moist a fee of $1
 * whenever it has to move a trading card during the sorting process.
 *
 * Moist has figured out that the robot's sorting mechanism is very primitive.
 * It scans the deck of cards from top to bottom.
 * Whenever it finds a card that is lexicographically smaller than the previous card,
 * it moves that card to its correct place in the stack above.
 * This operation costs $1, and the robot resumes scanning down towards the bottom of the deck,
 * moving cards one by one until the entire deck is sorted in lexicographical order from top to bottom.
 *
 * As wet luck would have it, Moist is almost broke,
 * but keeping his trading cards in order is the only remaining joy in his miserable life.
 * He needs to know how much it would cost him to use the robot to sort his deck of cards.
 *
 * Input (Just numbers and cardNames)
 * TestCase: 2
 * CardCount 2
 * Oksana Baiul
 * Michelle Kwan
 * CardCount 3
 * Elvis Stojko
 * Evgeni Plushenko
 * Kristi Yamaguchi
 */

public class Moist {
    private static int testCases;
    private static final Map<Integer, List<String>> testCaseMap = new HashMap<>();

    public static void main(String[] args) {
        readInput();

        for (int i=0; i<testCases; i++){
            if (testCaseMap.get(i).size() > 1){
                int cost = costOfHorribleSort(testCaseMap.get(i));
                System.out.println("Case #"+(i+1)+": "+cost);
            }
            else {
                System.out.println("Case #"+(i+1)+": 0");
            }
        }
    }

    private static void readInput(){
        Scanner scanner = new Scanner(System.in);
        testCases = scanner.nextInt();

        for (int i=0; i<testCases; i++){
            getTestCaseData(i,scanner);
        }
    }

    private static void getTestCaseData(int testCase, Scanner scanner){
        int cardCount = scanner.nextInt();
        scanner.nextLine();
        List<String> cards = new ArrayList<>();

        for (int i=0;i<cardCount; i++){
            String card = scanner.nextLine();
            cards.add(card);
        }
        testCaseMap.put(testCase, cards);
    }

    private static int costOfHorribleSort(List<String> cards){
        String previousCard = cards.get(0);
        String currentCard;
        int cost=0;
        int currentCardIndex = 1;

        while (currentCardIndex < cards.size()){
            currentCard = cards.get(currentCardIndex);
            if (previousCard.compareTo(currentCard) > 0){
                cost++;
            }
            else {
                previousCard = currentCard;
            }
            currentCardIndex++;
        }

        return cost;
    }
}
