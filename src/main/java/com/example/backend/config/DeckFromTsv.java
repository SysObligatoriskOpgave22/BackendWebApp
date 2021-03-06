package com.example.backend.config;

import com.example.backend.entity.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Utility class to create an initial deck from a TSV file
 * Reads a file of 52 lines, containing Person action object url separated by tabs and in that order.
 * The Order of the Suits should be HEARTS, SPADES, DIAMONDS and CLUBS
 */
public class DeckFromTsv {

    /**
     * @return the default PAOs from the .tsv file
     */
    public static List<Pao> createDefaultPaos() {
        return List.of(
                // Hearts
                new Pao("Arnold Schwarzenegger", "Bench press", "Barbell", "https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-h1.jpg"),
                new Pao("Flojo", "Breaks nail on", "Gold medal", "https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-h2.jpg"),
                new Pao("Tom Hanks", "Runs through", "Forest", "https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-h3.jpg"),
                new Pao("Scarlett Johansson", "Drinks with", "Bill Murray", "https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-h4.jpg"),
                new Pao("Julian Assange", "Vanishes into", "Puff of smoke", "https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-h5.jpg"),
                new Pao("Taylor Swift", "Offended by", "Kanye West", "https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-h6.jpg"),
                new Pao("Albert Einstein", "Fly at light speed into", "Shiny star", "https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-h7.jpg"),
                new Pao("Pamela Anderson", "Saves drowning", "Child", "https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-h8.jpg"),
                new Pao("Steve Jobs", "Use LSD and invent", "iPad", "https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-h9.jpg"),
                new Pao("J.K. Rowling", "Writes story about", "Harry Potter", "https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-h10.jpg"),
                new Pao("Jesus Christ", "Walks on", "Puddle", "https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-h11.jpg"),
                new Pao("Michelle Obama", "Star-jumps on", "White House lawn", "https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-h12.jpg"),
                new Pao("Barack Obama", "Fly-swatting", "Buzzing fly", "https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-h13.jpg"),
                // Spades
                new Pao("Usain Bolt", "Chases", "Cheetah", "https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-s1.jpg"),
                new Pao("Annika Sorenstam", "Puts", "Golf ball", "https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-s2.jpg"),
                new Pao("Ben Stiller", "Polygraphed by", "Robert De Niro", "https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-s3.jpg"),
                new Pao("June Carter", "Plays guitar with", "Johnny Cash", "https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-s4.jpg"),
                new Pao("Osama Bin Laden", "Records video with", "Suicide bomber", "https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-s5.jpg"),
                new Pao("Lady Gaga", "Wears meat for", "Paparazzi", "https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-s6.jpg"),
                new Pao("Stephen Hawking", "Sounds robotic in", "Wheelchair", "https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-s7.jpg"),
                new Pao("Naomi Campbell", "Beats maid with", "Handbag", "https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-s8.jpg"),
                new Pao("Kevin Rose", "Drinks", "Tea", "https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-s9.jpg"),
                new Pao("Sarah Palin", "Riffle-shoots", "Moose", "https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-s10.jpg"),
                new Pao("Dalai Lama", "Prays to", "Buddha", "https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-s11.jpg"),
                new Pao("Victoria Beckham", "Does makeup in", "Mirror", "https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-s12.jpg"),
                new Pao("David Beckham", "Kicks", "Football", "https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-s13.jpg"),
                // Diamonds
                new Pao("Michael Jordan", "Slam dunks", "Basketball", "https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-d1.jpg"),
                new Pao("Caroline Wozniacki", "Grand slams", "Enrique Iglesias", "https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-d2.jpg"),
                new Pao("George Clooney", "Smokes", "Cigarette", "https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-d3.jpg"),
                new Pao("Julia Roberts", "Tongue kisses", "Richard Gere", "https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-d4.jpg"),
                new Pao("Joseph Stalin", "Tells joke to", "Bear", "https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-d5.jpg"),
                new Pao("Madonna", "Dances with", "Ghettoblaster", "https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-d6.jpg"),
                new Pao("Isaac Newton", "Hit on head by", "Apple", "https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-d7.jpg"),
                new Pao("Marylin Monroe", "Flutter over", "Subway vent", "https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-d8.jpg"),
                new Pao("Bill Gates", "Furiously reboot", "Crashed PC", "https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-d9.jpg"),
                new Pao("Oprah Winfrey", "Interviews", "Couch", "https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-d10.jpg"),
                new Pao("Zeus", "Throws", "Lighting bolt", "https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-d11.jpg"),
                new Pao("Princess Kate", "In white before", "Church", "https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-d12.jpg"),
                new Pao("Prince William", "Save people from", "Sea", "https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-d13.jpg"),
                // Clubs
                new Pao("Mohammad Ali", "Knocks out", "Butterfly", "https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-c1.jpg"),
                new Pao("Serena Williams", "Raises", "Trophy", "https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-c2.jpg"),
                new Pao("Jack Sparrow", "Steals back", "Black pearl", "https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-c3.jpg"),
                new Pao("Lara Croft", "Karate kicks", "Ancient tomb", "https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-c4.jpg"),
                new Pao("Adolf Hitler", "Goose-steps Into", "Bunker", "https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-c5.jpg"),
                new Pao("Rihanna", "Uses umbrella for", "Rainstorm", "https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-c6.jpg"),
                new Pao("Thomas Edison", "Screws In", "Light bulb", "https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-c7.jpg"),
                new Pao("Medusa", "Turns Into", "Stone", "https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-c8.jpg"),
                new Pao("Mark Zuckerberg", "Unfriends", "Best friend", "https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-c9.jpg"),
                new Pao("Hillary Clinton", "Smacks", "Monica Lewinsky", "https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-c10.jpg"),
                new Pao("Pope John-Paul Ii", "Forgives", "Devil", "https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-c11.jpg"),
                new Pao("Beyonce", "Power dances on", "Beach", "https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-c12.jpg"),
                new Pao("Jay-Z", "Raps into", "Microphone", "https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-c13.jpg")
        );
    }

    /**
     * Reads and parses a tsv-file into a list of PaoCards
     * @param filePath location of the tsv-file to be read.
     * @return List<PaoCard>
     */
    public static List<PaoCard> createDeck(String filePath){
        List<Pao> paoList = createDefaultPaos();
        List<PaoCard> paoDeck = new ArrayList<>(52);


        // Create PaoCards
        String[] suits = {"HEARTS", "SPADES", "DIAMONDS", "CLUBS"}; //Data is not in same order as ENUMS
        Rank[] ranks = Rank.values();
        int cardCount = 0;
        for (String suit : suits) {
            for (Rank rank : ranks) {
                Card card = new Card(rank, Suit.valueOf(suit));
                paoDeck.add(new PaoCard(card, paoList.get(cardCount)));
                cardCount++;
            }
        }

        return paoDeck;
    }

    /**
     * Reads and parses a tsv-file into a list of PaoCards.
     * Uses the default hardcoded tsv file from resources.
     * @return List<PaoCard>
     */
    public static List<PaoCard> createDefaultDeck(){
        return createDeck("src/main/resources/card-data.tsv");
    }

    // Helper Method
    /* Removed because we moved away from tsv
    private static Pao makePao(String[] properties){
        return new Pao(properties[0],properties[1],properties[2],properties[3]);
    }
    */
}
