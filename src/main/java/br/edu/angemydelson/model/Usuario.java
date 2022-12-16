package br.edu.angemydelson.model;
import org.apache.commons.codec.digest.DigestUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name = "usuario")
public class Usuario {


    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "sequencia")
    @SequenceGenerator(name="sequencia", sequenceName="usuario_seq", initialValue = 1, allocationSize = 1)
    @Column(name = "id_usuario")
    private Integer id;

    
    @NotNull
    @Size(min = 3, max = 30)
    @Pattern(regexp = "[^0-9]*")
    @Column(name = "nome")
    private String usuario;
    
    @NotEmpty
    @NotNull
    @Size(min = 3, max = 30)
    private String senha;
    // byte[] hash1 = DigestUtils.sha256("senha"); 
    
    @NotNull
    @NotEmpty
    @Email
    @Column(name = "email")
    private String email;
    
    @NotNull
    @NotEmpty
    @CPF
    private String cpf;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
