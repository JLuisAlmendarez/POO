package mx.iteso.calendar;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.Calendar;
import java.util.Objects;

public class DateTime extends Date{
    //Elementos(Variables)
    private int seconds;
    private int minutes;
    private int hours;

    //Constructores
    public DateTime(int hours, int minutes, int seconds, int day, int month, int year){
    super(day,month,year);
    setHours(hours);
    setMinutes(minutes);
    setSeconds(seconds);
    }
    public DateTime(int hours, int minutes, int seconds){
        this(hours,minutes,seconds,
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH),
                Calendar.getInstance().get(Calendar.MONTH)+1,
                Calendar.getInstance().get(Calendar.YEAR));
    }
    public DateTime(){
        this(Calendar.getInstance().get(Calendar.HOUR_OF_DAY),
                Calendar.getInstance().get(Calendar.MINUTE),
                Calendar.getInstance().get(Calendar.SECOND),

                Calendar.getInstance().get(Calendar.DAY_OF_MONTH),
                Calendar.getInstance().get(Calendar.MONTH)+1,
                Calendar.getInstance().get(Calendar.YEAR));

    }
    public DateTime(Date obj1){
        this(Calendar.getInstance().get(Calendar.HOUR_OF_DAY),
                Calendar.getInstance().get(Calendar.MINUTE),
                Calendar.getInstance().get(Calendar.SECOND),
                obj1.getDay(), obj1.getMonth(), obj1.getYear());
    }


    //Setters AQUI HICISTE UN CAMBIO EN LOS SETTERS, HACERLE SABER AL PROFESOR
    public void setHours(int hours) {
        if (hours<0||hours>23){
            this.hours = 0;
        } else {
            this.hours = hours;
        }

    }
    public void setMinutes(int minutes) {

        if (minutes<0||minutes>59){
            this.minutes = 0;
        } else {
            this.minutes = minutes;
        }
    }
    public void setSeconds(int seconds) {
        if (seconds<0||seconds>59){
            this.seconds = 0;
        } else {
            this.seconds = seconds;
        }    }

    //getters
    public int getSeconds(){return seconds;}
    public int getMinutes(){return minutes;}
    public int getHours(){return hours;}

//ToString
    @Override
    public String toString() {
        //Strings a modificar y variables condicionales
        String resultado;
        String hr = "";
        String defDay;
        String defMonth;
        String defHour;
        String defMin;
        String defSec;
        String primTres = getMonthName().substring(0,3);
        String cmpDay   = String.valueOf(getDay());
        String cmpMonth = String.valueOf(getMonth());
        String cmpHour  = String.valueOf(getHours());
        String cmpMin   = String.valueOf(getMinutes());
        String cmpSec   = String.valueOf(getSeconds());

        //Modificacion de hr
        if(getHours()>12||getHours()<23){
            hr = " PM";
        } else {
            hr= "AM";
        }

        //Modificacion de variables con digitos unicos
        if(cmpDay.length()<2){
            defDay = "0"+getDay();
        }else {
            defDay = cmpDay;
        }

        if(cmpMonth.length()<2){
            defMonth = "0"+getMonth();
        }else {
            defMonth = cmpMonth;
        }

        if(cmpHour.length()<2){
            defHour = "0"+getHours();
        }else {
            defHour = cmpHour;
        }

        if(cmpMin.length()<2){
            defMin = "0"+getMinutes();
        }else {
            defMin = cmpMin;
        }

        if(cmpSec.length()<2){
            defSec = "0"+getSeconds();
        }else {
            defSec = cmpSec;
        }

        //Asignacion de cadenas por formato
        if(getFormat()==0){
            String annoStr = String.valueOf(getYear());
            String ult_dos = annoStr.substring(2,4);

            resultado= "["+defHour+":"+defMin+":"+defSec+"]"+" "+defDay+"/"+defMonth+"/"+ult_dos;
            return resultado;

        } else if(getFormat()==1){
            resultado = "["+defHour+":"+defMin+":"+defSec+ hr +"]"+" "+defDay+"-"+primTres+"-"+getYear();
            return resultado;

        } else if(getFormat()==2){
            resultado = "["+getHours()+":"+getMinutes()+":"+getSeconds()+ hr +"]"+" "+getDay()+" de "+getMonthName()+" de "+getYear();
            return resultado;
        }


        return null;
    }


    //Problema en estos dos
    public Object clone(){
        Object prov = new DateTime(getHours(),getMinutes(),getSeconds(),getDay(),getMonth(),getYear());
        return prov;
    }
    public void next() {
        if (getMinutes() == 59 & getSeconds()==59){
            setHours(getHours()+1);
            setMinutes(getMinutes()+1);
            setSeconds(getSeconds()+1);
        } else if (getSeconds() == 59) {
            setMinutes(getMinutes()+1);
            setSeconds(getSeconds()+1);
        } else {
            setSeconds(getSeconds()+1);
        }

    }
    public boolean equals(DateTime obj2){//Tambien tendria que ser dias o solo segundos
        if (getSeconds()==obj2.getSeconds() && getMinutes()==obj2.getMinutes() && getHours()==obj2.getHours()){
            return true;
        }else {
            return false;
        }
    }

    public Date toDate(){
        Date obj0 = new Date();
        obj0.setDay(getDay());
        obj0.setMonth(getMonth());
        obj0.setYear(getYear());
        return obj0;
    }
}


