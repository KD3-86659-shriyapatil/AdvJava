package com.sunbeam.dto;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class BaseEntityDTO {
	private Long id;
	private LocalDate createdOn;
	private LocalDate updatedOn;
}
