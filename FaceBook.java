package com.sdj;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class FaceBook extends JFrame implements ActionListener{
	JLabel lFbid,lpass,linfoholder,title;
	JTextField tFbid,tinfoholder;
	JButton Save,All,Back,confirm;
	JPasswordField tpass;
	
	public FaceBook() {
		setLayout(new FlowLayout());
		title=new JLabel("//FaceBook Information//");
		linfoholder=new JLabel("Enter your name");
		tinfoholder=new JTextField(25);
		lFbid=new JLabel("Enter FaceBook Id");
		tFbid=new JTextField(25);
		lpass=new JLabel("Password");
		tpass=new JPasswordField(25);
	
		Save=new JButton("save");
		All=new JButton("all");
		Back=new JButton("Back");
		confirm=new JButton("Confirm");
		
		add(title);
		add(linfoholder);
		add(tinfoholder);
		add(lFbid);
		add(tFbid);
		add(lpass);
		add(tpass);
		
		
		add(All);
		add(Save);
		add(Back);
		add(confirm);
		
		
		confirm.addActionListener(this);
		Save.addActionListener(this);
		All.addActionListener(this);
	    Back.addActionListener(this);
	    
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Connection con=null;
		Statement stmt=null;
		String name= tinfoholder.getText();
		

		if(e.getSource()==confirm)
		{
			try
			{
				//String name= tinfoholder.getText();
				String mbt=tFbid.getText();
				String  pass= tpass.getText();
				String sql="select  * from infosecurity where UserName='"+name+"' ";
				System.out.println(sql);
				con=DBConnection.getConnection();
				stmt=con.createStatement();

				ResultSet rs=stmt.executeQuery(sql);
				if(rs.next())
				{
					
					//jd.show();
					String msg="Granted Permission  for add information about FaceBook";
					JOptionPane.showMessageDialog(null, msg);
					this.setVisible(true);
					/*
					 * UnOfficialInformation an=new UnOfficialInformation();//object created for Menuitem
					an.setVisible(true);
					an.setSize(500,500);
					an.setTitle("CreditCard Information");
				  //  md.setDefaultCloseOperation(EXIT_ON_CLOSE);
					*/
				}
				else
				{
					String msg="You can't add other things without adding information about Credit Card Information Because every Person have ATM Card";
					JOptionPane.showConfirmDialog(null, msg);
					this.setVisible(false);
					CreditCard an=new CreditCard();//object created for Menuitem
					an.setVisible(true);
					an.setSize(500,500);
					an.setTitle("CreditCard Information");
					this.setVisible(false);
					
					
					
				}
		
			}
			catch(SQLException ex)
			{
				ex.printStackTrace();
			}
		
		}
		else if(e.getSource()==Save)
		{
			
	
			try
			{  
				String msg="if you did't click on CONFIRM button then first of all you have to go on that button";
				JOptionPane.showMessageDialog(null, msg);
				this.setVisible(true);
		

				//String name= tinfoholder.getText();
				String mbt=tFbid.getText();
				String  pass= tpass.getText();
			
				String sql="update  infosecurity set FaceBookId='"+mbt+"',FaceBookPassword='"+pass+"' where UserName='"+name+"'";
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
		else if(e.getSource()==All)
		{
			try
			{
				

				String sql="select FaceBookId,FaceBookPassword,UserName from infosecurity where UserName='"+name+"'";
				con=DBConnection.getConnection();
				stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery(sql);
				DefaultTableModel dtm=new DefaultTableModel() ;
				JTable table=new JTable(dtm);
				//dtm.addColumn("CreditCard");//1
				//dtm.addColumn("PinNo");//2
				//dtm.addColumn("WhatsppNo");//3
				//dtm.addColumn("WhatsppPassword");//4
				dtm.addColumn("FaceBookId");//5
				dtm.addColumn("FaceBookPassword");//6
				//dtm.addColumn("GmailId");//7
				//dtm.addColumn("GmailPassword");//8
				//dtm.addColumn("YahooId");//9
				//dtm.addColumn("YahooPassword");//10
				//dtm.addColumn("LinkedineId");//11
				//dtm.addColumn("LinkedinePassword");//12
				//dtm.addColumn("PinterestId");//13
				//dtm.addColumn("PinterestPassword");//14
				dtm.addColumn("UserName");//15
				//dtm.addColumn("BankName");//16
				
				if(rs.next())
				{
					
				
				//System.out.println(rs.getInt(1)+":"+rs.getString(2));
				dtm.insertRow(0, new Object[]{rs.getString(1),rs.getString(2),rs.getString(3)});
				}
				
				/*
				int count=0;
				while(rs.next())
				{
					//System.out.println(rs.getInt(1)+":"+rs.getString(2));
					dtm.insertRow(count, new Object[]{rs.getString(1),rs.getString(2),rs.getString(3)});
					count++;
				}*/
				
				JScrollPane jsp=new JScrollPane(table);
				add(jsp);
				
			}
			catch(SQLException ex)
			{
				ex.printStackTrace();
			}
				
				
	}
		

		else
		{
			this.setVisible(false);
			AddNewInformation1 IS=new AddNewInformation1 ();// object created for frame
			
			IS.setVisible(true);
			IS.setSize(500,500);
			IS.setTitle("Add New Information ");
		}
		}
	}

