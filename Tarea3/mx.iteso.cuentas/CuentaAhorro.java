package mx.iteso.cuentas;

public class CuentaAhorro extends Cuenta {

    private double cuota=0.0;



    public void setCuota(double cuota) {this.cuota = (cuota<0)?0.0:cuota;}
    public double getCuota() {return cuota;}



    public CuentaAhorro(String nombre, String cuenta, double saldo, double tipo_de_interes,double cuota) {//agregar los valores de cuota de manteniminto
        super(nombre,cuenta,saldo,tipo_de_interes);
        setCuota(cuota);
    }



    public void comisiones() {// las comisiones se cobran
        setSaldo(getSaldo()-getCuota());
    }

    public void intereses(){// los intereses se pagan
        double interes= ((getTipo_de_interes()*getSaldo()/100)/12);
        setSaldo(getSaldo()+interes);
    }



    public String toString() {
        String titulo = "Cuenta de ahorro\n";
        String mensaje_prov = String.format("Cuota de mantenimiento: %.2f", getCuota());
        String mensaje = titulo + super.toString() + mensaje_prov;
        return mensaje;
    }


}
