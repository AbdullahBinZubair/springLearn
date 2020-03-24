package pilots.promotions.courses;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
    private	CourseRepository courserepository;
	
	public List<Course> getCourses(String topicId) {
	
		
		return courserepository.findByTopicTopicId(topicId);
		//List<Course> courses=new ArrayList<>();
		//courserepository.findAll().forEach(courses::add);
		//return courses;
		
	}

	public Course getCourse(String id ) {
		
		return courserepository.findById(id).get();
		
	}
	
	public void add(Course new_course) {
		
		courserepository.save(new_course);
	}

	public void update(Course replaceCourse) {
		
		courserepository.save(replaceCourse);
		
	}

	public void delete(String deleteId) {
		
		courserepository.deleteById(deleteId);
		
		
	}

	public String name(String courseId) {
		// TODO Auto-generated method stub
		 
		//return courserepository.findAllById(courseId);
		return courserepository.findById(courseId).get().getName();
		
		//return topics.stream().filter(topic -> topic.getId().equals(courseId)).findFirst().get().getName();
		
	
	}
	
	public String id(String courseName) {
		
		List<Course> courses=new ArrayList<>();
		 courserepository.findAll().forEach(courses::add);
		 
		 return courses.stream().filter(topic->topic.getName().equals(courseName)).findFirst().get().getId();
				
		//return topics.stream().filter(topic -> topic.getName().equals(courseName)).findFirst().get().getId();
	}
	
	

}
