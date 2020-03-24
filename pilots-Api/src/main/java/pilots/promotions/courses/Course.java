package pilots.promotions.courses;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

//import com.fasterxml.jackson.annotation.JsonBackReference;

import pilots.promotions.topics.Topic;


@Entity
@Table(name = "course")
public class Course {
	
	@Id
	String id;
	String name;
	
	@JoinColumn(name = "topicId", nullable = false)
	@ManyToOne( fetch = FetchType.LAZY,targetEntity = Topic.class)   
	@NotNull
	 private Topic topic;
	
	//@NotFound(action = NotFoundAction.IGNORE)
		//@JsonBackReference
	
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topics) {
		this.topic = topics;
		
	}
	public Course() {
		
		
	}
	public Course(String name, String id,String topicID) {
		super();
		this.name = name;
		this.id = id;
		this.topic=new Topic(topicID,"");
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	

}
