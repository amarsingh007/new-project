package com.sdj;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class EmailId extends JFrame implements ActionListener {
	JLabel title;
	JComboBox emailid;
	  JButton Click;
  public EmailId(){
	  setLayout(new FlowLayout());
	  title=new JLabel("Email Id Information");
	  emailid=new JComboBox();
	  emailid.addItem("--select emailid type--");
	  emailid.addItem("Gmail");
	  emailid.addItem("Yahoo");
	  emailid.addItem("Rediffmail");
	  Click=new JButton("Click");
	  add(title);
	  add(emailid);
	  add(Click);
	  Click.addActionListener(this);
	  
	}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	String st=emailid.getSelectedItem().toString();
	if(st=="Gmail")
	{
		GmailId GM=new GmailId();// object created for frame
		
		GM.setVisible(true);
		GM.setSize(500,500);
		GM.setTitle("GmailInformation");
	}
	else if(st=="Yahoo")
	{
        YahooId YO=new YahooId();// object created for frame
		
		YO.setVisible(true);
		YO.setSize(500,500);
		YO.setTitle("InformationSecurity");
		
	}
		
	else if(st=="Rediffmail")
	{
        RediffmailId RM=new RediffmailId();// object created for frame
		
		RM.setVisible(true);
		RM.setSize(500,500);
		RM.setTitle("InformationSecurity");
	}
	
	
	
}

  
}
