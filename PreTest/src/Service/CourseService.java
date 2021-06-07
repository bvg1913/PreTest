package Service;

import java.util.List;

import com.asb.example.dto.CourseDto;

import Entity.Course;

public interface CourseService {
	
	public CourseDto updateCourse(Integer id, CourseDto course);

	public String deleteCourse(Integer id);

	public CourseDto addCourse(CourseDto courseDto);

	public List<CourseDto> getAllCourses();

	Service.CourseDto updateCourse(Integer id, Course courseDto);

}
