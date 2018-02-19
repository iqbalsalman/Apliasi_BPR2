package com.iqbal.salman.aplikasibpr.Controller.master;


import com.iqbal.salman.aplikasibpr.master.Agama;
import com.iqbal.salman.aplikasibpr.service.AgamaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Timestamp;
import java.time.LocalDateTime;


@Controller
@RequestMapping("/agama")
public class AgamaController {

    @Autowired
    private AgamaService agamaService;


    /**
     * localhost:8080/agama/   localhost:8080/agama/list
     *
     * @return
     */

    @GetMapping(value = {"/", "/list"})
    public String lisAgama(ModelMap params) {
        params.addAttribute("lisAgama", agamaService.findAll());
        return "/pages/agama/list";
    }

    @GetMapping("/form")
    public String formAgama(Agama agama, ModelMap params) {
        params.addAttribute("agama", agama);
        return "/pages/agama/form";
    }
    @GetMapping("/form/{id}")
    public String formAgama(@PathVariable (value = "id") String idup, ModelMap params, RedirectAttributes redirectAttributes) {
        Agama agama = agamaService.findById(idup);
        if (agama != null) {
            params.addAttribute("agama", agama);
            return "/pages/agama/form";
        }else{
//            params.addAttribute("agama",new Agama());
            redirectAttributes.addFlashAttribute("notAvailabel","Data Tidak ditemukan");
            return "redirect:/agama/list";
        }
    }

    @PostMapping("/submit")
    public String submitAgama(@ModelAttribute Agama agama,RedirectAttributes redirectAttributes) {
        agama.setCreatedDate(Timestamp.valueOf(LocalDateTime.now()));
        agama.setCreatedBy("admin");
        agamaService.save(agama);
        redirectAttributes.addFlashAttribute("alertSuccess", "Data berhasil disimpan");
        return "redirect:/agama/list";
    }


    @RequestMapping("/hapus/delete/{id}")
    public String delete(@PathVariable(value = "id") String id) {
        agamaService.delete(id);
        return "redirect:/agama/list";
    }

}