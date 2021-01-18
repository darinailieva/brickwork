package com.brickwork.helpers.common;

/**
 * Constants class for validation messages.
 */
public class Constants {
    /**
     * The minimal value of the dimensions n and m.
     */
    public static final int N_M_MIN = 2;

    /**
     * The maximal value of the dimensions n and m.
     */
    public static final int N_M_MAX = 100;

    /**
     * Validation message for minimal and maximal dimensions of n and m.
     */
    public static final String ARGUMENTS_OUT_OF_RANGE =
            String.format("The wall thickness/width" +
                    "and length (n and m) should be between %d and %d.", N_M_MIN, N_M_MAX);

    /**
     * Validation message for even n and m.
     */
    public static final String INVALID_NUMBER_TYPE = "The wall thickness/width " +
            "and length (n and m) should be even numbers.";

    /**
     * Validation message for column length.
     */
    public static final String INVALID_COLUMN_LENGTH = "Column length should be equal to m.";

    /**
     * Validation message for maximal plates of a brick.
     */
    public static final String INVALID_BRICK_NUMBER = "Bricks should be made of maximum 2 plates.";

    /**
     * Validation message if second layer can be done.
     */
    public static final String SOLUTION_NOT_FOUND = "-1\n" +
            "A solution is not found.";
}
