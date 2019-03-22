package com.java7.feature;

public class SwitchStrings
{
  public static void main(String args[])
  {
    StringBuffer  sb = new StringBuffer();
  
    for(String str : args)
    {
      switch(str)
      {
        case "Idly":	sb.append(str +", ");   break;
        case "Dosa":	sb.append(str +", ");   break;
        case "Puri":	sb.append(str +", ");   break;
        case "Vada":	sb.append(str);         break;
        default:        sb.append("No breakfast menu");
      }
    }
    System.out.println("Your breakfast menu: " + sb);
  }
}