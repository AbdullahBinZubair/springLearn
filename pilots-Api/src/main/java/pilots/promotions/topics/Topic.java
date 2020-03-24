package pilots.promotions.topics;



import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;

//import javax.persistence.Table;

//import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
//@Table(name = "Topic")
public class Topic {
	
	@Id
	@Column(name = "topicId")
	String topicId;
	String name;
	//@OneToMany( fetch = FetchType.EAGER,cascade = CascadeType.ALL, mappedBy ="topic")
	//@JsonManagedReference
	// List<Course> courseList;
	
	public Topic() {	
	}
	
	/*public void add(Course course) {
		if (courseList==null) {
			courseList=new ArrayList<>();
			
		}
		course.topic=this;
		courseList.add(course);
	}*/
	public Topic(String name, String id) {
		super();
		this.name = name;
		this.topicId = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return topicId;
	}
	public void setId(String id) {
		this.topicId = id;
	}
	
	
	

}
