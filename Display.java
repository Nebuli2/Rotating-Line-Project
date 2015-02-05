import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Display {
	
	Timer timer;
	JButton button1;
	NewPanel panel1;
	
	public Display(){
		JFrame frame=new JFrame();
		
		panel1 = new NewPanel();
		panel1.setPreferredSize(new Dimension(500,500));
		panel1.setBackground(Color.WHITE);
		
		ActionListener action1 = new ActionListener(){
			public void actionPerformed(ActionEvent b){
				panel1.updateUI();
				panel1.rotate();
			}
		};
		timer = new Timer(10,action1);
		
		
		
		JPanel panel2 = new JPanel(new FlowLayout());
		button1 = new JButton("Start");
		ActionListener action2 = new ActionListener(){
			public void actionPerformed(ActionEvent a){
				if(timer.isRunning()){
					timer.stop();
					button1.setText("Start");
				}
				else{
					timer.start();
					button1.setText("Stop");
				}
			}
		};
		button1.addActionListener(action2);
		
		panel2.add(button1);
		frame.setLayout(new BorderLayout());
		frame.add(panel1, BorderLayout.CENTER);
		frame.add(panel2, BorderLayout.SOUTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void update(){
		
	}
	
	public static void main(String[] args){
		Display a = new Display();
	}
}

