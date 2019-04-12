package MatrixSolver.src;

import java.util.Random;

public class AutoMatrix extends Matrix
{
   
   public AutoMatrix (int rows, int cols)
   {
      super(rows,cols);
      
      createValues();
   }
   
   public AutoMatrix (int rows, int cols, boolean own)
   {
      super(rows,cols);
   }
   
   protected void createValues()
   {
      Random rand = new Random();
      for (int r = 0; r < rows; r++)
      {
         for (int c = 0; c < cols; c++)
         {
            int nextValue = rand.nextInt(100);
            matrix[r][c] = nextValue;
         }
      }  
   }
   
   protected void enterValues()
   {
      
   }
   
   public String toString()
   {
      String returnString = "";
      for (int r = 0; r < rows; r++)
      {
         for (int c = 0; c < cols; c++)
         {
            returnString += matrix[r][c] + " ";
         }
         returnString += "\n";
      }
      return returnString;
   }
   
}