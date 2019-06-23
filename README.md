# Java high performance Quicksort
Quicksort algorithm optimized implementation in Java and performance comparison with Java utils Collections.sort().

Exercise of Java programming with generics, trying to get a high performance implementation of the quicksort algorithm for lists with some tests and comparisons with the default Collections.sort() method.


## Some comparisons
### Integers

	Statistics on 100000 sorts of lists of 1000 random Integer
	Collections	avg : 0.0915174 ms	 Std Deviation: 2.52494e-05 ms
	QuickSort	avg : 0.0783190 ms	 Std Deviation: 0.000146805 ms

	Statistics on 1000 sorts of lists of 100000 random Integer
	Collections	avg : 15.6007 ms	 Std Deviation: 0.00275111 ms
	QuickSort	avg : 13.6509 ms	 Std Deviation: 0.0166620 ms
	
	Statistics on 100 sorts of lists of 1000000 random Integer
	Collections	avg : 239.706 ms	 Std Deviation: 1.72933 ms
	QuickSort	avg : 215.788 ms	 Std Deviation: 1.90205 ms
	
### Doubles

	Statistics on 100000 sorts of lists of 1000 random Double
	Collections	avg : 0.0966663 ms	 Std Deviation: 1.15717e-05 ms
	QuickSort	avg : 0.0774790 ms	 Std Deviation: 5.23372e-06 ms

	Statistics on 1000 sorts of lists of 100000 random Double
	Collections	avg : 16.3122 ms	 Std Deviation: 0.0161096 ms
	QuickSort	avg : 14.3338 ms	 Std Deviation: 0.0156966 ms
	
	Statistics on 100 sorts of lists of 1000000 random Double
	Collections	avg : 280.959 ms	 Std Deviation: 2.09132 ms
	QuickSort	avg : 247.493 ms	 Std Deviation: 1.72578 ms
	
## Strings
Testing with Strings of 250 random chars

	Statistics on 1000 sorts of lists of 1000 random String
	Collections	avg : 0.157401 ms	 Std Deviation: 0.000823811 ms
	QuickSort	avg : 0.158797 ms	 Std Deviation: 0.000390629 ms

	Statistics on 1000 sorts of lists of 10000 random String
	Collections	avg : 2.23195 ms	 Std Deviation: 0.00493961 ms
	QuickSort	avg : 2.55720 ms	 Std Deviation: 0.0100697 ms
	
	Statistics on 100 sorts of lists of 100000 random String
	Collections	avg : 42.8703 ms	 Std Deviation: 0.697318 ms
	QuickSort	avg : 40.7592 ms	 Std Deviation: 0.0938920 ms
	
