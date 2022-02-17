package workshop;

import org.junit.Test;
import workshop.fizzBuzz.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FizzBuzzTest {
    List<PatternMatcher> patternMatcherList = Arrays.asList(
            new FizzPatternMatcher(),
            new BuzzPatternMatcher(),
            new FizzBuzzPatternMatcher()
    );

    FizzBuzz fizzBuzz = new FizzBuzz(patternMatcherList);

    @Test
    public void returnsANumber() {
        assertEquals("1", fizzBuzz.say(1));
        assertEquals("4", fizzBuzz.say(4));
        assertEquals("7", fizzBuzz.say(7));
    }

    @Test
    public void factorOf3() {
        assertEquals("Fizz", fizzBuzz.say(3));
        assertEquals("Fizz", fizzBuzz.say(6));
        assertEquals("Fizz", fizzBuzz.say(9));
    }

    @Test
    public void factorOf5() {
        assertEquals("Buzz", fizzBuzz.say(5));
        assertEquals("Buzz", fizzBuzz.say(10));
        assertEquals("Buzz", fizzBuzz.say(20));
    }

    @Test
    public void factorOf3And5() {
        assertEquals("FizzBuzz", fizzBuzz.say(15));
        assertEquals("FizzBuzz", fizzBuzz.say(30));
        assertEquals("FizzBuzz", fizzBuzz.say(60));
    }
}