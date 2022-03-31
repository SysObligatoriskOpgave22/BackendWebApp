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
     * Reads and parses a tsv-file into a list of PaoCards
     * @param filePath location of the tsv-file to be read.
     * @return List<PaoCard>
     */
    public static List<PaoCard> createDeck(String filePath){

        List<Pao> paoList = new ArrayList<>(52);
        List<PaoCard> paoDeck = new ArrayList<>(52);


        try{
            Scanner sc = new Scanner(new File(filePath));

            // Create PAOs' from tsv file.
            sc.nextLine();
            while(sc.hasNext()){
                paoList.add(makePao(sc.nextLine().split("\t"))); //create pao and add to list afterwards.
            }
        }
        catch (FileNotFoundException err){
            System.out.println(err.getMessage());
        }

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
    private static Pao makePao(String[] properties){
        return new Pao(properties[3],properties[0],properties[1],properties[2]);
    }
}
