package com.sdj;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Regist extends JFrame implements ActionListener{
	
	JLabel lfullname,lphoneoremail,lBirthday,lpass,ltitle;
	JRadioButton male,female;
	JPasswordField tNewpass;
	JTextField tfullname,tphoneoremail,tGender,tBirthday;
	JButton signup,txt;
	ButtonGroup bg;
	
	public Regist()
	{
		setLayout(new FlowLayout());
		ltitle=new JLabel("Create New Account");
		
		lfullname=new JLabel("Full Name");
		tfullname=new JTextField(25);
		
		/*male=new JRadioButton("Male");
		female=new JRadioButton("Female");
		bg.add(male);
		bg.add(female);
		add(male);
		add(female);
		*/
		lphoneoremail=new JLabel("Phone or Email");
		tphoneoremail=new JTextField(25);
		
		
		lBirthday=new JLabel("Date Of Birth");
		tBirthday=new JTextField(25);
		
		
		lpass=new JLabel("New Password");
		tNewpass=new JPasswordField();
		
		
		signup=new JButton("Sign Up");
		
		
		txt=new JButton("Already have an account");
		
		/*
		 * ltitle.setBounds(550, -180, 700, 500);
		lname.setBounds(300, 100, 150, 50);
		tname.setBounds(450, 115, 150, 25);
		lpwd.setBounds(300, 150, 150, 50);
		tpwd.setBounds(450, 165, 150, 25);
		login.setBounds(300, 200, 80, 30);
		registration.setBounds(400, 200, 80, 30);
		clear.setBounds(600, 200, 80, 30);
		exit.setBounds(700, 200, 80, 30);
		
		  */
		setLayout(null);
		
		ltitle.setBounds(550, -180, 700, 500);
		lfullname.setBounds(300, 100, 150, 50);
		tfullname.setBounds(450, 115, 150, 25);
		lphoneoremail.setBounds(300, 150, 150, 50);
		tphoneoremail.setBounds(450, 165, 150, 25);
		lBirthday.setBounds(300, 200, 150, 50);
		tBirthday.setBounds(450, 215, 150, 25);
		lpass.setBounds(300, 250, 150, 50);
		tNewpass.setBounds(450, 265, 150, 25);
		signup.setBounds(600, 250, 80, 30);
		txt.setBounds(700,250, 200, 30);
		
		add(ltitle);
		add(lfullname);
		add(tfullname);
		add(lphoneoremail);
		add(tphoneoremail);
		add(lBirthday);
		add(tBirthday);
		add(lpass);
		add(tNewpass);
		add(signup);
		add(txt);
	   signup.addActionListener(this);
	   txt.addActionListener(this);
	   
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Connection con=null;
		Statement stmt=null;
		if(e.getSource()==signup)
		{
			try
			{  
				String fullname= tfullname.getText();
				String phoneoremail= tphoneoremail.getText();
				String Birthday= tBirthday.getText();
				String Newpass= tNewpass.getText();
				
				
				String sql="insert into logininfo(username,password,DOB,phoneoremail) values('"+fullname+"','"+Newpass+"','"+Birthday+"','"+phoneoremail+"')";
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
		

	
		else if(e.getSource()==txt)
		{
			InfoPiracy IP=new InfoPiracy ();
			IP.setVisible(true);
			IP.setSize(500,500);
			IP.setTitle("InformationSecurity");
		}
	}
}


