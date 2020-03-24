package pilots.promotions.topics;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	@Autowired
	private TopicService topicservice;
	
	
	
	
	
	@RequestMapping("/topic")
	public List<Topic> topic() {
		return topicservice.getTopics();
	}
	
	@RequestMapping ("/topics/{id}")
	public Topic getTopic(@PathVariable  String id ) {
		return topicservice.gettopic(id);
		
	}
		
	@RequestMapping (method = RequestMethod.POST,value = "/topic/add")
	public void addTopic(@RequestBody Topic newTopic)
	{
		topicservice.add(newTopic);
	}
	
	@RequestMapping (method = RequestMethod.PUT, value = "/topic/{updateid}")
	public void update(@RequestBody Topic replaceTopic,@PathVariable String updateid) {
		topicservice.update(replaceTopic,updateid);
	}
	
	@RequestMapping (method = RequestMethod.DELETE,value= "/topic/{deleteId}")
	public void delete(@PathVariable String deleteId) {
		topicservice.delete(deleteId);
	}
	
	@RequestMapping (method = RequestMethod.GET,value = "/topic/{id}/getname")
	public String name (@PathVariable String id) {
		
		return topicservice.name(id);
		
	}
	
	@RequestMapping (method = RequestMethod.GET,value = "/topic/getid/{name}")
	public String id(@PathVariable String name) {
		return topicservice.id(name);
		
	}
	
}
