@Service
public class UserService {

    @Autowired
    private AdvisorRepository advisorRepository;

    // Other dependencies injection

    public List<Advisor> getAllAdvisors() {
        return advisorRepository.findAll();
    }

    // Other service methods
}
