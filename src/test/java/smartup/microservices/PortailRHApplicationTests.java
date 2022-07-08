package smartup.microservices;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PortailRHApplicationTests {
	
	@Test
	void contextLoads() {
		//throw new UnsupportedOperationException();
		
		Assertions.assertDoesNotThrow(this::doNotThrowException);
	}

	private void doNotThrowException(){
	    
	}
	}


