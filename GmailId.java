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

public class GmailId extends JFrame implements ActionListener{
	JLabel lgmail,lpass,linfoholder,title;
	JTextField tgmail,tinfoholder;
	JButton Save,All,Back;
	JPasswordField tpass;
public GmailId() {
	setLayout(new FlowLayout());
	
	title=new JLabel("//Gmail Information//");
	linfoholder=new JLabel("Enter You Name");
	lgmail=new JLabel("GmailId");
	lpass=new JLabel("GmailPassword");
	
	tinfoholder=new JTextField(25);
	tgmail=new JTextField(25);
	tpass=new JPasswordField(25);
	
	Save=new JButton("Save");
	All=new JButton("All");
	Back=new JButton("Back");
	add(title);
	add(linfoholder);
	add(tinfoholder);
	
	add(lgmail);
	add(lpass);
	add(tgmail);
	add(tpass);
	add(Save);
	add(All);
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
		{   String gmail= tgmail.getText();
		    String pass=tpass.getText();
			String name=tinfoholder.getText();
			
			
			String sql="update  infosecurity set GmailId='"+gmail+"',GmailPassword='"+pass+"' where UserName='"+name+"'";
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
			String sql="select GmailId,GmailPassword,UserName from infosecurity";
			con=DBConnection.getConnection();
			stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			DefaultTableModel dtm=new DefaultTableModel() ;
			JTable table=new JTable(dtm);
			//dtm.addColumn("  Credit_Card     ");//1
			//dtm.addColumn("   Pin_No         ");//2
			//dtm.addColumn("  Whatspp_No      ");//3
			//dtm.addColumn(" Whatspp_Password ");//4
			//dtm.addColumn("    FaceBook_Id   ");//5
			//dtm.addColumn(" FaceBook_Password");//6
			dtm.addColumn("    Gmail_Id      ");//7
			dtm.addColumn("   Gmail_Password ");//8
			//dtm.addColumn("    Yahoo_Id      ");//9
			//dtm.addColumn("  Yahoo_Password  ");//10
			//dtm.addColumn("  Linkedine_Id    ");//11
			//dtm.addColumn("Linkedine_Password");//12
			//dtm.addColumn("  Pinterest_Id    ");//13
			//dtm.addColumn("Pinterest_Password");//14
			dtm.addColumn("  User_Name       ");//15
			//dtm.addColumn("   Bank_Name      ");//16
			
			
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


