package in.vanna.studentmgnts.service;

import java.util.List;

import in.vanna.studentmgnts.binding.ClassDTLS;

public interface ClassService {
	public String studentToClass(ClassDTLS classDTLS);

	public List<Integer> allStudentsInClass(Integer sClass);

}
