package model;

public class Monomial {
    private int power;
    private double coeff;

    public Monomial(int power,double coeff){
        this.power = power;
        this.coeff = coeff;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public double getCoeff() {
        return coeff;
    }

    public void setCoeff(double coeff) {
        this.coeff = coeff;
    }

    //method that returns a monomial as a string; used for building the polynomial to display
    public String getMonomialString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (coeff != 0) {
            if(power == 0) {
                return stringBuilder.append("+ ").append(coeff).append(" ").toString();
            }
            else{
                return stringBuilder.append("+ ").append(coeff).append("x^").append(power).append(" ").toString();
            }
        }
        else {
            return "";
        }
    }
}
