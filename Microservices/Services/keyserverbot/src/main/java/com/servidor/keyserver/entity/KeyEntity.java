package com.servidor.keyserver.entity;

import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="keytb")
public class KeyEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Size(min=1,max=1)
	@NotNull
	@Column(name="keystate")
	private int keystate;
	
	@Column(name="keycontent")
	@Size(min=29,max=29)
	@NotBlank
	private String keycontent;
	
	@Column(name="serialnumber")
	private String serialnumber;

	@Column(name="dh_bloq_activ")
	private Date dhBloqActiv;
	
	@Column(name="disk")
	@Size(max=4)
	private int disk;
	
	@Column(name="memory")
	@Size(max=2)
	private int memory;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getKeystate() {
		return keystate;
	}

	public void setKeystate(int keystate) {
		this.keystate = keystate;
	}

	public String getKeycontent() {
		return keycontent;
	}

	public void setKeycontent(String keycontent) {
		this.keycontent = keycontent;
	}

	public String getSerialnumber() {
		return serialnumber;
	}

	public void setSerialnumber(String serialnumber) {
		this.serialnumber = serialnumber;
	}

	public Date getDhBloqActiv() {
		return dhBloqActiv;
	}

	public void setDhBloqActiv(Date dhBloqActiv) {
		this.dhBloqActiv = dhBloqActiv;
	}

	public int getDisk() {
		return disk;
	}

	public void setDisk(int disk) {
		this.disk = disk;
	}

	public int getMemory() {
		return memory;
	}

	public void setMemory(int memory) {
		this.memory = memory;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dhBloqActiv, disk, id, keycontent, keystate, memory, serialnumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KeyEntity other = (KeyEntity) obj;
		return Objects.equals(dhBloqActiv, other.dhBloqActiv) && disk == other.disk && id == other.id
				&& Objects.equals(keycontent, other.keycontent) && keystate == other.keystate && memory == other.memory
				&& Objects.equals(serialnumber, other.serialnumber);
	}
	
}
