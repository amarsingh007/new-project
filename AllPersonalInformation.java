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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class AllPersonalInformation extends JFrame implements ActionListener{
 JLabel lusername;
 JTextField tusername;
 JButton search,back;
 JComboBox type;
public AllPersonalInformation()
		 {
	setLayout(new FlowLayout());
    lusername=new JLabel("UserName Whose Information You Want To Search");
    tusername=new JTextField(25);
    type=new JComboBox();
    type.addItem("//Credit Card Information//");//1
    type.addItem("//FaceBook Information//");//2
    type.addItem("//Whatspp Information//");//3
    type.addItem("//Gmail Information//");//4
    type.addItem("//Yahoo Information//");//5
    type.addItem("//Rediffmail Information//");//6
   add(type);
    
    
    search=new JButton("Search");
    back=new JButton("Back");
    add(lusername);
    add(tusername);
    add(search);
    add(back);
   
    search.addActionListener(this);
    back.addActionListener(this);
}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	Connection con=null;
	Statement stmt=null;
	 String name=tusername.getText();
	 String type1=type.getSelectedItem().toString();
	
	 if(e.getSource()==search &&  type1=="//Credit Card Information//")
	{
		 
		
		try
		{
			String sql="select CreditCardNo,PinNo,UserName,BankName from infosecurity where UserName='"+name+"' ";
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
			
			System.out.println("amar singh");
		    int count=0;
			while(rs.next() )
			{
				//System.out.println(rs.getInt(1)+":"+rs.getString(2));
				dtm.insertRow(count, new Object[]{rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4)});
				
			}
			
			JScrollPane jsp=new JScrollPane(table);
			add(jsp);
			
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
		 }	


	
		 else if(type1=="//FaceBook Information//")
		 {
			 try
				{
					String sql="select FaceBookId,FaceBookPassword,UserName from infosecurity where UserName='"+name+"' ";
					con=DBConnection.getConnection();
					stmt=con.createStatement();
					ResultSet rs=stmt.executeQuery(sql);
					DefaultTableModel dtm=new DefaultTableModel() ;
					JTable table=new JTable(dtm);
					//dtm.addColumn("  Credit_Card     ");//1
					//dtm.addColumn("   Pin_No         ");//2
					//dtm.addColumn("  Whatspp_No      ");//3
					//dtm.addColumn(" Whatspp_Password ");//4
					dtm.addColumn("    FaceBook_Id   ");//5
					dtm.addColumn(" FaceBook_Password");//6
					//dtm.addColumn("    Gmail_Id      ");//7
					//dtm.addColumn("   Gmail_Password ");//8
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
						
					}
					
					JScrollPane jsp=new JScrollPane(table);
					add(jsp);
					
				}
				catch(SQLException ex)
				{
					ex.printStackTrace();
				}
		 }
		 
		 else if(type1=="//Whatspp Infrmation//")
		 {
			 try
				{
					String sql="select WhatsppNo,WhatsppPassword,UserName from infosecurity where UserName='"+name+"' ";
					con=DBConnection.getConnection();
					stmt=con.createStatement();
					ResultSet rs=stmt.executeQuery(sql);
					DefaultTableModel dtm=new DefaultTableModel() ;
					JTable table=new JTable(dtm);
					//dtm.addColumn("  Credit_Card     ");//1
					//dtm.addColumn("   Pin_No         ");//2
					dtm.addColumn("  Whatspp_No      ");//3
					dtm.addColumn(" Whatspp_Password ");//4
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
					//dtm.addColumn("   Bank_Name      ");//16
					
					
					int count=0;
					while(rs.next())
					{
						//System.out.println(rs.getInt(1)+":"+rs.getString(2));
						dtm.insertRow(count, new Object[]{rs.getString(1),rs.getString(2),rs.getString(3)});
					
					}
					
					JScrollPane jsp=new JScrollPane(table);
					add(jsp);
					
				}
				catch(SQLException ex)
				{
					ex.printStackTrace();
				}
			
}
		 else if(type1=="//Gmail Information//")
		 {
			 try
				{
					String sql="select GmailId,GmailPassword,UserName from infosecurity where UserName='"+name+"' ";
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
					
					}
					
					JScrollPane jsp=new JScrollPane(table);
					add(jsp);
					
				}
				catch(SQLException ex)
				{
					ex.printStackTrace();
				}
	}
		 else if(type1=="//Yahoo Information//")
		 {
			 try
				{
					String sql="select YahooId,YahooPassword,UserName from infosecurity where UserName='"+name+"' ";
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
					//dtm.addColumn("    Gmail_Id      ");//7
					//dtm.addColumn("   Gmail_Password ");//8
					dtm.addColumn("    Yahoo_Id      ");//9
					dtm.addColumn("  Yahoo_Password  ");//10
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
						
					}
					
					JScrollPane jsp=new JScrollPane(table);
					add(jsp);
					
				}
				catch(SQLException ex)
				{
					ex.printStackTrace();
				}
	}
		 else if(type1=="//Rediffmail Information//")
		 {
			 try
				{
					String sql="select RediffmailId,RediffmailPassword,UserName from infosecurity where UserName='"+name+"' ";
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
					//dtm.addColumn("    Gmail_Id      ");//7
					//dtm.addColumn("   Gmail_Password ");//8
					//dtm.addColumn("    Yahoo_Id      ");//9
					//dtm.addColumn("  Yahoo_Password  ");//10
					//dtm.addColumn("  Linkedine_Id    ");//11
					//dtm.addColumn("Linkedine_Password");//12
					//dtm.addColumn("  Pinterest_Id    ");//13
					//dtm.addColumn("Pinterest_Password");//14
					dtm.addColumn("  User_Name       ");//15
					//dtm.addColumn("   Bank_Name      ");//16
					dtm.addColumn("  Rediffmail_id     ");//17
					dtm.addColumn("  Rediffmail_Password");//18
					
					
					
					int count=0;
					while(rs.next())
					{
						//System.out.println(rs.getInt(1)+":"+rs.getString(2));
						dtm.insertRow(count, new Object[]{rs.getString(1),rs.getString(2),rs.getString(3)});
						
					}
					
					JScrollPane jsp=new JScrollPane(table);
					add(jsp);
					
				}
				catch(SQLException ex)
				{
					ex.printStackTrace();
				}
		 }
	

	else if(e.getSource()==back)
	{
		this.setVisible(false);
		InformationSecurity IS=new InformationSecurity();// object created for frame
		
		IS.setVisible(true);
		IS.setSize(500,500);
		IS.setTitle("InformationSecurity");
	}

}
}




 

