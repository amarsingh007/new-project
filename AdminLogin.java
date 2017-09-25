package com.sdj;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class AdminLogin extends JFrame implements ActionListener {
		JLabel ladmin,ltitle,lpass;
		JTextField tadmin;
		JPasswordField jppass;
		JButton adminlogin;
		
		public AdminLogin()
			{
			setLayout(new FlowLayout());
			ltitle=new JLabel("Admin Panel");
			ladmin=new JLabel("Admin");
			tadmin=new JTextField();
			
			lpass=new JLabel("Admin Password");
			jppass=new JPasswordField(25);
		
			adminlogin=new JButton("Admin Sign Up ");
			add(ltitle);
			add(ladmin);
			add(tadmin);
			add(jppass);
			add(lpass);
			add(adminlogin);
			setLayout(null);
			ltitle.setBounds(550, -180, 700, 500);
			ladmin.setBounds(300, 100, 150, 50);
			tadmin.setBounds(450, 115, 175, 25);
			lpass.setBounds(300, 150, 150, 50);
			jppass.setBounds(450, 165, 175, 25);
			adminlogin.setBounds(300, 200,175, 30);
			adminlogin.addActionListener(this);
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			Connection con=null;
			Statement stmt=null;
			
			String name= tadmin.getText();
			String pass=jppass.getText();
		/*	try {
				String passwordEnc= AESencrp.encrypt(pass);
				String passwordDec = AESencrp.decrypt(passwordEnc);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}*/
			
			
		
			if(e.getSource()==adminlogin)
			{
				try
				{
					
					
			String sql="select  * from adminlogin where admin='"+name+"' and password= '"+pass+"'";
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
				DyLabel IS=new DyLabel();// object created for frame
				
				IS.setVisible(true);
				IS.setSize(500,500);
				IS.setTitle("Label CReation");
			  //  md.setDefaultCloseOperation(EXIT_ON_CLOSE);
				
			}
			else
			{
				String msg="Login Unsuccess";
				JOptionPane.showConfirmDialog(null, msg);
				this.setVisible(false);
				AdminLogin login=new AdminLogin();
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