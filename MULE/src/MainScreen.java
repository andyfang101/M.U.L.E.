import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainScreen extends JFrame{
	JLabel title;
	JButton start;
	ImageIcon logo = new ImageIcon("logo.png");
	private static final int WIDTH = 580; //I used same dimensions as Wei for consistancy
	private static final int HEIGHT = 600; 
	
	public MainScreen(){
		title = new JLabel(logo);
		start = new JButton("Start Game");
		start.addActionListener(new ButtonListener());
		
		setTitle("M.U.L.E.");
    	getContentPane().setBackground(Color.white);
        setSize(WIDTH, HEIGHT);
        setVisible(true);
        

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(title, BorderLayout.NORTH);
        getContentPane().add(start, BorderLayout.SOUTH);

	}
	
	public class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			initial settings = new initial();
		}
	}
	
	public static void main(String[] args){
		MainScreen main = new MainScreen();
	}
}
