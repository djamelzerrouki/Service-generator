package com.djamel.entities;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

public class Employe  {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
//	@Column(nullable=false, unique=true  )
	@Column(unique=true)
	@NotEmpty(message="ne peut pas être vide !")
	@Size(min = 2, message = "Le nom doit comporter plus de deux lettres")
	private String name;
	@NotEmpty(message="ne peut pas être vide !")
	@Size(min = 8 , message = "Le mot de passe doit comporter 8 caractères ou plus .")
	private String password;
	@Pattern(regexp = "[0][5-7][0-9]{8}", message = "Numéro de portable invalide.")
	@Size(max = 10, message = "les chiffres doivent être 10")
	private String tlphon; 

	//	@ManyToOne
	//  	private Service service;
	//	@DateTimeFormat(pattern="yyyy-MM-dd")   
	//    private Date datenes;
  
	private boolean enabled;
 
 
	@ManyToMany(cascade=CascadeType.MERGE)
	@JoinTable(
			name="employes_role",
			joinColumns={@JoinColumn(name="EMPLOYE_ID", referencedColumnName="id")},
			inverseJoinColumns={@JoinColumn(name="ROLE_ID", referencedColumnName="id")})
	private List<Role> roles;

 

}
