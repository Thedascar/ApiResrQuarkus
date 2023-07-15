package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.entity.ProductEntity;

// aplicationscoped é uma notação como @service ou @repository
// esta notação da ao quarkus o poder de gerenciar está classe
@ApplicationScoped
public class ProductRepository implements PanacheRepository<ProductEntity> {
}
