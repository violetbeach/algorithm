package basic.approximatesolution;

import java.util.ArrayList;
import java.util.List;

public class FillingInDataTest {
	    public static void main(String[] args){
	        List<String> readings = new ArrayList<String>();
	        readings.add("1/3/2012 16:00:00   Missing_1");
	        readings.add("1/4/2012 16:00:00   Missing_2");
	        readings.add("1/5/2012 16:00:00   27.728");
	        readings.add("1/6/2012 16:00:00   Missing_3");
	        readings.add("1/9/2012 16:00:00   28.1");
	        readings.add("1/10/2012 16:00:00  28.15");
	        
	        for(int i=0; i<readings.size(); i++){
	        	
	        	if(readings.get(i).split("\\s+")[2].contains("Missing")) {
	        		int pre = getPreIndex(readings, i-1);
		            int next = getNextIndex(readings, i+1);
		            if(pre == 0){
		                int next2 = getNextIndex(readings, next+1);
		                double v1 = Double.parseDouble(readings.get(next).split("\\s+")[2]);
		                double v2 = Double.parseDouble(readings.get(next2).split("\\s+")[2]);
		                System.out.println(v1 + (v1-v2));
		            } else if(next == 0){
		                int pre2 = getNextIndex(readings, pre-1);
		                double v1 = Double.parseDouble(readings.get(pre).split("\\s+")[2]);
		                double v2 = Double.parseDouble(readings.get(pre2).split("\\s+")[2]);
		                System.out.println(v1 + (v2-v1));
		            } else {
		                double v1 = Double.parseDouble(readings.get(pre).split("\\s+")[2]);
		                double v2 = Double.parseDouble(readings.get(next).split("\\s+")[2]);
		                System.out.println(v1 + (v2-v1)/2);
		            }
	        	}
	        }
	    }


	    public static int getNextIndex(List<String> input, int start){
	        for(int i=start; i<input.size(); i++){
	            if(!input.get(i).contains("Missing")){
	                return i;
	            }
	        }
	        return 0;
	    }

	    public static int getPreIndex(List<String> input, int start){
	        for(int i=start; i>=0; i--){
	            if(!input.get(i).contains("Missing")){
	                return i;
	            }
	        }
	        return 0;
	    }

}
