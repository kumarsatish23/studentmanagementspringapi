package in.vanna.studentmgnts.binding;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Entity
@Table
public class MarksDTLS {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@JsonProperty("sId")
	private Integer sId;
	@JsonProperty("math")
	@Min(0)
	@Max(100)
	private Integer sMath;
	@JsonProperty("physics")
	@Min(0)
	@Max(100)
	private Integer sPhysics;
	@JsonProperty("chem")
	@Min(0)
	@Max(100)
	private Integer sChem;

}
