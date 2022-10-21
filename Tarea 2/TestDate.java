package mx.iteso.calendar;

public class TestDate {
    public static void main(String[] args) {

        //A)
        Date d1= new Date();
        //B)
        Date d2= new Date(31,12,2016);
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
    }
}