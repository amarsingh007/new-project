package com.sdj;


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

public class UpdateMedicine extends JFrame implements ActionListener{

	JLabel lmn,lchangeinquantity,lchangeintype;
	JTextField tmn,tchangeinquantity,tchangeintype;
	JButton update,back;
	public UpdateMedicine() {
		//FlowLayout f1=new FlowLayout();
				setLayout(null);
				lmn=new JLabel("Enter Medicine Batch No which you want to update");
				tmn=new JTextField();
				lchangeinquantity=new JLabel("Writedown Changes in Quantity ");
				tchangeinquantity=new JTextField();
				lchangeintype=new JLabel("Writedown Changes in MedicineType");
				tchangeintype=new JTextField();
				update=new JButton("Update");
				back=new JButton("Back");
				
				lmn.setBounds(300, 100, 150, 50);
				tmn.setBounds(450, 115, 150, 25);
				lchangeintype.setBounds(300, 140, 150, 50);
				tchangeintype.setBounds(450, 145, 150, 25);
				lchangeinquantity.setBounds(300, 150, 150, 50);
				tchangeinquantity.setBounds(450, 165, 150, 25);
				update.setBounds(300, 200, 80, 30);
				back.setBounds(400, 200, 80, 30);
				
				add(lmn);
				add(tmn);
				add(lchangeintype);
				add(tchangeintype);
				add(lchangeinquantity);
				add(tchangeinquantity);
				
				add(update);
				add(back);
				update.addActionListener(this);
				
				
				
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Connection con=null;
		Statement stmt=null;
		{
			if(e.getSource()==update)
			{
				int tmn1=Integer.parseInt((tmn.getText()));
				String tchangeintype1=tchangeintype.getText();
				int  tchangeinquantity1=Integer.parseInt(tchangeinquantity.getText());
				try
				{
					con=DBConnection.getConnection();
					stmt=con.createStatement();
					String sql="Update medicine Set MedicineBatchType='"+tchangeintype1+"',Quantity='"+tchangeinquantity1+"' Where MedicineBatchNo='"+tmn1+"'";
					stmt.executeUpdate(sql);
					String msg="Information Update Successfully";
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
			
			
					
			
		
		
		
	}
	

