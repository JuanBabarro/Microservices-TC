package com.springmicroservices.users_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO { //Creamos un DTO ya que users va a consultar post, por lo tanto va a traer un Post

    private Long id;
    private String title;
    private Long user_id;
}
