package bdbt_project.SpringApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import java.util.List;
//import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.servlet.http.HttpServletRequest;


@Configuration
public class AppController implements WebMvcConfigurer {

    @Autowired
    private ClientDAO dao;

    @Autowired
    private PracownikDAO daoEmpl;

    @Autowired
    private SaunaDAO daoSauna;

    @Autowired
    private UslugaDAO daoUsluga;

    @Autowired
    private AdresDAO daoAdres;

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/uslugi").setViewName("uslugi");
        registry.addViewController("/login").setViewName("login");

        registry.addViewController("/main_admin").setViewName("admin/main_admin");
        registry.addViewController("/main_user").setViewName("user/main_user");
    }



//    private JdbcTemplate jdbcTemplate;



    @Controller
    public class DashboardController
    {
        @RequestMapping
                ("/main"
                )
        public String defaultAfterLogin
                (HttpServletRequest request) {
            if
            (request.isUserInRole
                    ("ADMIN")) {
                return "redirect:/main_admin";
            }
            else if
            (request.isUserInRole
                            ("USER")) {
                return "redirect:/main_user";
            }
            else
            {
                return "redirect:/index";
            }
        }
        @RequestMapping("/")
        public String viewHomePage(Model model) {
            List<Client> listClient = dao.list();
            model.addAttribute("listClient", listClient);
            return "index";
        }

        @RequestMapping("/main_user")
        public String kutas(Model model) {
            List<Client> listClient = dao.list();
            model.addAttribute("listClient", listClient);
            return "user/main_user";
        }

        @RequestMapping("/main_admin")
        public String kutas3(Model model) {
            List<Client> listClient = dao.list();
            model.addAttribute("listClient", listClient);
            return "admin/main_admin";
        }

//        CUSTOMER MANAGEMENT

        @RequestMapping("/customer_management")
        public String showCustomerManagementPage(Model model) {
            List<Client> listClient = dao.list();
            model.addAttribute("listClient", listClient);
            return "admin/customer_management";
        }

        @RequestMapping(value = "/saveCustomer", method = RequestMethod.POST)
        public String saveCustomer(@ModelAttribute("client") Client client) {
            dao.save(client);

            return "redirect:/customer_management";
        }

        @RequestMapping("/edit_customer/{nr_klienta}")
        public ModelAndView showEditCustomerForm(@PathVariable(name = "nr_klienta") int nr_klienta) {
            ModelAndView mav = new ModelAndView(("admin/edit_customer"));
            Client client = dao.get(nr_klienta);
            mav.addObject("client", client);

            return mav;
        }

        @RequestMapping(value="/update_customer", method = RequestMethod.POST)
        public String updateCustomer(@ModelAttribute("client") Client client) {
            dao.update(client);

            return "redirect:/customer_management";
        }

        @RequestMapping("/delete_customer/{nr_klienta}")
        public String deleteCustomer(@PathVariable(name = "nr_klienta") int nr_klienta) {
            dao.delete(nr_klienta);

            return "redirect:/customer_management";
        }

        @RequestMapping("/new_customer")
        public String addNewCustomer(Model model) {
            Client client = new Client();
            model.addAttribute("client", client);
            return "admin/new_customer";
        }

        @RequestMapping(value = "/save", method = RequestMethod.POST)
        public String save(@ModelAttribute("client") Client client) {
            dao.save(client);

            return "redirect:/customer_management";
        }

//        EMPL MANAGEMENT

        @RequestMapping("/empl_management")
        public String showEmplManagementPage(Model model) {
            List<Pracownik> listPracownik = daoEmpl.list();
            model.addAttribute("listPracownik", listPracownik);
            return "admin/empl_management";
        }

        @RequestMapping(value = "/saveEmpl", method = RequestMethod.POST)
        public String saveEmpl(@ModelAttribute("pracownik") Pracownik pracownik) {
            daoEmpl.save(pracownik);

            return "redirect:/empl_management";
        }

        @RequestMapping("/edit/{nr_pracownika}")
        public ModelAndView showEditForm(@PathVariable(name = "nr_pracownika") int nr_pracownika) {
            ModelAndView mav = new ModelAndView(("admin/edit_empl"));
            Pracownik pracownik = daoEmpl.get(nr_pracownika);
            mav.addObject("pracownik", pracownik);

            return mav;
        }

        @RequestMapping(value="/update", method = RequestMethod.POST)
        public String updateEmpl(@ModelAttribute("pracownik") Pracownik pracownik) {
            daoEmpl.update(pracownik);

            return "redirect:/empl_management";
        }

        @RequestMapping("/delete/{nr_pracownika}")
        public String delete(@PathVariable(name = "nr_pracownika") int nr_pracownika) {
            daoEmpl.delete(nr_pracownika);

            return "redirect:/empl_management";
        }

        @RequestMapping("/new_empl")
        public String addNewEmpl(Model model) {
            Pracownik pracownik = new Pracownik();
            model.addAttribute("pracownik", pracownik);
            return "admin/new_empl";
        }

        @RequestMapping(value = "/savePracownik", method = RequestMethod.POST)
        public String savePracownik(@ModelAttribute("pracownik") Pracownik pracownik) {
            daoEmpl.save(pracownik);

            return "redirect:/empl_management";
        }

//        SAUNA MANAGEMENT

        @RequestMapping("/sauna_management")
        public String showSaunaManagementPage(Model model) {
            List<Sauna> listSauna = daoSauna.list();
            model.addAttribute("listSauna", listSauna);
            return "admin/sauna_management";
        }

        @RequestMapping(value = "/saveSauna", method = RequestMethod.POST)
        public String saveSauna(@ModelAttribute("sauna") Sauna sauna) {
            daoSauna.save(sauna);

            return "redirect:/sauna_management";
        }

        @RequestMapping("/edit_sauna/{nr_sauny}")
        public ModelAndView showEditSaunaForm(@PathVariable(name = "nr_sauny") int nr_sauny) {
            ModelAndView mav = new ModelAndView(("admin/edit_sauna"));
            Sauna sauna = daoSauna.get(nr_sauny);
            mav.addObject("sauna", sauna);

            return mav;
        }

        @RequestMapping(value="/update_sauna", method = RequestMethod.POST)
        public String updateSauna(@ModelAttribute("sauna") Sauna sauna) {
            daoSauna.update(sauna);

            return "redirect:/sauna_management";
        }

        @RequestMapping("/delete_sauna/{nr_sauny}")
        public String deleteSauna(@PathVariable(name = "nr_sauny") int nr_sauny) {
            daoSauna.delete(nr_sauny);

            return "redirect:/sauna_management";
        }

        @RequestMapping("/new_sauna")
        public String addNewAddSauna(Model model) {
            Sauna sauna = new Sauna();
            model.addAttribute("sauna", sauna);
            return "admin/new_sauna";
        }

        @RequestMapping(value = "/saveSauna2", method = RequestMethod.POST)
        public String saveSauna2(@ModelAttribute("sauna") Sauna sauna) {
            daoSauna.save(sauna);

            return "redirect:/sauna_management";
        }

//        USLUGA MANAGEMENT

        @RequestMapping("/service_management")
        public String showServiceManagementPage(Model model) {
            List<Usluga> listUsluga = daoUsluga.list();
            model.addAttribute("listUsluga", listUsluga);
            return "admin/service_management";
        }

        @RequestMapping(value = "/saveService", method = RequestMethod.POST)
        public String saveService(@ModelAttribute("usluga") Usluga usluga) {
            daoUsluga.save(usluga);

            return "redirect:/service_management";
        }

        @RequestMapping("/edit_service/{nr_uslugi}")
        public ModelAndView showEditServiceForm(@PathVariable(name = "nr_uslugi") int nr_uslugi) {
            ModelAndView mav = new ModelAndView(("admin/edit_service"));
            Usluga usluga = daoUsluga.get(nr_uslugi);
            mav.addObject("usluga", usluga);

            return mav;
        }

        @RequestMapping(value="/update_service", method = RequestMethod.POST)
        public String updateSauna(@ModelAttribute("usluga") Usluga usluga) {
            daoUsluga.update(usluga);

            return "redirect:/service_management";
        }

        @RequestMapping("/delete_service/{nr_uslugi}")
        public String deleteService(@PathVariable(name = "nr_uslugi") int nr_uslugi) {
            daoUsluga.delete(nr_uslugi);

            return "redirect:/service_management";
        }

        @RequestMapping("/new_service")
        public String addNewService(Model model) {
            Usluga usluga = new Usluga();
            model.addAttribute("usluga", usluga);
            return "admin/new_service";
        }

        @RequestMapping(value = "/saveUsluga", method = RequestMethod.POST)
        public String saveUsluga(@ModelAttribute("usluga") Usluga usluga) {
            daoUsluga.save(usluga);

            return "redirect:/service_management";
        }

//        ADRES MANAGEMENT

        @RequestMapping("/address_management")
        public String showAddressManagementPage(Model model) {
            List<Adres> listAdres = daoAdres.list();
            model.addAttribute("listAdres", listAdres);
            return "admin/address_management";
        }

        @RequestMapping(value = "/saveAddress", method = RequestMethod.POST)
        public String saveAddress(@ModelAttribute("adres") Adres adres) {
            daoAdres.save(adres);

            return "redirect:/address_management";
        }

        @RequestMapping("/edit_address/{nr_adresu}")
        public ModelAndView showEditAddressForm(@PathVariable(name = "nr_adresu") int nr_adresu) {
            ModelAndView mav = new ModelAndView(("admin/edit_address"));
            Adres adres = daoAdres.get(nr_adresu);
            mav.addObject("adres", adres);

            return mav;
        }

        @RequestMapping(value="/update_address", method = RequestMethod.POST)
        public String updateAddress(@ModelAttribute("adres") Adres adres) {
            daoAdres.update(adres);

            return "redirect:/address_management";
        }

        @RequestMapping("/delete_address/{nr_adresu}")
        public String deleteAddress(@PathVariable(name = "nr_adresu") int nr_adresu) {
            daoAdres.delete(nr_adresu);

            return "redirect:/address_management";
        }

        @RequestMapping("/new_address")
        public String addNewAddress(Model model) {
            Adres adres = new Adres();
            model.addAttribute("adres", adres);
            return "admin/new_address";
        }

        @RequestMapping(value = "/saveAdres", method = RequestMethod.POST)
        public String saveAdres(@ModelAttribute("adres") Adres adres) {
            daoAdres.save(adres);

            return "redirect:/address_management";
        }








    }

    @RequestMapping(value={"/main_admin"})
    public String showAdminPage(Model model) {
        return "admin/main_admin";
    }
    @RequestMapping(value={"/main_user"})
    public String showUserPage(Model model) {
        return "user/main_user";
    }
}