package mx.iteso.calendar;

public class TestDate {
    public static void main(String[] args) {



       //Tarea 2 pt.1 Pruebas

      /*  //A)
        Date d1= new Date();
        //B)
        Date d2= new Date(31,12,2016,2);
        //C)
        Date d3= new Date().clone(d1);
        //D)
        Date d4= new Date(d1.getDay(),d2.getMonth(), d3.getYear(),1);
        //E)
        Date d5= new Date().clone(d2);
        d5.next();
        //F)
        d3.setMonth(4);
        //G)
        Date[] elementos={d1,d2,d3,d4,d5};

        for (int i = 0; i < elementos.length; i++) {
            System.out.println("La fecha de es: "+elementos[i]);
        }

        System.out.println("___________________________");
*/
        //Tarea 2 pt.2 Pruebas

        DateTime time1 = new DateTime();//1
        DateTime time2 = new DateTime(0,26,3);//2
        DateTime time3 = new DateTime(11, 59, 59, 31, 12, 2017);//3
        DateTime time4 = (DateTime) time3.clone();//4
        time4.next();
        Date date5 = new Date(31,12,2017);//5
        Date p_time6 = new Date(time3.getDay(),time3.getMonth(),time3.getYear()) ;//6
        p_time6.next();
        DateTime time6 = new DateTime(time3.getHours(),time3.getMinutes(),time3.getSeconds(),p_time6.getDay(),p_time6.getMonth(),p_time6.getYear());


        Date[] elementosTime = {time1, time2, time3, time4 ,date5,time6};//10!!!!!!!!!!
        for (Date elemento:elementosTime) {
            System.out.println("Fecha:  -"+elemento+"-");
            for (int j = 0; j <=2; j++) {

                elemento.setFormat(j);
                System.out.println("Format"+j+": "+elemento);
            }
            System.out.println("_________________________________________");
        }

        System.out.println("Ejericio7:");
        DateTime time2clone = (DateTime) time2.clone();//7
        System.out.println(time2.equals(time2clone)+"\n" );

        System.out.println("Ejericio8:");
        DateTime c_date5= new DateTime(date5);//8
        System.out.println(  time3.equals(c_date5)+"\n");

        System.out.println("Ejericio9:");
        System.out.println(date5.equals(time3)+"\n");//9
    }
    }