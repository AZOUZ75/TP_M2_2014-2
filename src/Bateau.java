
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity(name="Bateau")
@Table(name="bateau", uniqueConstraints={
		@UniqueConstraint(name="full_name", columnNames={"family_name"})
})
@Access(AccessType.FIELD)

public class Bateau implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="nom",length=40)
	private String nom;
	
	@OneToMany(cascade=CascadeType.PERSIST)
	
	private List <Marin> equipage = new ArrayList<Marin>() ; 
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Bateau [id=");
		builder.append(id);
		builder.append(", nom=");
		builder.append(nom);
		builder.append(", equipage=");
		builder.append(equipage);
		builder.append("]");
		return builder.toString();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;}
	public List<Marin> getEquipage() {
		return equipage;
	}
	
	
	public void setEquipage(List<Marin> equipage) {
		this.equipage = equipage;
	}
	public void addMarin(Marin m) {
		// TODO Auto-generated method stub
		equipage.add(m);
	}}

