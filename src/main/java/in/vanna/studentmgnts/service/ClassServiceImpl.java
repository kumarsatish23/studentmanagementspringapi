package in.vanna.studentmgnts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.vanna.studentmgnts.binding.ClassDTLS;
import in.vanna.studentmgnts.repo.ClassRepository;
import in.vanna.studentmgnts.repo.StudentRepository;

@Service
public class ClassServiceImpl implements ClassService {
	@Autowired
	private ClassRepository classRepository;
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public String studentToClass(ClassDTLS classDTLS) {
		if (!studentRepository.findById(classDTLS.getSId()).isEmpty()
				&& !classRepository.existsById(classDTLS.getSId())) {
			classRepository.save(classDTLS);
			return "success\n" + String.valueOf(studentRepository.findById(classDTLS.getSId())) + classDTLS.toString()
					+ " Added";
		} else {
			return "failed adding student to class Student with Id " + String.valueOf(classDTLS.getSId());
		}
	}

	@Override
	public List<Integer> allStudentsInClass(Integer sClass) {
		return classRepository.allStudentsInClass(sClass);
	}

}
