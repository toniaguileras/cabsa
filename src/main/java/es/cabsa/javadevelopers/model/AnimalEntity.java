package es.cabsa.javadevelopers.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "animal", schema="jungle")
public class AnimalEntity
{

	@Id
	private Integer id;
	private String name;
	private Integer legs;

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Integer getLegs()
	{
		return legs;
	}

	public void setLegs(Integer legs)
	{
		this.legs = legs;
	}

}
