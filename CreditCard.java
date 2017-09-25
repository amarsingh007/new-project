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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class CreditCard extends JFrame  implements ActionListener{
	JLabel lccno,linfoholder,lpass,title;
	JTextField tccno,tinfoholder;
	JButton Save,All,Back;
	JComboBox mtype;
	JPasswordField tpass;
	
		public CreditCard()
	    {
			setLayout(new FlowLayout());
			title=new JLabel("//Credit Card Infrmation//");
			linfoholder=new JLabel("Enter your name");
			tinfoholder=new JTextField(25);
			lccno=new JLabel("Enter Credit Card No");
			tccno=new JTextField(25);
			lpass=new JLabel("PinNo");
			tpass=new JPasswordField(25);
			mtype=new JComboBox();
			Save=new JButton("save");
			All=new JButton("all");
			Back=new JButton("Back");
			mtype.addItem("--select bank  type --");
			mtype.addItem("SBI BANK");
			mtype.addItem("SBBJ BANK");
			mtype.addItem("PNB BANK");
			mtype.addItem("RMGB BANK");
			mtype.addItem("AXIS BANK");
			mtype.addItem("ICICI BANK");
			add(title);
			add(linfoholder);
			add(tinfoholder);
			add(lccno);
			add(tccno);
			add(lpass);
			add(tpass);
			
			
			
			add(mtype);
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
			String name= tinfoholder.getText();
			if(e.getSource()==Save)
			{
				
				try
				{   
					int mbt=Integer.parseInt(tccno.getText());
					int  pass= Integer.parseInt(tpass.getText());
					String mt=mtype.getSelectedItem().toString();
					String sql="insert into infosecurity(UserName,BankName,CreditCardNo,PinNo) values('"+name+"','"+mt+"','"+mbt+"','"+pass+"')";
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
					String sql="select CreditCardNo,PinNo,UserName,BankName from infosecurity where UserName= '"+name+"'";
					con=DBConnection.getConnection();
					stmt=con.createStatement();
					ResultSet rs=stmt.executeQuery(sql);
					DefaultTableModel dtm=new DefaultTableModel() ;
					JTable table=new JTable(dtm);
					dtm.addColumn("  Credit_Card     ");//1
					dtm.addColumn("   Pin_No         ");//2
					//dtm.addColumn("  Whatspp_No      ");//3
					//dtm.addColumn(" Whatspp_Password ");//4
					//dtm.addColumn("    FaceBook_Id   ");//5
					//dtm.addColumn(" FaceBook_Password");//6
					//dtm.addColumn("    Gmail_Id      ");//7
					//dtm.addColumn("   Gmail_Password ");//8
					//dtm.addColumn("    Yahoo_Id      ");//9
					//dtm.addColumn("  Yahoo_Password  ");//10
					//dtm.addColumn("  Linkedine_Id    ");//11
					//dtm.addColumn("Linkedine_Password");//12
					//dtm.addColumn("  Pinterest_Id    ");//13
					//dtm.addColumn("Pinterest_Password");//14
					dtm.addColumn("  User_Name       ");//15
					dtm.addColumn("   Bank_Name      ");//16
					if(rs.next())
					{
						
					
					System.out.println(rs.getInt(1)+":"+rs.getString(2));
					dtm.insertRow(0, new Object[]{rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4)});
					}
					/*int count=0;
					while(rs.next())
					{
						//System.out.println(rs.getInt(1)+":"+rs.getString(2));
						dtm.insertRow(count, new Object[]{rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4)});
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
				AddNewInformation1 ann=new AddNewInformation1();//object created for Menuitem
				ann.setVisible(true);
				ann.setSize(500,500);
				ann.setTitle("CreditCard Information");
			}
}
}
