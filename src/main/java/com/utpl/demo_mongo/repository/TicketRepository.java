package com.utpl.demo_mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.utpl.demo_mongo.models.Ticket;
import com.utpl.demo_mongo.enums.Estado;
import java.util.List;

@Repository
public interface TicketRepository extends MongoRepository<Ticket, String> {
    
    List<Ticket> findByEstado(Estado estado);
    List<Ticket> findByNombrePersonaContainingIgnoreCase(String nombrePersona);
    List<Ticket> findByAplicacionAfectadaContainingIgnoreCase(String aplicacionAfectada);
}
