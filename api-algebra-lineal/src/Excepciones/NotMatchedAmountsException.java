package Excepciones;

import Clases.MatrixAD;
import Clases.VectorAD;

// Se lanza cuando se opera con dos objetos de tamaños distintos
public class NotMatchedAmountsException extends RuntimeException {

    private double Guilt;

    public NotMatchedAmountsException(VectorAD vec1, VectorAD vec2) {
        super("NotMatchedAmounts"); // stored in super.message
        this.Guilt = (vec1.getSize() > vec2.getSize()) ? 1 : 0;
    }

    public NotMatchedAmountsException(MatrixAD mat1, MatrixAD mat2) {
        super("NotMatchedAmounts");
        this.Guilt = (mat1.getSize() > mat2.getSize()) ? 1 : 0;
    }

    public NotMatchedAmountsException(MatrixAD mat, VectorAD vec) {
        super("NotMatchedAmounts");
        this.Guilt = (mat.getSize() > vec.getSize()) ? 1 : 0;
    }

    @Override
    public String toString() {
        String mensaje = (this.Guilt == 1) ? "Objeto 1" : "Objeto 2";
        return getMessage() + "\nUnnecessary Extra Data in: " + mensaje;
    }
}
