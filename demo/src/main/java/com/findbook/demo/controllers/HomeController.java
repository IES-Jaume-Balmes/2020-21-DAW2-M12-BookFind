
@Controller
public class HomeController {

    @Autowired


    @GetMapping("")
    public String home(Model model) {
        return "main/home";
    }
}