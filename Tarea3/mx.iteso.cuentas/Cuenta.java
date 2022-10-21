package mx.iteso.cuentas;

public abstract class Cuenta {

    protected String nombre = "Desconocido";//por que son protected y no public, supongo que para que las otras que se extienden no lo puedan modificar
    protected String cuenta = "000000";//preguntar como notamos esto en un uml
    protected double saldo = 0.0;
    protected double tipo_de_interes=0.0;



    public void setNombre(String nombre) {this.nombre = (nombre.equals("")?"Desconocido":nombre);}
    public void setCuenta(String cuenta) {
        char [] array = cuenta.toCharArray();
        if(array.length==6){
            this.cuenta=cuenta;
        } else {
            this.cuenta="000000";
        }
    }
    public void setSaldo(double saldo)   {this.saldo = (saldo<0)?0.0:saldo;}
    public void setTipo_de_interes(double tipo_de_interes) {this.tipo_de_interes = (tipo_de_interes<0)?0.0:tipo_de_interes;}



    public String getNombre() {return nombre;}
    public String getCuenta() {return cuenta;}
    public double getSaldo()  {return saldo ;}
    public double getTipo_de_interes() {return tipo_de_interes;}



    public Cuenta(String nombre, String cuenta, double saldo, double tipo_de_interes){
        setNombre(nombre);
        setCuenta(cuenta);
        setSaldo(saldo);
        setTipo_de_interes(tipo_de_interes);
    }



    public void deposito(double cantidad) {
        if (cantidad>0){
        setSaldo(getSaldo()+cantidad);
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
            System.out.println("Operacion Exitosa");

        }
    }

    public abstract void comisiones();

    public abstract void intereses();



    public String toString() {
        String mensaje= "";//preguntar como funciona el += metodo to string
        mensaje += String.format("Nombre: %s\n" +
                                 "Cuenta: %s\n" +
                                 "Saldo:  %.2f\n" +
                                 "Tipo de interes: %.2f\n"
                                 ,this.nombre,this.cuenta,this.saldo,this.tipo_de_interes);
        return mensaje;
    }

}
