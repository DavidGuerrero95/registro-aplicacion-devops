package com.app.registro.models;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "registro")
@Data
@NoArgsConstructor
public class Registro {

	@Id
	@JsonIgnore
	private String id;

	@NotBlank(message = "El username no puede estar en blanco")
	@Size(max = 20)
	@Indexed(unique = true)
	@Pattern(regexp = "[A-Za-z0-9_.-]+", message = "Solo se permite:'_' o '.' o '-'")
	private String username;

	@NotBlank(message = "La contraseña no puede estar en blanco")
	@Pattern(regexp = "[^ ]*+", message = "Caracter: ' ' (Espacio en blanco) invalido")
	@Size(min = 6, max = 20, message = "La contraseña debe estar entre About 6 y 20 caracteres")
	private String password;

	@NotBlank(message = "Celular no puede estar en blanco")
	@Pattern(regexp = "[0-9]+", message = "Solo numeros")
	@Size(max = 50)
	@Indexed(unique = true)
	private String cellPhone;

	@NotBlank(message = "Email no puede estar en blanco")
	@Size(max = 50)
	@Pattern(regexp = "[^ ]*+", message = "Caracter: ' ' (Espacio en blanco) invalido")
	@Email(message = "Debe ser un email valido")
	@Indexed(unique = true)
	private String email;

	private String codigo;
	private Long minutos;
	private List<String> roles;

}
