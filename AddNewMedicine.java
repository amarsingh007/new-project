package com.sdj;

import java.awt.FlowLayout;
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

public class AddNewMedicine extends JFrame implements ActionListener 
{
	//AddNewMedicine an=new AddNewMedicine();
	


	JLabel lmbn,lmquantity,title;
	JLabel lmtype;
	JTextField tmbn,tmquantity;
	JComboBox mtype;
	JButton save,all;
	public AddNewMedicine()
	{
		setLayout(new FlowLayout());
		title=new JLabel("Add New Medicine");
		lmbn =new JLabel("Medicine Batch No");
		lmtype =new JLabel("Medicine Batch Type");
		lmquantity=new JLabel("Medicine Quantity");	
		tmbn=new JTextField(20);
		tmquantity=new JTextField(20);
		mtype=new JComboBox();
		save=new JButton("save");
		all=new JButton("all");
		mtype.addItem("--select type --");
		mtype.addItem("A");
		mtype.addItem("B");
		mtype.addItem("C");
		
		add(lmbn);
	    add(tmbn);
		add(lmtype);
		add(mtype);
		add(lmquantity);
		add(tmquantity);
		add(save);
		add(all);
		
		save.addActionListener(this);
		all.addActionListener(this);
				
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		Connection con=null;
		Statement stmt=null;
		if(e.getSource()==save)
		{
			try
			{
				int mbt=Integer.parseInt(tmbn.getText());
				int axt=Integer.parseInt(tmquantity.getText());
				String mt=mtype.getSelectedItem().toString();
				String sql="insert into medicine values("+mbt+",'"+mt+"',"+axt+")";
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
		else if(e.getSource()==all)
		{
			try
			{
				String sql="select *from medicine";
				con=DBConnection.getConnection();
				stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery(sql);
				DefaultTableModel dtm=new DefaultTableModel() ;
				JTable table=new JTable(dtm);
				dtm.addColumn("Medicine_Batch_no");
				dtm.addColumn("Medicine_Batch_type");
				dtm.addColumn("Medicine Quantity");
				int count=0;
				while(rs.next())
				{
					//System.out.println(rs.getInt(1)+":"+rs.getString(2));
					dtm.insertRow(count, new Object[]{rs.getInt(1),rs.getString(2),rs.getInt(3)});
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

				
			
		
		
	
	
	
	


