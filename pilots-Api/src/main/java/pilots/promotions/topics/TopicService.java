package pilots.promotions.topics;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
    private	TopicRepository topicrepository;

	
	public Topic gettopic(String id ) {
			
		return topicrepository.findById(id).get();
		
	}
	
	
	public List<Topic> getTopics() {
	
		List<Topic> topics=new ArrayList<>();
		topicrepository.findAll().forEach(topics::add);
		return topics;
		
	}

	

	public void add(Topic new_topic) {
		
		topicrepository.save(new_topic);
	}

	public void update(Topic replaceTopic, String idp) {
		
		topicrepository.save(replaceTopic);
		
	}

	public void delete(String deleteId) {
		
		topicrepository.deleteById(deleteId);
		
		
	}

	public String name(String courseId) {
		// TODO Auto-generated method stub
		 
		return topicrepository.findById(courseId).get().getName();
		
		//return topics.stream().filter(topic -> topic.getId().equals(courseId)).findFirst().get().getName();
		
	
	}
	
	public String id(String courseName) {
		
		List<Topic> topics=new ArrayList<>();
		 topicrepository.findAll().forEach(topics::add);
		 
		 return topics.stream().filter(topic->topic.getName().equals(courseName)).findFirst().get().getId();
				
		//return topics.stream().filter(topic -> topic.getName().equals(courseName)).findFirst().get().getId();
	}
	
	

}
