package com.springmicroservices.users_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/*
   Creamos userDTO ya que nuestro ENTITY User no guarda una lista de posteos y desde la API "IPostsAPI" vamos a recibir
   una lista de posteos, por lo que es necesario crear una un userDTO para poder agregar una lista para almacenar
   estos posteos, y para guardar estos posteos también creamos PostDTO.
*/

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long user_id;
    private String name;
    private String lastname;
    private String cellphone;
    private List<PostDTO> listaPosteos;

}
