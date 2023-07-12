package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.dto.ProductDTO;
import org.acme.entity.ProductEntity;
import org.acme.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
// aplicationscoped é uma notação como @service ou @repositor
// esta notação da ao quarkus o poder de gerenciar está classe
@ApplicationScoped
public class ProductService {

    @Inject //  faz a injecao da classe (dependencia) simialr ao @autowired
    ProductRepository productRepository;

    public List<ProductDTO> getAllProducts(){

        List<ProductDTO> products = new ArrayList<>();

        productRepository.findAll().stream().forEach(item -> {
            products.add(mapProductEntityToDTO(item));
        });
        return products;
    }

    public void createNewProduct(ProductDTO productDTO){
        productRepository.persist(mapProductDTOTOEntity(productDTO));
    }

    public void changeProduct(Long id,ProductDTO productDTO){

        ProductEntity productEntity = productRepository.findById(id);

        productEntity.setName(productDTO.getName());
        productEntity.setCategory(productDTO.getCategory());
        productEntity.setModel(productDTO.getModel());
        productEntity.setDescription(productDTO.getDescription());
        productEntity.setPrice(productDTO.getPrice());

        productRepository.persist(productEntity);

    }

    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }



    private ProductDTO mapProductEntityToDTO(ProductEntity productEntity){

        ProductDTO product = new ProductDTO();

        product.setName(productEntity.getName());
        product.setDescription(productEntity.getDescription());
        product.setCategory(productEntity.getCategory());
        product.setModel(productEntity.getModel());
        product.setPrice(productEntity.getPrice());
        return product;
    }

    private ProductEntity mapProductDTOTOEntity(ProductDTO productDTO){

        ProductEntity product = new ProductEntity();

        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setCategory(productDTO.getCategory());
        product.setModel(productDTO.getModel());
        product.setPrice(productDTO.getPrice());
        return product;
    }



}
