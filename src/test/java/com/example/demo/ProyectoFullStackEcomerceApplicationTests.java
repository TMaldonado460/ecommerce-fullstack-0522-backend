package com.example.demo;

import com.example.demo.repository.UserInfoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProyectoFullStackEcomerceApplicationTests {
    @Autowired
    UserInfoRepository userInfoRepository;

	@Test
	void contextLoads() {


	}

    @Test
    void checkFindByEmail(){


    }

}
