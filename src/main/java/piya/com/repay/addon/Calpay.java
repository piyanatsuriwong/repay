package piya.com.repay.addon;

import java.util.*;
 public class Calpay {
 	private double x1;
 	private double x2;
 	// private int x3;
 	private double y1;
 	private double y2;
 	private double y3;

//  	public Calpay( int x1, int x2 )
// {

// // this.x2 = x3;
// }

	 public  double increase( double x1, double x2 ){
	 	this.x1 = x1;
		this.x2 = x2;
	 		return ( (x1 * x2 )/(36500));
	 }
	 public  double	increase2(double y1,double y2,double y3){
	 	this.y1 = y1;
		this.y2 = y2;
		this.y3 = y3;
	 		return ( (y1 * y3 * y3)/(36500));
	 }
 }

