package dev.m1stwng.sturdy;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class SturdyApplicationTests {

	@Test
	void contextLoads() {
	}

}
