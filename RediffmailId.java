package com.sdj;

import java.awt.FlowLayout;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class RediffmailId extends JFrame{
	JLabel lgmail,lpass,linfoholder,title;
	JTextField tgmail,tinfoholder;
	JButton Save,All,Back;
	JPasswordField tpass;
	public RediffmailId()
			{
		setLayout(new FlowLayout());
	}
}
