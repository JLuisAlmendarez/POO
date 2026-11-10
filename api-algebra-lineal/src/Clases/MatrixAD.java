package Clases;

import Excepciones.NotMatchedAmountsException;
import Excepciones.NotPermitedSizeException;

import java.util.Vector;

// Matriz cuadrada de 1x1 hasta 3x3. Cada fila es un VectorAD.
public class MatrixAD {
    // Atributos
    private Vector<VectorAD> matriz = new Vector<>();
    private int size = 3;

    // Constructores
    public MatrixAD(VectorAD[] Matriz) throws NotPermitedSizeException {
        if (Matriz.length == 0 || Matriz.length > 3) throw new NotPermitedSizeException(Matriz);
        for (VectorAD fila : Matriz) {
            if (fila.getSize() != Matriz.length) throw new NotPermitedSizeException(Matriz);
        }
        setSize(Matriz.length);
        for (int i = 0; i < Matriz.length; i++) {
            this.matriz.add(new VectorAD(Matriz[i].toDouble()));
        }
    }

    public MatrixAD(double[][] Matriz) throws NotPermitedSizeException {
        if (Matriz.length == 0 || Matriz.length > 3) throw new NotPermitedSizeException(Matriz);
        for (double[] fila : Matriz) {
            if (fila.length != Matriz.length) throw new NotPermitedSizeException(Matriz);
        }
        setSize(Matriz.length);
        for (int i = 0; i < Matriz.length; i++) {
            this.matriz.add(new VectorAD(Matriz[i]));
        }
    }

    public MatrixAD(MatrixAD Matriz) {
        this(Matriz.toDouble());
    }

    // Setter && Getters
    public Vector<VectorAD> getMatriz() {
        return matriz;
    }
    public int getSize() {
        return this.size;
    }
    private void setSize(int size) {
        this.size = size;
    }
    public double elemento(int i, int j) {
        return this.matriz.get(i).getVectorData(j);
    }
    public void setElemento(int i, int j, double n) {
        this.matriz.get(i).setVectorData(j, n);
    }

    // Metodos
    // Suma
    public MatrixAD suma(MatrixAD matriz2) throws NotMatchedAmountsException {
        if (this.size != matriz2.size) throw new NotMatchedAmountsException(this, matriz2);
        MatrixAD result = new MatrixAD(this);
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                result.setElemento(i, j, this.elemento(i, j) + matriz2.elemento(i, j));
            }
        }
        return result;
    }
    // Resta
    public MatrixAD resta(MatrixAD matriz2) throws NotMatchedAmountsException {
        if (this.size != matriz2.size) throw new NotMatchedAmountsException(this, matriz2);
        MatrixAD result = new MatrixAD(this);
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                result.setElemento(i, j, this.elemento(i, j) - matriz2.elemento(i, j));
            }
        }
        return result;
    }
    // Transpuesta
    public MatrixAD transpuesta() {
        MatrixAD transp = new MatrixAD(this);
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                transp.setElemento(j, i, this.elemento(i, j));
            }
        }
        return transp;
    }
    // Escalar
    public MatrixAD escalar(double n) {
        MatrixAD nueva = new MatrixAD(this);
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                nueva.setElemento(i, j, this.elemento(i, j) * n);
            }
        }
        return nueva;
    }
    @Override
    public String toString() {
        String mensaje = "";
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                mensaje += String.format("%.2f\t", this.elemento(i, j));
            }
            mensaje += "\n";
        }
        return mensaje;
    }
    // Multiplicación (renglon por columna)
    public MatrixAD multiply(MatrixAD b) throws NotMatchedAmountsException {
        // se comprueba si las matrices se pueden multiplicar
        if (this.size != b.size) throw new NotMatchedAmountsException(this, b);
        MatrixAD respuesta = new MatrixAD(this);
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                double suma = 0;
                for (int k = 0; k < this.size; k++) {
                    // aquí se multiplica la matriz
                    suma += this.elemento(i, k) * b.elemento(k, j);
                }
                respuesta.setElemento(i, j, suma);
            }
        }
        return respuesta;
    }
    // Determinante
    public static double determinant(MatrixAD x) {
        return determinant(x.toDouble());
    }
    // Determinante double [][] (expansion por cofactores en el primer renglon)
    private static double determinant(double[][] matrix) {
        if (matrix.length != matrix[0].length) {
            throw new IllegalArgumentException("Dimensiones invalidas");
        }
        if (matrix.length == 1)
            return matrix[0][0];
        if (matrix.length == 2)
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        double det = 0;
        for (int i = 0; i < matrix[0].length; i++)
            det += Math.pow(-1, i) * matrix[0][i]
                    * determinant(submatrix(matrix, 0, i));
        return det;
    }
    // Menor / Submatriz (quita el renglon row y la columna column)
    public static double[][] submatrix(MatrixAD matrix, int row, int column) {
        return submatrix(matrix.toDouble(), row, column);
    }
    public static double[][] submatrix(double[][] matrix, int row, int column) {
        double[][] submatrix = new double[matrix.length - 1][matrix.length - 1];
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; i != row && j < matrix[i].length; j++)
                if (j != column)
                    submatrix[i < row ? i : i - 1][j < column ? j : j - 1] = matrix[i][j];
        return submatrix;
    }
    // Inversa = adjunta / determinante
    public MatrixAD inverse() {
        double det = determinant(this);
        if (Math.abs(det) < 1e-12) {
            throw new ArithmeticException("Determinante es igual a cero, la matriz no tiene inversa");
        }
        return adjunta(this).escalar(1.0 / det);
    }
    //Cofactor
    public static double cofactor(MatrixAD matriz, int i, int j) {
        return Math.pow(-1, i + j) * determinant(submatrix(matriz, i, j));
    }

    //Adjunta (transpuesta de la matriz de cofactores)
    public static MatrixAD adjunta(MatrixAD matriz) {
        int n = matriz.getSize();
        if (n == 1) return new MatrixAD(new double[][] {{1}});

        double[][] arr = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = cofactor(matriz, i, j);
            }
        }
        MatrixAD matrizProv = new MatrixAD(arr);
        return matrizProv.transpuesta();
    }

    //Cramer: resuelve matriz * x = vector
    public static VectorAD cramer(MatrixAD matriz, VectorAD vector) throws NotMatchedAmountsException {
        int n = matriz.getSize();
        if (vector.getSize() != n) throw new NotMatchedAmountsException(matriz, vector);

        double detGen = determinant(matriz);
        if (Math.abs(detGen) < 1e-12) {
            throw new ArithmeticException("Determinante es igual a cero, el sistema no tiene solucion unica");
        }

        VectorAD cramerXs = new VectorAD(vector);
        for (int k = 0; k < n; k++) {
            // Se reemplaza la columna k por el vector de resultados
            MatrixAD dk = new MatrixAD(matriz);
            for (int i = 0; i < n; i++) {
                dk.setElemento(i, k, vector.getVectorData(i));
            }
            cramerXs.setVectorData(k, determinant(dk) / detGen);
        }
        return cramerXs;
    }
    // toDouble
    public double[][] toDouble() {
        double[][] arr = new double[this.getSize()][this.getSize()];
        for (int i = 0; i < this.getSize(); i++) {
            for (int j = 0; j < this.getSize(); j++) {
                arr[i][j] = this.elemento(i, j);
            }
        }
        return arr;
    }
}
