package com.example.backend.config;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class HardCode {

    static public void createCards(){
        try{
            Scanner sc = new Scanner(new File("src/main/resources/card-data.tsv"));
            List<String[]> parsedFile = new ArrayList<>(); //Change to list of cards
            sc.nextLine();
            while(sc.hasNext()){
                parsedFile.add(sc.nextLine().split("\t")); //create card and add to list afterwards.
            }

            parsedFile.forEach(entity -> System.out.println(Arrays.toString(entity)));

        }
        catch (FileNotFoundException err){
            System.out.println(err.getMessage());
        }

    }

    public static void main(String[] args) {
        createCards();
    }

    /*
        Hearts:

    A. Schwartenegger	Bench press	Barbell	https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-h1.jpg
    Flojo	Breaks nail on	Gold medal	https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-h2.jpg
    Tom Hanks	Runs through	Forest	https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-h3.jpg
    Scarlett Johansson	Drinks with	Bill Murray	https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-h4.jpg
    Julian Assange	Vanishes into	Puff of smoke	https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-h5.jpg
    Taylor Swift	Offended by	Kanye West	https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-h6.jpg
    Albert Einstein	Fly at light speed into	Shiny star	https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-h7.jpg
    Pamala Andersen	Saves drowning	Child	https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-h8.jpg
    Steve Jobs	Use LSD and invent	iPad	https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-h9.jpg
    Jk Rowling	Writes story about	Harry Potter	https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-h10.jpg
    Jesus Christ	Walks on	Puddle	https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-h11.jpg
    Michelle Obama	Star-jumps on	White House lawn	https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-h12.jpg
    Barack Obama	Fly-swatting	 Buzzing fly	https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-h13.jpg

        Spades:

    Usain Bolt	Chases	Cheetah	https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-s1.jpg
    Annika Sorenstam	Puts	Golf ball	https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-s2.jpg
    Ben Stiller	Polygraphed by	Robert De Niro	https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-s3.jpg
    June Carter	Plays guitar with	Johnny Cash	https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-s4.jpg
    Osama Bin Laden	Records video with	Suicide bomber	https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-s5.jpg
    Lady Gaga	Wears meat for	Paparazzi	https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-s6.jpg
    Stephen Hawking	Sounds robotic in	Whellchair	https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-s7.jpg
    Naomi Campbell	Beats maid with	Handbag	https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-s8.jpg
    Kevin Rose	Drinks	Tea	https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-s9.jpg
    Sarah Palin	Riffle-shoots	Moose	https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-s10.jpg
    Dalai Lama	Prays to	Buddha	https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-s11.jpg
    Victoria Beckham	Does makeup in	Mirror	https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-s12.jpg
    David Beckham	Kicks	Football	https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-s13.jpg

        Diamonds:

    Michael Jordan	Slam dunks	Basketball	https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-d1.jpg
    Caroline Wozniacki	Grand slams	Enrique Iglesias	https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-d2.jpg
    George Clooney	Smokes	Cigarette	https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-d3.jpg
    Julia Roberts	Tongue kisses	Richard Gere	https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-d4.jpg
    Joseph Stalin	Tells joke to	Bear	https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-d5.jpg
    Madonna	Dances with	Ghettoblaster	https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-d6.jpg
    Isaac Newton	Hit on head by	Apple	https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-d7.jpg
    Marylin Monroe	Flutter over	Subway vent	https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-d8.jpg
    Bill Gates	Furiously reboot	Crashed PC	https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-d9.jpg
    Oprah Winfrey	Interviews	Couch	https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-d10.jpg
    Zeus	Throws	Lighting bolt	https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-d11.jpg
    Princess Kate	In white before	Church	https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-d12.jpg
    Prince William	Save people from	Sea	https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-d13.jpg

    Mohammad Ali	Knocks out	Butterfly	https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-c1.jpg
    Serena Williams	Raises	Trophy	https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-c2.jpg
    Jack Sparrow	Steals back	Black pearl	https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-c3.jpg
    Lara Croft	Karate kicks	Ancient tomb	https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-c4.jpg
    Adolf Hitler	Goose-steps Into	Bunker	https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-c5.jpg
    Rihanna	Uses umbrella for	Rainstorm	https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-c6.jpg
    Thomas Edison	Screws In	Light bulb	https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-c7.jpg
    Medusa	Turns Into	Stone	https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-c8.jpg
    Mark Zuckerberg	Unfriends	Best friend	https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-c9.jpg
    Hillary Clinton	Smacks	Monica Lewinsky	https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-c10.jpg
    Pope John-Paul Ii	Forgives	Devil	https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-c11.jpg
    Beyonce	Power dances on	Beach	https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-c12.jpg
    Jay-Z	Raps into	Microphone	https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-c13.jpg

         */



}
