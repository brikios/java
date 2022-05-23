package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import view.*;
import model.*;
public class ControleurCiterne2 implements ActionListener{
	CiterneView2 cframe;
	public  ControleurCiterne2(CiterneView2 cf)
	{
		cframe = cf;
	}	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(cframe.op1.isSelected())
		{
			cframe.getCiterne().setVolume(0);
		}else if(cframe.op2.isSelected())
		{
			cframe.getCiterne().setVolume(3140);
		}else if (cframe.op3.isSelected())
		{
			cframe.getCiterne().setVolume(6280/4);
		}
		else if(cframe.op4.isSelected())
		{
			cframe.getCiterne().setVolume(6280*3/4);
		}
	}
	
}
