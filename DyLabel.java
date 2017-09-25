package com.sdj;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DyLabel extends JFrame implements ActionListener{
		
	JLabel x;//z1;
	JTextField y;//,z2;
	JButton z;
	public DyLabel() {
		setLayout(new FlowLayout());
		x=new JLabel("Enter Column Name");
		y=new JTextField(25);
		//z1=new JLabel("Enter user name");
		//z2=new JTextField(25);
		z=new JButton("Include");
		add(x);
		add(y);
		//add(z1);
		//add(z2);
		add(z);
		z.addActionListener(this);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Connection con=null;
		Statement stmt=null;
		
		if(e.getSource()==z)
		{
			String st=y.getText();
			//String st2=z2.getText();
			try
			{   
				
				String sql="alter table  infosecurity  add "+st+" varchar(25) " ; //where UserName='"+st2+"' ";
					
				System.out.println(sql);
				con=DBConnection.getConnection();
				stmt=con.createStatement();
				stmt.executeUpdate(sql);
			
				}
			catch(SQLException ex)
			{
				ex.printStackTrace();
			}
			
		}
		
			
	}
	
	}

	

	


