package Excepciones;

import Clases.VectorAD;

// Se lanza cuando una matriz no es cuadrada o es mayor a 3x3
public class NotPermitedSizeException extends RuntimeException {

    private double OverloadFound;

    public NotPermitedSizeException(double[][] matriz) {
        super("NotPermitedSizeException"); // stored in super.message
        this.OverloadFound = mayor(matriz.length, matriz.length > 0 ? matriz[0].length : 0);
    }

    public NotPermitedSizeException(Number[][] matriz) {
        super("NotPermitedSizeException");
        this.OverloadFound = mayor(matriz.length, matriz.length > 0 ? matriz[0].length : 0);
    }

    public NotPermitedSizeException(VectorAD[] matriz) {
        super("NotPermitedSizeException");
        this.OverloadFound = mayor(matriz.length, matriz.length > 0 ? matriz[0].getSize() : 0);
    }

    private static double mayor(int filas, int columnas) {
        return Math.max(filas, columnas);
    }

    public double getOverloadFound() {
        return OverloadFound;
    }

    @Override
    public String toString() {
        return getMessage() + "\nNot Permitted Matrix Size: " + this.OverloadFound;
    }
}
