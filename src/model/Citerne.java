package model;

import java.util.ArrayList;
import interfaces.*;

public class Citerne implements Observable{
	private double maximumValue;
	private double currentValue;
	private ArrayList<Observer> listObservers = new ArrayList<Observer>();   
	public void addObserver (Observer o)
	{
		this.listObservers.add(o);
	}
	public Citerne(double rayon, double hauteur)
	{
		maximumValue = (3.14*rayon*rayon*hauteur)/1000;
		currentValue=0.0;
	}
	public boolean add (double volume)
	{
		if (this.maximumValue>=this.currentValue+volume)
		{
			this.currentValue+=volume;
			this.notifyObservers(null);
			return true;
		}else
		{
		return false;
		}
	}
	public boolean setVolume ( double pourc)
	{
		if (this.maximumValue>=pourc)
		{
			this.currentValue=pourc;
			this.notifyObservers(null);
			return true;
		}else
		{
		return false;
		}
	}
	public boolean drain (double volume)
	{   if(this.currentValue>=volume)   
	    {
		    this.currentValue=this.currentValue-volume;
		    this.notifyObservers(null);
		    return true;
	    }else
	    {
	    	return false;
	    }
	}
	public double getCurrentVolume()
	{
		return currentValue;
	}
	public double getCurrentRate()
	{
		return (currentValue/maximumValue)*100;
	}
	public double getMaximumValue()
	{
		return maximumValue;
	}
	@Override
    public void notifyObservers (Object v)
	{  //
		for(int i=0;i<=this.listObservers.size();i++)
		{
			this.listObservers.get(i).update(this, v);
		}
	}
	public String toString()
	{
		return "Current volume : " + currentValue + " litres (" + getCurrentRate() + "%)";
	}
	@Override
	public void removeObservers() {
		this.listObservers.clear();
		
	}
	
}
