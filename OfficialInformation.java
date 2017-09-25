package com.sdj;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

public class OfficialInformation extends JFrame implements ActionListener {
	JComboBox stype;
	JButton Click;
   public OfficialInformation()  {
	   setLayout(new FlowLayout());
	   stype=new JComboBox();
	   Click=new JButton("Click");
	   stype.addItem("--select information  type --");
	   stype.addItem("Credit Card Information");
	   
	   
	   
	   add(stype);
	   add(Click);
	   Click.addActionListener(this);
	   
	}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	String st=stype.getSelectedItem().toString();
	if(st=="Credit Card Information")
	{
		CreditCard an=new CreditCard();//object created for Menuitem
		an.setVisible(true);
		an.setSize(500,500);
		an.setTitle("CreditCard Information");
		this.setVisible(false);
		/*
		UnOfficialInformation ann=new UnOfficialInformation();//object created for Menuitem
		ann.setVisible(true);
		ann.setSize(500,500);
		ann.setTitle("CreditCard Information");*/
	}
}


   
}
