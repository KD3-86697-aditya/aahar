package com.aahar.entity;




import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;


@MappedSuperclass
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BaseClass{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;
	@Column(name = "created_on")
	@CreationTimestamp
	private LocalDate createdOn;
	@Column(name = "updated_on")
	@UpdateTimestamp
	private LocalDate updatedOn;
	
}
