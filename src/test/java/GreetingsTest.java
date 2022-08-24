import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GreetingsTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void greet() {
        System.out.println("Testing greeting with name");
        String actual = new Greetings().greet("Casper");
        String expected = "Hello Casper";
        assertEquals(expected, actual);
    }

    @Test
    void nullPointerName(){
        System.out.println("Testing greeting without name");
        String actual = new Greetings().greet(null);
        String expected = "Hello my friend.";
        assertEquals(expected, actual);
    }

    @Test
    public void shoutName(){
        System.out.println("Testing shouting when all uppercase");
        String actual = new Greetings().greet("CASPER");
        String expected = "HELLO CASPER!";
        assertEquals(expected, actual);
    }

    @Test
    public void twoGreetings(){
        String[] names = {"Jill", "Jane"};
        System.out.println("Testing two greetings");
        String actual = new Greetings().greet(names);
        String expected = "Hello Jill and Jane";
        assertEquals(expected, actual);
    }

    @Test
    public void multipleGreetings(){
        String[] names = {"Casper", "Mia", "Long"};
        System.out.println("Testing multiple greetings");
        String actual = new Greetings().greet(names);
        String expected = "Hello Casper, Mia and Long";
        assertEquals(expected, actual);
    }

    @Test
    public void shoutNotShout(){
        String[] names = {"Casper", "MIA", "Long"};
        System.out.println("Testing greetings with mixed shouting");
        String actual = new Greetings().greet(names);
        String expected = "Hello Casper and Long. AND HELLO MIA!";
        assertEquals(expected, actual);
    }

    @Test
    public void commaSeparation(){
        String[] names = {"Casper", "Mia, Long"};
        System.out.println("Testing greetings with comma separation");
        String actual = new Greetings().greet(names);
        String expected = "Hello Casper, Mia and Long";
        assertEquals(expected, actual);
    }

    @Test
    public void intendedComma(){
        String[] names = {"Mia", "\"Casper, Fluffa\""};
        System.out.println("Testing with intentional comma");
        String actual = new Greetings().greet(names);
        String expected = "Hello Mia and Casper, Fluffa";
        assertEquals(expected, actual);
    }
}