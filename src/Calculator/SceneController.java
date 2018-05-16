package Calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.Stack;
import java.util.regex.Pattern;

public class SceneController {
	@FXML
	private TextArea textOut;
	@FXML
	private TextField textIn;
	@FXML
	private Button btnM;
	@FXML
	private Button btnMC;
	@FXML
	private Button btnMR;
	@FXML
	private Button btnMS;
	@FXML
	private Button btnMA;
	@FXML
	private Button btnBack;
	@FXML
	private Button btnCE;
	@FXML
	private Button btnC;
	@FXML
	private Button btnOut;
	@FXML
	private Button btnNum8;
	@FXML
	private Button btnNum4;
	@FXML
	private Button btnNum5;
	@FXML
	private Button btnNum6;
	@FXML
	private Button btnNum9;
	@FXML
	private Button btnAdd;
	@FXML
	private Button btnDot;
	@FXML
	private Button btnTra;
	@FXML
	private Button btnNum0;
	@FXML
	private Button btnNum2;
	@FXML
	private Button btnNum1;
	@FXML
	private Button btnNum3;
	@FXML
	private Button btnDiv;
	@FXML
	private Button btnRem;
	@FXML
	private Button btnMul;
	@FXML
	private Button btnSqr;
	@FXML
	private Button btnNum7;
	@FXML
	private Button btnRev;
	@FXML
	private Button btnSub;

	// Event Listener on Button[#btnMC].onAction
	@FXML
	public void MCOnAction(ActionEvent event) {
		// TODO Autogenerated
		btnM.setText("");
	}
	// Event Listener on Button[#btnMR].onAction
	@FXML
	public void MROnAction(ActionEvent event) {
		// TODO Autogenerated
		textIn.appendText(btnM.getText());
	}
	// Event Listener on Button[#btnMS].onAction
	@FXML
	public void MSOnAction(ActionEvent event) {
		// TODO Autogenerated
		btnM.setText(textOut.getText());
	}
	// Event Listener on Button[#btnMA].onAction
	@FXML
	public void MAOnAction(ActionEvent event) {
		// TODO Autogenerated
		if(btnM.getText()!="") {
			try {
				btnM.setText(Double.toString(Double.parseDouble(btnM.getText())+Double.parseDouble(textOut.getText())));
			}catch(Exception e) {
				textOut.setText("Input Error!");
			}
		}
		//else if(textOut.getText()!=""&&btnM.getText()="")
	}
	// Event Listener on Button[#btnBack].onAction
	@FXML
	public void BackOnAction(ActionEvent event) {
		// TODO Autogenerated
		if(textIn.getLength()!=0)
			textIn.deleteText(textIn.getLength()-1, textIn.getLength());
	}
	// Event Listener on Button[#btnCE].onAction
	@FXML
	public void CEOnAction(ActionEvent event) {
		// TODO Autogenerated
		textIn.deleteText(0, textIn.getLength());
	}
	// Event Listener on Button[#btnC].onAction
	@FXML
	public void COnAction(ActionEvent event) {
		// TODO Autogenerated
		textIn.deleteText(0, textIn.getLength());
		textOut.deleteText(0, textOut.getLength());
	}
	// Event Listener on Button[#btnOut].onAction
	@FXML
	public void OutOnAction(ActionEvent event) {
		// TODO Autogenerated
		textOut.deleteText(0, textOut.getLength());
		
		Pattern pattern1 = Pattern.compile("^[-\\+]?[\\d]*$");
		Pattern pattern2 = Pattern.compile("^[-\\+]?[\\d]*[\\.][\\d]*$");  
        if(pattern1.matcher(textIn.getText()).matches()||pattern2.matcher(textIn.getText()).matches()) {
        	textOut.setText(textIn.getText());
        	return;
        }
        
		Stack<String> ops = new Stack<String>();
		Stack<Double> vals = new Stack<Double>();
		
		try {
	        String str = '('+textIn.getText()+')';
	        StringBuilder  sb = new StringBuilder (str);
	        
	        int n = 0;
	        for(int i = 0; i < str.length()-1; i++) {
	        	char a = str.charAt(i);
	        	char b = str.charAt(i+1);
	        	if(!(Character.isDigit(a)&&Character.isDigit(b))&&a!=' '&&b!=' '&&a!='.'&&b!='.') {
	        		sb.insert(i+n+1, ' ');
	        		n++;
	        	}
	        }
	        str = sb.toString();
	        String[] strs = str.split("\\s+");
	        for (String s : strs) {
				if(s.equals("("))  ops.push(s);
				else if(s.equals("+"))	ops.push(s);
				else if(s.equals("-"))	ops.push(s);
				else if(s.equals("*"))	ops.push(s);
				else if(s.equals("/"))	ops.push(s);
				else if(s.equals("%"))	ops.push(s);
				else if(s.equals(")")) {
				    while(!ops.peek().equals("(")) {
                        String op = ops.pop();
                        double v = vals.pop();
                        if (op.equals("+")) v = vals.pop() + v;
                        else if (op.equals("-")) v = vals.pop() - v;
                        else if (op.equals("*")) v = vals.pop() * v;
                        else if (op.equals("/")) v = vals.pop() / v;
                        else if (op.equals("%")) v = vals.pop() % v;
                        vals.push(v);
                    }
					ops.pop();
				}
				else	vals.push(Double.parseDouble(s));
			}
			textOut.setText(Double.toString(vals.pop()));
		}catch(Exception e) {
			textOut.setText("ERROR INPUT");
		}
	}
	// Event Listener on Button[#btnNum8].onAction
	@FXML
	public void Num8OnAction(ActionEvent event) {
		// TODO Autogenerated
		textIn.appendText("8");
	}
	// Event Listener on Button[#btnNum4].onAction
	@FXML
	public void Num4OnAction(ActionEvent event) {
		// TODO Autogenerated
		textIn.appendText("4");
	}
	// Event Listener on Button[#btnNum5].onAction
	@FXML
	public void Num5OnAction(ActionEvent event) {
		// TODO Autogenerated
		textIn.appendText("5");
	}
	// Event Listener on Button[#btnNum6].onAction
	@FXML
	public void Num6OnAction(ActionEvent event) {
		// TODO Autogenerated
		textIn.appendText("6");
	}
	// Event Listener on Button[#btnNum9].onAction
	@FXML
	public void Num9OnAction(ActionEvent event) {
		// TODO Autogenerated
		textIn.appendText("9");
	}
	// Event Listener on Button[#btnAdd].onAction
	@FXML
	public void AddOnAction(ActionEvent event) {
		// TODO Autogenerated
		textIn.appendText("+");
	}
	// Event Listener on Button[#btnDot].onAction
	@FXML
	public void DotOnAction(ActionEvent event) {
		// TODO Autogenerated
		textIn.appendText(".");
	}
	// Event Listener on Button[#btnTra].onAction
	@FXML
	public void TraOnAction(ActionEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on Button[#btnNum0].onAction
	@FXML
	public void Num0OnAction(ActionEvent event) {
		// TODO Autogenerated
		textIn.appendText("0");
	}
	// Event Listener on Button[#btnNum2].onAction
	@FXML
	public void Num2OnAction(ActionEvent event) {
		// TODO Autogenerated
		textIn.appendText("2");
	}
	// Event Listener on Button[#btnNum1].onAction
	@FXML
	public void Num1OnAction(ActionEvent event) {
		// TODO Autogenerated
		textIn.appendText("1");
	}
	// Event Listener on Button[#btnNum3].onAction
	@FXML
	public void Num3OnAction(ActionEvent event) {
		// TODO Autogenerated
		textIn.appendText("3");
	}
	// Event Listener on Button[#btnDiv].onAction
	@FXML
	public void DivOnAction(ActionEvent event) {
		// TODO Autogenerated
		textIn.appendText("/");
	}
	// Event Listener on Button[#btnRem].onAction
	@FXML
	public void RemOnAction(ActionEvent event) {
		// TODO Autogenerated
		textIn.appendText("%");
	}
	// Event Listener on Button[#btnMul].onAction
	@FXML
	public void MulOnAction(ActionEvent event) {
		// TODO Autogenerated
		textIn.appendText("*");
	}
	// Event Listener on Button[#btnSqr].onAction
	@FXML
	public void SqrOnAction(ActionEvent event) {
		// TODO Autogenerated
		try {
			textOut.setText(Double.toString(Math.sqrt(Double.parseDouble(textOut.getText()))));
		}catch(Exception e) {
			textOut.setText("ERROR INPUT");
		}
	}
	// Event Listener on Button[#btnNum7].onAction
	@FXML
	public void Num7OnAction(ActionEvent event) {
		// TODO Autogenerated
		textIn.appendText("7");
	}
	// Event Listener on Button[#btnRev].onAction
	@FXML
	public void RevOnAction(ActionEvent event) {
		// TODO Autogenerated
		try {
			textOut.setText(Double.toString(1/Double.parseDouble(textOut.getText())));
		}catch(Exception e) {
			textOut.setText("ERROR INPUT");
		}
	}
	// Event Listener on Button[#btnSub].onAction
	@FXML
	public void SubOnAction(ActionEvent event) {
		// TODO Autogenerated
		textIn.appendText("-");
	}
}