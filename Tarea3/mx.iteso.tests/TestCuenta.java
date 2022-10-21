package mx.iteso.tests;

import mx.iteso.cuentas.*;

public class TestCuenta {
        public static void main(String[] args) {

            CuentaAhorro p1ahorro = new CuentaAhorro("Jose","737807",500,6,40);
            CuentaAhorro p2ahorro = new CuentaAhorro("Maria","138220",1900,3,40);

            CuentaCorriente p1corriente = new CuentaCorriente("Evelyn","800123", 600, 5,6,50,5);
            CuentaCorriente p2corriente = new CuentaCorriente("Luis","123456", 38000, 15,10,50,5);

            CuentaCorrienteInteres p1interes = new CuentaCorrienteInteres("ramin","000111",500, 5
                    ,0,20,10,500);
            CuentaCorrienteInteres p2interes = new CuentaCorrienteInteres("david","111000",600000, 5
                    ,50,40,4,300);

            //Comisiones, Intereses, Deposito y retiro

            //Metodos de deposito
            //p1ahorro
            p1ahorro.deposito(200);
            p1ahorro.deposito(100);
            //p2ahorro
            p2ahorro.deposito(200);
            p2ahorro.deposito(100);

            //p1corriente
            p1corriente.deposito(200);
            p1corriente.deposito(100);
            //p2corriente
            p2corriente.deposito(200);
            p2corriente.deposito(100);

            //p1interes
            p1interes.deposito(200);
            p1interes.deposito(100);
            //p2interes
            p2interes.deposito(200);
            p2interes.deposito(100);


            //Metodos de retiro!!!!!!!!!!!!!!
            //p1ahorro
            p1ahorro.retiro(300);
            p1ahorro.retiro(100);
            //p2ahorro
            p2ahorro.retiro(100);
            p2ahorro.retiro(100);

            //p1corriente
            p1corriente.retiro(300);
            p1corriente.retiro(100);
            //p2corriente
            p2corriente.retiro(100);
            p2corriente.retiro(100);

            //p1interes
            p1interes.retiro(300);
            p1interes.retiro(100);
            //p2interes
            p2interes.retiro(100);
            p2interes.retiro(100);


            //info todas cuentas
            Cuenta[] array= {p1ahorro,p2ahorro, p1corriente,p2corriente, p1interes,p2interes};

            for (Cuenta arr: array){
                for (int i = 0; i < 1; i++) {
                    System.out.println(arr);
                    System.out.println("____________________________");
                }
            }


            //info todas cuentas
            for (Cuenta arr: array){
                for (int i = 0; i < 1; i++) {
                    arr.comisiones();
                    arr.intereses();
                }
            }
        }
}