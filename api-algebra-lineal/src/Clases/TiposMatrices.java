package Clases;

// Matrices de 3x3 predefinidas
public enum TiposMatrices {

    MatTriSup(1), MatTriInf(2), Identidad(3), Zero(4);

    private String nombre;
    private double[][] matriz;

    TiposMatrices(int n) {
        double[][] MatTriSup = {{1,1,1},{0,1,1},{0,0,1}};
        double[][] MatTriInf = {{1,0,0},{1,1,0},{1,1,1}};
        double[][] Identidad = {{1,0,0},{0,1,0},{0,0,1}};
        double[][] Zero      = {{0,0,0},{0,0,0},{0,0,0}};

        switch (n) {
            case 1:
                this.nombre = "Matriz Triangular Superior";
                this.matriz = MatTriSup;
                break;
            case 2:
                this.nombre = "Matriz Triangular Inferior";
                this.matriz = MatTriInf;
                break;
            case 3:
                this.nombre = "Matriz Identidad";
                this.matriz = Identidad;
                break;
            case 4:
                this.nombre = "Matriz Zero";
                this.matriz = Zero;
                break;
        }
    }

    // Regresa una copia para que nadie modifique la constante
    public double[][] getMatriz() {
        double[][] copia = new double[matriz.length][];
        for (int i = 0; i < matriz.length; i++) copia[i] = matriz[i].clone();
        return copia;
    }
    public String getNombre() { return nombre; }

    public MatrixAD toMatrixAD() { return new MatrixAD(getMatriz()); }
}
