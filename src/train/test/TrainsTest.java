package train.test;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import train.model.Train;

public class TrainsTest {
	
	/*
	 * Train class is the Java model of a train
	 * Train class has a constructor that takes the train composition as argument (String).
	 * Train composition can be a sequence of the following characters, each
	 * corresponding to a wagon:
	 *  - 'H' represents a locomotive (it can be in leading or trailing position, or both)
	 *  - 'P' represents a passenger wagon
	 *  - 'R' represents a restaurant wagon
	 *  - 'C' represents an empty cargo wagon
	 *  
	 *  
	 *  fill() method fills empty cargo wagons. It must follow these rules:
	 *  	- if there is at least one empty cargo wagon, it fills the first empty cargo wagon 
	 *  	  starting from the left and return true
	 *      - if there is no empty cargo wagon, return false
	 *      
	 *  detachStart() method detach the leading wagon of the train
	 *  detachEnd() method detach the trailing wagon of the train
	 *  
	 *  print() method of Train class gives an alternative String representation of the train,
	 *    in such a way that:
	 *  - Each wagon is separated by the "::" string
	 *  - Leading locomotive corresponds to "<HHHH" String
	 *  - Trailing locomotive corresponds to "HHHH>" String
	 *  - Passenger wagon corresponds to "|OOOO|" String
	 *  - Restaurant wagon corresponds to "|hThT|" String
	 *  - Empty cargo wagon corresponds to "|____|" String
	 *  - Filled cargo wagon corresponds to "|^^^^|" String
	 * 
	 */

    @Test
    public void printShortPassengerTrain() {
    	System.out.println("--------------------------- START TEST 1");
        Train train = new Train("HPP");
        assertEquals("<HHHH::|OOOO|::|OOOO|", train.print());
        System.out.println("--------------------------- END TEST 1");
    }

    @Test
    public void printPassengerTrainWithRestaurant() {
    	System.out.println("--------------------------- START TEST 2");
        Train train = new Train("HPRP");
        assertEquals("<HHHH::|OOOO|::|hThT|::|OOOO|", train.print());
        System.out.println("--------------------------- END TEST 2");
    }

    @Test
    public void printDoubleHeadedPassengerTrain() {
    	System.out.println("--------------------------- START TEST 3");
        Train train = new Train("HPPPH");
        assertEquals("<HHHH::|OOOO|::|OOOO|::|OOOO|::HHHH>", train.print());
        System.out.println("--------------------------- END TEST 3");
    }

    @Test
    public void printModifiedTrain() {
    	System.out.println("--------------------------- START TEST 4");
        Train train = new Train("HPRPH");
        assertEquals("<HHHH::|OOOO|::|hThT|::|OOOO|::HHHH>", train.print());
        train.detachEnd();
        assertEquals("<HHHH::|OOOO|::|hThT|::|OOOO|", train.print());
        train.detachFront();
        assertEquals("|OOOO|::|hThT|::|OOOO|", train.print());
        System.out.println("--------------------------- END TEST 4");
    }

    @Test
    public void printCargoTrain() {
    	System.out.println("--------------------------- START TEST 5");
        Train train = new Train("HCCC");
        assertEquals("<HHHH::|____|::|____|::|____|", train.print());
        train.fill();
        assertEquals("<HHHH::|^^^^|::|____|::|____|", train.print());
        train.fill();
        assertEquals("<HHHH::|^^^^|::|^^^^|::|____|", train.print());
        train.fill();
        assertEquals("<HHHH::|^^^^|::|^^^^|::|^^^^|", train.print());
        assertEquals(false, train.fill());
        System.out.println("--------------------------- END TEST 5");
    }

    @Test
    public void printMixedTrain() {
    	System.out.println("--------------------------- START TEST 6");
        Train train = new Train("HPCCP");
        assertEquals("<HHHH::|OOOO|::|____|::|____|::|OOOO|", train.print());
        train.fill();
        assertEquals("<HHHH::|OOOO|::|^^^^|::|____|::|OOOO|", train.print());
        train.fill();
        assertEquals("<HHHH::|OOOO|::|^^^^|::|^^^^|::|OOOO|", train.print());
        assertEquals(false, train.fill());
        System.out.println("--------------------------- END TEST 6");
    }

}
