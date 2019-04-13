package MatrixSolver.src;

import java.util.Random;
import java.util.Scanner;

public class ManualMatrix extends Matrix
{
   
   public ManualMatrix (int rows, int cols)
   {
      super(rows, cols);
            
      enterValues();
   }
   
   protected void enterValues()
   {
      Scanner numberChecker = new Scanner(System.in);
      for (int r = 0; r < rows; r++)
      {
         for (int c = 0; c < cols; c++)
         {
            System.out.print("Please enter the number for row " + r + ", column " + c + ": ------------>     ");
            int newValue = numberChecker.nextInt();
            matrix[r][c] = newValue;
         }
      }
   }
   
   protected void createValues()
   {
   }
      
   public String toString()
   {
      String returnString = "";
      for (int r = 0; r < rows; r++)
      {
         for (int c = 0; c < cols; c++)
         {
            if (matrix[r][c] >= 10)
               returnString += matrix[r][c] + " ";
            
            else
               returnString += " " + matrix[r][c] + " ";
         }
         returnString += "\n";
      }
      return returnString;
   }
}