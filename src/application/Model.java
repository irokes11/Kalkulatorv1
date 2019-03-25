package application;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Model {

	@FXML
	private Button AC;

	@FXML
	private Button plusMinus;

	@FXML
	private Button procent;

	@FXML
	private Button dzielenie;

	@FXML
	private Button seven;

	@FXML
	private Button eight;

	@FXML
	private Button nine;

	@FXML
	private Button mnozenie;

	@FXML
	private Button four;

	@FXML
	private Button five;

	@FXML
	private Button six;

	@FXML
	private Button odejmowanie;

	@FXML
	private Button one;

	@FXML
	private Button two;

	@FXML
	private Button three;

	@FXML
	private Button dodawanie;
	

	@FXML
	private Button zero;

	@FXML
	private Button przecinek;

	@FXML
	private Button rownosci;

	@FXML
	private Label wyswietlacz;

	Float data = 0f;
	int operation = -1;

	private boolean start;
	private double result;
	private String lastCommand;

	@FXML
	private void handleButtonAction(ActionEvent event) {
		
		

		if (event.getSource() == one)

		{
			wyswietlacz.setText(wyswietlacz.getText() + "1");
		} else if (event.getSource() == two) {
			wyswietlacz.setText(wyswietlacz.getText() + "2");
		} else if (event.getSource() == three) {
			wyswietlacz.setText(wyswietlacz.getText() + "3");
		} else if (event.getSource() == four) {
			wyswietlacz.setText(wyswietlacz.getText() + "4");
		} else if (event.getSource() == five) {
			wyswietlacz.setText(wyswietlacz.getText() + "5");
		} else if (event.getSource() == six) {
			wyswietlacz.setText(wyswietlacz.getText() + "6");
		} else if (event.getSource() == seven) {
			wyswietlacz.setText(wyswietlacz.getText() + "7");
		} else if (event.getSource() == eight) {
			wyswietlacz.setText(wyswietlacz.getText() + "8");
		} else if (event.getSource() == nine) {
			wyswietlacz.setText(wyswietlacz.getText() + "9");
		} else if (event.getSource() == zero) {
			wyswietlacz.setText(wyswietlacz.getText() + "0");
		} else if (event.getSource() == AC) {
			wyswietlacz.setText("");
		} else if (event.getSource() == dodawanie) {
			data = Float.parseFloat(wyswietlacz.getText());
			operation = 1; // Dodawanie
			wyswietlacz.setText("");
		} else if (event.getSource() == odejmowanie) {
			data = Float.parseFloat(wyswietlacz.getText());
			operation = 2; // Odejmowanie
			wyswietlacz.setText("");
		} else if (event.getSource() == mnozenie) {
			data = Float.parseFloat(wyswietlacz.getText());
			operation = 3; // Mnozenie
			wyswietlacz.setText("");
		} else if (event.getSource() == dzielenie) {
			data = Float.parseFloat(wyswietlacz.getText());
			operation = 4; // Dzielenie
			wyswietlacz.setText("");

		} else if (event.getSource() == rownosci) {

			Float secondOperand = Float.parseFloat(wyswietlacz.getText());
			switch (operation) {
			case 1: // Dodawanie
				Float ans = data + secondOperand;
				displayResult (ans);
				//wyswietlacz.setText(String.valueOf(ans));
				break;

			case 2: // Odejmowanie
				ans = data - secondOperand;
				displayResult (ans);
				//wyswietlacz.setText(String.valueOf(ans));
				break;

			case 3: // Mnozenie
				ans = data * secondOperand;
				displayResult (ans);
				//wyswietlacz.setText(String.valueOf(ans));
				break;

			case 4: // Dzielenie
				ans = 0f;
				try {
					ans = data / secondOperand;
				} catch (Exception e) {
					
					wyswietlacz.setText("Error");
				}
				displayResult (ans);
				//wyswietlacz.setText(String.valueOf(ans));
				break;

			}

		}
	}

	public void przecinek_klik() {
		String oldvalue = wyswietlacz.getText();
		String set = ".";
		wyswietlacz.setText(oldvalue + set);
	}

	public void znakMinusPlus() {

		double digit = Double.parseDouble(wyswietlacz.getText());
		digit = -digit;
		displayResult (digit);
		
	}

	public void initialize() {
		wyswietlacz.setText("0");

	}

	private void displayResult(double x1) {
		NumberFormat numberFormatter = new DecimalFormat("##.##");
		String result = numberFormatter.format(x1);
		wyswietlacz.setText(result);
	}

	public void procenty() {
		double digit = Double.parseDouble(wyswietlacz.getText());
		digit = digit / 100;
		displayResult (digit);
		//wyswietlacz.setText(Double.toString(digit));

	}

	@FXML
	public void clear_klik(ActionEvent evt) {
		String command = ((Button) evt.getSource()).getText();
		if (command.equals("AC")) {
			result = 0;
			start = true;
			lastCommand = "=";
		}
		wyswietlacz.setText("");
		AC.setText("AC");

	}
}