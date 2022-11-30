import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

class calculator extends JFrame implements ActionListener {
	
	static JFrame f;

    static JTextField l;

	String s0, s1, s2;

	
	calculator()
	{
		s0 = s1 = s2 = "";
	}

	// main function
	public static void main(String args[])
	{
		f = new JFrame("calculator");

		calculator c = new calculator();

		l = new JTextField(16);

		l.setEditable(false);

		JButton button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, addButton, subButton, divButton, multButton, be, equalButton, equalButton1;

		
		button0 = new JButton("0");
		button1 = new JButton("1");
		button2 = new JButton("2");
		button3 = new JButton("3");
		button4 = new JButton("4");
		button5 = new JButton("5");
		button6 = new JButton("6");
		button7 = new JButton("7");
		button8 = new JButton("8");
		button9 = new JButton("9");

		
		equalButton1 = new JButton("=");

		
		addButton = new JButton("+");
		subButton = new JButton("-");
		divButton = new JButton("/");
		multButton = new JButton("*");
		equalButton = new JButton("C");

		
		be = new JButton(".");

		// create a panel
		JPanel calcPanel = new JPanel();

		// add action listeners
		multButton.addActionListener(c);
		divButton.addActionListener(c);
		subButton.addActionListener(c);
		addButton.addActionListener(c);
		button9.addActionListener(c);
		button8.addActionListener(c);
		button7.addActionListener(c);
		button6.addActionListener(c);
		button5.addActionListener(c);
		button4.addActionListener(c);
		button3.addActionListener(c);
		button2.addActionListener(c);
		button1.addActionListener(c);
		button0.addActionListener(c);
		be.addActionListener(c);
		equalButton.addActionListener(c);
		equalButton1.addActionListener(c);

		
		calcPanel.add(l);
		calcPanel.add(addButton);
		calcPanel.add(button1);
		calcPanel.add(button2);
		calcPanel.add(button3);
		calcPanel.add(subButton);
		calcPanel.add(button4);
		calcPanel.add(button5);
		calcPanel.add(button6);
		calcPanel.add(multButton);
		calcPanel.add(button7);
		calcPanel.add(button8);
		calcPanel.add(button9);
		calcPanel.add(divButton);
		calcPanel.add(be);
		calcPanel.add(button0);
		calcPanel.add(equalButton);
		calcPanel.add(equalButton1);
		
		f.add(calcPanel);

		f.setSize(200, 220);
		f.show();
	}
	public void actionPerformed(ActionEvent e)
	{
		String s = e.getActionCommand();

		
		if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.') {
			
			if (!s1.equals(""))
				s2 = s2 + s;
			else
				s0 = s0 + s;

			
			l.setText(s0 + s1 + s2);
		}
		else if (s.charAt(0) == 'C') {
			
			s0 = s1 = s2 = "";

			l.setText(s0 + s1 + s2);
		}
		else if (s.charAt(0) == '=') {

			double te;

			if (s1.equals("+"))

				te = (Double.parseDouble(s0) + Double.parseDouble(s2));
			else if (s1.equals("-"))
				te = (Double.parseDouble(s0) - Double.parseDouble(s2));
			else if (s1.equals("/"))
				te = (Double.parseDouble(s0) / Double.parseDouble(s2));
			else
				te = (Double.parseDouble(s0) * Double.parseDouble(s2));

			
			l.setText(s0 + s1 + s2 + "=" + te);

			
			s0 = Double.toString(te);

			s1 = s2 = "";
		}
		else {
			
			if (s1.equals("") || s2.equals(""))
				s1 = s;
			
			else {
				double te;

				
				if (s1.equals("+"))
					te = (Double.parseDouble(s0) + Double.parseDouble(s2));
				else if (s1.equals("-"))
					te = (Double.parseDouble(s0) - Double.parseDouble(s2));
				else if (s1.equals("/"))
					te = (Double.parseDouble(s0) / Double.parseDouble(s2));
				else
					te = (Double.parseDouble(s0) * Double.parseDouble(s2));

				
				s0 = Double.toString(te);

				
				s1 = s;

				
				s2 = "";
			}

			
			l.setText(s0 + s1 + s2);
		}
	}
}
