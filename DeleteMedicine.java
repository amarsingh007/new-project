package com.sdj;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class DeleteMedicine extends JFrame implements ActionListener{
	
	JLabel ld,title;
	JTextField td;
	JButton delete,back;
	public DeleteMedicine()
	{
		title=new JLabel("Delete_Medicine");
		ld=new JLabel("Medicine Batch No");
		td=new JTextField(25);
		delete=new JButton("Delete");
		back=new JButton("Back");
		setLayout(null);
		title.setBounds(500, -180, 700, 500);
		ld.setBounds(350, 155, 150, 50);
		td.setBounds(500, 170, 150, 25);
		delete.setBounds(400,280, 80, 30);
		back.setBounds(600, 280, 80, 30);
		add(title);
		add(ld);
		add(td);
		add(delete);
		add(back);
		delete.addActionListener(this);
		back.addActionListener(this);				
}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Connection con=null;
		Statement stmt=null;
		if(e.getSource()==delete)
		{
			int batchno=Integer.parseInt(td.getText());
			try
			{
				con=DBConnection.getConnection();
				stmt=con.createStatement();
				String sql="Delete From Medicine Where MedicineBatchNo='"+batchno+"'";
				stmt.executeUpdate(sql);
				String msg="Information Deleted Successfully";
				JOptionPane.showMessageDialog(null, msg);
				this.setVisible(false);
				Medicine md=new Medicine();// object created for frame
				md.setVisible(true);
			    md.setSize(500,500);
			    md.setTitle("Medicine");
			}
			catch(SQLException ex)
			{
				ex.printStackTrace();
			}
				
			}
		if(e.getSource()==back)
		{
			this.setVisible(false);
			Medicine md=new Medicine();// object created for frame
			md.setVisible(true);
		    md.setSize(500,500);
		    md.setTitle("Medicine");
		}
		}
	}
		
		
		

