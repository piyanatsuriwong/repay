package piya.com.repay.addon;

import java.util.*;
 public class Numberformat {

 public int Numberformat(Date d1, Date d2){
 return (int)( (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
 }
 }

