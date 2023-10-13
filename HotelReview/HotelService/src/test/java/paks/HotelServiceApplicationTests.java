package paks;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import paks.Entities.hotel;
import paks.servicez.hotelservice;

@SpringBootTest
class HotelServiceApplicationTests {

	@Autowired
	private hotelservice  hs;
	@Test
	void contextLoads() {
		hotel f =new hotel();
		f.setName("shinning smads");
f.setAbout("on the beach ");
f.setLocation("Baga");
		hotel  h =this.hs.addhotel(f);
	}

}
