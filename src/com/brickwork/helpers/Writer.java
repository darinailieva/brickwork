package com.brickwork.helpers;

/**
 * Writer class for console writing.
 */

public class Writer {

    /**
     * Prints layer two of the wall.
     *
     * @param n            wall thickness.
     * @param m            wall length m.
     * @param layerTwoGrid the array to be printed.
     */
    public static void printLayerTwo(int n, int m, int[][] layerTwoGrid) {
        System.out.println();
        /* For loop for printing rows of the wall.*/
        for (int row = 0; row < n; row++) {

            /* For loop for printing columns of the wall.*/
            for (int col = 0; col < m; col++) {
                System.out.print(layerTwoGrid[row][col] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Prints layer two of the wall with asterisk and dashes.
     *
     * @param gridTwoForPrint the array to be printed.
     */
    public static void printLayerTwoWithDashAndAsterisk(int[][] gridTwoForPrint) {

        /* For loop for printing rows of the wall.*/
        for (int row = 0; row < gridTwoForPrint.length; row++) {

            /* For loop for printing columns of the wall.*/
            for (int col = 0; col < gridTwoForPrint[0].length; col++) {
                /* Prints dashes on the first and last row of the layer.*/
                if (row == 0 || row == gridTwoForPrint.length - 1) {
                    System.out.print("----");

                    /*Other cases.*/
                } else {

                    /* Prints vertical bars on the first and last column of the layer.*/
                    if (col == 0 || col == gridTwoForPrint[0].length - 1) {
                        System.out.print(" || ");

                        /*Other cases.*/
                    } else {
                        /* Prints the current position with three leading zeros.*/
                        if (gridTwoForPrint[row][col] != 0) {
                            System.out.printf("%04d", gridTwoForPrint[row][col]);

                            /*Other cases.*/
                        } else {

                            /* Checks if previous position is equal to zero.*/
                            if (gridTwoForPrint[row][col - 1] == 0) {

                                /* Prints two spaces and two asterisks if previous row position and next row positions
                                are equal and previous row position is not equal to zero.*/
                                if (gridTwoForPrint[row - 1][col] == gridTwoForPrint[row + 1][col]
                                        && gridTwoForPrint[row - 1][col] != 0) {
                                    System.out.print(" ** ");

                                    /*Other cases.*/
                                } else {
                                    System.out.print("----");
                                }

                            /* Prints two spaces and two asterisks if next column position is equal to previous column
                            position*/
                            } else if (gridTwoForPrint[row][col - 1] == gridTwoForPrint[row][col + 1]) {
                                System.out.print(" ** ");

                                /*Other cases.*/
                            } else {
                                System.out.print(" || ");
                            }

                        }
                    }
                }
            }
            System.out.println();
        }
    }
}
