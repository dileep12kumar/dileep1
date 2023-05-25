package GenaricLibraries;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;


public class Javautility 
{
	public int GenarateRandomNum(int limit) 
	{
		Random random=new Random();
		return random.nextInt(limit);
	}
  


public String getCureentTime() 
{
	  Date date=new Date();
	  SimpleDateFormat sdf=new SimpleDateFormat("dd_MM_yy_hh_mm_sss");
	  return sdf.format(date);
}
}
