package com.book.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Books {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_sequence")
	@SequenceGenerator(name = "book_sequence", sequenceName = "book_sequence", allocationSize = 1)
	private int id;

	private String name;
	private String author;
	private String price;
}
