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
   private static int rows;
   private static int cols;
   private static Matrix matrix1;
   private static Matrix matrix2;
   public static void main(String args[])
   {
      startup();
   }
   
   private static void startup()
   {
      Scanner modeChecker = new Scanner(System.in);
      System.out.println("Hello. Thank you for using the Matrix Math Machine(c).\nPlease select if you'd like to use random matrices, or enter your own numbers.");
      System.out.print("Enter random to select random or rand numbers, or own to select your own numbers ------->    ");
      String setMode = modeChecker.nextLine();
      setMode = setMode.toUpperCase();
      if (setMode.equals("RANDOM") || setMode.equals("RAND"))
      {
         System.out.println("You have selected to enter a random number.");
         System.out.print("How many rows would you like the first matrix to have? ------------------------->    ");
         String numRows = modeChecker.nextLine();
         rows = Integer.parseInt(numRows);
         System.out.println("There are " + rows + " rows.");
         System.out.print("How many columns would you like the first matrix to have? ---------------------->    ");
         String numCols = modeChecker.nextLine();
         cols = Integer.parseInt(numCols);
         System.out.println("There are " + cols + " columns");
         matrix1 = new AutoMatrix(rows, cols);
         System.out.println("Matrix 1:\n" + matrix1);
         System.out.print("How many rows would you like the second matrix to have? ------------------------>    ");
         numRows = modeChecker.nextLine();
         rows = Integer.parseInt(numRows);
         System.out.println("There are " + rows + " rows.");
         System.out.print("How many columns would you like the second matrix to have? --------------------->    ");
         numCols = modeChecker.nextLine();
         cols = Integer.parseInt(numCols);
         System.out.println("There are " + cols + " columns.");
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
      }
      
      else
      {
         System.out.println("You didn't enter a proper value!!!");
         return;
      }
   }
}