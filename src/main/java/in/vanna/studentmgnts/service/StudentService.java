package in.vanna.studentmgnts.service;

import java.util.List;

import in.vanna.studentmgnts.binding.StudentDTLS;

public interface StudentService {
	public String addStudent(StudentDTLS studentDTLS);

	public List<StudentDTLS> getAllStudents();
}
