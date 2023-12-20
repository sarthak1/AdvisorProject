@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    public void testGetAdvisorsForUser() throws Exception {
        // Mocking service response
        List<Advisor> mockAdvisors = Arrays.asList(
            new Advisor(1L, "Advisor 1", "photo1.jpg"),
            new Advisor(2L, "Advisor 2", "photo2.jpg")
        );
        Mockito.when(userService.getAllAdvisors()).thenReturn(mockAdvisors);

        // Perform GET request
        mockMvc.perform(MockMvcRequestBuilders.get("/user/123/advisor"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)))
            .andExpect(MockMvcResultMatchers.jsonPath("$[0].name", Matchers.is("Advisor 1")))
            .andExpect(MockMvcResultMatchers.jsonPath("$[1].name", Matchers.is("Advisor 2")));
    }

    // Other tests for UserController
}
