package Controller;

@RestController
public class StudeentController {
	@Autowired
	private StudentService studentService;
	@GetMapping("/students")
	public ResponseEntity<List<StudentDto>> getAllStudents() {
		List<StudentDto> students = studentService.getAllStudents();
		return new ResponseEntity<>(students, HttpStatus.OK);
	}
	@PostMapping("/student")
	public ResponseEntity<StudentDto> getAllStudents(@RequestBody StudentDto studentDto) {
		StudentDto std = studentService.addStudent(studentDto);
		return new ResponseEntity<>(std, HttpStatus.CREATED);
	}

	@PutMapping("/student/{id}")
	public ResponseEntity<StudentDto> updateEmployee(@PathVariable(name = "id") Integer id,
	public ResponseEntity<StudentDto> updateStudent(@PathVariable(name = "id") Integer id,
			@RequestBody StudentDto student) {
		StudentDto std = studentService.updateStudent(id, student);
		return new ResponseEntity<>(std, HttpStatus.CREATED);
	}
	@DeleteMapping("/student/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable(name = "id") Integer studentId) {
		String message = studentService.deleteStudent(studentId);
		return new ResponseEntity<>(message, HttpStatus.OK);
	}
}

