import Clases.MatrixAD;
import Clases.TiposMatrices;
import Clases.VecFormat;
import Clases.VectorAD;
import Excepciones.NotMatchedAmountsException;
import Excepciones.NotPermitedSizeException;

// Demo y pruebas rapidas de la libreria
public class Test {

    static int fallas = 0;

    static void check(String nombre, boolean ok) {
        System.out.println((ok ? "  [OK]    " : "  [FALLA] ") + nombre);
        if (!ok) fallas++;
    }

    static boolean cerca(double a, double b) { return Math.abs(a - b) < 1e-9; }

    static boolean iguales(MatrixAD a, MatrixAD b) {
        if (a.getSize() != b.getSize()) return false;
        for (int i = 0; i < a.getSize(); i++)
            for (int j = 0; j < a.getSize(); j++)
                if (!cerca(a.elemento(i, j), b.elemento(i, j))) return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println("=== Vectores ===");
        VectorAD v = new VectorAD(3, 4);
        System.out.println("v = " + v);
        v.changeFormat(VecFormat.COMUN);      System.out.println("Comun:      " + v);
        v.changeFormat(VecFormat.ALGEBRAICA); System.out.println("Algebraica: " + v);
        v.changeFormat(VecFormat.POLAR);      System.out.println("Polar:      " + v);

        check("magnitud de <3,4> = 5", cerca(v.magnitud(), 5));
        check("direccion de <3,4> = 53.13°", Math.abs(v.direccion() - 53.1301) < 1e-3);

        VectorAD r = new VectorAD(1, 0).rotar(90);
        check("rotar <1,0> 90° = <0,1>", cerca(r.getVectorData(0), 0) && cerca(r.getVectorData(1), 1));

        VectorAD refl = new VectorAD(2, 5).reflexionX();
        check("reflexionX <2,5> = <2,-5>", cerca(refl.getVectorData(1), -5));

        VectorAD sh = new VectorAD(1, 2).shearY(3);
        check("shearY(3) <1,2> = <1,5>", cerca(sh.getVectorData(1), 5));

        VectorAD a = new VectorAD(1, 2, 3), b = new VectorAD(4, 5, 6);
        VectorAD s = a.sumaVectores(b);
        check("suma <1,2,3>+<4,5,6> = <5,7,9>", cerca(s.getVectorData(2), 9));
        check("resta <1,2,3>-<4,5,6> = <-3,-3,-3>", cerca(a.restaVectores(b).getVectorData(0), -3));

        try {
            new VectorAD(1, 2, 3, 4).sumaVectores(new VectorAD(1, 2, 3));
            check("suma de tamaños distintos lanza excepcion", false);
        } catch (NotMatchedAmountsException e) {
            check("suma de tamaños distintos lanza excepcion", true);
            System.out.println("    " + e.toString().replace("\n", " | "));
        }

        System.out.println("\n=== Matrices ===");
        MatrixAD A = new MatrixAD(new double[][] {{2, 1, 1}, {1, 3, 2}, {1, 0, 0}});
        System.out.println("A =\n" + A);
        check("det(A) = -1", cerca(MatrixAD.determinant(A), -1));
        check("det 2x2 [[4,7],[2,6]] = 10",
              cerca(MatrixAD.determinant(new MatrixAD(new double[][] {{4, 7}, {2, 6}})), 10));

        MatrixAD I = TiposMatrices.Identidad.toMatrixAD();
        check("A * I = A", iguales(A.multiply(I), A));

        MatrixAD inv = A.inverse();
        System.out.println("A^-1 =\n" + inv);
        check("A * A^-1 = I", iguales(A.multiply(inv), I));

        check("(A^T)^T = A", iguales(A.transpuesta().transpuesta(), A));
        check("A + A = 2A", iguales(A.suma(A), A.escalar(2)));

        // Sistema A x = b con solucion x = (1, 2, 3)
        VectorAD x = MatrixAD.cramer(A, new VectorAD(7, 13, 1));
        x.changeFormat(VecFormat.COMUN);
        System.out.println("Cramer: x = " + x);
        check("Cramer resuelve x = <1,2,3>",
              cerca(x.getVectorData(0), 1) && cerca(x.getVectorData(1), 2) && cerca(x.getVectorData(2), 3));

        try {
            new MatrixAD(new double[][] {{1, 2, 3, 4}, {1, 2, 3, 4}, {1, 2, 3, 4}, {1, 2, 3, 4}});
            check("matriz de 4x4 lanza excepcion", false);
        } catch (NotPermitedSizeException e) {
            check("matriz de 4x4 lanza excepcion", true);
            System.out.println("    " + e.toString().replace("\n", " | "));
        }

        try {
            TiposMatrices.Zero.toMatrixAD().inverse();
            check("inversa de matriz singular lanza excepcion", false);
        } catch (ArithmeticException e) {
            check("inversa de matriz singular lanza excepcion", true);
        }

        System.out.println(fallas == 0 ? "\nTodo bien." : "\n" + fallas + " prueba(s) fallaron.");
        if (fallas > 0) System.exit(1);
    }
}
