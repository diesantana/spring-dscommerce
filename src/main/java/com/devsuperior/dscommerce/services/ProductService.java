package com.devsuperior.dscommerce.services;


import com.devsuperior.dscommerce.dto.ProductDTO;
import com.devsuperior.dscommerce.entities.Product;
import com.devsuperior.dscommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository repository;
    
    @Transactional(readOnly = true)
    public ProductDTO findById(Long id){
        Product product = repository.findById(id).get();
        return new ProductDTO(product);
    }
    
    @Transactional(readOnly = true)
    public Page<ProductDTO> findAll(Pageable pageable){
        Page<Product> result = repository.findAll(pageable);
        return result.map(x -> new ProductDTO(x));
    }
    
    @Transactional
    public ProductDTO insert(ProductDTO productDTO) {
        Product entity = new Product();
        convertDtoToEntity(productDTO, entity);
        return new ProductDTO(repository.save(entity));
    }

    @Transactional
    public ProductDTO update(Long id, ProductDTO productDTO) {
        Product entity = repository.getReferenceById(id);
        convertDtoToEntity(productDTO, entity);
        return new ProductDTO(repository.save(entity));
    }

    // Copia os dados de um DTO para uma entidade
    private void convertDtoToEntity(ProductDTO productDTO, Product entity) {
        entity.setName(productDTO.getName());
        entity.setDescription(productDTO.getDescription());
        entity.setPrice(productDTO.getPrice());
        entity.setImgUrl(productDTO.getImgUrl());
    }
}
