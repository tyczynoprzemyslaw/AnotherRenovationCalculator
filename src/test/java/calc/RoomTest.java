package calc;

import logic.Room;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RoomTest {

	String name = "testowy";
	double wallA = 3;
	double wallB = 4;
	double high = 2.5;
	double expected = 47;


	@Test
	public void testAnalyzeRoombyParams_correctArguments_returnTrue() {

		//given

		Room room = new Room(this.name, this.wallA, this.wallB, this.high);

		//when
		double result = room.totalArea();

		//then
		Assertions.assertEquals(expected, result);
	}
		@Test
		public void testAnalyzeRoombyParams_incorrectArguments_returnTrue() {

			//given
			String name= "testowy";
			double wallA=1;
			double wallB=1;
			double high=1;
			Room room = new Room(name,wallA,wallB,high);

			//when
			double result = room.totalArea();

			//then
			Assertions.assertEquals(5, result);
		}
		
	}


