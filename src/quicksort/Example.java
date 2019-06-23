package quicksort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.LongStream;


public class Example {
	
	public static void main(String[] args) {
		Random rand = new Random();
		
		// Generating a random array of Integer
		int size = 100000;
		double maxDouble= Double.MAX_VALUE;
		List<Double> list = new ArrayList<>(size);
		for(int i=0;i<size;i++)
			list.add(i,rand.nextDouble()*maxDouble);
		
//		int maxLength=250;
//		List<String> list = new ArrayList<>(size);
//		for(int i=0;i<size;i++)
//			list.add(i, randomString(maxLength));

		//Check correctness
		//checkCorrectness(list,Quicksort.sort(list));
		
		
		//Timing Check
		int numRep = 100;
		long start,end;
		long[] collectTimes = new long[numRep];
		long[] qsTimes = new long[numRep];
		for(int i=0;i<numRep;i++) {
			//Generating array
			for(int j=0;j<size;j++)
				list.set(j,rand.nextDouble()*maxDouble);
//			for(int j=0;j<size;j++)
//				list.set(j,randomString(maxLength));
			
			//Quicksort has to be tested before Collections.sort() because the latter sorts the 
			//list "in place".
			start = System.nanoTime();
			Quicksort.sort(list);
			end = System.nanoTime();
			qsTimes[i]=end-start;
			
			start = System.nanoTime();
			Collections.sort(list);
			end = System.nanoTime();
			collectTimes[i]=end-start;
			
		}
		
		double collAvg = LongStream.of(collectTimes).average().getAsDouble();
		double qsAvg = LongStream.of(qsTimes).average().getAsDouble();
		double collStdDev = getStdDeviation(collectTimes);
		double qsStdDev = getStdDeviation(qsTimes);

		System.out.println(String.format("Statistics on %d sorts of lists of %d random %s",numRep,size,list.get(0).getClass().getSimpleName()));
		System.out.println(String.format("Collections\tavg : %g ms\t Std Deviation: %g ms",collAvg/1000000,collStdDev/1000000));
		System.out.println(String.format("QuickSort\tavg : %g ms\t Std Deviation: %g ms",qsAvg/1000000,qsStdDev/1000000));
		
	}
	
	
	public static <T extends Comparable<? super T>> void checkCorrectness(List<T> list, List<T> sortedByAlg) {
		Collections.sort(list);
		int size=list.size();
		int flag=0;
		for(int i=0;i<size;i++)
			if(!list.get(i).equals(sortedByAlg.get(i))){
				flag++;
				System.out.println("WARNING: Wrong sort!");
				System.out.println("Sorted["+i+"]:\t"+list.get(i));
				System.out.println("SortedByAlg["+i+"]:\t"+sortedByAlg.get(i));
			}
		if(flag!=0) {
			// Do something, if you want.
		}	
		else {
			System.out.println("PASS");
		}
	}
	
	public static double getStdDeviation(long[] array) {
		double avg = LongStream.of(array).average().getAsDouble();
		double sum = LongStream.of(array).asDoubleStream()
							.map( x -> (x-avg)*(x-avg))
							.reduce(0, (a,b) -> (a+b)/array.length );
		return Math.sqrt(sum);
	}
	
	
	public static String randomString(int length) {
		Random rand = new Random();
		char[] tmp = new char[length];
		for(int i=0;i<length;i++)
			tmp[i]=(char)(rand.nextInt(145)+32);		
		return new String(tmp);
	}
	
	
	
	
	
	
}
