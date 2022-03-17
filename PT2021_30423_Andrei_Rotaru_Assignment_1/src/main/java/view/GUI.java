package view;

import javax.swing.*;
import java.awt.event.ActionListener;

public class GUI extends JFrame {

    //buttons for operations
    private final JLabel operationLabel;
    private final JButton addButton;
    private final JButton subButton;
    private final JButton multiplyButton;
    private final JButton deriveButton;
    private final JButton integrateButton;

    //labels and text fields for polynomials
    private final JLabel poly1Label;
    private final JTextField poly1TextField;
    private final JLabel poly2Label;
    private final JTextField poly2TextField;

    //labels for result
    private final JLabel textResultLabel;
    private final JLabel resultLabel;

    //label for more information
    private final JLabel infoLabel;
    private final JLabel infoLabel1;
    private final JLabel infoLabel2;
    private final JLabel infoLabel3;
    private final JLabel infoLabel4;

    public GUI(){

        this.setIconImage(new ImageIcon(getClass().getResource("/CalculatorIcon.png")).getImage());
        this.setTitle("Polynomial Calculator");
        this.setBounds(200,200,900,600);
        this.getContentPane().setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        //label and text field for first polynomial
        poly1Label = new JLabel("Polynomial 1: ");
        poly1Label.setBounds(50, 20, 120, 30);
        getContentPane().add(poly1Label);
        poly1TextField = new JTextField();
        poly1TextField.setBounds(170, 20, 400, 30);
        getContentPane().add(poly1TextField);

        //label and text field for second polynomial
        poly2Label = new JLabel("Polynomial 2: ");
        poly2Label.setBounds(50, 70, 120, 30);
        getContentPane().add(poly2Label);
        poly2TextField = new JTextField();
        poly2TextField.setBounds(170, 70, 400, 30);
        getContentPane().add(poly2TextField);

        //label for result
        textResultLabel = new JLabel("Result: ");
        textResultLabel.setBounds(50, 120, 120, 30);
        getContentPane().add(textResultLabel);
        resultLabel = new JLabel("0");
        resultLabel.setBounds(170, 120, 500, 30);
        getContentPane().add(resultLabel);

        //info label
        infoLabel = new JLabel("Info");
        infoLabel.setBounds(50,320,850,100);
        getContentPane().add(infoLabel);

        infoLabel1 = new JLabel("1. Input is: ax^power1+bx^power2+...");
        infoLabel1.setBounds(50,350,850,100);
        getContentPane().add(infoLabel1);

        infoLabel2 = new JLabel("2. For negative coefficient put +-coefficient (except for the first monomial)");
        infoLabel2.setBounds(50,380,850,100);
        getContentPane().add(infoLabel2);

        infoLabel3 = new JLabel("3. Subtraction is polynomial 1 - polynomial 2");
        infoLabel3.setBounds(50,410,850,100);
        getContentPane().add(infoLabel3);

        infoLabel4 = new JLabel("4. Derivation and integration are applied to polynomial 1");
        infoLabel4.setBounds(50,440,850,100);
        getContentPane().add(infoLabel4);

        //label for operation
        operationLabel = new JLabel("Operation");
        operationLabel.setBounds(740, 10, 120, 30);
        getContentPane().add(operationLabel);

        //addition button
        addButton = new JButton("+");
        addButton.setBounds(740, 40, 120, 60);
        getContentPane().add(addButton);

        //subtraction button
        subButton = new JButton("-");
        subButton.setBounds(740, 110, 120, 60);
        getContentPane().add(subButton);

        //multiplication button
        multiplyButton = new JButton("*");
        multiplyButton.setBounds(740, 180, 120, 60);
        getContentPane().add(multiplyButton);

        //derivation button
        deriveButton = new JButton("( )'");
        deriveButton.setBounds(740, 250, 120, 60);
        getContentPane().add(deriveButton);

        //integration button
        integrateButton = new JButton("Integrate");
        integrateButton.setBounds(740, 320, 120, 60);
        getContentPane().add(integrateButton);

        this.setVisible(true);
    }

    //setter for result
    public void setResult(String result) {
        resultLabel.setText(result);
    }

    //getters for polynomial text fields
    public String getFirstPoly() {
        return poly1TextField.getText();
    }

    public String getSecondPoly() {
        return poly2TextField.getText();
    }

    //action listeners
    public void addAddActionListener(final ActionListener actionListener) {
        addButton.addActionListener(actionListener);
    }

    public void addSubActionListener(final ActionListener actionListener) {
        subButton.addActionListener(actionListener);
    }

    public void addMultiplyActionListener(final ActionListener actionListener) {
        multiplyButton.addActionListener(actionListener);
    }

    public void addDeriveActionListener(final ActionListener actionListener) {
        deriveButton.addActionListener(actionListener);
    }

    public void addIntegrateActionListener(final ActionListener actionListener) {
        integrateButton.addActionListener(actionListener);
    }
}
