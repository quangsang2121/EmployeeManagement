package com.sang.ManageEmployee.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "setting")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Setting {
	@Id
	private String name;
	
	private String value;
}
