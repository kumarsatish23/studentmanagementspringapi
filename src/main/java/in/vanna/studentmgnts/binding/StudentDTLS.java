package in.vanna.studentmgnts.binding;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Entity
@Table
public class StudentDTLS {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sId;
	@JsonProperty("name")
	private String sName;
	@JsonProperty("age")
	private Integer sAge;

}
