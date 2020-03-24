package pilots.promotions.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hello {

	@RequestMapping("/helloo")
	public String Hello() {
		return "hi my name is abz";
	}
}
