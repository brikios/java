package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import view.*;
import model.*;
public class ControleurCiterne1 implements ActionListener,  MouseMotionListener{
	CiterneView1 cframe;
	public ControleurCiterne1(CiterneView1 cf)
	{
		cframe = cf;
	}			
	@Override
	public void actionPerformed(ActionEvent ev) 
	{
		JButton btn=(JButton) ev.getSource();
		if(btn.getText().equals("Add"))
		{
			cframe.getCiterne().add(Double.parseDouble(cframe.getVolume()));
		}else if(btn.getText().equals("Drain"))
		{
			cframe.getCiterne().drain(Double.parseDouble(cframe.getVolume()));
		}
		
	}


	@Override
	public void mouseDragged(MouseEvent e) {
		cframe.getCiterne().setVolume(cframe.slide.getValue()*cframe.getCiterne().getMaximumValue()/100);
		}
	@Override
	public void mouseMoved(MouseEvent e) {
		
		
	}
	
}