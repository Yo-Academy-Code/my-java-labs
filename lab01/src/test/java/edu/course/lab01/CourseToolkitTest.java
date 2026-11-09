package edu.course.lab01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CourseToolkitTest {

    @Test
    void returnsTrueForEvenNumber() {
        boolean result = CourseToolkit.isEven(8);

        assertTrue(result);
    }

    @Test
    void returnsFalseForOddNumber() {
        boolean result = CourseToolkit.isEven(7);

        assertFalse(result);
    }

    @Test 
    void returnsTrueForZero(){
        boolean result = CourseToolkit.isEven(0);
        assertTrue(result);
    }

    @Test 
    void returnsFalseForNonPrimeNumbers() {
        assertFalse(CourseToolkit.isPrime(1));
        assertFalse(CourseToolkit.isPrime(4));
        assertFalse(CourseToolkit.isPrime(9));
    }

    @Test
    void returnsTrueForPrimeNumbers() {
        assertTrue(CourseToolkit.isPrime(2));
        assertTrue(CourseToolkit.isPrime(3));
        assertTrue(CourseToolkit.isPrime(13));
    }

    @Test
    void returnsTrueForPalindromes() {
        assertTrue(CourseToolkit.isPalindrome("madam"));
        assertTrue(CourseToolkit.isPalindrome("шалаш"));
    }

    @Test
    void returnsFalseForNonPalindromes() {
        assertFalse(CourseToolkit.isPalindrome("hello"));
    }

    @Test
    void throwsExceptionForNullPalindrome() {
        assertThrows(IllegalArgumentException.class, () -> CourseToolkit.isPalindrome(null));
    }

    @Test
    void calculatesAverageCorrectly() {
        int[] numbers = {2, 4, 6, 8};
        assertEquals(5.0, CourseToolkit.average(numbers), 0.0001);
    }

    @Test
    void throwsExceptionForEmptyOrNullArrayAverage() {
        assertThrows(IllegalArgumentException.class, () -> CourseToolkit.average(null));
        assertThrows(IllegalArgumentException.class, () -> CourseToolkit.average(new int[]{}));
    }

    @Test
    void calculatesMinAndMaxCorrectly() {
        int[] numbers = {3, 1, 5, 2};
        assertEquals(1, CourseToolkit.min(numbers));
        assertEquals(5, CourseToolkit.max(numbers));
    }

    @Test
    void throwsExceptionForEmptyOrNullArrayMinMax() {
        assertThrows(IllegalArgumentException.class, () -> CourseToolkit.min(null));
        assertThrows(IllegalArgumentException.class, () -> CourseToolkit.min(new int[]{}));
        assertThrows(IllegalArgumentException.class, () -> CourseToolkit.max(null));
        assertThrows(IllegalArgumentException.class, () -> CourseToolkit.max(new int[]{}));
    }
}