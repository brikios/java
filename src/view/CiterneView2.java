package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import interfaces.*;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import controllers.ControleurCiterne2;
import model.*;

public class CiterneView2 extends JFrame implements Observer{
    public Citerne cmodel;	
    ButtonGroup bg = new ButtonGroup();
    JLabel lchoix = new JLabel("Liste des choix");
	public JRadioButton op1 = new JRadioButton ("Citerne vide");
	public JRadioButton op2 = new JRadioButton ("Citerne � moiti� plein ");
	public JRadioButton op3 = new JRadioButton ("Citerne � 1/4 plein ");
	public JRadioButton op4 = new JRadioButton ("Citerne � 3/4 plein ");	
	JLabel lcurrent = new JLabel ("Volume actuel: ");
	JLabel lcurrentV = new JLabel ("0.0 litres");
	JLabel lpourc = new JLabel ("Pourcentage de remplissage");
	JLabel lpourcV = new JLabel ("0%");
	JPanel p,p1, p2, p3, p4;
	public CiterneView2 (Citerne ct)
	{	super ("Citerne (View2)");
		cmodel=ct;
		cmodel.addObserver(this);	
		bg.add(op1); bg.add(op2); bg.add(op3); bg.add(op4);
		p1 = new JPanel();	
		p1.setLayout(new BoxLayout(p1,BoxLayout.LINE_AXIS));
		p3= new JPanel(new GridLayout(5,1));
		lchoix.setForeground(Color.BLUE);
		p3.add(lchoix);
		p3.add(op1); p3.add(op2); p3.add(op3); p3.add(op4);
		p1.add(p3);
		p2 = new JPanel();
		p2.setLayout(new GridLayout(2,2));
		p2.setBackground(Color.LIGHT_GRAY);
		p2.add(lcurrent); p2.add(lcurrentV);
		p2.add(lpourc); p2.add(lpourcV);
		lcurrentV.setForeground(Color.red);
		lpourcV.setForeground(Color.red);
		p= new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));
		p.add(p1);p.add(p2);
	    op1.addActionListener(new ControleurCiterne2 (this));
	    op2.addActionListener(new ControleurCiterne2 (this));
	    op3.addActionListener(new ControleurCiterne2 (this));
	    op4.addActionListener(new ControleurCiterne2 (this));
		setSize(new Dimension (400, 400));
		setLocation (400, 300);
		getContentPane().add(p);
		setVisible(true);
	
	}
	public Citerne getCiterne()
	{
		return cmodel;
	}
	
	@Override
	public void update(Observable ov, Object v) {
		lcurrentV.setText(cmodel.getCurrentVolume()+" litres");
		lpourcV.setText(cmodel.getCurrentRate()+" %");
		if(cmodel.getCurrentRate()>=65)
		{
			lcurrentV.setForeground(Color.green);
			lpourcV.setForeground(Color.green);
			
		}else
		{
			lcurrentV.setForeground(Color.red);
			lpourcV.setForeground(Color.red);
		}
	}
	public static void main (String []argv)
	{
		Citerne c = new Citerne(100,200);
		CiterneView1 view1 =new CiterneView1(c);
		CiterneView2 view2 = new CiterneView2(c);
	}
}
