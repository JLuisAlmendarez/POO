package mx.iteso.cuentas;

public class CuentaCorriente extends Cuenta {

    private int transc=0;
    private int impPorTransc=0;
    private int transExentas=0;



    public void setTransc(int transc) {this.transc = (transc<0)?0:transc;}
    public void setImpPorTransc(int impPorTransc) {this.impPorTransc = (impPorTransc<0)?0:impPorTransc;}
    public void setTransExentas(int transExentas)    {this.transExentas = (transExentas<0)?0:transExentas;  }



    public int getTransc() {return transc;}
    public double getImpPorTransc() {return impPorTransc;}
    public int getTransExentas() {return transExentas;}



    public CuentaCorriente(String nombre, String cuenta, double saldo, double tipo_de_interes, int transc, int impPorTransc, int transExentas){
        super(nombre,cuenta,saldo,tipo_de_interes);
        setTransc(transc);
        setImpPorTransc(impPorTransc);
        setTransExentas(transExentas);
    }


    public void deposito(double cantidad) {
        if (cantidad>0){
            setSaldo(getSaldo()+cantidad);
            this.transc += 1;
            System.out.println("Operacion Exitosa");

        }else{
            System.out.println("Cantidad invalida");
        }
    }

    public void retiro(double cantidad) {
        if(cantidad>getSaldo()||cantidad<0){
            System.out.println("Cantidad invalida");
        } else {
            setSaldo(getSaldo()-cantidad);
            this.transc += 1;
            System.out.println("Operacion Exitosa");

        }
    }



    public void comisiones() {
        if (getTransc()>getTransExentas()){
            int calculo = getTransc()-getTransExentas();
            double comision = calculo * getImpPorTransc();
            setSaldo(getSaldo()-comision);
        }
    }

    public void intereses(){// los intereses se pagan o se cobran
        double interes= ((getTipo_de_interes()*getSaldo()/100)/12);
        setSaldo(getSaldo()+interes);
    }



    public String toString() {// preguntar acerca formatos validos y format del string
        String titulo = "Cuenta Corriente\n";
        String mensaje_prov = String.format("Transacciones Exentas: %d\n" +
                                            "importe por transaccion: %d\n"
                                            , this.transExentas, this.impPorTransc);
        String mensaje = titulo + super.toString()+mensaje_prov;
        return mensaje;
    }
}
