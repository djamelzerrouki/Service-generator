package com.djamel.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

public class Service  {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	
 	@Column(unique=true)
	@NotEmpty(message="ne peut pas être vide !")
	@Size(min = 2, message = "Le nom doit comporter plus de deux lettres")
	private String name;
 	private String ip;
	
	@Column(unique=true)
	@Pattern(regexp = "[0-9]{4}", message = "Numéro de port invalide.")
	@NotEmpty(message="Prt ne peut pas être vide !")
	private String port; 
	private String path; 
 
  

}
