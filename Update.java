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
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Update extends JFrame implements ActionListener{
		 
	JLabel ltitle,lCreditCardNo,lPinNo,lWhatsppNo,lWhatsppPassword,lFaceBookId,lFaceBookPassword
	,lGmailId,lGmailPassword,lYahooId,lYahooPassword,lLinkedineId,lLinkedinePassword,lPinterestId,
	lPinterestPassword,lUserName,lBankName;
	
	JPasswordField tPinNo,tWhatsppPassword,tFaceBookPassword,tGmailPassword,tYahooPassword,tLinkedinePassword,
	tPinterestPassword;
	
	JTextField ttitle,tCreditCardNo,tWhatsppNo,tFaceBookId
	,tGmailId,tYahooId,tLinkedineId,tPinterestId,
	tUserName,tBankName;
	
	JButton update,reset,exit,availableuser;

	public Update()
	{
		setLayout(new FlowLayout());
		ltitle=new JLabel("Upadte Information");
		lUserName=new JLabel("UserName");
		tUserName=new JPasswordField(25);
		lCreditCardNo=new JLabel("CreditCardNo");
		tCreditCardNo=new JPasswordField(25);
		lPinNo=new JLabel("PinNo");
		tPinNo=new JPasswordField(25);
		lBankName=new JLabel("BankName");
		tBankName=new JPasswordField(25);
		lWhatsppNo=new JLabel("WhatsppNo");
		tWhatsppNo=new JPasswordField(25);
		lWhatsppPassword=new JLabel("WhatsppPassword");
		tWhatsppPassword=new JPasswordField(25);
		lFaceBookId=new JLabel("FaceBookId");
		tFaceBookId=new JPasswordField(25);
		lFaceBookPassword=new JLabel("FaceBookPassword");
		tFaceBookPassword=new JPasswordField(25);
		lGmailId=new JLabel("GmailId");
		tGmailId=new JPasswordField(25);
		lGmailPassword=new JLabel("GmailPassword");
		tGmailPassword=new JPasswordField(25);
		lYahooId=new JLabel("YahooId");
		tYahooId=new JPasswordField(25);
		lYahooPassword=new JLabel("YahooPassword");
		tYahooPassword=new JPasswordField(25);
		lLinkedineId=new JLabel("LinkedineId");
		tLinkedineId=new JPasswordField(25);
		lLinkedinePassword=new JLabel("LinkedinePassword");
		tLinkedinePassword=new JPasswordField(25);
		lPinterestId=new JLabel("PinterestId");
		tPinterestId=new JPasswordField(25);
		lPinterestPassword=new JLabel("PinterestPassword");
		tPinterestPassword=new JPasswordField(25);
		
		update=new JButton("Update");
		reset=new JButton("Reset");
		exit=new JButton("Exit");
		availableuser=new JButton("Available User");
		
		
		add(ltitle);
		add(lUserName);
		add(tUserName);
		add(lCreditCardNo);
		add(tCreditCardNo);
		add(lPinNo);
		add(tPinNo);
		add(lBankName);
		add(tBankName);
		add(lWhatsppNo);
		add(tWhatsppNo);
		add(lWhatsppPassword);
		add(tWhatsppPassword);
		add(lFaceBookId);
		add(tFaceBookId);
		add(lFaceBookPassword);
		add(tFaceBookPassword);
		add(lGmailId);
		add(tGmailId);
		add(lGmailPassword);
		add(tGmailPassword);
		add(lYahooId);
		add(tYahooId);
		add(lYahooPassword);
		add(tYahooPassword);
		add(lLinkedineId);
		add(tLinkedineId);
		add(lLinkedinePassword);
		add(tLinkedinePassword);
		add(lPinterestId);
		add(tPinterestId);
		add(lPinterestPassword);
		add(tPinterestPassword);
		
		
	    add(update);
	    add(reset);
	    add(exit);
	    add(availableuser);
	    
		
		
		update.addActionListener(this);
		reset.addActionListener(this);
		exit.addActionListener(this);
		availableuser.addActionListener(this);
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Connection con=null;
		Statement stmt=null;
		if(e.getSource()==reset)
		{
			
			tUserName.setText("");
			tCreditCardNo.setText("");
			tPinNo.setText("");
			tBankName.setText("");
			tWhatsppNo.setText("");
		    tWhatsppPassword.setText("");
			tFaceBookId.setText("");
			tFaceBookPassword.setText("");
			tGmailId.setText("");
			tGmailPassword.setText("");
			tYahooId.setText("");
			tYahooPassword.setText("");
			tLinkedineId.setText("");
			tLinkedinePassword.setText("");
			tPinterestId.setText("");
			tPinterestPassword.setText("");
			
		}
		else if(e.getSource()==exit)
		{
			this.setVisible(false);
		}
		else if(e.getSource()==update)
		{
			String username=tUserName.getText();
			int ccno=Integer.parseInt(tCreditCardNo.getText());
			int pno=Integer.parseInt(tPinNo.getText());
			String bname=tBankName.getText();
			String wno=tWhatsppNo.getText();
		    String wp=tWhatsppPassword.getText();
			String fid=tFaceBookId.getText();
			String fp=tFaceBookPassword.getText();
			String gid= tGmailId.getText();
			String gp=tGmailPassword.getText();
			String yid=tYahooId.getText();
			String yp=tYahooPassword.getText();
			String lid=tLinkedineId.getText();
			String lp=tLinkedinePassword.getText();
			String pid=tPinterestId.getText();
			String pp=tPinterestPassword.getText();
			try
			{   
				String sql="update  infosecurity  set CreditCardNo='"+ccno+"',PinNo="+pid+",BankName='"+bname+"',WhatsppNo='"+wno+"',WhatsppPassword='"+wp+"',FaceBookId="+fid+",FaceBookPassword='"+fp+"',GmailId='"+gid+"',GmailPassword='"+gp+"',YahooId="+yid+",YahooPassword='"+yp+"',LinkedineId='"+lid+"',LinkedinePassword='"+lp+"',PinterestId='"+pid+",PinterestPassword='"+pp+"' where UserName='"+username+"' ";
					
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
		else if(e.getSource()==availableuser)
		{
			try
			{
			String sql="select UserName from infosecurity";
			System.out.println(sql);
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
			
			
			int count=0;
			while(rs.next())
			{
				//System.out.println(rs.getInt(1)+":"+rs.getString(2));
				dtm.insertRow(count, new Object[]{rs.getString(1)});
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
	}

}
