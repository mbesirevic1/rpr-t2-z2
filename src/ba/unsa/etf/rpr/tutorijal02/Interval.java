package ba.unsa.etf.rpr.tutorijal02;

public class Interval {

    private double pocetna, krajnja;
    private boolean pocetna_Pripada, krajnja_Pripada;

    public Interval(double x, double y, boolean z, boolean w){

        if(x>y) throw new IllegalArgumentException("Pocetna tacka veca od krajnje");

        pocetna = x;
        krajnja = y;
        pocetna_Pripada = z;
        krajnja_Pripada = w;
    }

    public Interval(){

        pocetna = 0;
        krajnja = 0;
        pocetna_Pripada = false;
        krajnja_Pripada = false;

    }

    public boolean isNull(){
        return (pocetna == 0 && krajnja == 0);
    }

    public boolean isIn(double t){
        return ((t>pocetna && t<krajnja) ||
                (pocetna == t && pocetna_Pripada || krajnja==t && krajnja_Pripada ));
    }




    @Override
    public boolean equals(Object object){
        Interval interval = (Interval) object;
        return ((pocetna == interval.pocetna && krajnja == interval.krajnja)
                && (pocetna_Pripada==interval.pocetna_Pripada && krajnja_Pripada==interval.krajnja_Pripada));
    }

    @Override
    public String toString(){

        if(pocetna == 0 && krajnja==0) return "()";

        String string = "";

        if(pocetna_Pripada){
            string = string + "[";
        }
        else{
            string = string + "(";
        }

        if(krajnja_Pripada){
            string = string + "]";
        }
        else{
            string = string + ")";
        }

        return string;
    }



}
