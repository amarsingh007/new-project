package com.sdj;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.sql.Connection;
import java.sql.Statement;

public class LoginPage extends JFrame implements ActionListener {


	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LoginPage login=new LoginPage();
		login.setVisible(true);
		login.setTitle("LoginPage");
		login.setSize(1500,1500);
		
	}
	JLabel lname,lpwd,ltitle;
	JTextField tname;
	JPasswordField tpwd;
	JButton login,clear,exit;
	public LoginPage()
	{
		lname=new JLabel("Enter the name");
		lpwd=new JLabel("Enter the password");
		ltitle=new JLabel("Hospital Management System");
		tname=new JTextField(25);
		tpwd=new JPasswordField(25);
		login=new JButton("Login");
		clear=new JButton("Clear");
		exit=new JButton("Exit");
		//FlowLayout f1=new FlowLayout();
		setLayout(null);
		ltitle.setBounds(550, -180, 700, 500);
		lname.setBounds(300, 100, 150, 50);
		tname.setBounds(450, 115, 150, 25);
		lpwd.setBounds(300, 150, 150, 50);
		tpwd.setBounds(450, 165, 150, 25);
		login.setBounds(300, 200, 80, 30);
		clear.setBounds(400, 200, 80, 30);
		exit.setBounds(500, 200, 80, 30);
		
		add(ltitle);
		add(lname);
		add(lpwd);
		add(tname);
		add(tpwd);
		add(login);
		add(clear);
		add(exit);
		login.addActionListener(this);
		clear.addActionListener(this);
		exit.addActionListener(this);
		
		
				
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==clear)
		{
			tname.setText("");
			tpwd.setText("");
		}
		if(e.getSource()==exit)
		{
			this.setVisible(false);
		}
		if(e.getSource()==login)
		{
			Connection con=null;
			Statement stmt=null;
			try
			{
				
				
				String uname=tname.getText();
				String upwd=tpwd.getText();
				String sql="select *from logininfo where username='"+uname+"' and password='"+upwd+"'";
				System.out.println(sql);
				con=DBConnection.getConnection();
				stmt=con.createStatement();
				
				ResultSet rs=stmt.executeQuery(sql);
				if(rs.next())
				{
					//jd.show();
					String msg="Login success";
					JOptionPane.showMessageDialog(null, msg);
					this.setVisible(false);
					Medicine md=new Medicine();// object created for frame
					
					md.setVisible(true);
				    md.setSize(500,500);
				    md.setTitle("Medicine");
				  //  md.setDefaultCloseOperation(EXIT_ON_CLOSE);
					
				}
				else
				{
					String msg="Login Unsuccess";
					JOptionPane.showConfirmDialog(null, msg);
					this.setVisible(false);
					LoginPage login=new LoginPage();
					login.setVisible(true);
					login.setTitle("LoginPage");
					login.setSize(1500,1500);
					
					
					
				}
		
			}
			catch(SQLException ex)
			{
				ex.printStackTrace();
			}
		}
}
	}
