package in.vanna.studentmgnts.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import in.vanna.studentmgnts.binding.StudentDTLS;

public interface StudentRepository extends JpaRepository<StudentDTLS, Serializable> {

}
