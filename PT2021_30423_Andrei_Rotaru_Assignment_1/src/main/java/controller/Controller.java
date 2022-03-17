package controller;

import model.Monomial;
import model.Polynomial;
import view.GUI;

import javax.swing.*;

public class Controller {
    private GUI gui;

    public void start(){
        gui = new GUI();
        activateButtons();
    }

    //method that returns a polynomial from the TextField for input
    public Polynomial extractPolynomial(String textFieldString) {
        Polynomial currentPolynomial = new Polynomial();
        String polynomialString = textFieldString;
        try {
            polynomialString = polynomialString.replaceAll("\\s","");   //make sure that there are no spaces
            for (String token : polynomialString.split("\\+")) {    //a monomial is what is between 2 '+'
                int coeff;
                int power;
                int xPosition = token.indexOf("x");
                int powerPosition = token.indexOf("^");
                try {
                    coeff = Integer.parseInt(token.substring(0, xPosition));
                    power = Integer.parseInt(token.substring(powerPosition + 1));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Invalid input! Check Info!");
                    return null;
                }
                if (coeff != 0) {
                    Monomial myMonomial = new Monomial(power, coeff);
                    currentPolynomial.getPolynomial().add(myMonomial);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid input! Check Info!");
        }
        return currentPolynomial;
    }

    //method that makes the buttons for operations to work
    public void activateButtons(){
        //Addition
        gui.addAddActionListener(e -> {
                Polynomial poly1 = extractPolynomial(gui.getFirstPoly());
                Polynomial poly2 = extractPolynomial(gui.getSecondPoly());
                Polynomial sumPolynomial;
                try {
                    sumPolynomial = poly1.add(poly1, poly2);
                    gui.setResult(sumPolynomial.getPolynomialString());
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
        });

        //Subtraction
        gui.addSubActionListener(e -> {
            Polynomial poly1 = extractPolynomial(gui.getFirstPoly());
            Polynomial poly2 = extractPolynomial(gui.getSecondPoly());
            Polynomial diffPolynomial;
            try {
                diffPolynomial = poly1.sub(poly1, poly2);
                gui.setResult(diffPolynomial.getPolynomialString());
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

        //Multiplication
        gui.addMultiplyActionListener(e -> {
            Polynomial poly1 = extractPolynomial(gui.getFirstPoly());
            Polynomial poly2 = extractPolynomial(gui.getSecondPoly());
            Polynomial multiplyPolynomial;
            try {
                multiplyPolynomial = poly1.multiply(poly1, poly2);
                gui.setResult(multiplyPolynomial.getPolynomialString());
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

        //Derivation
        gui.addDeriveActionListener(e -> {
            Polynomial poly1 = extractPolynomial(gui.getFirstPoly());
            Polynomial derivatePolynomial;
            try {
                derivatePolynomial = poly1.derive(poly1);
                gui.setResult(derivatePolynomial.getPolynomialString());
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

        //Integration
        gui.addIntegrateActionListener(e -> {
            Polynomial poly1 = extractPolynomial(gui.getFirstPoly());
            Polynomial integratePolynomial;
            try {
                integratePolynomial = poly1.integrate(poly1);
                gui.setResult(integratePolynomial.getPolynomialString());
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });
    }
}