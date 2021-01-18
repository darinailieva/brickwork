package com.brickwork.helpers.common;

import java.util.HashMap;
import java.util.Map;

/**
 * Validator class for validating different parameters.
 */
public class Validator {

    /**
     * Validates a specific value is between min and max value
     * and throws an exception with a specified detail message,
     * if condition is not met.
     *
     * @param value   the value to be validated.
     * @param min     the minimal value.
     * @param max     the maximal value.
     * @param message the detail message.
     */
    public static void validateIntRange(int value, int min, int max, String message) {
        if (value < min || value > max) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * Validates a specific number is even and throws
     * an exception with a specified detail message, if
     * condition is not met.
     *
     * @param number  the value to be validated.
     * @param message the detail message.
     */
    public static void validateEvenNumber(int number, String message) {
        if (number % 2 != 0) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * Validates a columns of a given array with a given number
     * and throws an exception with a specified detail message,
     * if condition is not met.
     *
     * @param input   the String array to be validated.
     * @param m       the given number.
     * @param message the detail message.
     */
    public static void validateColumns(String[] input, int m, String message) {
        if (input.length != m) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * Validates a 2d array has no more than two elements
     * and throws an exception with a specified detail message,
     * if condition is not met.
     *
     * @param grid    the 2d array to be validated.
     * @param message the detail message.
     */
    public static void hasNotMoreThanTwoElements(int[][] grid, String message) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (map.containsKey(grid[row][col])) {
                    int value = map.getOrDefault(grid[row][col], 1);
                    map.put(grid[row][col], value + 1);
                } else {
                    map.put(grid[row][col], 1);
                }
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 2) {
                throw new IllegalArgumentException(message);
            }
        }
    }

    /**
     * Validates if a solution is found and throws an
     * exception with a specified detail message, if
     * condition is not met.
     *
     * @param n            wall thickness.
     * @param m            wall length m.
     * @param layerTwoGrid the 2d array to be validated.
     * @param message the detail message.
     */
    public static void validateSolution(int n, int m, int[][] layerTwoGrid, String message) {
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (layerTwoGrid[row][col] == 0) {
                    throw new IllegalArgumentException(message);
                }
            }
        }
    }
}
