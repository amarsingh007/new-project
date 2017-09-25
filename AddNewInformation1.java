package com.sdj;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

public class AddNewInformation1 extends JFrame implements ActionListener {
	JButton Click;
	JComboBox type;

	public AddNewInformation1()
			 {
		
		setLayout(new FlowLayout());
		
		type=new JComboBox();
		type.addItem("SELECT INFORMATION TYPE");
		type.addItem("OFFICIAL");
		type.addItem("UNOFFICIAL");
		Click=new JButton("Click");

		add(type);
	
		add(Click);
		
		Click.addActionListener(this);
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		 
		Connection con=null;
		Statement stmt=null;
		if(e.getSource()==Click)
		{
			String mt=type.getSelectedItem().toString();
			if(mt=="OFFICIAL")
			{
			 
				OfficialInformation an=new OfficialInformation();//object created for Menuitem
				an.setVisible(true);
				an.setSize(500,500);
				an.setTitle("Official Information");
				
				
				}
			else if(mt=="UNOFFICIAL")
			{
				UnOfficialInformation an=new UnOfficialInformation();//object created for Menuitem
				an.setVisible(true);
				an.setSize(500,500);
				an.setTitle("Unofficial Information");
			}
			
		}
	}
	
	

}
