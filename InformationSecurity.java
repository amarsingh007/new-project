package com.sdj;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InformationSecurity extends JFrame implements ActionListener{
	
	
	
	JMenuBar mbar;
	JMenu me,report,about,exit,nia;
	JMenuItem anm,snm,off,unoff,info1,info2,filecreation,ncl,nsl;
	JTextField pass1;
public InformationSecurity() {
	
	JPanel main=new JPanel();//object created for panel
	main.setLayout(new BorderLayout());
	mbar = new JMenuBar();
	
	me=new JMenu("Common Information");
	nia=new JMenu("Extra Information");
	
	
	report=new JMenu("Report");
	about=new JMenu("About");
	
	
	anm=new JMenuItem("Add new Information");
	snm=new JMenuItem("Search Information");
	
	filecreation=new JMenuItem("BackUp Plan");
	ncl=new JMenuItem("Extra Information Add");
	nsl=new JMenuItem("Extra Information Search");
	
	
	
	add(anm);
	add(snm);
	
	add(ncl);
	add(nsl);
	add(filecreation);
	
	
	
	
	me.add(anm);
	me.add(snm);
	me.add(filecreation);
	
	
	
	nia.add(ncl);
	nia.add(nsl);
	
	

	
	
	mbar.add(me);
	mbar.add(report);
	mbar.add(about);
	mbar.add(nia);
	
	//mbar.add(exit);
	main.add(mbar,BorderLayout.NORTH);
	add(main);
	
	anm.addActionListener(this);
	snm.addActionListener(this);
	filecreation.addActionListener(this);


	ncl.addActionListener(this);
	nsl.addActionListener(this);	
	
	}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
	if(e.getSource()==anm)//1
			{
		AddNewInformation1 an=new AddNewInformation1();//object created for Menuitem
	an.setVisible(true);
	an.setSize(500,500);
	an.setTitle("AddNewInformation");
		}
	else if(e.getSource()==snm)//2
	{
		System.out.println("sum");
	AllPersonalInformation sm=new AllPersonalInformation();//object created for Menuitem
	sm.setVisible(true);
	sm.setSize(500, 500);
	sm.setTitle("Search Medicine");
	}
	
	else if(e.getSource()==filecreation)//4
	{
		FileCreation FC=new FileCreation();
		FC.setVisible(true);
		FC.setSize(500, 500);
		FC.setTitle("File Creation");
		String msg="File Format should be in .txt format";
		JOptionPane.showMessageDialog(null, msg);
		this.setVisible(false);
		
	}
	else if(e.getSource()==ncl)//5
	{
		ExtraLabelInfo extra=new ExtraLabelInfo();
		extra.setVisible(true);
		extra.setSize(500, 500);
		extra.setTitle("Extra Add Information");
		
	}
	else if(e.getSource()==nsl)
	{
		ExtraInfoSearch extra1=new ExtraInfoSearch();
		extra1.setVisible(true);
		extra1.setSize(500, 500);
		extra1.setTitle("Extra Search Information");
	}
	
		
		}
	}



