/* 
	Description:
		ZK Essentials
	History:
		Created by dennis

Copyright (C) 2012 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.essentials.entity;

import org.zkoss.bind.annotation.*;

import javax.persistence.*;
import java.io.*;
import java.util.*;

/**
 * Todo entity 
 */
@Entity
@Table(name="apptodo")
public class Todo implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	Integer id;
	
	boolean complete;
	
	@Column(nullable=false,length=128)
	String subject;
	
	@Column(nullable=false,length=128)
	@Enumerated(EnumType.ORDINAL)
	Priority priority;
	
	@Temporal(TemporalType.TIMESTAMP)
	Date date;
	
	String description;
	
	public Todo(){
    }
	
	public Todo(String subject) {
		this.subject = subject;
		this.priority = Priority.LOW;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isComplete() {
		return complete;
	}

	public void setComplete(boolean complete) {
		this.complete = complete;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	@Immutable // avoid ZK creating proxy object for java.sql.Timestamp since it has no empty constructor
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Todo other = (Todo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

//	public static Todo clone(Todo todo) {
//		try {
//			return (Todo) todo.clone();
//		} catch (CloneNotSupportedException e) {
//			// not possible
//		}
//		return null;
//	}

}
