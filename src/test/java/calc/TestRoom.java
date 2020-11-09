package calc;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

import logic.Room;

public class TestRoom {

		@Test
		public void testAnalyzeRoombyParams_correctArguments_returnTrue() {
			
			//given
			String name= "testowy";
			double wallA=3;
			double wallB=4;
			double high=2.5;
			Room room = new Room(name,wallA,wallB,high);
			
			//when
			double result = room.totalArea();
			
			//then
			Assertions.assertEquals(47.0, result);
			
			
			
		}
}
