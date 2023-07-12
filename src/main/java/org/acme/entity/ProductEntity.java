package org.acme.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity // indica que é uma classe de entidade do bd do pacote hibernate
@Table(name = "product") // a table indica em qual tabela do bd a entidade sera mapeada
@Data // Data ja cria os getters e setter da classe
@AllArgsConstructor // jaz o construtor com os dados
@NoArgsConstructor // faz o construtor vazio
public class ProductEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String description;

    private String category;

    private String model;

    private BigDecimal price;
}
