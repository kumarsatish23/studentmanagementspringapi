package in.vanna.studentmgnts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.vanna.studentmgnts.binding.ClassDTLS;
import in.vanna.studentmgnts.binding.MarksDTLS;
import in.vanna.studentmgnts.repo.ClassRepository;
import in.vanna.studentmgnts.repo.MarksRepository;
import in.vanna.studentmgnts.repo.StudentRepository;

@Service
public class MarksServiceImpl implements MarksService {
	@Autowired
	MarksRepository marksRepository;
	@Autowired
	StudentRepository studentRepository;
	@Autowired
	ClassRepository classRepository;

	@Override
	public String studentMarks(MarksDTLS marksDTLS) {
		if (!studentRepository.findById(marksDTLS.getSId()).isEmpty()
				&& !classRepository.findById(marksDTLS.getSId()).isEmpty()
				&& !marksRepository.existsById(marksDTLS.getSId())) {
			marksRepository.save(marksDTLS);
			return "successfully saved marks";
		} else {
			return "failed saving marks Student with Id : " + marksDTLS.getSId();
		}
	}

	@Override
	public String studentDetails(Integer sId) {
		if (marksRepository.existsById(sId)) {
			return "Student Details : " + studentRepository.findById(sId) + classRepository.findById(sId)
					+ marksRepository.findById(sId) + "percentage : " + marksRepository.getPercentage(sId) + "%";
		} else {
			return "Student Id doesnt Exist";
		}
	}

	@Override
	public String promo() {
		List<MarksDTLS> students = marksRepository.findAll();
		for (MarksDTLS m : students) {
			if (marksRepository.getPercentage(m.getSId()) > 30) {
				ClassDTLS c = classRepository.updateStudent(m.getSId());
				c.setSClass(c.getSClass() + 1);
				classRepository.save(c);
			}
			marksRepository.delete(m);
		}
		return "done";
	}

}
