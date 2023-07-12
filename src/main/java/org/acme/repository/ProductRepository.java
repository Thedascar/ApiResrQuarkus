package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.entity.ProductEntity;

@ApplicationScoped // aplicationscoped é uma notação como @service ou @repositor
// esta notação da ao quarkus o poder de gerenciar está classe
public class ProductRepository implements PanacheRepository<ProductEntity> {
}
