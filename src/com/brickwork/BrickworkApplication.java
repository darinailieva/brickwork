package com.brickwork;

import java.util.*;

import static com.brickwork.helpers.common.Constants.*;
import static com.brickwork.helpers.LayerInitializer.*;
import static com.brickwork.helpers.common.Validator.*;
import static com.brickwork.helpers.Writer.*;

/**
 * Starting point of the Brickwork console application.
 */

public class BrickworkApplication {

    public static void main(String[] args) {

        /*Try statement checks the program for errors while it is being executed.*/
        try {
            /* Scanner object to get user input.*/
            Scanner scanner = new Scanner(System.in);

            /* String array to get n and m dimensions of user input.*/
            String[] dimensions = scanner.nextLine().split(" ");
            //System.out.println(Arrays.toString(dimensions));

            /* Wall thickness n.*/
            int n = Integer.parseInt(dimensions[0]);

            /* Wall length m.*/
            int m = Integer.parseInt(dimensions[1]);
            // System.out.println(n + " " + m);

            /* Validation for n and m in min and max range.*/
            validateIntRange(n, N_M_MIN, N_M_MAX, ARGUMENTS_OUT_OF_RANGE);
            validateIntRange(m, N_M_MIN, N_M_MAX, ARGUMENTS_OUT_OF_RANGE);

            /* Validation for n and m are even numbers.*/
            validateEvenNumber(n, INVALID_NUMBER_TYPE);
            validateEvenNumber(m, INVALID_NUMBER_TYPE);

            /* int array for layer one of the wall.*/
            int[][] layerOneGrid = new int[n][m];

            /* Initialisation of layer one.*/
            initialiseLayerOne(scanner, n, m, layerOneGrid);

            /* Validation of each brick on layer one has no more than 2 elements.*/
            hasNotMoreThanTwoElements(layerOneGrid, INVALID_BRICK_NUMBER);

            /* int array for layer two of the wall.*/
            int[][] layerTwoGrid = new int[n][m];

            /*int to count the brick number.*/
            int brick = 0;

            /* Initialisation of layer two.*/
            initialiseLayerTwo(n, m, layerOneGrid, layerTwoGrid, brick);

            /* Validation if second layer can be done.*/
            validateSolution(n, m, layerTwoGrid, SOLUTION_NOT_FOUND);

            /* Printing of layer two.*/
            printLayerTwo(n, m, layerTwoGrid);

            System.out.println();

            /* int 2d array for printing layer two with asterisk and dash.*/
            int[][] gridTwoForPrint = new int[n * 2 + 1][m * 2 + 1];

            /*Initialisation of layer two with asterisk and dash for printing.*/
            initialiseLayerTwoForPrinting(layerTwoGrid, gridTwoForPrint);

            /* Printing of layer two with asterisk and dash.*/
            printLayerTwoWithDashAndAsterisk(gridTwoForPrint);

            /* The catch statement prints message, if an error occurs in the try block.*/
        } catch (Exception ex) {
            System.out.println((ex.getMessage() != null &&
                    !ex.getMessage().isEmpty() ? ex.getMessage() : ex.toString()));
        }
    }

}

