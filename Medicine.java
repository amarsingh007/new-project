package com.sdj;

import java.awt.BorderLayout;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuBar;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Medicine extends JFrame implements ActionListener
{
	
  
JMenuBar mbar;
JMenu su,me,report,about,exit;
JMenuItem anm,snm,um,dm,som;
public Medicine()
{
	JPanel main=new JPanel();//object created for panel
	main.setLayout(new BorderLayout());
	mbar = new JMenuBar();
	su=new JMenu("supplier");
	me=new JMenu("Medicine");
	report=new JMenu("Report");
	about=new JMenu("About");
	anm=new JMenuItem("Add new medicine");
	snm=new JMenuItem("Search medicine");
	um=new JMenuItem("Update medicine");
	dm=new JMenuItem("Delete medicine");
	som=new JMenuItem("Stock new medicine");
	me.add(anm);
	me.add(snm);
	me.add(um);
	me.add(dm);
	me.add(som);
	mbar.add(su);
	mbar.add(me);
	mbar.add(report);
	mbar.add(about);
	//mbar.add(exit);
	main.add(mbar,BorderLayout.NORTH);
	add(main);
	anm.addActionListener(this);
	snm.addActionListener(this);
	dm.addActionListener(this);
	um.addActionListener(this);
}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if(e.getSource()==anm)
	{
    AddNewMedicine an=new AddNewMedicine();//object created for Menuitem
	an.setVisible(true);
	an.setSize(500,500);
	an.setTitle("Add New Medicine");
	}
	else if(e.getSource()==snm)
	{
		System.out.println("sum");
	SearchMedicine sm=new SearchMedicine();//object created for Menuitem
	sm.setVisible(true);
	sm.setSize(500, 500);
	sm.setTitle("Search Medicine");
	}
	else if(e.getSource()==dm)
	{
		System.out.println("amar");
	DeleteMedicine dm1=new DeleteMedicine();
	dm1.setVisible(true);
	dm1.setSize(500, 500);
	dm1.setTitle("Delete Medicine");
	}
	else if(e.getSource()==um)
	{
		UpdateMedicine um1=new UpdateMedicine();
		um1.setVisible(true);
		um1.setSize(500, 500);
		um1.setTitle("Delete Medicine");
	}
}
}

	
	/*
	 * public static void main(String[] args) 
	{
		Medicine md=new Medicine();// object created for frame
	
		md.setVisible(true);
	    md.setSize(500,500);
	    md.setTitle("Medicine");
	    md.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    

}
	 * 
	 */
	

	