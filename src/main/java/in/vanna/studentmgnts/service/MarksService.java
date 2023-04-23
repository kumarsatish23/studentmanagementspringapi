package in.vanna.studentmgnts.service;

import in.vanna.studentmgnts.binding.MarksDTLS;

public interface MarksService {
	public String studentMarks(MarksDTLS marksDTLS);

	public String studentDetails(Integer sId);

	public String promo();

}
