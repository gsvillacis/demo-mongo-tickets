package com.utpl.demo_mongo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.utpl.demo_mongo.models.Ticket;
import com.utpl.demo_mongo.service.TicketService;
import com.utpl.demo_mongo.enums.Estado;
import com.utpl.demo_mongo.enums.Prioridad;
import com.utpl.demo_mongo.enums.GrupoResolutor;
import com.utpl.demo_mongo.enums.AplicacionAfectada;
import java.util.Optional;

@Controller
@RequestMapping("/tickets")
public class TicketController {
    
    @Autowired
    private TicketService ticketService;
    
    @GetMapping
    public String listTickets(Model model) {
        model.addAttribute("tickets", ticketService.getAllTickets());
        model.addAttribute("pageTitle", "Consultar Tickets");
        model.addAttribute("pageDescription", "Todos los tickets del sistema");
        return "tickets/list";
    }
    
    @GetMapping("/pending")
    public String listPendingTickets(Model model) {
        model.addAttribute("tickets", ticketService.getPendingTickets());
        model.addAttribute("pageTitle", "Atender Tickets");
        model.addAttribute("pageDescription", "Selecciona un ticket para atender");
        model.addAttribute("isAttendMode", true);
        return "tickets/attend";
    }
    
    @GetMapping("/attend/{id}")
    public String showAttendForm(@PathVariable String id, Model model) {
        Optional<Ticket> ticket = ticketService.getTicketById(id);
        if (ticket.isPresent()) {
            model.addAttribute("ticket", ticket.get());
            model.addAttribute("estados", Estado.values());
            return "tickets/attend-form";
        }
        return "redirect:/tickets/pending";
    }
    
    @PostMapping("/attend")
    public String attendTicket(@ModelAttribute Ticket ticket) {
        Optional<Ticket> existingTicket = ticketService.getTicketById(ticket.getId());
        if (existingTicket.isPresent()) {
            Ticket updatedTicket = existingTicket.get();
            updatedTicket.setAccionesRecuperacion(ticket.getAccionesRecuperacion());
            updatedTicket.setEstado(ticket.getEstado());
            ticketService.saveTicket(updatedTicket);
        }
        return "redirect:/tickets";
    }
    
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("ticket", new Ticket());
        model.addAttribute("prioridades", Prioridad.values());
        model.addAttribute("estados", Estado.values());
        model.addAttribute("gruposResolutores", GrupoResolutor.values());
        model.addAttribute("aplicacionesAfectadas", AplicacionAfectada.values());
        return "tickets/form";
    }
    
    @PostMapping("/save")
    public String saveTicket(@ModelAttribute Ticket ticket) {
        // Si es un ticket nuevo (sin ID), asegurar que se genere automáticamente
        if (ticket.getId() == null || ticket.getId().isEmpty()) {
            ticket.setId(null); // MongoDB generará automáticamente
            if (ticket.getFechaCreacion() == null) {
                ticket.setFechaCreacion(java.time.LocalDateTime.now());
            }
            if (ticket.getEstado() == null) {
                ticket.setEstado(Estado.NUEVO);
            }
        }
        ticketService.saveTicket(ticket);
        return "redirect:/tickets";
    }
    
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable String id, Model model) {
        Optional<Ticket> ticket = ticketService.getTicketById(id);
        if (ticket.isPresent()) {
            model.addAttribute("ticket", ticket.get());
            model.addAttribute("prioridades", Prioridad.values());
            model.addAttribute("estados", Estado.values());
            model.addAttribute("gruposResolutores", GrupoResolutor.values());
            model.addAttribute("aplicacionesAfectadas", AplicacionAfectada.values());
            return "tickets/form";
        }
        return "redirect:/tickets";
    }
    
    @GetMapping("/delete/{id}")
    public String deleteTicket(@PathVariable String id) {
        ticketService.deleteTicket(id);
        return "redirect:/tickets";
    }
    
    @GetMapping("/view/{id}")
    public String viewTicket(@PathVariable String id, Model model) {
        Optional<Ticket> ticket = ticketService.getTicketById(id);
        if (ticket.isPresent()) {
            model.addAttribute("ticket", ticket.get());
            return "tickets/view";
        }
        return "redirect:/tickets";
    }
}
