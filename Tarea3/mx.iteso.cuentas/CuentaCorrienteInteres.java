package mx.iteso.cuentas;

public class CuentaCorrienteInteres extends CuentaCorriente {

    private double saldoMinimo;
    public void setSaldoMinimo(double saldoMinimo) {this.saldoMinimo = (saldoMinimo<0)?0.0:saldoMinimo;}
    public double getSaldoMinimo() {return saldoMinimo;}



    public CuentaCorrienteInteres(String nombre, String cuenta, double saldo, double tipo_de_interes
                                  ,int transc, int impPorTransc, int transExentas,double saldoMinimo){
        super(nombre, cuenta, saldo, tipo_de_interes,transc,impPorTransc,transExentas);
        setSaldoMinimo(saldoMinimo);
    }



    public void intereses() {
        double diff = getSaldo() - getSaldoMinimo();
        if (diff > 0) {
            double interes = ((getTipo_de_interes() * diff / 100) / 12);
            setSaldo(getSaldo() + interes);
        }
    }



    public String toString(){
        String titulo = "Cuenta Corriente Interes\n";
        String mensaje_prov = String.format("Saldo minimo: %.2f", this.saldoMinimo);
        String mensaje = titulo + super.toString() + mensaje_prov;

        return mensaje;
    }
}
