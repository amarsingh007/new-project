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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SearchMedicine extends JFrame implements ActionListener
{

		// TODO Auto-generated method stub
		// SearchMedicine sm=new SearchMedicine();
		JLabel lmn,lmt;
		JTextField tmn,tmt;
		JButton submit;
		
		public SearchMedicine()
		{
			setLayout(new FlowLayout());
		
		lmt =new JLabel("Medicine Batch Type");
		tmt=new JTextField(20);
		submit=new JButton("Submit");
		
		add(lmt);
		add(tmt);
		add(submit);
		
		
		submit.addActionListener(this);
		//set TextField Editable
		
		//tmn.setEditable(false);
		//tmt.setEditable(false);
		//
		
		}


		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Connection con=null;
			
			Statement stmt=null;
			
			System.out.println("search");
			if(e.getSource()==submit)
			{
				try
				{
								
					String str =tmt.getText();
					System.out.println(str);
				
					String sql="SELECT *  FROM  medicine WHERE MedicineBatchType='"+str+"'";
					
					con=DBConnection.getConnection();
					stmt=con.createStatement();
					java.sql.ResultSet rs=stmt.executeQuery(sql);
					DefaultTableModel dtm=new DefaultTableModel() ;
					JTable table=new JTable(dtm);
					dtm.addColumn("Medicine_Batch_no");
					dtm.addColumn("Medicine_Batch_type");
					dtm.addColumn("Medicine Quantity");
					//System.out.println(rs.getInt(1)+":"+rs.getString(2));
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

/*
/*
con=DBConnection.getConnection();
//preparedStatement =(PreparedStatement) con.prepareStatement(sql);
preparedStatement.setInt(1, str);
//ResultSet rs=(ResultSet)preparedStatement.executeQuery(sql);
stmt=con.createStatement();
java.sql.ResultSet rs=stmt.executeQuery(sql);


while(rs.next())
{
int a=rs.getInt("MedicineBatchNo");
String b=rs.getString("MedicineBatchType");
int c=rs.getInt("MedicineQuantity");
	
System.out.println("MedicineBatchNo"+a);
System.out.println("MedicineBatchType"+b);
System.out.println("MedicineQuantity"+c);
}

rs.close();*/




/*
/*		//pst.setString(1, str);
con=DBConnection.getConnection();
stmt=con.createStatement();
pst=(PreparedStatement) con.prepareStatement(sql);
result= (ResultSet) pst.executeQuery();


//ResultSet rs=(ResultSet) stmt.executeQuery(sql);
 //stmtsetString(1, str);
				
//PreparedStatement st= con.prepareStatement(sql);
//pst.setString(1, str);

//	ResultSet rs=(ResultSet) st.executeQuery();

if(result.next())
{
	String s=result.getString(1);
	String s1=result.getString(2);
	tmn1.setText(s);
	tmt2.setText(s1);
}
else
{
	JOptionPane.showMessageDialog(null, "Name not Found");
}

}
catch(SQLException ex)
{
ex.printStackTrace();
}
*/