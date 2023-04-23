package in.vanna.studentmgnts.repo;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import in.vanna.studentmgnts.binding.ClassDTLS;

@EnableJpaRepositories

public interface ClassRepository extends JpaRepository<ClassDTLS, Serializable> {
	@Query("SELECT sId FROM ClassDTLS c WHERE c.sClass = ?1")
	List<Integer> allStudentsInClass(Integer sClass);

	@Query("SELECT c FROM ClassDTLS c WHERE c.sId = ?1")
	ClassDTLS updateStudent(Integer sId);

}
