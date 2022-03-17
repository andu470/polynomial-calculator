package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class Polynomial {

    private final ArrayList<Monomial> polynomial = new ArrayList<>();

    public Polynomial(){}

    public ArrayList<Monomial> getPolynomial() {
        return polynomial;
    }

    //method that returns a polynomial as a string; used for display
    public String getPolynomialString() {
        StringBuilder stringBuilder = new StringBuilder();
        Iterator<Monomial> myIterator = this.getPolynomial().iterator();
        while (myIterator.hasNext()) {
            Monomial currentMonomial = myIterator.next();
            stringBuilder.append(currentMonomial.getMonomialString());
        }
        return stringBuilder.toString();
    }

    //method that returns a monomial with a specific degree; used for operations
    public Monomial getDegree(int degree) {
        Monomial resultMonomial = null;
        Iterator<Monomial> myIterator = this.getPolynomial().iterator();
        while (myIterator.hasNext()) {
            Monomial currentMonomial = myIterator.next();
            if (currentMonomial.getPower() == degree) {
                resultMonomial = currentMonomial;
            }
        }
        return resultMonomial;
    }

    //method that returns a copy of a polynomial
    public Polynomial copyPolynomial(Polynomial poly) {
        Polynomial copyPolynomial = new Polynomial();
        Iterator<Monomial> myIterator = poly.getPolynomial().iterator();
        while (myIterator.hasNext()) {
            Monomial currentMonomial = myIterator.next();
            int power = currentMonomial.getPower();
            double coeff = currentMonomial.getCoeff();
            Monomial copyMonomial = new Monomial(power, coeff);
            copyPolynomial.getPolynomial().add(copyMonomial);
        }
        return copyPolynomial;
    }

    //method to sort (decreasing) the polynomial based on its degrees, used for a pretty display
    //code (little changed) from: https://dzone.com/articles/how-to-sort-objects-in-java
    public void sortDegree() {
        Collections.sort(polynomial, new Comparator<Monomial>() {
            @Override
            public int compare(Monomial mono1, Monomial mono2) {
                return mono1.getPower() >  mono2.getPower() ? -1 : mono1.getPower() == mono2.getPower() ? 0 : 1;
            }
        });
    }

    //Addition
    public Polynomial add(Polynomial poly1, Polynomial poly2) {
        Polynomial sumPolynomial;
        sumPolynomial = poly1.copyPolynomial(poly1);
        Iterator<Monomial> myIterator = poly2.getPolynomial().iterator();
        while (myIterator.hasNext()) {
            Monomial currentMonomial = myIterator.next();
            int currentDegree = currentMonomial.getPower();
            double currentCoeff = currentMonomial.getCoeff();
            Monomial searchedMonomial = sumPolynomial.getDegree(currentDegree);
            if (searchedMonomial == null) {
                sumPolynomial.getPolynomial().add(currentMonomial);
            } else {
                double oldCoeff = searchedMonomial.getCoeff();
                searchedMonomial.setCoeff(currentCoeff + oldCoeff);
            }
        }
        sumPolynomial.sortDegree();
        return sumPolynomial;
    }

    //Subtraction
    public Polynomial sub(Polynomial poly1, Polynomial poly2) {
        Polynomial diffPolynomial;
        diffPolynomial = poly1.copyPolynomial(poly1);
        Iterator<Monomial> myIterator = poly2.getPolynomial().iterator();
        while (myIterator.hasNext()) {
            Monomial currentMonomial = myIterator.next();
            int currentDegree = currentMonomial.getPower();
            double currentCoeff = currentMonomial.getCoeff();
            Monomial searchedMonomial = diffPolynomial.getDegree(currentDegree);
            if (searchedMonomial == null) {
                Monomial newMonomial = new Monomial(currentDegree, -currentCoeff);
                diffPolynomial.getPolynomial().add(newMonomial);
            } else {
                double oldCoeff = searchedMonomial.getCoeff();
                searchedMonomial.setCoeff(oldCoeff - currentCoeff);
            }
        }
        diffPolynomial.sortDegree();
        return diffPolynomial;
    }

    //Multiplication
    public Polynomial multiply(Polynomial poly1, Polynomial poly2) {
        Polynomial multiplyPolynomial = new Polynomial();
        Iterator<Monomial> myIterator1 = poly1.getPolynomial().iterator();
        while (myIterator1.hasNext()) {
            Monomial currentMonomial1 = myIterator1.next();
            int powerPoly1 = currentMonomial1.getPower();
            double coeffPoly1 = currentMonomial1.getCoeff();
            Iterator<Monomial> myIterator2 = poly2.getPolynomial().iterator();
            while (myIterator2.hasNext()) {
                Monomial currentMonomial2 = myIterator2.next();
                int powerPoly2 = currentMonomial2.getPower();
                int multiplyPower = powerPoly1 + powerPoly2;
                double coeffPoly2 = currentMonomial2.getCoeff();
                double multiplyCoeff = coeffPoly1 * coeffPoly2;
                Monomial searchedMonomial = multiplyPolynomial.getDegree(multiplyPower);
                if (searchedMonomial == null) {
                    Monomial newMonom = new Monomial(multiplyPower, multiplyCoeff);
                    multiplyPolynomial.getPolynomial().add(newMonom);
                } else {
                    double oldCoeff = searchedMonomial.getCoeff();
                    searchedMonomial.setCoeff(oldCoeff + multiplyCoeff);
                }
            }
        }
        multiplyPolynomial.sortDegree();
        return multiplyPolynomial;
    }

    //Derivation
    public Polynomial derive(Polynomial poly) {
        Polynomial derivatePolynomial = new Polynomial();
        Iterator<Monomial> myIterator = poly.getPolynomial().iterator();
        while (myIterator.hasNext()) {
            Monomial currentMonomial = myIterator.next();
            int power = currentMonomial.getPower();
            double coeff = currentMonomial.getCoeff();
            currentMonomial.setCoeff(power * coeff);
            currentMonomial.setPower(power - 1);
            derivatePolynomial.getPolynomial().add(currentMonomial);
        }
        derivatePolynomial.sortDegree();
        return derivatePolynomial;
    }

    //Integration
    public Polynomial integrate(Polynomial poly) {
        Polynomial integratePolynomial = new Polynomial();
        Iterator<Monomial> myIterator = poly.getPolynomial().iterator();
        while (myIterator.hasNext()) {
            Monomial currentMonomial = myIterator.next();
            int power = currentMonomial.getPower();
            double coeff = currentMonomial.getCoeff();
            currentMonomial.setPower(power + 1);
            currentMonomial.setCoeff(coeff / (power + 1));
            integratePolynomial.getPolynomial().add(currentMonomial);
        }
        integratePolynomial.sortDegree();
        return integratePolynomial;
    }
}