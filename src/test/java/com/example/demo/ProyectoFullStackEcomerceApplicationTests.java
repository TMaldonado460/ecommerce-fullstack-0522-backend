package com.example.demo;

import com.example.demo.repository.BillRepository;
import com.example.demo.repository.ImageRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.security.repository.IUserRepository;
import com.example.demo.service.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProyectoFullStackEcomerceApplicationTests {
    @Autowired
    IUserRepository userInfoRepository;

    @Autowired
    BillRepository billRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ImageRepository imageRepository;

    @Autowired
    ProductService productService;

    @Autowired
    ObjectMapper objectMapper;

	@Test
	void contextLoads() {


	}

//    @Test
//    void checkFindByEmail() throws JsonProcessingException {
//        ImageDTO imageDTO = new ImageDTO();
//        imageDTO.setUrlMiniature("https://essential.vteximg.com.br/arquivos/ids/544181-99-86/316-0384_1.jpg?v=637850384394900000");
//        imageDTO.setUrlFull("https://essential.vteximg.com.br/arquivos/ids/544181-1000-1000/316-0384_1.jpg?v=637850384394900000");
//
//        ImageDTO imageDTO2 = new ImageDTO();
//        imageDTO2.setUrlMiniature("https://essential.vteximg.com.br/arquivos/ids/544549-99-86/316-0384_2.jpg?v=637850388687800000");
//        imageDTO2.setUrlFull("https://essential.vteximg.com.br/arquivos/ids/544549-1000-1000/316-0384_2.jpg?v=637850388687800000");
//
//        ImageDTO imageDTO3 = new ImageDTO();
//        imageDTO3.setUrlMiniature("https://essential.vteximg.com.br/arquivos/ids/544912-99-86/316-0384_3.jpg?v=637850390919100000");
//        imageDTO3.setUrlFull("https://essential.vteximg.com.br/arquivos/ids/544912-1000-1000/316-0384_3.jpg?v=637850390919100000");
//
//        ImageDTO imageDTO4 = new ImageDTO();
//        imageDTO4.setUrlMiniature("https://essential.vteximg.com.br/arquivos/ids/544912-99-86/316-0384_4.jpg?v=637850390919100000");
//        imageDTO4.setUrlFull("https://essential.vteximg.com.br/arquivos/ids/544912-1000-1000/316-0384_4.jpg?v=637850390919100000");
//
//        ImageDTO imageDTO5 = new ImageDTO();
//        imageDTO5.setUrlMiniature("https://essential.vteximg.com.br/arquivos/ids/544912-99-86/316-0384_5.jpg?v=637850390919100000");
//        imageDTO5.setUrlFull("https://essential.vteximg.com.br/arquivos/ids/544912-1000-1000/316-0384_5.jpg?v=637850390919100000");
//
//        ImageDTO imageDTO6 = new ImageDTO();
//        imageDTO6.setUrlMiniature("https://essential.vteximg.com.br/arquivos/ids/544912-99-86/316-0384_6.jpg?v=637850390919100000");
//        imageDTO6.setUrlFull("https://essential.vteximg.com.br/arquivos/ids/544912-1000-1000/316-0384_6.jpg?v=637850390919100000");
//
//        StockDTO stockDTO = new StockDTO();
//        stockDTO.setQuantity(10);
//        stockDTO.setSize("39");
//
//        StockDTO stockDTO2 = new StockDTO();
//        stockDTO2.setQuantity(10);
//        stockDTO2.setSize("40");
//
//        StockDTO stockDTO3 = new StockDTO();
//        stockDTO3.setQuantity(2);
//        stockDTO3.setSize("41");
//
//        StockDTO stockDTO4 = new StockDTO();
//        stockDTO4.setQuantity(0);
//        stockDTO4.setSize("42");
//
//        StockDTO stockDTO5 = new StockDTO();
//        stockDTO5.setQuantity(1);
//        stockDTO5.setSize("43");
//
//
//        ProductDTO productDTO = new ProductDTO();
//        /*
//        "name": "ZAPATILLAS NIKE REVOLUTION 6",
//        "price": "$14.999",
//        "property": "HOMBRE - Nike - Zapatilla",
//        "valoration": 4.5
//         */
//        productDTO.setName("ZAPATILLAS NIKE REVOLUTION 6");
//        productDTO.setPrice(14.999);
//        productDTO.setProperty("GeneroHombre - MarcaNike - CategoríaZapatilla - ProveedorDC3728-003 - AjusteCordones - ColorNegro - DisciplinaRunning");
//        productDTO.setValoration(4.5F);
//        productDTO.setImages(Set.of(imageDTO, imageDTO2, imageDTO3, imageDTO4, imageDTO5, imageDTO6));
//        productDTO.setStock(Set.of(stockDTO, stockDTO2, stockDTO3, stockDTO4, stockDTO5));
//        productDTO.setDescription("<h2>ZAPATILLAS NIKE REVOLUTION 6</h2><br><br><b>COMODIDAD VERSÁTIL CON AMORTIGUACIÓN FLEXIBLE.</b><br><br><i>Por nuevos desafíos en el pavimento. Ata las agujetas 100% recicladas y marca el ritmo al comienzo de tu experiencia de running con la sensación de suavidad del Nike Revolution 6 Next Nature. Sabemos que la comodidad es la clave de una carrera exitosa, así que nos aseguramos de que tus pasos sean amortiguados y flexibles para brindar una pisada suave. Es la evolución de un favorito, con un diseño transpirable confeccionado con al menos un 20% de contenido reciclado por peso.</i><br><br><b>DETALLES</b><br><br>•El antepié lleva una malla acolchada que se extiende a lo largo del cuello para brindar una sensación de comodidad. Las capas adicionales en el cuerpo aportan mayor durabilidad.<br>•Mayor flexibilidad<br>•La entresuela de espuma proporciona una pisada más suave que los Revolution 5. La suela lleva un diseño generado por computadora que crea un efecto natural de pistón mientras corres, lo que proporciona más amortiguación y flexibilidad. Al combinarlos brindan tracción duradera.<br>•Sensación intuitiva<br>•Los puntos de contacto en el talón y la lengüeta crean una sensación natural mientras te quitas el calzado.<br>•Agujetas de poliéster 100% reciclado.<br><br>Zapatillas Nike Revolution 6 De Running Para Hombre Código: Dc3728-003");
//
//        ProductDTO productDTO1 = productService.saveAllProducts(List.of(productDTO)).get(0);
//
//        System.out.println(objectMapper.writeValueAsString(productDTO1));
//    }

    @Test
    void checkCount() throws JsonProcessingException {
        productRepository.countByProperty("GeneroHombre - MarcaNike - CategoríaZapatilla - ProveedorDC3728-003 - AjusteCordones - ColorNegro - DisciplinaRunning");

    }


}
