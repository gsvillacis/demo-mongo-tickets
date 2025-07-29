package com.utpl.demo_mongo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.utpl.demo_mongo.models.Ticket;
import com.utpl.demo_mongo.repository.TicketRepository;
import com.utpl.demo_mongo.enums.Estado;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    
    @Autowired
    private TicketRepository ticketRepository;
    
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }
    
    public Optional<Ticket> getTicketById(String id) {
        return ticketRepository.findById(id);
    }
    
    public Ticket saveTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }
    
    public void deleteTicket(String id) {
        ticketRepository.deleteById(id);
    }
    
    public List<Ticket> getTicketsByEstado(Estado estado) {
        return ticketRepository.findByEstado(estado);
    }
    
    public List<Ticket> getPendingTickets() {
        return getAllTickets().stream()
                .filter(ticket -> ticket.getEstado() == Estado.NUEVO || ticket.getEstado() == Estado.EN_PROCESO)
                .collect(java.util.stream.Collectors.toList());
    }
    
    public List<Ticket> searchByNombrePersona(String nombrePersona) {
        return ticketRepository.findByNombrePersonaContainingIgnoreCase(nombrePersona);
    }
    
    public List<Ticket> searchByAplicacionAfectada(String aplicacionAfectada) {
        return ticketRepository.findByAplicacionAfectadaContainingIgnoreCase(aplicacionAfectada);
    }
}
