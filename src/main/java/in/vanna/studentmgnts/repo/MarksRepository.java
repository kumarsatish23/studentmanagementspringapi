package in.vanna.studentmgnts.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.vanna.studentmgnts.binding.MarksDTLS;

public interface MarksRepository extends JpaRepository<MarksDTLS, Serializable> {
	@Query("SELECT (sChem + sMath + sPhysics)/3 FROM MarksDTLS m WHERE m.sId = ?1")
	public Long getPercentage(Integer sId);

}
