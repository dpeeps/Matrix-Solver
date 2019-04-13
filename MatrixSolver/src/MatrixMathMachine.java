package MatrixSolver.src;

import MatrixSolver.src.*;

import java.util.Scanner;
/*
*   This program is free software: you can redistribute it and/or modify
*   it under the terms of the GNU General Public License as published by
*   the Free Software Foundation, either version 3 of the License, or
*   (at your option) any later version.
*
*   This program is distributed in the hope that it will be useful,
*   but WITHOUT ANY WARRANTY; without even the implied warranty of
*   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
*   GNU General Public License for more details.
*
*   You should have received a copy of the GNU General Public License
*   along with this program.  If not, see <https://www.gnu.org/licenses/>.
*/


public class MatrixMathMachine
{
   private static Matrix matrix1;
   private static Matrix matrix2;
   
   public static void main(String args[])
   {
      startup();
      doMath();
   }
   
   private static void startup()
   {
      Scanner modeChecker = new Scanner(System.in);
      System.out.println("Hello. Thank you for using the Matrix Math Machine(c).\nPlease select if you'd like to use random matrices, or enter your own numbers.");
      System.out.print("Enter random to select random or rand numbers, or own to select your own numbers, or if you want to be able to use both enter change: ------->    ");
      String setMode = modeChecker.nextLine();
      setMode = setMode.toUpperCase();
      if (setMode.equals("RANDOM") || setMode.equals("RAND"))
      {
         System.out.println("You have selected to enter a random number.");
         System.out.print("How many rows would you like the first matrix to have? ------------------------->    ");
         String numRows = modeChecker.nextLine();
         int rows = Integer.parseInt(numRows);
         System.out.print("How many columns would you like the first matrix to have? ---------------------->    ");
         String numCols = modeChecker.nextLine();
         int cols = Integer.parseInt(numCols);
         matrix1 = new AutoMatrix(rows, cols);
         System.out.println("Matrix 1:\n" + matrix1);
         System.out.print("How many rows would you like the second matrix to have? ------------------------>    ");
         numRows = modeChecker.nextLine();
         rows = Integer.parseInt(numRows);
         System.out.print("How many columns would you like the second matrix to have? --------------------->    ");
         numCols = modeChecker.nextLine();
         cols = Integer.parseInt(numCols);
         matrix2 = new AutoMatrix(rows, cols);
         System.out.println("Matrix 2:\n" + matrix2);
      }
      
      else if (setMode.equals("OWN"))
      {
         System.out.println("You have selected to enter your own values");
         System.out.print("How many rows would you like the first matrix to have? -------------->     ");
         String numRows = modeChecker.nextLine();
         int rows = Integer.parseInt(numRows);
         System.out.print("How many columns would you like the first matrix to have ------------>     ");
         String numCols = modeChecker.nextLine();
         int cols = Integer.parseInt(numCols);
         matrix1 = new ManualMatrix(rows, cols);
         System.out.println("Matrix 1:\n" + matrix1);
      }
      
      else if(setMode.equals("CHANGE"))
      {
         System.out.println("You have selected to be able to change in the middle");
         System.out.print("For the first matrix please enter rand or random to have random values, \nOr enter own to choose your own: -------------------------->     ");
         String mode1 = modeChecker.nextLine();
         mode1 = mode1.toUpperCase();
         
         if (mode1.equals("RAND") || mode1.equals("RANDOM"))
         {
            System.out.print("How many rows would you like the first matrix to have? ------------->     ");
            String numRows = modeChecker.nextLine();
            int rows = Integer.parseInt(numRows);
            System.out.print("How many columns would you like the first matrix to have? ---------->     ");
            String numCols = modeChecker.nextLine();
            int cols = Integer.parseInt(numCols);
            matrix1 = new AutoMatrix(rows, cols);
            System.out.println("Matrix 1:\n" + matrix1);
         }
         
         else if (mode1.equals("OWN"))
         {
            System.out.print("How many rows would you like the first matrix to have? ------------->     ");
            String numRows = modeChecker.nextLine();
            int rows = Integer.parseInt(numRows);
            System.out.print("How many columns would you like the first matrix to have? ---------->     ");
            String numCols = modeChecker.nextLine();
            int cols = Integer.parseInt(numCols);
            matrix1 = new ManualMatrix(rows, cols);
            System.out.println("Matrix 1:\n" + matrix1);
         }
         
         else
         {
            System.out.println("That was not a valid option!");
            return;
         }
         
         System.out.print("For the second matrix please enter rand or random to have random values,\nOr enter own to choose your own: -------------------------->     ");
         String mode2 = modeChecker.nextLine();
         mode2 = mode2.toUpperCase();
         
         if (mode2.equals("RAND") || mode2.equals("RANDOM"))
         {
            System.out.print("How many rows would you like the second matrix to have? -------------->     ");
            String numRows = modeChecker.nextLine();
            int rows = Integer.parseInt(numRows);
            System.out.print("How many columns would you like the second matrix to have? ----------->     ");
            String numCols = modeChecker.nextLine();
            int cols = Integer.parseInt(numCols);
            matrix2 = new AutoMatrix(rows, cols);
            System.out.println("Matrix 2:\n" + matrix2);
         }
         
         else if(mode2.equals("OWN"))
         {
            System.out.print("How many rows would you like the second matrix to have? -------------->     ");
            String numRows = modeChecker.nextLine();
            int rows = Integer.parseInt(numRows);
            System.out.print("How many columns would you like the second matrix to have? ----------->     ");
            String numCols = modeChecker.nextLine();
            int cols = Integer.parseInt(numCols);
            matrix2 = new ManualMatrix(rows, cols);
            System.out.println("Matrix 2:\n" + matrix2);
         }
         
         else
         {
            System.out.println("That was not a valid option!");
            return;
         }
      }
      
      else
      {
         System.out.println("You didn't enter a proper value!!!");
         return;
      }
   }
   
   private static void doMath()
   {
      System.out.print("Please enter add, or addition to do addition\nOr enter sub, or subtract to do subtraction\nOr enter mult, or multiply to do multiplication\nOr enter div, or divide to do division: --------------->     ");
      Scanner mathChoice = new Scanner(System.in);
      String choice = mathChoice.nextLine();
      choice = choice.toUpperCase();
      
      if (choice.equals("ADD") || choice.equals("ADDITION"))
      {
         if (matrix1.rows == matrix2.rows && matrix1.cols == matrix2.cols)
         {
            System.out.println("Adding the matrices");
            for (int r = 0; r < matrix1.rows; r++)
            {
               for (int c = 0; c < matrix1.cols; c++)
               {
                  matrix1.matrix[r][c] = matrix1.matrix[r][c] + matrix2.matrix[r][c];
                  if (matrix1.matrix[r][c] < 100)
                  {
                     if (matrix1.matrix[r][c] < 10)
                     {
                        System.out.print("  " + matrix1.matrix[r][c] + " ");
                     }
                     else
                     {
                        System.out.print(" " + matrix1.matrix[r][c] + " ");
                     }
                  }
                  else
                  {
                     System.out.print(matrix1.matrix[r][c] + " ");
                  }
               }
               System.out.println();
            }
         }
         else
         {
            System.out.println("To be able to add matrices the rows and columns need to be of the same length.");
         }
      }
      else if (choice.equals("SUB") || choice.equals("SUBTRACT"))
      {  
         
      }
      else if (choice.equals("MULT") || choice.equals("MULTIPLY"))
      {
         
      }
      else if (choice.equals("DIV") || choice.equals("DIVIDE"))
      {
         
      }
      else
      {
         System.out.println("That was not one of the options!");
         return;
      }
   }
}