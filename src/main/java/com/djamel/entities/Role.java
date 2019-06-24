package com.djamel.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Ramesh Fadatare
 *
 */
@Entity@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
 
public class Role
{
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@Column(nullable=false, unique=true)
	@NotNull
	private String name;
	 	
	@ManyToMany(mappedBy="roles")
	private List<Employe> employes;
	
	
}
