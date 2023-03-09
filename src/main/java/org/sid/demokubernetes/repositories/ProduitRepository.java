package org.sid.demokubernetes.repositories;

import org.sid.demokubernetes.entities.Produit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProduitRepository extends JpaRepository<Produit,Long> {
}
