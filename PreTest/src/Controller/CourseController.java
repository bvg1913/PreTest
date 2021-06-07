package Controller;

import java.util.concurrent.CompletionService;

import javax.xml.ws.RequestWrapper;

@RestController
public class CourseController {
	@Autowired
	private CourseService courseService;

	@GetMapping("/courses")
	public ResponseEntity<List<CourseDto>> getAllStudents() {
		List<CourseDto> students = courseService.getAllCourses();
		return new ResponseEntity<>(students, HttpStatus.OK);
	}

	@GetMapping("/course")
	public ResponseEntity<CourseDto> getAllStudents(@RequestWrapper CourseDto courseDto) {
		CourseDto std = CompletionService.addCourse(courseDto);
		return new ResponseEntity<>(std, HttpStatus.CREATED);
	}

	@GetMapping("/course/{id}")
	public ResponseEntity updateCourse(@PathVariable(name = "id") Integer id,
			@RequestWrapper CourseDto course) {
		CourseDto crs = CompletionService.updateCourse(id, course);
		return new ResponseEntity(crs, HttpStatus.CREATED);
	}

	@DeleteMapping("/course/{id}")
	public ResponseEntity<String> deleteCourse(@PathVariable(name = "id") Integer id) {
		String message = courseService.deleteCourse(id);
		return new ResponseEntity<>(message, HttpStatus.OK);
	}

}
