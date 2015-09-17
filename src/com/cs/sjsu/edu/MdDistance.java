package com.cs.sjsu.edu;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MdDistance 
{
	public double minMean;
	
	MdDistance(double min)
	{
		minMean = min;
	}

	public double calcDistance(HashMap frequencyVector, HashMap meanVector)
	{
		double score = 0.0;
		
		Iterator it = frequencyVector.entrySet().iterator();
				
		while(it.hasNext())
		{
			Map.Entry pairs = (Map.Entry)it.next();
			
			List nGram = (List)pairs.getKey();
			double temp_score =(double)pairs.getValue();
			
			
			if(meanVector.containsKey(nGram))
			{
				temp_score = (temp_score - (double)meanVector.get(nGram)/*/(double)stdev.get(nGram)*/);
				
				if (temp_score<0)
				temp_score = 0 - temp_score;
				
				// sum of squares
				score = score+(temp_score); 
			}
			
			else
			{
				//temp_score = (temp_score)/(double)stdev.get(nGram);
				score =score + (temp_score) ;
			}
			
		}
		
		it = meanVector.entrySet().iterator();
		
		while(it.hasNext())
		{
			Map.Entry pairs = (Map.Entry)it.next();
			
			List nGram = (List)pairs.getKey();
			double temp_score = (double)pairs.getValue();
			
			if(frequencyVector.containsKey(nGram))
			{
				
			}
			
			else
			{
				score = score + (temp_score);
			}
		}
		
		// Change 16777219 later on
		return (Math.pow(score, 2)/*/Math.pow(16777216, 2)*/);
	}
	
}
