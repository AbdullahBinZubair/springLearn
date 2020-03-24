package pilots.promotions.courses;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pilots.promotions.topics.Topic;

@RestController
public class CourseController {
	@Autowired
	private CourseService courseservice;
	
	@RequestMapping("/hello")
	public String Hello() {
		return "my name is abz virk";
	}
	
	@RequestMapping("/topic/{topicId}/course")
	public List<Course> courses(@PathVariable String topicId) {
		
		return courseservice.getCourses( topicId);
	}
	
	@RequestMapping ("/topic/{topicId}/course/{courseId}")
	public Course getCourse(@PathVariable  String courseId ) {
		return courseservice.getCourse(courseId);
		
	}
	
		
	@RequestMapping (method = RequestMethod.POST,value = "/topic/{topicId}/course/add")
	public void addCourse(@RequestBody Course newCourse,@PathVariable String topicId)
	{
		newCourse.setTopic(new Topic(topicId, ""));
		courseservice.add(newCourse);
	}
	
	@RequestMapping (method = RequestMethod.PUT, value = "/topic/{topiId}/course/{updateid}")
	public void update(@RequestBody Course replaceCourse,@PathVariable String topicId,@PathVariable String updateid) {
		
		replaceCourse.setTopic(new Topic(topicId,""));
		courseservice.update(replaceCourse);
	}
	
	@RequestMapping (method = RequestMethod.DELETE,value= "/topic/course/{deleteId}")
	public void delete(@PathVariable String deleteId) {
		courseservice.delete(deleteId);
	}
	
	@RequestMapping (method = RequestMethod.GET,value = "/topic/course/{id}/getname")
	public String name (@PathVariable String id) {
		
		return courseservice.name(id);
		
	}
	
	@RequestMapping (method = RequestMethod.GET,value = "/topic/course/getid/{name}")
	public String id(@PathVariable String name) {
		return courseservice.id(name);
		
	}
	
}
