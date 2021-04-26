package cz.czechitas.java2webapps.ukol3.controller;

import cz.czechitas.java2webapps.ukol3.entity.Vizitka;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

/**
 * Kontroler obsluhující zobrazování vizitek.
 */
@Controller
public class VizitkaController {
    private final List<Vizitka> vizitky;

    public VizitkaController() {
        vizitky = Arrays.asList(
                new Vizitka("Jana Novakova", "Alza s. r. o.", "Hybesova 15", "602 00 Brno",
                        "jn@alza.cz", "608765433", "www.alza.cz"),
                new Vizitka("Petr Smutný", "CZC a. s.", "Hybesova 38", "602 00 Brno",
                        "ps@czc.cz", "608787433", "www.czc.cz"),
                new Vizitka("Adéla Masná", "Net123 s r. o.", "Veveří 3", "606 10 Brno",
                        null, "767890433", "www.net123.cz"),
                new Vizitka("Martin Pavelka", "TSMe k. s.", "Kounicova 1", "602 00 Brno",
                        "mp@tsme.cz", null, "www.tsme.cz"),
                new Vizitka("Jan Hajný", "Les s. r. o.", "Žitná 98", "602 00 Brno",
                        "jh@les.cz", "777843433", null),
                new Vizitka("Lucie Černá", "Divadlo a. s.", "Moravské námestí 15", "602 10 Brno",
                        "lc@adivadlo.cz", null, "www.divadlo.cz")

        );
    }

    @GetMapping("/")
    public ModelAndView seznam() {
        ModelAndView modelAndView = new ModelAndView("seznam");
        modelAndView.addObject("vizitky", vizitky);
        return modelAndView;
    }

    @GetMapping("/detail")
    public ModelAndView detail(int id) {
        ModelAndView nevim = new ModelAndView("detail");
        nevim.addObject("vizitky", vizitky.get(id));
        return nevim;
    }
}
