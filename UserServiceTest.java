@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    private AdvisorRepository advisorRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void testGetAllAdvisors() {
        // Mocking repository response
        List<Advisor> mockAdvisors = Arrays.asList(
            new Advisor(1L, "Advisor 1", "photo1.jpg"),
            new Advisor(2L, "Advisor 2", "photo2.jpg")
        );
        Mockito.when(advisorRepository.findAll()).thenReturn(mockAdvisors);

        // Call service method
        List<Advisor> advisors = userService.getAllAdvisors();

        // Assertions
        Assert.assertEquals(2, advisors.size());
        Assert.assertEquals("Advisor 1", advisors.get(0).getName());
        Assert.assertEquals("photo2.jpg", advisors.get(1).getPhotoUrl());
    }

    // Other tests for UserService
}
