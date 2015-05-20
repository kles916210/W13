import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Calculator extends JPanel implements ActionListener{
	public static final int HEIGHT=480;
	public static final int WIDTH=320;
	private GridBagLayout layout;
	private GridBagConstraints gbc;
	private JButton[] numButtons;
	private JButton[] countButtons;
	private JTextField field;
	private Insets insets;
	private double num1,num2,ans;
	private int op;
	private int [][] numConstraints=new int[][]{
			{0,5,2,1},
			{0,4,1,1},
			{1,4,1,1},
			{2,4,1,1},
			{0,3,1,1},
			{1,3,1,1},
			{2,3,1,1},
			{0,2,1,1,},
			{1,2,1,1},
			{2,2,1,1},
	};
	private int [][] countConstraints=new int[][]{
			{2,5,1,1},
			{3,4,1,2},
			{3,3,1,1},
			{3,2,1,1},
			{3,1,1,1},
			{2,1,1,1},
			{1,1,1,1},
			{0,1,1,1,},
			
	};
	public Calculator(){
		setPreferredSize(new Dimension(WIDTH,HEIGHT));
		layout = new GridBagLayout();
		layout.columnWidths = new int[] {80,80,80,80};
		layout.rowHeights = new int[] {80,80,80,80,80,80};
		setLayout(layout);
		gbc = new GridBagConstraints();
		numButtons=new JButton[10];
		for(int i=0;i<numButtons.length;i++){
			numButtons[i]=new JButton(""+i);
			numButtons[i].addActionListener(this);
			gbc.gridx=numConstraints[i][0];
			gbc.gridy=numConstraints[i][1];
			gbc.gridwidth=numConstraints[i][2];
			gbc.gridheight=numConstraints[i][3];
			gbc.fill=GridBagConstraints.BOTH;
			gbc.insets=new Insets(2,2,2,2);
			add(numButtons[i],gbc);
		}
		countButtons= new JButton[8];
		countButtons[0]=new JButton(".");
		countButtons[1]=new JButton("=");
		countButtons[2]=new JButton("+");
		countButtons[3]=new JButton("-");
		countButtons[4]=new JButton("*");
		countButtons[5]=new JButton("/");
		countButtons[6]=new JButton("+/-");
		countButtons[7]=new JButton("c");
		for(int j=0;j<countButtons.length;j++){
			countButtons[j].addActionListener(this);
			gbc.gridx=countConstraints[j][0];
			gbc.gridy=countConstraints[j][1];
			gbc.gridwidth=countConstraints[j][2];
			gbc.gridheight=countConstraints[j][3];
			gbc.fill=GridBagConstraints.BOTH;
			gbc.insets=new Insets(2,2,2,2);
			add(countButtons[j],gbc);
		}
		field = new JTextField();
		field.setEditable(false);
		field.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		field.setHorizontalAlignment(JTextField.RIGHT);
		field.setFont(new Font("Arial",Font.PLAIN,24));
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.gridwidth=4;
		gbc.gridheight=1;
		gbc.insets=new Insets(2,2,2,2);
		add(field,gbc);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i=0;i<numButtons.length;i++){
			if(e.getSource()==numButtons[i]){
				field.setText(field.getText()+i);
			}
		}
		if(e.getSource()==countButtons[0] && !field.getText().contains(".")){
			field.setText(field.getText()+".");
		}
		else if(e.getSource()==countButtons[1] ){
			num2 = Double.parseDouble(field.getText());
			if(op==1){
				ans = num1 + num2;
			}
			else if(op==2){
				ans = num1 - num2;
			}
			else if(op==3){
				ans = num1 * num2;
			}
			else if(op==4){
				ans = num1 / num2;
			}
			field.setText(""+ans);
		}
		else if(e.getSource()==countButtons[2] ){
			num1 = Double.parseDouble(field.getText());
			op=1;
			field.setText("");
		}
		else if(e.getSource()==countButtons[3] ){
			num1 = Double.parseDouble(field.getText());
			op=2;
			field.setText("");
		}
		else if(e.getSource()==countButtons[4] ){
			num1 = Double.parseDouble(field.getText());
			op=3;
			field.setText("");
		}
		else if(e.getSource()==countButtons[5] ){
			num1 = Double.parseDouble(field.getText());
			op=4;
			field.setText("");
		}
		
		else if(e.getSource()==countButtons[6] ){
			field.setText(""+(-1*Double.parseDouble(field.getText())));
		}
		else if(e.getSource()==countButtons[7]){
			field.setText("");
		}
		
	}


	public static void main(String[] args) {
		JFrame app=new JFrame("Calculator");
		app.add(new Calculator(),BorderLayout.CENTER);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setResizable(false);
		app.pack();
		app.setLocationRelativeTo(null);
		app.setVisible(true);

	}

}
