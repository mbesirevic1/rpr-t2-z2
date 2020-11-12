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

    public double getPocetna() {
        return pocetna;
    }

    public void setPocetna(double pocetna) {
        this.pocetna = pocetna;
    }

    public double getKrajnja() {
        return krajnja;
    }

    public void setKrajnja(double krajnja) {
        this.krajnja = krajnja;
    }

    public boolean isPocetnaPripada() {
        return pocetna_Pripada;
    }

    public void setPocetnaPripada(boolean pocetna_Pripada) {
        this.pocetna_Pripada = pocetna_Pripada;
    }

    public boolean isKrajnjaPripada() {
        return krajnja_Pripada;
    }

    public void setKrajnjaPripada(boolean krajnja_Pripada) {
        this.krajnja_Pripada = krajnja_Pripada;
    }

    public boolean isNull(){
        return (pocetna == 0 && krajnja == 0 && !pocetna_Pripada && !krajnja_Pripada );
    }

    public boolean isIn(double t){
        return ((t>pocetna && t<krajnja) ||
                (pocetna == t && pocetna_Pripada || krajnja==t && krajnja_Pripada ));
    }

    public static Interval intersect(Interval I1, Interval I2){

        Interval interval = new Interval();

        if(I1.isIn(I2.getPocetna())){
            interval.setPocetna(I2.getPocetna());
            interval.setPocetnaPripada(I2.isPocetnaPripada());

            if(I1.isIn(I2.getKrajnja())){
                interval.setKrajnja(I2.getKrajnja());
                interval.setKrajnjaPripada(I2.isKrajnjaPripada());
            }
            else{
                interval.setKrajnja((I1.getKrajnja()));
                interval.setKrajnjaPripada(I1.isKrajnjaPripada());
            }

        }
        if(I2.isIn(I1.getPocetna())){
            interval.setPocetna(I1.getPocetna());
            interval.setPocetnaPripada(I1.isPocetnaPripada());

            if(I2.isIn(I1.getKrajnja())){
                interval.setKrajnja(I1.getKrajnja());
                interval.setKrajnjaPripada(I1.isKrajnjaPripada());
            }
            else{
                interval.setKrajnja((I2.getKrajnja()));
                interval.setKrajnjaPripada(I2.isKrajnjaPripada());
            }

        }



        return interval;
    }

    public Interval intersect(Interval I){

        Interval interval = new Interval();

        if(I.isIn(getPocetna())){
            interval.setPocetna(getPocetna());
            interval.setPocetnaPripada(isPocetnaPripada());

            if(I.isIn(getKrajnja())){
                interval.setKrajnja(getKrajnja());
                interval.setKrajnjaPripada(isKrajnjaPripada());
            }
            else{
                interval.setKrajnja(I.getKrajnja());
                interval.setKrajnjaPripada(I.isKrajnjaPripada());
            }
        }



        if(isIn(I.getPocetna())){
            interval.setPocetna(I.getPocetna());
            interval.setPocetnaPripada(I.isPocetnaPripada());

            if(isIn(I.getKrajnja())){
                interval.setKrajnja(I.getKrajnja());
                interval.setKrajnjaPripada(I.isKrajnjaPripada());
            }
            else{
                interval.setKrajnja(getKrajnja());
                interval.setKrajnjaPripada(isKrajnjaPripada());
            }
        }



        return interval;
    }



    @Override
    public boolean equals(Object object){
        Interval interval = (Interval) object;
        return ((pocetna == interval.pocetna && krajnja == interval.krajnja)
                && (pocetna_Pripada==interval.pocetna_Pripada && krajnja_Pripada==interval.krajnja_Pripada));
    }

    @Override
    public String toString(){

        if(isNull()) return "()";

        String string = new String();

        if(pocetna_Pripada){
            string = string + "[";
        }
        else{
            string = string + "(";
        }

        string = string + Double.toString(getPocetna())+"," + Double.toString(getKrajnja());

        if(krajnja_Pripada){
            string = string + "]";
        }
        else{
            string = string + ")";
        }

        return string;
    }



}
