package Entity;


import java.beans.Statement;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import Repository.Student;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "COURSE")

public class Course {
	
	private static final String GenerationType = null;
	@Id
	@Generated(strategy = GenerationType.SEQUENCE, generator = "course_sequence")
	@SequenceGenerator(name = "course_sequence", sequenceName = "course_sequence")
	private Integer id;
	@Column(name = "name")
	private String name;
	@ManyToMany(mappedBy = "courses")
	@JsonIgnore
	private Set<Statement> students;

	public void removeStudent(Object student) {
		this.removeStudents().remove(student);
		student.getClass().remove(this);
	}

	public void removeStudents() {
		for (Statement student : new HashSet<>(students)) {
			removeStudent(student);
		}
	}

	public Object getName() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setStudents(HashSet hashSet) {
		// TODO Auto-generated method stub
		
	}
	}

