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

public class ExtraLabelInfo extends JFrame  implements ActionListener{
	
	
		JLabel title,llabel,lpass,luser;
		JTextField tlabel,tuser;
		JButton Save,Back;
		JPasswordField tpass;
		
			public ExtraLabelInfo()
		    {
				setLayout(new FlowLayout());
				title=new JLabel("//Here you can add Informaion of newly created Column//");
				llabel=new JLabel("Enter your column name");
				tlabel=new JTextField(25);
				lpass=new JLabel("value");
				tpass=new JPasswordField(25);
				luser=new JLabel("User Name");
				tuser=new JPasswordField(25);
				
				
				Save=new JButton("save");
		
				Back=new JButton("Back");
				
				add(title);
				add(llabel);
				add(tlabel);
				add(lpass);
				add(tpass);
				add(luser);
				add(tuser);
				
				
				
				
				
				
				add(Save);
				add(Back);
			
				
				Back.addActionListener(this);
				Save.addActionListener(this);
				
				
				
				
			}

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Connection con=null;
				Statement stmt=null;
				if(e.getSource()==Save)
				{
					try
					{   String name= tlabel.getText();
						String mbt=tpass.getText();
						
						String usr=tuser.getText();
						String sql="update  infosecurity set "+name+"='"+mbt+"' where UserName='"+usr+"'";
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
	


