package MatrixSolver.src;

import java.util.Random;

public abstract class Matrix
{
   protected int rows;
   protected int cols;
   protected int[][] matrix;
   
   public Matrix (int rows, int cols)
   {
      this.cols = cols;
      this.rows = rows;
      matrix = new int[rows][cols];
   }
   abstract protected void createValues();
   abstract protected void enterValues();
}