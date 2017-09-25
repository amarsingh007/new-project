package com.sdj;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Mainpage extends JFrame implements ActionListener{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Mainpage mp=new Mainpage();
      mp.setVisible(true);
		 mp.setTitle("MainPage");
		 mp.setSize(1500,1500);
	}
	JLabel xxx,ltitle;
	JButton mlogin,alogin;
	public Mainpage() {
		setLayout(new FlowLayout());
		ltitle=new JLabel("Main Page");
		xxx=new JLabel("Click On Your Choise");
		mlogin=new JButton("Member Login");
		alogin=new JButton("Admin Login");
		
		add(ltitle);
		add(xxx);
		add(mlogin);
		add(alogin);
		
		
		mlogin.addActionListener(this);
		alogin.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==mlogin)
		{
			
			
				 InfoPiracy IP=new InfoPiracy();
				 IP.setVisible(true);
				 IP.setTitle("Member Login");
				 IP.setSize(1500,1500);
				
			
		}
		else if(e.getSource()==alogin)
		{
				 AdminLogin al=new AdminLogin();
				 al.setVisible(true);
				 al.setTitle("Admin Login");
				 al.setSize(1500,1500);
		}
		
	}

}
