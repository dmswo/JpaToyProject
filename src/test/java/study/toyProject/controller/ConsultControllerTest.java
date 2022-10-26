package study.toyProject.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import study.toyProject.repository.ConsultRepository;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ConsultControllerTest {

    @Autowired
    ConsultRepository consultRepository;

    @Test
    void consultList() {
    }

    @Test
    void consultSave() {
    }
}