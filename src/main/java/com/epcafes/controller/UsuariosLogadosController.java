package com.epcafes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.epcafes.service.UsuariosLogadosService;

import lombok.extern.java.Log;

@Log
@Controller
public class UsuariosLogadosController {
    
    @Autowired
    private UsuariosLogadosService usuariosLogadosService;

    @GetMapping("/usuarioslogados/usuarioslogados")
    public String usuariosLogados(Model model) {
        log.info("acessando página de usuários logados");

        model.addAttribute("usuariosLogados", usuariosLogadosService.getUsuariosLogados());
        return "usuarioslogados/usuarioslogados";
    }
}
