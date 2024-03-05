package edu.calpoly.csc366.teamdatabase.supplier;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.UniqueConstraint;

import javax.validation.constraints.NotNull;

@Entity                   // this class maps to a database table
@Table(name = "supplier")   // (may be omitted for default table naming)
public class Supplier {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String firstName;

	@NotNull
	private String lastName;

    @Column(unique = true)
	private String email;

    private String address;

}