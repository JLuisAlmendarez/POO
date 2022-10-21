package mx.iteso.calendar;
import java.util.Calendar;

public class Date {

    //Declaracion de caracteristocas
    private int day;
    private int month;
    private int year;
    private String monthName;
    private int format=0;

    //Constructores
    //Estos son los 3 cronstructores hechos para dejar en claro los valores con las que se van a trabajar asi como
    //sus valores predeterminados
    public Date(){
        this(Calendar.getInstance().get(Calendar.DAY_OF_MONTH),
                Calendar.getInstance().get(Calendar.MONTH)+1,
                Calendar.getInstance().get(Calendar.YEAR));
    }

    public Date(int day, int month, int year){
        this(day,month,year,0);
    }
    public Date(int day, int month, int year, int format){
        setYear(year);
        setMonth(month);
        setDay(day);
        setFormat(format);
    }

    //Setters
    public void setDay(int day){
        //El set de day esta hecho asi para dejar en claro que si alguno de los valores se pasan de rango en un mes en
        // especifico se ponga el valor predeterminado
        if ((day>31||day<1)&&(this.month ==1||this.month ==3||this.month ==5||this.month ==7||this.month ==8||this.month ==10||this.month ==12)){
            this.day= 1;
        } else if ((day>30 || day < 1)& (this.month ==4||this.month==6||this.month==9||this.month==11)){
            this.day= 1;
        } else if ((day>28 || day < 1)& (this.month ==2)) {
            this.day= 1;
        }
        else {
            this.day=day;
        }
    }

    public void setMonth(int month){
        //El set de month tambien corrige los rangos asi como que dependiendo del valor de month tambien cambia el valor
        //de Monthname
        if(month>12||month<1){
            this.month=1;
            this.monthName="Enero";
        } else {
            if (month==1){
                this.month=1;
                this.monthName="Enero";
            } else if (month==2){
                this.month=2;
                this.monthName="Febrero";
            } else if (month==3){
                this.month=3;
                this.monthName="Marzo";
            } else if (month==4){
                this.month=4;
                this.monthName="Abril";
            } else if (month==5){
                this.month=5;
                this.monthName="Mayo";
            } else if (month==6){
                this.month=6;
                this.monthName="Junio";
            } else if (month==7){
                this.month=7;
                this.monthName="Julio";
            } else if (month==8){
                this.month=8;
                this.monthName="Agosto";
            } else if (month==9){
                this.month=9;
                this.monthName="Septiembre";
            } else if (month==10){
                this.month=10;
                this.monthName="Octubre";
            } else if (month==11){
                this.month=11;
                this.monthName="Noviembre";
            } else if (month==12){
                this.month=12;
                this.monthName="Diciembre";
            }
        }
    }
    public void setYear(int year){
        //Este set year unicamente corrige la salida de rangos a los valores predeterminados
        //como los anteriores
        if(year>3000||year<1900){
            this.year=2017;
        } else {
            this.year=year;
        }
    }
    public void setFormat(int format){
        //Como los anteriores, corrige la salida de rangos y apunta al propio valor del input
        if (format<0||format>2){
            this.format = 0;
        }else {
            this.format = format;
        }
    }

    //Getters
    // Estos getters te consiguen los valores ya establecidos
    public int getDay(){return day;}
    public int getMonth(){return month;}
    public int getYear(){return year;}
    public String getMonthName(){ return monthName;}
    public int getFormat(){return format;}

    //Metodos
    // Dependiendo del resultado de format se regresara un String con los datos y el formato a como se desea que se imprima
    public String toString(){
        String result;
    if (getFormat()== 0){
        String annoStr = String.valueOf(getYear());// transformamos el int del anno a string
        String ultimos2 = annoStr.substring(2,4);// La funcion substring sirve para agarrar un rango de caracteres dentro del arreglo del string
        String diaM10;
        if (getDay()<10){
            diaM10 = "0"+getDay(); // Para que el formato quede como se pide para los que no tienen 2 caracteres se suma un 0 string al principio
        } else {
            String diaStr = String.valueOf(getDay());
            diaM10 = diaStr;
        }

        //se repite lo que hicimos con el formato de los valores monocaracteristicos
        String mesM10;
        if (getMonth()<10){
            mesM10 = "0"+getMonth();
        } else {
            String mesStr = String.valueOf(getMonth());
            mesM10 = mesStr;
        }

        result = diaM10+"/"+mesM10+"/"+ultimos2;//Se imprime como se pide
        return result;
    }else if(getFormat()== 1){
        String primerosTres =getMonthName().substring(0,3);//usamos substring de nuevo para seleccionar los primeros 3 caracteres de monthname
        result=getDay()+"-"+primerosTres+"-"+getYear();
        return result;
    }else if(getFormat()== 2){
        result = getDay() +" de "+ getMonth()+" de "+getYear(); //esto unicamente creamos un string dedicado para imprimir
        return result;
    }
    return null;
    }

   public boolean equals(Date obj2){//se comparan los datos encapsulados con los datos del objeto, hecho eso se llega a un veredicto
        if (getDay()==obj2.getDay() && getMonth()==obj2.getMonth() && getYear()==obj2.getYear()){
            return true;
        }else {
            return false;
        }
    }


    public Object clone(){
        Object prov = new Date(getDay(),getMonth(),getYear(),getFormat());
        return prov;
    }


    public void next(){// Aqui dependiendo del rango de valores del dia y el mes decidimos si sumar un dia, ajustar un dia y sumar un mes o
        //ajustar dia, mes y sumar anno
        //Es exactamente igual para los meses que tienen 30,31 y 28 dias
        if (getDay()==31 && (getMonth() ==1|| getMonth()==3|| getMonth()==5||getMonth()== 7||getMonth()==8||getMonth()==10)){
            setDay(1);
            setMonth(getMonth()+1);
        }else if (getDay()<31 && ((getMonth() ==1|| getMonth()==3|| getMonth()==5||getMonth()== 7||getMonth()==8||getMonth()==10))){
            setDay(getDay()+1);
        }else if(getDay()==31&& getMonth()==12){
            setDay(1);
            setMonth(1);
            setYear(getYear()+1);
        }
        if (getDay()<30 && (getMonth() ==4||getMonth() ==6||getMonth() ==9||getMonth() ==11)){
            setDay(getDay()+1);
        } else if(getDay()>=30 &&(getMonth() ==4||getMonth() ==6||getMonth() ==9||getMonth() ==11)){
            setDay(1);
            setMonth(getMonth()+1);
        }

        if (getDay()<28 && (getMonth() ==2)){
            setDay(getDay()+1);
        } else if(getDay()>=28 &&(getMonth() ==2)){
            setDay(1);
            setMonth(getMonth()+1);
        }

    }

}


