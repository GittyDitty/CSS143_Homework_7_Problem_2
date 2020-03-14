import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class MaxHeapTest {
    // homework
    @Test
    public void tester() {
        MaxHeap test1 = new MaxHeap(10);
        // assertTrue(test1.add(10));
        Integer[] data = {60, 30, 15, 2, 7, 10, 3};
        test1.MaxHeapN(data);
        test1.MaxHeapLogN(data);
        test1.pop();

        MaxHeap compare = new MaxHeap(10);
        Integer[] data2 = {30, 15, 2, 7, 10,3};
        compare.MaxHeapLogN(data2);

        test1.equals(compare);
        System.out.println(test1);


        //For the performance comparison tests
        //testMaxHeapLogN(7);
        //testMaxHeapN(7);
    }

    private long testMaxHeapLogN(int size){
        MaxHeap tester = new MaxHeap(size);
        Integer[] data = {60,30,15,2,7,10,3};
        long startTime = System.nanoTime();
        tester.MaxHeapLogN(data);
        long endTime = System.nanoTime();
        System.out.println(TimeUnit.MICROSECONDS.convert(endTime-startTime, TimeUnit.NANOSECONDS)); //for data recording
        return TimeUnit.MICROSECONDS.convert(endTime-startTime, TimeUnit.NANOSECONDS);
    }

    private long testMaxHeapN(int size){
        MaxHeap tester2 = new MaxHeap(size);
        Integer[] data = {60,30,15,2,7,10,3};
        long startTime = System.nanoTime();
        tester2.MaxHeapN(data);
        long endTime = System.nanoTime();
        System.out.println(TimeUnit.MICROSECONDS.convert(endTime-startTime, TimeUnit.NANOSECONDS)); //for data recording
        return TimeUnit.MICROSECONDS.convert(endTime-startTime, TimeUnit.NANOSECONDS);
    }
//60,30,15,2,7,10,3


}