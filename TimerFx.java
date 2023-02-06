package courseproject;
import java.awt.EventQueue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;
import java.text.*;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JEditorPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class TimerFx implements ActionListener{
private JFrame jf;
JRadioButton radio1,radio2,radio3;
String operation;
private JLabel lblNewLabel_2;
private JLabel lblNewLabel_3;
private JTextField textField;
private JTextField textField_1;
private JTextField textField_2;
private JButton btnNewButton;
public static void main(String[] args){
EventQueue.invokeLater(new Runnable(){
public void run(){
try{
TimerFx window=new TimerFx();
window.jf.setVisible(true);
}catch(Exception e){
e.printStackTrace();
}
}
});
}
public TimerFx(){
initialize();
}
private void initialize(){
jf=new JFrame();
jf.setTitle("Course Project");
jf.setBounds(100, 100, 1187, 728);
jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
jf.getContentPane().setLayout(null);

JLabel lblNewLabel=new JLabel("Operations");
lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
lblNewLabel.setBounds(285, 77, 88, 23);
jf.getContentPane().add(lblNewLabel);

radio1 = new JRadioButton("Shutdown");
radio1.setFont(new Font("Tahoma", Font.BOLD, 14));
radio1.setHorizontalAlignment(SwingConstants.CENTER);
radio1.setBounds(403, 77, 111, 23);
jf.getContentPane().add(radio1);

radio2=new JRadioButton("sleep");
radio2.setFont(new Font("Tahoma", Font.BOLD, 14));
radio2.setHorizontalAlignment(SwingConstants.CENTER);
radio2.setBounds(385,123,111,23);
jf.getContentPane().add(radio2);

radio3=new JRadioButton("Restart");
radio3.setFont(new Font("Tahoma", Font.BOLD, 14));
radio3.setBounds(403,171,111,23);
jf.getContentPane().add(radio3);

ButtonGroup bg=new ButtonGroup();
bg.add(radio1);
bg.add(radio2);
bg.add(radio3);
JLabel lblNewLabel_1 = new JLabel("HOURS");
lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
lblNewLabel_1.setBounds(391, 313, 105, -70);
jf.getContentPane().add(lblNewLabel_1);
JLabel lblHours = new JLabel("HOURS");
lblHours.setFont(new Font("Tahoma", Font.BOLD, 15));
lblHours.setHorizontalAlignment(SwingConstants.CENTER);
lblHours.setBounds(284, 269, 105, 32);
jf.getContentPane().add(lblHours);
lblNewLabel_2 = new JLabel("MINUTES");
lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
lblNewLabel_2.setBounds(403, 274, 111, 23);
jf.getContentPane().add(lblNewLabel_2);
lblNewLabel_3 = new JLabel("SECONDS");
lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
lblNewLabel_3.setBounds(524, 269, 104, 32);
jf.getContentPane().add(lblNewLabel_3);
textField = new JTextField();
textField.setBounds(294, 313, 96, 32);
jf.getContentPane().add(textField);
textField.setColumns(10);
textField_1 = new JTextField();
textField_1.setBounds(418, 313, 96, 32);
jf.getContentPane().add(textField_1);
textField_1.setColumns(10);
textField_2 = new JTextField();
textField_2.setBounds(544, 316, 96, 32);
jf.getContentPane().add(textField_2);
textField_2.setColumns(10);
btnNewButton = new JButton("START");
btnNewButton.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		int hour= Integer.parseInt(textField.getText());
		int min= Integer.parseInt(textField_1.getText());
		int sec= Integer.parseInt(textField_2.getText());
		Runtime runtime = Runtime.getRuntime();
		int time= ((hour*3600)+(min*60)+sec);
		
		for(int i=time;i>=0;i--) {
			try {
				Thread.sleep(1000);
				if(i==10 && radio1.isSelected())
				{
					JOptionPane.showMessageDialog(jf, " SYSTEM SHUT DOWN IN 10 SECONDS ");
				}
				if(i==10 && radio2.isSelected())
				{
					JOptionPane.showMessageDialog(jf, " SYSTEM SLEEPS IN 10 SECONDS ");
				}
				if(i==10 && radio3.isSelected())
				{
					JOptionPane.showMessageDialog(jf, " SYSTEM RESTARTS IN 10 SECONDS ");
				}
				
				
				if(i==0 && radio1.isSelected())
				{
					try {runtime.exec("shutdown -s -t ");} catch(IOException ie) {ie.printStackTrace();}
				}
				if(i==0 && radio2.isSelected())
				{
					try {runtime.exec("rundll32.exe powrprof.dll,SetSuspendState 0,1,0");} catch(IOException ie) {ie.printStackTrace();}
				}
				if(i==0 && radio3.isSelected())
				{
					try {runtime.exec("shutdown -r -t 5 ");} catch(IOException ie) {ie.printStackTrace();}
				}
			} catch (InterruptedException e1) {
				
				e1.printStackTrace();
			}
		}
	}
});
btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
btnNewButton.setBounds(417, 431, 111, 54);
jf.getContentPane().add(btnNewButton);
}
public void actionPerformed(ActionEvent e) {
if(radio1.isSelected())
operation = "Shutdown";
else if(radio2.isSelected())
operation= "sleep";
else if(radio3.isSelected())
operation="Restart";
else
JOptionPane.showMessageDialog(jf, "Please select at least one option");
return;
}
}

 




		