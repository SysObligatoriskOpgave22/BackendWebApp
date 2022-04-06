package com.example.backend.api;


import com.example.backend.repositories.CardRepository;
import com.example.backend.repositories.DeckRepository;
import com.example.backend.repositories.PaoCardRepository;
import com.example.backend.repositories.PaoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class CardControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    CardRepository cardRepository;

    @Autowired
    DeckRepository deckRepository;

    @Autowired
    PaoRepository paoRepository;

    @Autowired
    PaoCardRepository paoCardRepository;

    @Autowired
    private ObjectMapper objectMapper;


    static long cardOneId, cardTwoId;


    @BeforeEach
    void setUp() {
        //cardOneId = cardRepository.save(new Card(Rank.ACE, Suit.CLUBS)).getId();
        //cardTwoId = cardRepository.save(new Card(Rank.JACK, Suit.DIAMONDS)).getId();


    }

    @AfterEach
    void tearDown() {
        cardRepository.deleteAll();
        deckRepository.deleteAll();
        paoCardRepository.deleteAll();
        paoRepository.deleteAll();
    }

    @Test
    void getCards() throws Exception {
        String object = "$[?(@.object == '%s')]";
        String person = "$[?(@.person == '%s')]";
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/cards")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0]").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(52))

                .andExpect(MockMvcResultMatchers.jsonPath(object, "Microphone").exists())
                .andExpect(MockMvcResultMatchers.jsonPath(person, "Julian Assange").exists());

    }

    @Test
    void getCardsRandomized() throws Exception {
        String object = "$[?(@.object == '%s')]";
        String person = "$[?(@.person == '%s')]";
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/cards/random")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0]").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(52))

                .andExpect(MockMvcResultMatchers.jsonPath(object, "Microphone").exists())
                .andExpect(MockMvcResultMatchers.jsonPath(person, "Julian Assange").exists())
                .andReturn();

        String content1 = result.getResponse().getContentAsString();

        result = mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/cards/random")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0]").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(52))

                .andExpect(MockMvcResultMatchers.jsonPath(object, "Microphone").exists())
                .andExpect(MockMvcResultMatchers.jsonPath(person, "Julian Assange").exists())
                .andReturn();

        String content2 = result.getResponse().getContentAsString();

        assertNotEquals(content1, content2); //Da der er tale om tilfældighed, kan denne i meget sjældne tilfælde fejle. Prøv derfor igen v. fejl.
    }

    @Test
    void getCard() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/cards/{id}", 0)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.person").value("Arnold Schwarzenegger"));
    }
}