package com.sdj;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

public class UnOfficialInformation extends JFrame implements ActionListener{
	JComboBox stype;
	JButton Click;
	public UnOfficialInformation() {
		setLayout(new FlowLayout());
		   stype=new JComboBox();
		   Click=new JButton("Click");
		   stype.addItem("--select information  type --");
		   stype.addItem("FaceBook Information");
		   stype.addItem("Whatspp Information");
		   stype.addItem("Email Id Information");
		   
		   
		   
		   
		   add(stype);
		   add(Click);
		   Click.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String st=stype.getSelectedItem().toString();
		if(st=="FaceBook Information")
		{
			FaceBook fb=new FaceBook();//object created for Menuitem
			fb.setVisible(true);
			fb.setSize(500,500);
			fb.setTitle("FaceBook Information");
		}
		else if(st=="Whatspp Information")
		{
			Whatspp wp=new Whatspp();//object created for Menuitem
			wp.setVisible(true);
			wp.setSize(500,500);
			wp.setTitle("Whatspp Information");
			
		}
		else if(st=="Email Id Information")
		{
			EmailId ed=new EmailId();//object created for Menuitem
			ed.setVisible(true);
			ed.setSize(500,500);
			ed.setTitle("Email Id Information");
			
		}
		
	}
	

}
