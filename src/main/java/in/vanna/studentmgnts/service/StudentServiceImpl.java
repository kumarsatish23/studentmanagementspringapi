package in.vanna.studentmgnts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.vanna.studentmgnts.binding.StudentDTLS;
import in.vanna.studentmgnts.repo.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public String addStudent(StudentDTLS studentDTLS) {
		studentRepository.save(studentDTLS);
		return "Success \n Student Details : " + studentDTLS.toString();
	}

	@Override
	public List<StudentDTLS> getAllStudents() {
		return studentRepository.findAll();
	}

}
