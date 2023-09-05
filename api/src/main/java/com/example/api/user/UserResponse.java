package com.example.api.user;

import java.util.Objects;

public class UserResponse{
	private int id;
	private String firtname;
	private String lastname;

	public void setFirtname(String firtname){
		this.firtname = firtname;
	}

	public String getFirtname(){
		return firtname;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setLastname(String lastname){
		this.lastname = lastname;
	}

	public String getLastname(){
		return lastname;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		UserResponse that = (UserResponse) o;
		return id == that.id && Objects.equals(firtname, that.firtname) && Objects.equals(lastname, that.lastname);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, firtname, lastname);
	}

	@Override
 	public String toString(){
		return 
			"UserResponse{" + 
			"firtname = '" + firtname + '\'' + 
			",id = '" + id + '\'' + 
			",lastname = '" + lastname + '\'' + 
			"}";
		}
}
