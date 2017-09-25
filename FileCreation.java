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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetMetaData;

public class FileCreation  extends JFrame implements ActionListener
{
	JLabel lfilename,title,luser,lb;
	JTextField tfilename,tuser,text;
	JButton file,updatefile;
	
public FileCreation()  {
		setLayout(new FlowLayout());
		title=new JLabel("//Backup Plan//");
		lfilename=new JLabel("Enter File Name  In which You Want to Store");
		tfilename=new JTextField(25);
		luser=new JLabel("Enter UserName Whose information you want to store");
		tuser=new  JTextField(25);
		lb=new JLabel("Enter which column added in database");
		text=new JTextField(25);
		 
		file=new JButton("File Creation");
		updatefile=new JButton("New Label Consideration");
		add(title);
		add(lfilename);
		add(tfilename);
		add(luser);
		add(tuser);
		add(file);
		add(lb);
		add(text);
		add(updatefile);
		file.addActionListener(this);
		updatefile.addActionListener(this);
		
	}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	 if(e.getSource()==file)
	{
		File f1=null;
		FileWriter fw=null;
		Connection con=null;
		Statement stmt=null;
		try
		{
			String username=tuser.getText();
            String name=tfilename.getText();
			String sql="select * from infosecurity where UserName='"+username+"'";
			con=DBConnection.getConnection();
			stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			
			
			//DefaultTableModel dtm=new DefaultTableModel() ;
			//JTable table=new JTable(dtm);
			//dtm.addColumn("CreditCard");//1
			//dtm.addColumn("PinNo");//2
			//dtm.addColumn("WhatsppNo");//3
			//dtm.addColumn("WhatsppPassword");//4
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
			//dtm.addColumn("UserName");//15
			//dtm.addColumn("BankName");//16
			
			 
			
			/*
			
			 count=0;
			while(rs.next())
			{
				//System.out.println(rs.getInt(1)+":"+rs.getString(2));
				//dtm.insertRow(count, new Object[]{rs.getString(1),rs.getString(2),rs.getString(3)});
				count++;
			}
			*/
			
			//JScrollPane jsp=new JScrollPane(table);
			//add(jsp);
			//FileWriter fw=new FileWriter("D:\\sample.txt");
			f1=new File("D:\\"+name);
			fw=new FileWriter(f1);
			//Scanner sc=new Scanner(System.in);
			//System.out.println("enter website name");
			//String sname=sc.next();
			String st3,st4,st5,st6,st7,st8,st9,st10,st11,st12,st13,st14,st15,st16,st17,st18;
			int st1,st2;
			int count=0 ;
			while(rs.next())
			{
			 st1=rs.getInt(1);
			 st2=rs.getInt(2);
			 st3=rs.getString(3);
			 st4=rs.getString(4);
			 st5=rs.getString(5);
			 st6=rs.getString(6);
			 st7=rs.getString(7);
			 st8=rs.getString(8);
			 st9=rs.getString(9);
			 st10=rs.getString(10);
			 st11=rs.getString(11);
			 st12=rs.getString(12);
			 st13=rs.getString(13);
			 st14=rs.getString(14);
			 st15=rs.getString(15);
			 st16=rs.getString(16);
			
			 
			 fw.write("CreditCardNo:"+st1+" ");
			 fw.write("PinNo:"+st2+" ");
			 fw.write("WhatsppNo:"+st3+" ");
			 fw.write("WhatsppPassword:"+st4+" ");
			 fw.write("FaceBookId:"+st5+" ");
			 fw.write("FaceBookPassword:"+st6+" ");
			 fw.write("GmailId:"+st7+" ");
			 fw.write("GmailPassword:"+st8+" ");
			 fw.write("YahooId:"+st9+" ");
			 fw.write("YahooPassword:"+st10+" ");
			 fw.write("LinkedineId:"+st11+" ");
			 fw.write("LinkedinePassword:"+st12+" ");
			 fw.write("PinterestId:"+st13+" ");
			 fw.write("PinterestPassword:"+st14+" ");
			 fw.write("UserName:"+st15+" ");
			 fw.write("BankName:"+st16+" |complete| "+" ___________Next USER's Information=>__________");
			
			 
			 
			 
			
			 
			}
			
			System.out.println("Before flush and close length of file:"+f1.length());
			
			
			
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
			
		catch(IOException ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			try
			{
				if(fw!=null)
				{
					fw.flush();
					fw.close();
				}
			}
			catch(IOException ex)
			{
				ex.printStackTrace();
			}
			System.out.println("After flush and close lengthof file:"+f1.length());
		}
			
		}
	
	 else if(e.getSource()==updatefile )
	 {
		
		 
		 
		 
		    File f1=null;
			FileWriter fw=null;
			Connection con=null;
			Statement stmt=null;
			try
			{
				
				String username=tuser.getText();
				String ttext=text.getText();
	            String name=tfilename.getText();
				String sql="select * from infosecurity where UserName='"+username+"'";
				con=DBConnection.getConnection();
				stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery(sql);
				
				
				//DefaultTableModel dtm=new DefaultTableModel() ;
				//JTable table=new JTable(dtm);
				//dtm.addColumn("CreditCard");//1
				//dtm.addColumn("PinNo");//2
				//dtm.addColumn("WhatsppNo");//3
				//dtm.addColumn("WhatsppPassword");//4
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
				//dtm.addColumn("UserName");//15
				//dtm.addColumn("BankName");//16
				
				 
				
				/*
				
				 count=0;
				while(rs.next())
				{
					//System.out.println(rs.getInt(1)+":"+rs.getString(2));
					//dtm.insertRow(count, new Object[]{rs.getString(1),rs.getString(2),rs.getString(3)});
					count++;
				}
				*/
				
				//JScrollPane jsp=new JScrollPane(table);
				//add(jsp);
				//FileWriter fw=new FileWriter("D:\\sample.txt");
				f1=new File("D:\\"+name);
				fw=new FileWriter(f1);
				//Scanner sc=new Scanner(System.in);
				//System.out.println("enter website name");
				//String sname=sc.next();
				String st3,st4,st5,st6,st7,st8,st9,st10,st11,st12,st13,st14,st15,st16,st17,st18,st19,st20;
				int st1,st2;
				int count=0 ;
				while(rs.next())
				{
				 st1=rs.getInt(1);
				 st2=rs.getInt(2);
				 st3=rs.getString(3);
				 st4=rs.getString(4);
				 st5=rs.getString(5);
				 st6=rs.getString(6);
				 st7=rs.getString(7);
				 st8=rs.getString(8);
				 st9=rs.getString(9);
				 st10=rs.getString(10);
				 st11=rs.getString(11);
				 st12=rs.getString(12);
				 st13=rs.getString(13);
				 st14=rs.getString(14);
				 st15=rs.getString(15);
				 st16=rs.getString(16);
				 
				 
				
				 System.out.println("done");
				 fw.write("CreditCardNo:"+st1+" ");
				 fw.write("PinNo:"+st2+" ");
				 fw.write("WhatsppNo:"+st3+" ");
				 fw.write("WhatsppPassword:"+st4+" ");
				 fw.write("FaceBookId:"+st5+" ");
				 fw.write("FaceBookPassword:"+st6+" ");
				 fw.write("GmailId:"+st7+" ");
				 fw.write("GmailPassword:"+st8+" ");
				 fw.write("YahooId:"+st9+" ");
				 fw.write("YahooPassword:"+st10+" ");
				 fw.write("LinkedineId:"+st11+" ");
				 fw.write("LinkedinePassword:"+st12+" ");
				 fw.write("PinterestId:"+st13+" ");
				 fw.write("PinterestPassword:"+st14+" ");
				 fw.write("UserName:"+st15+" ");
				 fw.write("BankName:"+st16+" ");
				 
				 st17=rs.getString(17);
				 st18=rs.getString(18);
				 st19=rs.getString(19);
				 st20=rs.getString(20);
				 
				 java.sql.ResultSetMetaData meta=rs.getMetaData();
				 String col1name=meta.getColumnLabel(17);
				 String col2name=meta.getColumnLabel(18);
				 String col3name=meta.getColumnLabel(19);
				 String col4name=meta.getColumnLabel(20);
				 //String col5name=meta.getColumnLabel(21);
				// System.out.println(col1name);
				 //System.out.println(col2name);
				 //System.out.println(col3name);
				 //System.out.println(col4name);
				// System.out.println(col5name);
				 System.out.println(ttext+"="+col4name);
				 if(ttext==col1name)
				 {
					 fw.write(  ttext+":"+st17+" |complete| "+" ___________Next USER's Information=>__________");
					 
				 }
				 else if(ttext==col2name)
				 {
					 fw.write(  ttext+":"+st18+" |complete| "+" ___________Next USER's Information=>__________");
					 
				 }
				 else if(ttext==col3name)
				 {
					 fw.write(  ttext+":"+st19+" |complete| "+" ___________Next USER's Information=>__________");
				 }
				 else if(ttext==col4name)
				 {
					 fw.write(  ttext+":"+st20+" |complete| "+" ___________Next USER's Information=>__________");
				 }
					 
					
				 
				 
				 
				
				 
				}
				
				System.out.println("Before flush and close length of file:"+f1.length());
				
				
				
			}
			catch(SQLException ex)
			{
				ex.printStackTrace();
			}
				
			catch(IOException ex)
			{
				ex.printStackTrace();
			}
			finally
			{
				try
				{
					if(fw!=null)
					{
						fw.flush();
						fw.close();
					}
				}
				catch(IOException ex)
				{
					ex.printStackTrace();
				}
				System.out.println("After flush and close lengthof file:"+f1.length());
			}
				
	 }
}



}

