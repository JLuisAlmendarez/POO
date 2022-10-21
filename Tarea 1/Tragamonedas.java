import javax.swing.*;

public class Tragamonedas {
    public static void main(String[] args) {

        //Declaracion de variables
        int creditos=1000;
        int jugada;
        int min=1,max=13;
        int slot1, slot2,slot3;
        int sino;

        //Mensaje de Bienvenida
        JOptionPane.showMessageDialog(null,"Bienvenido A Celtic Casino");

        do {
            //Input Usuario
            jugada=Integer.parseInt(JOptionPane.showInputDialog(null,"Cuanto apuesta?\n Usted tiene "+creditos+"  Creditos", "Casino Celtic",JOptionPane.QUESTION_MESSAGE));

            //Ciclo de inputs no validos
            while (jugada>creditos|jugada==0){
                /*No encontre la manera de comparar el int con null, segun entiendo no se puede de igual manera con un scanner normal separando los
                 * inputs haciendo un new Scanner creo que podria. No se si me explico pero no pude hacerlo con JOptionPane, tampoco supe como hacerlo si el
                 * usuario ingresa un string
                 * De igual manera al esc = null creo que si lo hubiera logrado eso hubiera afectado el programa*/
                JOptionPane.showMessageDialog(null,"Error, apuesta no valida", "Error",JOptionPane.ERROR_MESSAGE);
                jugada=Integer.parseInt(JOptionPane.showInputDialog(null,"Cuanto apuesta?\n Usted tiene "+creditos+"  Creditos", "Casino Celtic",JOptionPane.QUESTION_MESSAGE));
            }

            //Resultados de Slot. Es un metodo random donde Minimo y Maximo se especifica en las variables
            slot1= (int)(Math.random()*(max-min+1)+min);
            slot2= (int)(Math.random()*(max-min+1)+min);
            slot3= (int)(Math.random()*(max-min+1)+min);

            //Condiciones de victoria. Aqui se definen mediante un if, else if, else. Ordenados de manera que las
            //condiciones no se sobrepongan una sobre otra.

            // De manera agregada tambien el aviso de ganar o perder mas los creditos que quedan
            // y la pregunta de si quieren jugar donde Yes == int sino = 0 y No == int sino = 1

            if (slot1==7 & slot2==7 & slot3==7){
            creditos+=(jugada*100);
            JOptionPane.showMessageDialog(null,"Ganaste!!!\nSlot1<"+slot1+"> Slot2<"+slot2+"> Slot3<"+slot3+"> \n Usted tiene "+creditos+"  Creditos AHORA!!!", "Casino Celtic",JOptionPane.INFORMATION_MESSAGE);
            sino= JOptionPane.showConfirmDialog(null,"Quieres seguir jugando?", "Pregunta",JOptionPane.YES_NO_OPTION);

            }else if (slot1==5 & slot2==5 & slot3==5){
                creditos+=(jugada*5);
                JOptionPane.showMessageDialog(null,"Ganaste!!!\nSlot1<"+slot1+"> Slot2<"+slot2+"> Slot3<"+slot3+"> \n Usted tiene "+creditos+"  Creditos AHORA!!!", "Casino Celtic",JOptionPane.INFORMATION_MESSAGE);
                sino= JOptionPane.showConfirmDialog(null,"Quieres seguir jugando?", "Pregunta",JOptionPane.YES_NO_OPTION);

            }else if (slot1==1 & slot2==1 & slot3==1){
                creditos+=(jugada*7);
                JOptionPane.showMessageDialog(null,"Ganaste!!!\nSlot1<"+slot1+"> Slot2<"+slot2+"> Slot3<"+slot3+"> \n Usted tiene "+creditos+"  Creditos AHORA!!!", "Casino Celtic",JOptionPane.INFORMATION_MESSAGE);
                sino= JOptionPane.showConfirmDialog(null,"Quieres seguir jugando?", "Pregunta",JOptionPane.YES_NO_OPTION);

            } else if (slot1==9 & slot2==9 & slot3==9){
                creditos+=(jugada*10);
                JOptionPane.showMessageDialog(null,"Ganaste!!!\nSlot1<"+slot1+"> Slot2<"+slot2+"> Slot3<"+slot3+"> \n Usted tiene "+creditos+"  Creditos AHORA!!!", "Casino Celtic",JOptionPane.INFORMATION_MESSAGE);
                sino= JOptionPane.showConfirmDialog(null,"Quieres seguir jugando?", "Pregunta",JOptionPane.YES_NO_OPTION);

            }else if (slot1==slot2 & slot1==slot3){
                creditos+=(jugada*2);
                JOptionPane.showMessageDialog(null,"Ganaste!!!\nSlot1<"+slot1+"> Slot2<"+slot2+"> Slot3<"+slot3+"> \n Usted tiene "+creditos+"  Creditos AHORA!!!", "Casino Celtic",JOptionPane.INFORMATION_MESSAGE);
                sino= JOptionPane.showConfirmDialog(null,"Quieres seguir jugando?", "Pregunta",JOptionPane.YES_NO_OPTION);

            }else if (slot1==7|slot2==7|slot3==7){
                creditos+=jugada;
                JOptionPane.showMessageDialog(null,"Ganaste!!!\nSlot1<"+slot1+"> Slot2<"+slot2+"> Slot3<"+slot3+"> \n Usted tiene "+creditos+"  Creditos AHORA!!!", "Casino Celtic",JOptionPane.INFORMATION_MESSAGE);
                sino= JOptionPane.showConfirmDialog(null,"Quieres seguir jugando?", "Pregunta",JOptionPane.YES_NO_OPTION);

            } else {
                creditos-=jugada;
                JOptionPane.showMessageDialog(null,"Perdiste!\n Slot1<"+slot1+"> Slot2<"+slot2+"> Slot3<"+slot3+"> \n Usted tiene "+creditos+"  Creditos :(((!!!", "Casino Celtic",JOptionPane.INFORMATION_MESSAGE);
                sino= JOptionPane.showConfirmDialog(null,"Quieres seguir jugando?", "Pregunta",JOptionPane.YES_NO_OPTION);

            }}while (sino==0);
        //En base a la variable int si no podemos asignar una condicion para el ciclo while y que
        //se repita cada vez que marque Yes == int sino = 0


        //Mensaje de despedida. Este unicamente se despliega rompiendo el ciclo y pone fin al programa.
        JOptionPane.showMessageDialog(null,"Gracias por JUGAR!!", "Vuelva Pronto!",JOptionPane.INFORMATION_MESSAGE);



        /*

        //Este codigo comentado es para poder visualizar los resultados de las variables
        //que no aparecen en los cuadros de texto o comprobar el buen funcionamiento

        System.out.println(slot1);
        System.out.println(slot2);
        System.out.println(slot3);

        System.out.println(creditos);

        if (sino==0){
            System.out.println("si");
        }else{
            System.out.println("no");
        }

        */

    }
}