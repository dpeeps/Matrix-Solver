package MatrixSolver.src;

import java.util.Random;

public abstract class Matrix
{
   protected static int rows;
   protected static int cols;
   protected static int[][] matrix;
   
   public Matrix (int rows, int cols)
   {
      this.cols = cols;
      this.rows = rows;
      matrix = new int[rows][cols];
      
      //createValues();
   }
   // public Matrix ()
//    {
//       
//    }
   abstract protected void createValues();
   abstract protected void enterValues();
}