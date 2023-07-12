package org.acme.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

import java.math.BigDecimal;


@Data // Data ja cria os getters e setter da classe
@AllArgsConstructor // jaz o construtor com os dados
@NoArgsConstructor // faz o construtor vazio
@Jacksonized // infirma que essa classe pode receber json
public class ProductDTO {

    private String name;

    private String description;

    private String category;

    private String model;

    private BigDecimal price;
}
