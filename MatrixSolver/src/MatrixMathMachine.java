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

/**
*  A matrix math machine that can do addition, subtraction and multiplication to matrices.
*  This is a work in progress and is moving along quickly, but is heavily in development and not feature rich or bug free yet.
*  
*  V 0.5 4/13/2019
*     - First external launch of project, still only had addition and was missing the second half of the own set.
*     - Had very basic functions available but was operational to add matrices up to the size limited by an int
*
*  V 0.5.1 4/15/2019
*     - Created the ability to do subtraction with the matrices, and finished the own set of input
*     - Now will not run the math section of the program if the matrices are both not created
*     - This is still early development and is missing almost half of the possible math abilities that will be added in V0.6
*
*
*  MatrixMathMachine Copyright (c) 2019 David Pieper
*  To get in touch with author send mail to ds016524dp@dsisdconnect.com or go to github.com/dpeeps/Matrix-Solver
*/

public class MatrixMathMachine
{
   private static Matrix matrix1;
   private static Matrix matrix2;
   
   public static void main(String args[])
   {
      startup();
      if (matrix1 != null && matrix2 != null)
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
         System.out.print("How many rows would you like the second matrix to have? ------------->     ");
         numRows = modeChecker.nextLine();
         rows = Integer.parseInt(numRows);
         System.out.print("How many columns would you like the second matrix to have? ---------->     ");
         numCols = modeChecker.nextLine();
         cols = Integer.parseInt(numCols);
         matrix2 = new ManualMatrix(rows, cols);
         System.out.println("Matrix 2:\n" + matrix2);
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
         if (matrix1.rows == matrix2.rows && matrix1.cols == matrix2.cols)
         {
            System.out.println("Adding the matrices");
            for (int r = 0; r < matrix1.rows; r++)
            {
               for (int c = 0; c < matrix1.cols; c++)
               {
                  matrix1.matrix[r][c] = matrix1.matrix[r][c] - matrix2.matrix[r][c];
                  
                  if (matrix1.matrix[r][c] <= -100)
                  {
                     System.out.print(matrix1.matrix[r][c] + " ");
                  }
                  else if ((matrix1.matrix[r][c] >= -99 && matrix1.matrix[r][c] < -9) || matrix1.matrix[r][c] >= 100)
                  {
                     System.out.print(" " + matrix1.matrix[r][c] + " ");
                  }
                  else if ((matrix1.matrix[r][c] >= -9 && matrix1.matrix[r][c] < 0) || matrix1.matrix[r][c] >= 10)
                  {
                     System.out.print("  " + matrix1.matrix[r][c] + " ");
                  }
                  else
                  {
                     System.out.print("   " + matrix1.matrix[r][c] + " ");
                  }
               }
               System.out.println();
            }
         }
         else
         {
            System.out.println("To be able to subtract matrices the rows and columns need to be of the same length.");
         }
      }
      else if (choice.equals("MULT") || choice.equals("MULTIPLY"))
      {
         int largestValue = 0;
         if (matrix1.rows == matrix2.cols && matrix1.cols == matrix2.rows)
         {
            for (int r = 0; r < matrix1.rows; r++)
            {
               for (int c = 0; c < matrix1.cols; c++)
               {
                  matrix1.matrix[r][c] = matrix1.matrix[r][c] * matrix2.matrix[c][r];
                  if (matrix1.matrix[r][c] >= largestValue)
                     largestValue = matrix1.matrix[r][c];
               }
            }
         }
         else
         {
            System.out.println("To be able to multiply matrices the columns of the first matrix and the rows of the second matrices.");
            return;
         } 
         int spaceCnt = 0;
         spaceCnt = largestValue;
         String output = "";
         for (int r = 0; r < matrix1.rows; r++)
         {
            for (int c = 0; c < matrix1.cols; c++)
            {
               int numSpaces = (spaceCnt - matrix1.matrix[r][c]) / 1000;
               String addedSpaces = "";
               for (int space = 0; space < numSpaces; space++)
               {
                  addedSpaces = addedSpaces + " ";
               }
               output = output + addedSpaces + matrix1.matrix[r][c] + " ";
            }
            output = output + "\n";
         }
         System.out.print(output);
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