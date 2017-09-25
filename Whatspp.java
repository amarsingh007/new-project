package com.sdj;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Whatspp extends JFrame implements ActionListener {
	JLabel lFbid,lpass,linfoholder,title;
	JTextField tFbid,tinfoholder;
	JButton Save,All,Back;
	JPasswordField tpass;
	public Whatspp() {
		setLayout(new FlowLayout());
		title=new JLabel("//Whatspp Information//");
		linfoholder=new JLabel("Enter your name");
		tinfoholder=new JTextField(25);
		lFbid=new JLabel("Enter Whatspp ");
		tFbid=new JTextField(25);
		lpass=new JLabel("Password");
		tpass=new JPasswordField(25);
	
		Save=new JButton("save");
		All=new JButton("all");
		Back=new JButton("Back");
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
		Save.addActionListener(this);
		All.addActionListener(this);
		Back.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Connection con=null;
		Statement stmt=null;
		if(e.getSource()==Save)
		{
			try
			{   String name= tinfoholder.getText();
				String mbt=tFbid.getText();
				String  pass= tpass.getText();
			
				String sql="update  infosecurity set WhatsppNo='"+mbt+"',WhatsppPassword='"+pass+"' where UserName='"+name+"'";
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
				String sql="select WhatsppNo,WhatsppPassword,UserName from infosecurity";
				con=DBConnection.getConnection();
				stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery(sql);
				DefaultTableModel dtm=new DefaultTableModel() ;
				JTable table=new JTable(dtm);
				//dtm.addColumn("CreditCard");//1
				//dtm.addColumn("PinNo");//2
				dtm.addColumn("WhatsppNo");//3
				dtm.addColumn("WhatsppPassword");//4
				//dtm.addColumn("FaceBookId");//5
				//dtm.addColumn("FaceBookPassword");//6
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
				
				
				int count=0;
				while(rs.next())
				{
					//System.out.println(rs.getInt(1)+":"+rs.getString(2));
					dtm.insertRow(count, new Object[]{rs.getString(1),rs.getString(2),rs.getString(3)});
					count++;
				}
				
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
