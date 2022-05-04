package com.example.demo;

import com.example.demo.repository.BillRepository;
import com.example.demo.repository.UserInfoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import java.util.UUID;

@SpringBootTest
class ProyectoFullStackEcomerceApplicationTests {
    @Autowired
    UserInfoRepository userInfoRepository;

    @Autowired
    BillRepository billRepository;

	@Test
	void contextLoads() {
	}

    @Test
    void checkFindByEmail(){
        userInfoRepository.findByEmail("hola@mail.com");
        billRepository.findAllByUserInfoIdOrderByDate(new UUID(1,1), Sort.by("date"));

    }

}
