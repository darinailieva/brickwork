package com.brickwork.helpers;

import com.brickwork.helpers.common.Validator;

import java.util.Scanner;

import static com.brickwork.helpers.common.Constants.INVALID_COLUMN_LENGTH;

/**
 * Initializer class for initialising both layers of the wall.
 */

public class LayerInitializer {

    /**
     * Initialises layer one of the wall.
     *
     * @param scanner      to get user input.
     * @param n            wall thickness.
     * @param m            wall length m.
     * @param layerOneGrid array to be initialised.
     */
    public static void initialiseLayerOne(Scanner scanner, int n, int m, int[][] layerOneGrid) {

        /* For loop for initializing rows of the wall.*/
        for (int row = 0; row < n; row++) {

            /* String array to get columns of user input.*/
            String[] input = scanner.nextLine().split(" ");

            /* Validation for m is equal to user input column length.*/
            Validator.validateColumns(input, m, INVALID_COLUMN_LENGTH);
            //TODO validate n

            /* For loop for initializing columns of the wall.*/
            for (int col = 0; col < m; col++) {
                layerOneGrid[row][col] = Integer.parseInt(input[col]);
            }
        }
    }


    /**
     * Validates a specific value is between min and max value
     * and throws an exception with a specified detail message,
     * if condition is not met.
     *
     * @param n            wall thickness.
     * @param m            wall length.
     * @param layerOneGrid array for layer one of the wall.
     * @param layerTwoGrid array for layer two of the wall.
     * @param brick        to count the brick number.
     */
    public static void initialiseLayerTwo(int n, int m, int[][] layerOneGrid, int[][] layerTwoGrid, int brick) {

        /* For loop for initializing rows of the wall.*/
        for (int row = 0; row < n; row++) {

            /* For loop for initializing columns of the wall.*/
            for (int col = 0; col < m; col++) {

                /*Validates current position is not occupied in layer two.*/
                if (layerTwoGrid[row][col] == 0) {

                    /*Validates next position is in range, if brick in layer one is horizontal and next position is empty.*/
                    if (col + 1 < m && layerOneGrid[row][col] != layerOneGrid[row][col + 1]
                            && layerTwoGrid[row][col + 1] == 0) {

                        /*Brick update.*/
                        brick++;

                        /*Validates next position is in range, if special case, so that sequence of positions should be changed.*/
                        if (row + 1 < n
                                && layerOneGrid[row][0] == layerOneGrid[row][1]
                                && layerOneGrid[row][m - 1] == layerOneGrid[row + 1][m - 1] && col == 1) {
                            layerTwoGrid[row][col] = brick;
                            layerTwoGrid[row + 1][col] = brick;

                            /*Other cases.*/
                        } else {
                            layerTwoGrid[row][col] = brick;
                            layerTwoGrid[row][col + 1] = brick;
                        }

                        /*Validates next position is in range, if brick in layer one is vertical and next position is empty.*/
                    } else if (row + 1 < n && layerOneGrid[row][col] != layerOneGrid[row + 1][col]
                            && layerTwoGrid[row + 1][col] == 0) {

                        /*Brick update.*/
                        brick++;

                        layerTwoGrid[row][col] = brick;
                        layerTwoGrid[row + 1][col] = brick;
                    }
                }
            }
        }
    }

    /**
     * Initialises layer two for special printing.
     *
     * @param layerTwoGrid    array of layer two.
     * @param gridTwoForPrint array of layer two special printing.
     */
    public static void initialiseLayerTwoForPrinting(int[][] layerTwoGrid, int[][] gridTwoForPrint) {

        /* For loop for initializing rows of the wall.*/
        for (int row = 0; row < gridTwoForPrint.length; row++) {

            /* For loop for initializing columns of the wall.*/
            for (int col = 0; col < gridTwoForPrint[0].length; col++) {

                /*Validates if row is not even.*/
                if (row % 2 != 0) {

                    /*Validates if column is not even.*/
                    if (col % 2 != 0) {
                        gridTwoForPrint[row][col] = layerTwoGrid[(row - 1) / 2][(col - 1) / 2];
                    }
                }
            }
        }
    }
}
