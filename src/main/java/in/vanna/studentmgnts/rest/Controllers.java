package in.vanna.studentmgnts.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.vanna.studentmgnts.binding.ClassDTLS;
import in.vanna.studentmgnts.binding.ClassDto;
import in.vanna.studentmgnts.binding.MarksDTLS;
import in.vanna.studentmgnts.binding.MarksDto;
import in.vanna.studentmgnts.binding.StudentDTLS;
import in.vanna.studentmgnts.binding.StudentDto;
import in.vanna.studentmgnts.service.ClassService;
import in.vanna.studentmgnts.service.MarksService;
import in.vanna.studentmgnts.service.StudentService;

@RestController
public class Controllers {
	@Autowired
	private StudentService studentService;
	@Autowired
	private ClassService classService;
	@Autowired
	private MarksService marksService;

	@PostMapping("/student")
	public String addStudent(@RequestBody StudentDto studentDto) {
		StudentDTLS studentDTLS = new StudentDTLS();
		studentDTLS.setSName(studentDto.getSName());
		studentDTLS.setSAge(studentDto.getSAge());
		return studentService.addStudent(studentDTLS);
	}

	@GetMapping("/allstudents")
	public List<StudentDTLS> allStudents() {
		return studentService.getAllStudents();
	}

	@PostMapping("/class")
	public String addStudentToClass(@RequestBody ClassDto classDto) {
		ClassDTLS classDTLS = new ClassDTLS();
		classDTLS.setSId(classDto.getSId());
		classDTLS.setSClass(classDto.getSClass());
		return classService.studentToClass(classDTLS);
	}

	@PostMapping("/marks")
	public String saveMarks(@Valid @RequestBody MarksDto marksDto) {
		MarksDTLS marksDTLS = new MarksDTLS();
		marksDTLS.setSId(marksDto.getSId());
		marksDTLS.setSMath(marksDto.getSMath());
		marksDTLS.setSPhysics(marksDto.getSPhysics());
		marksDTLS.setSChem(marksDto.getSChem());

		return marksService.studentMarks(marksDTLS);
	}

	@GetMapping("/student/{sId}")
	public String studentPercentage(@PathVariable Integer sId) {
		return marksService.studentDetails(sId);
	}

	@GetMapping("/class/{sClass}")
	public List<Integer> getallStudentInClass(@PathVariable Integer sClass) {
		return classService.allStudentsInClass(sClass);
	}

	@GetMapping("/promo")
	public String promoteStudent() {
		return marksService.promo();
	}

}
