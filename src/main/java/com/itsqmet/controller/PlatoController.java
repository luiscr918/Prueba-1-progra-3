package com.itsqmet.controller;

import com.itsqmet.entity.Plato;
import com.itsqmet.service.PlatoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class PlatoController {
    @Autowired
    private PlatoService platoService;
    //mostrar los platos e incluir seccion para filtrar por categoria
    @GetMapping("/platos")
    public String mostrarPlatos(@RequestParam(name = "nombreCategoria",required = false,defaultValue = "")
            String nombreCategoria,Model model){
        List<Plato> platos=platoService.filtrarPorCategoria(nombreCategoria);
        model.addAttribute("nombreCategoria", nombreCategoria);
        model.addAttribute("platos", platos);
        return "pages/menuRestaurante";
    }
    //Insertar nuevo Plato
    @GetMapping("/formulario-platos")
    public String mostrarFormPlatos(Model model){
        model.addAttribute("plato",new Plato());
        return "pages/registroPlato";
    }
    @PostMapping("/guardar-plato")
    public String guardarPlato(@Valid @ModelAttribute Plato plato,
                               BindingResult bindingResult,Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("errores",bindingResult.getAllErrors());
            return "pages/registroPlato";
        }else{
            platoService.guardarPlato(plato);
            return "redirect:/platos";
        }
    }
    //Actualizar Plato
    @GetMapping("/actualizar-plato/{id}")
    public String actualizarPlato(@PathVariable long id,Model model){
        Optional<Plato> plato= platoService.buscarPorId(id);
        model.addAttribute("plato", plato);
        return "pages/registroPlato";
    }
    //Eliminar Libro
    @GetMapping("/eliminar-plato/{id}")
    public String eliminarPlato(@PathVariable long id){
        platoService.eliminarPlato(id);
        return "redirect:/platos";
    }
}
