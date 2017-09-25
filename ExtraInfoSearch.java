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

public class ExtraInfoSearch extends JFrame implements ActionListener{
	JLabel title,llabel,luser;
	JTextField tlabel,tuser;
	JButton Search,Back;
	
	
		public ExtraInfoSearch()
	    {
			setLayout(new FlowLayout());
			title=new JLabel("//Here you can add Informaion of newly created Column//");
			llabel=new JLabel("Enter your column name");
			tlabel=new JTextField(25);
			
			luser=new JLabel("User Name");
			tuser=new JTextField(25);
			
			
			
			
			Search=new JButton("Search");
			
			Back=new JButton("Back");
			
			add(title);
			add(llabel);
			add(tlabel);
			
		
			add(luser);
			add(tuser);
			
			
			
			
			
			
			add(Search);
			add(Back);
			Search.addActionListener(this);
			
			Back.addActionListener(this);
			

}


		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Connection con=null;
			Statement stmt=null;
			if(e.getSource()==Search)
			{
				try
				{   String cname= tlabel.getText();

					
					String usr=tuser.getText();
					String sql="select "+cname+" from infosecurity where UserName='"+usr+"'";
					System.out.println(sql);
					con=DBConnection.getConnection();
					stmt=con.createStatement();
					ResultSet rs=stmt.executeQuery(sql);
					DefaultTableModel dtm=new DefaultTableModel() ;
					JTable table=new JTable(dtm);
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
					dtm.addColumn(cname);
					
					
					int count=0;
					while(rs.next())
					{
						//System.out.println(rs.getInt(1)+":"+rs.getString(2));
						dtm.insertRow(count, new Object[]{rs.getString(1)});
						
					}
					
					JScrollPane jsp=new JScrollPane(table);
					add(jsp);
					
				}
					
					
				catch(SQLException ex)
				{
					ex.printStackTrace();
				}
			}
		else if(e.getSource()==Back)
		{
			
		
			this.setVisible(false);
			InformationSecurity IS=new InformationSecurity();// object created for frame
			
			IS.setVisible(true);
			IS.setSize(500,500);
			IS.setTitle("Add New Information ");
			
		}
}
}