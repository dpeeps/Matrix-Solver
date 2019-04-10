package MatrixSolver.src;

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
   public static void main(String args[])
   {
      startup();
   }
   
   private static void startup()
   {
      Scanner modeChecker = new Scanner(System.in);
      System.out.println("Hello. Thank you for using the Matrix Math Machine(c).\nPlease select if you'd like to use random matrices, or enter your own numbers.");
      System.out.print("Enter random to select random numbers, or own to select your own numbers ------->    ");
      String setMode = modeChecker.nextLine();
      setMode = setMode.toUpperCase();
      if (setMode.equals("RANDOM"))
      {
         System.out.println("You have selected to enter a random number.");
         System.out.print("How many rows would you like the first matrix to have -------------------------->    ");
         String numRows = modeChecker.nextLine();
         rows = Integer.parseInt(numRows);
         System.out.println("There are " + rows + " rows.");
         System.out.print("How many columns would you like the first matrix to have ----------------------->    ");
         String numCols = modeChecker.nextLine();
         cols = Integer.parseInt(numCols);
         System.out.println("There are " + cols + " columns");
      }
      
      else if (setMode.equals("OWN"))
      {
         
      }
      
      else
      {
         System.out.println("You didn't enter a proper value!!!");
         return;
      }
   }
}