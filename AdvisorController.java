@RestController
@RequestMapping("/admin/advisor")
public class AdvisorController {

    @Autowired
    private AdvisorRepository advisorRepository;

    @PostMapping("/")
    public ResponseEntity<Void> addAdvisor(@RequestBody Advisor advisor) {
        if (advisor.getName() == null || advisor.getPhotoUrl() == null) {
            return ResponseEntity.badRequest().build();
        }

        advisorRepository.save(advisor);
        return ResponseEntity.ok().build();
    }
}
