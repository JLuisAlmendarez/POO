import javax.swing.*;

public class CURP {

    public static void main(String[] args) {
        //Variables a declarar varias
        String nombre1, nombre2, apellido1, apellido2, annonacimiento, mesnacimiento, dianacimiento, entidad, genero;

        //Estas variables son para poder hacer las operaciones random, indican el valor min o max posible
        int min = 0;
        int max = 9;
        int min1 = 1;
        int max1 = 26;

        //Toda esta zona es parte de los inputs y los procesos---- Esto se subdivide en parias partes

        //Inputs cuyo solo necesitamos el valor para hacer operaciones
        nombre1 = JOptionPane.showInputDialog("Captura tu primer nombre");
        nombre2 = JOptionPane.showInputDialog("Captura tu segundo nombre");
        apellido1 = JOptionPane.showInputDialog("Captura tu primer apellido");
        apellido2 = JOptionPane.showInputDialog("Captura tu segundo apellido");
        entidad = JOptionPane.showInputDialog("Captura tu entidad de nacimiento");
        genero = JOptionPane.showInputDialog("Captura tu Genero (Hombre/mujer)");

        //Estos inputs de aqui estan dentro de operaciones pues se tiene restricciones para su buen funcionamiento--*
        //Los procesos se repiten en el input de anno, mes y dia

        // Rango Valido de annos
        annonacimiento = JOptionPane.showInputDialog("Captura tu anno de nacimiento(1920-2024)");//input
        int restriccionanno = Integer.parseInt(annonacimiento);//input String to int

        if(restriccionanno <1920|restriccionanno>2024){//Si input int cumple esos valores entonces se asigna el valor minimo en el output de String
            JOptionPane.showMessageDialog(null,"Dato fuera de rango, asignado el menor","ERROR", JOptionPane.ERROR_MESSAGE);
            annonacimiento = "1920";
        }

        //Esto se repite en los input de mes y dia

        //Rango Valido de meses
        mesnacimiento = JOptionPane.showInputDialog("Captura tu mes de nacimiento");
        int restriccionmes = Integer.parseInt(mesnacimiento);

        if(restriccionmes <1|restriccionmes>12){
            JOptionPane.showMessageDialog(null,"Dato fuera de rango, asignado el menor","ERROR", JOptionPane.ERROR_MESSAGE);
            mesnacimiento = "1";
        }

        // Rango Valido de dias
        dianacimiento = JOptionPane.showInputDialog("Captura tu dia de nacimiento");
        int restricciondias = Integer.parseInt(dianacimiento);

        if(restricciondias <1|restricciondias>31){
            JOptionPane.showMessageDialog(null,"Dato fuera de rango, asignado el menor","ERROR", JOptionPane.ERROR_MESSAGE);
            dianacimiento = "1";
        }

        //FIN de operaciones restricitivas y rangos validos --*


        //1L Apellido1
        char[] aapellido1 = apellido1.toCharArray();//Esto convierte el string en un arreglo
        String aa1= String.valueOf(aapellido1[0]);//Esto lo vuelve a convertir en String pero solo el caracter que deseamos
        //Como esta opracion la repito mas veces la vamos a llamar "Proceso de caracter selectivo"

        //1Vocal apellido
        int i = 0;
        boolean vocal= false;
        String vApp="";
        while(i < apellido1.length() & !vocal){
            if((apellido1.charAt(i) == 'a') ||
                    (apellido1.charAt(i) == 'e')  ||
                    (apellido1.charAt(i) == 'i') ||
                    (apellido1.charAt(i) == 'o') ||
                    (apellido1.charAt(i) == 'u')) {
                vApp = String.valueOf(apellido1.charAt(i)) ;
                vocal = true;
            }
            i++;
        }
        //Aqui se recorrio una lista hasta que se encuentre el valor de una vocal en el arreglo
        //hecho eso se asigna a una variable para que pueda imprimir


        //1L Apellido2
        String aa2c ="";
        if (apellido2.equals("")){
            aa2c=aa1;
        }else{
            char[] aapellido2 = apellido2.toCharArray();
            String aa2= String.valueOf(aapellido2[0]);
            aa2c=aa2;
        }
        //Aqui hacemos un proceso de caracter selectivo con la particularidad de que si el string del apellido2
        //esta vacia hagamos el mismo proceso con el apellido1

        //1L NombrePila
        char[] anombre1= nombre1.toCharArray();
        char[] anombre2= nombre2.toCharArray();
        String lnp = "";

        if (nombre1.equals("Maria")&nombre2.equals("")|nombre1.equals("Jose")&nombre2.equals("")){
            String an1= String.valueOf(anombre1[0]);
            lnp = an1;
        } else if(nombre1.equals("Maria")&!nombre2.equals("")|nombre1.equals("Jose")&!nombre2.equals("")){
            String an2= String.valueOf(anombre2[0]);
            lnp = an2;
        } else {
            String an1= String.valueOf(anombre1[0]);
            lnp= an1;
        }
        //Aqui hacemos un proceso de caracter selectivo con la particularidad de que si el string del nombre2
        //esta vacia hagamos el mismo proceso con el nombre1
        //exceptiando a si el primer nombre es maria o jose ahi se usa en nombre2 pero si nombre2 es nulo
        //nos conformamos usando el proceso de caracter selectivo del nombre1


        //Fecha de nacimiento
        char[] dNac = dianacimiento.toCharArray();
        char[] mNac = mesnacimiento.toCharArray();
        char[] aNac = annonacimiento.toCharArray();

        String dN1= String.valueOf(dNac[0]);
        String dN2= String.valueOf(dNac[1]);

        String mN1= String.valueOf(mNac[0]);
        String mN2= String.valueOf(mNac[1]);

        String aN1 = String.valueOf(aNac[2]);
        String aN2 = String.valueOf(aNac[3]);

        String fecha = aN1+aN2+mN1+mN2+dN1+dN2;
        //Aqui hacemos un proceso de caracter selectivo y hacemos un String Final sumando el conjunto deseado

        //Genero
        String GeneroD;

        if(genero.equals("Hombre")){
            GeneroD = "H";
        } else if (genero.equals("Mujer")){
            GeneroD= "M";
        } else
            GeneroD= "M";
        //Un sencillo if(){}else-if{}else{} que condiciona los inputs para definir una nueva variable que sera la que imprimimos

        //Estados
        String abrEn = "";
        if(entidad.equals("Aguscalientes")){
            abrEn = "AS";
        } else if (entidad.equals("Baja California")){
            abrEn = "BC";
        } else if (entidad.equals("Baja California Sur")){
            abrEn = "BS";
        } else if (entidad.equals("Campeche")){
            abrEn = "CC";
        } else if (entidad.equals("Coahuila")){
            abrEn = "CL";
        } else if (entidad.equals("Colima")){
            abrEn = "CM";
        } else if (entidad.equals("Chiapas")){
            abrEn = "CS";
        } else if (entidad.equals("Chihuahua")) {
            abrEn = "CH";
        } else if (entidad.equals("Ciudad de Mexico")){
            abrEn = "DF";}
        else if (entidad.equals("Durango")){
            abrEn = "DG";}
        else if (entidad.equals("Guanajuato")){
            abrEn = "GT";}
        else if (entidad.equals("Guerrero")){
            abrEn = "GR";}
        else if (entidad.equals("Hidalgo")){
            abrEn = "HG";}
        else if (entidad.equals("Jalisco")){
            abrEn = "JC";}
        else if (entidad.equals("Mexico")){
            abrEn = "MC";}
        else if (entidad.equals("Michoacan")){
            abrEn = "MN";}
        else if (entidad.equals("Morelos")){
            abrEn = "MS";}
        else if (entidad.equals("Nayarit")){
            abrEn = "NT";}
        else if (entidad.equals("Nuevo Leon")){
            abrEn = "NL";}
        else if (entidad.equals("Oaxaca")){
            abrEn = "OC";}
        else if (entidad.equals("Puebla")){
            abrEn = "PL";}
        else if (entidad.equals("Queretaro")){
            abrEn = "QT";}
        else if (entidad.equals("Quintana Roo")){
            abrEn = "QR";}
        else if (entidad.equals("San Luis Potosi")){
            abrEn = "SP";}
        else if (entidad.equals("Sinaloa")){
            abrEn = "SL";}
        else if (entidad.equals("Sonora")){
            abrEn = "SR";}
        else if (entidad.equals("Tabasco")){
            abrEn = "TC";}
        else if (entidad.equals("Tamaulipas")){
            abrEn = "TS";}
        else if (entidad.equals("Tlaxcala")){
            abrEn = "TL";}
        else if (entidad.equals("Veracruz")){
            abrEn = "VZ";}
        else if (entidad.equals("Yucatan")){
            abrEn = "YN";}
        else if (entidad.equals("Zacatecas")){
            abrEn = "ZS";}
        else {
            abrEn = "NE";
        }
        //--A Partir de aqui se acaban los input dentro de procesos y solo quedan los procesos--

        //Un if else con un condicionamiento de los inputs que se pueden poner
        //y si no es valido se denomina como extranjero

        //3c Apelllido1
        String aa1S= String.valueOf(aapellido1[2]);//Proceso de caracter selectivo

        //3c Apelllido2
        String aa2sC="";
        if (apellido2.equals("")){
            aa2sC=aa1S;
        }else {
            char[] aapellido2 = apellido2.toCharArray();
            String aa2S= String.valueOf(aapellido2[2]);
            aa2sC = aa2S;
        }
        //Lo mismo que hicimos hace rato con la 1 letra del apellido2 pero aplicado al tercer caracter

        //3c NombrePila
        String an3= String.valueOf(anombre1[2]);//Proceso de caracter selectivo

        //Puzzle
        int edad = Integer.valueOf(annonacimiento);// Int el anno de nacimiento para poder usar operadores
        String vejez1="";//Esta variable es la que vamos a imprimir y que se modifica

        if (edad<= 1999){//si edad menor que o igual 1999 usamos la funcion random y dependiendo del resultado
            int vejez = (int)(Math.random()*(max-min+1)+min);// de esta funcion modificamos el String que se imprime

            if (vejez==1){
                vejez1 = "1";
            } else if(vejez==2){
                vejez1 = "2";
            }else if(vejez==3){
                vejez1 = "3";
            }else if(vejez==4){
                vejez1 = "4";
            }else if(vejez==5){
                vejez1 = "5";
            }else if(vejez==6){
                vejez1 = "6";
            }else if(vejez==7){
                vejez1 = "7";
            }else if(vejez==8){
                vejez1 = "8";
            }else if(vejez==9){
                vejez1 = "9";
            }else if(vejez==10){
                vejez1 = "0";
            }
        }else {//Esto funciona exactamente igual
            int vejezA = (int)(Math.random()*(max1-min1+1)+min);

            if (vejezA==1){
                vejez1 = "A";
            } else if(vejezA==2){
                vejez1 = "B";
            }else if(vejezA==3){
                vejez1 = "C";
            }else if(vejezA==4){
                vejez1 = "D";
            }else if(vejezA==5){
                vejez1 = "E";
            }else if(vejezA==6){
                vejez1 = "F";
            }else if(vejezA==7){
                vejez1 = "G";
            }else if(vejezA==8){
                vejez1 = "H";
            }else if(vejezA==9){
                vejez1 = "I";
            }else if(vejezA==10){
                vejez1 = "J";
            }else if(vejezA==11){
                vejez1 = "K";
            }else if(vejezA==12){
                vejez1 = "L";
            }else if(vejezA==13){
                vejez1 = "M";
            }else if(vejezA==14){
                vejez1 = "N";
            }else if(vejezA==15){
                vejez1 = "O";
            }else if(vejezA==16){
                vejez1 = "P";
            }else if(vejezA==17){
                vejez1 = "Q";
            }else if(vejezA==18){
                vejez1 = "R";
            }else if(vejezA==19){
                vejez1 = "S";
            }else if(vejezA==20){
                vejez1 = "T";
            }else if(vejezA==21){
                vejez1 = "U";
            }else if(vejezA==22){
                vejez1 = "V";
            }else if(vejezA==23){
                vejez1 = "W";
            }else if(vejezA==24){
                vejez1 = "X";
            }else if(vejezA==25){
                vejez1 = "Y";
            }else if(vejezA==26){
                vejez1 = "Z";
            }
        }

        //Verificador
        /*
        El verificador luce como un desastre pero es el proceso de caracter selectivo pero sumando los ints para poder
        hacer el calclulo final tal como nos pide en el ejercicio
        */
        char verificador[]= fecha.toCharArray();
        String s1 = String.valueOf(verificador[0]);
        String s2 = String.valueOf(verificador[1]);
        String s3 = String.valueOf(verificador[2]);
        String s4 = String.valueOf(verificador[3]);
        String s5 = String.valueOf(verificador[4]);
        String s6 = String.valueOf(verificador[5]);

        int v1 = Integer.parseInt(s1);
        int v2 = Integer.parseInt(s2);
        int v3 = Integer.parseInt(s3);
        int v4 = Integer.parseInt(s4);
        int v5 = Integer.parseInt(s5);
        int v6 = Integer.parseInt(s6);

        int vDef1 = v1+v2+v3+v4+v5+v6;

        char[] sumaFinal = (""+vDef1).toCharArray();
        String solucion = String.valueOf(sumaFinal);
        String solucion2 = solucion+"0";
        char[] sumafinal2 = solucion2.toCharArray();

        String s7 = String.valueOf(sumafinal2[0]);
        String s8 = String.valueOf(sumafinal2[1]);

        int v7 = Integer.parseInt(s7);
        int v8 = Integer.parseInt(s8);
        int vDef2 = v7+v8;

        String veriFinal = String.valueOf(vDef2);

        //Armar String CasiDefinitivo
        String curpFinal = aa1+vApp+aa2c+lnp+fecha+GeneroD+abrEn+aa1S+aa2sC+an3+vejez1+veriFinal;//armamos String Prototipo
        String curpFinalUP = curpFinal.toUpperCase();// Lo ponemos en mayusculas

        //Remover acentos
        String original = "áàäéèëíìïóòöúùuñÁÀÄÉÈËÍÌÏÓÒÖÚÙÜÑçÇ";
        String ascii = "aaaeeeiiiooouuunAAAEEEIIIOOOUUUNcC";

        char[] array = curpFinalUP.toCharArray();
        for (int index = 0; index < array.length; index++) {
            int pos = original.indexOf(array[index]);
            if (pos > -1) {
                array[index] = ascii.charAt(pos);
            }
        }
        String curpFinalNoC = String.valueOf(array);
        //Y leyendo y recorriendo el arreglo del String del prototipo si encontramos una letra con acento que esta
        //en la lista de arriba sencillamente la remplazamos con una valida


        //Output Final
        JOptionPane.showMessageDialog(null,"Su curp es: "+curpFinalNoC,"Resultado",JOptionPane.INFORMATION_MESSAGE);
    }
}
