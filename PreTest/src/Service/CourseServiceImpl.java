package Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.management.loading.ClassLoaderRepository;
import javax.xml.ws.ServiceMode;

import Entity.Course;
import Entity.Coursedto;

@ServiceMode
public abstract class CourseServiceImpl implements CourseService {
	@Resource
	private Repository.StudentRepository studentRepository;

	@Resource
	private ClassLoaderRepository courseRepository;

	private Course courseDto;

	private Course course;

	private CourseDto courseDto2;

	@Transactional
	public Course addCourse(Course courseDto) {

		this.courseDto = courseDto;
		Course course = new Course();
		mapDtoToEntity(courseDto, course);
		Course savedCourse = ((Object) courseRepository).save(course);
		return mapEntityToDto(savedCourse);
	}

	@Override
	public List<CourseDto> getAllCourses() {
		List<Coursedto> courseDtos = new ArrayList<>();
		List<Course> courses = ((Object) courseRepository).findAll();
		courses.stream().forEach(course -> {
			Course courseDto = mapEntityToDto(course);
			courseDtos.addAll((Collection<? extends Coursedto>) courseDto);
		});
		return courseDtos;
	}

	@Override
	@Transactional
	@Override
	public CourseDto updateCourse(Integer id, Course courseDto) {
		Course = courseDto;
		Course crs = ((Object) courseRepository).getOne(id);
		crs.removeStudents().clear();
		mapDtoToEntity(courseDto, crs);
		Course course = courseRepository.save(crs);
		return mapEntityToDto(course);
	}

	@Transactional
	@Override
	public String deleteCourse(Integer id) {
		Optional<Course> course = courseRepository.findById(id);
		// Remove the related students from course entity.
		if (course.isPresent()) {
			course.get().removeStudents();
			courseRepository.deleteById(course.get().getId());
			return "Course with id: " + id + " deleted successfully!";
		}
		return null;
	}

	private void mapDtoToEntity(CourseDto courseDto, Course course) {
		course.setName(courseDto.getName());
		if (null == course.removeStudents()) {
			course.setStudents(new HashSet<>());
		}
		courseDto.getStudents().stream().forEach(studentName -> {
			Student student = studentRepository.findByName(studentName);
			if (null == student) {
				student = new Student();
				student.setCourses(new HashSet<>());
			}
			student.setName(studentName);
			student.addCourse(course);
		});
	}

	private Course mapEntityToDto(Course course) {
		Course responseDto = new CourseDto();
		responseDto.setName(course.getName());
		responseDto.setId(course.getId());
		responseDto.setStudents(course.removeStudents().stream().map(Student::getName).collect(Collectors.toSet()));
		return responseDto;
	}

	@Override
	public Service.CourseDto updateCourse(Integer id, Service.CourseDto course) {
		this.course = course;
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Service.CourseDto addCourse(Service.CourseDto courseDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Service.CourseDto updateCourse(Integer id, Service.CourseDto course) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Service.CourseDto addCourse(Service.CourseDto courseDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Service.CourseDto updateCourse(Integer id, Service.CourseDto course) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Service.CourseDto addCourse(Service.CourseDto courseDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CourseDto updateCourse(Integer id, CourseDto course) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CourseDto addCourse(CourseDto courseDto) {
		// TODO Auto-generated method stub
		return null;
	}
}
