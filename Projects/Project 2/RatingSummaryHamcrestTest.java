package project2;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;

public class RatingSummaryHamcrestTest {

  @Test 
  public void testEquals() { 
  	RatingSummary rs1 = new RatingSummary("A1EE2E3N7PW666", 2);
	RatingSummary rs2 = rs1;
	
    assertThat(rs1, equalTo(rs2)); 

  } 

} 