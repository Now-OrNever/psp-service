package com.scaffolding;

import com.scaffolding.model.*;
import com.scaffolding.repository.CategoryRepository;
import com.scaffolding.repository.LaptopRepository;
import com.scaffolding.repository.ProductRepository;
import com.scaffolding.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ScaffoldingMain {

    public static void main(String[] args) {
        SpringApplication.run(ScaffoldingMain.class, args);
    }

    @Bean
    public CommandLineRunner demo(StudentRepository studentRepository, LaptopRepository laptopRepository, CategoryRepository categoryRepository, ProductRepository productRepository) {
        return new DemoRunner(studentRepository, laptopRepository, categoryRepository, productRepository);
    }

    // Define a separate class to encapsulate the demo logic
    @Component
    public static class DemoRunner implements CommandLineRunner {
        private final StudentRepository studentRepository;
        private final LaptopRepository laptopRepository; // Add this line
        private final CategoryRepository categoryRepository;
        private final ProductRepository productRepository;

        public DemoRunner(
                StudentRepository studentRepository,
                LaptopRepository laptopRepository,
                CategoryRepository categoryRepository,
                ProductRepository productRepository) {
            this.studentRepository = studentRepository;
            this.laptopRepository = laptopRepository;
            this.categoryRepository = categoryRepository;
            this.productRepository = productRepository;
        }

        @Override
        @Transactional
        public void run(String... args) throws Exception {

            // ONE TO ONE
//            Student student = new Student();
//            student.setStudentID(1);
//            student.setStudentName("Krishna");
//            student.setAbout("I am the Supreme Personality of Godhead");
//
//            Laptop laptop = new Laptop(1, "108", "hp", student);
////            laptopRepository.save(laptop);   // cascade property will automatically do this job
//            student.setLaptop(laptop); // ?????????
//
//            // Save the student to the database using the repository
//            studentRepository.save(student);


//            // ONE TO MANY
//
//            Student student = new Student();
//            student.setStudentID(2);
//            student.setStudentName("Chaitanya");
//            student.setAbout("I am in the bhav of Internal Potency of the Supreme Personality of Godhead");
//
//            Adress a1 = new Adress(1, "GND Street", "Goloka", "IND", student);
//            Adress a2 = new Adress(2, "GTR Street", "VRN", "IND", student);
//
//            List<Adress> adressList = new ArrayList<>();
//            adressList.add(a1);
//            adressList.add(a2);
//            student.setAdressList(adressList);
//
//            studentRepository.save(student);



//            // MANY TO MANY
//            Product product1 = new Product("p1_id", "p1_name");
//            Product product2 = new Product("p2_id", "p2_name");
//            Product product3 = new Product("p3_id", "p3_name");
//
//
//
//            Category category1 = new Category("cat1_id", "cat1_name");
//            Category category2 = new Category("cat2_id", "cat2_name");
//
//            categoryRepository.save(category1);
//            categoryRepository.save(category2);
//
//            List<Product> C1productList = category1.getProductList();
//
//            C1productList.add(product1);
//            C1productList.add(product2);
//            C1productList.add(product3);
//            List<Product> C2productList = category2.getProductList();
//            C2productList.add(product2);
//            C2productList.add(product3);
//
//            List<Category> P1Category = product1.getCategoryList();
//            P1Category.add(category1);
//
//            List<Category> P2Category = product2.getCategoryList();
//            P2Category.add(category2);
//
//            List<Category> P3Category = product3.getCategoryList();
//            P3Category.add(category1);
//            P3Category.add(category2);
//
//
//            categoryRepository.save(category1);
//            categoryRepository.save(category2);\


            int product = categoryRepository.getById("cat1_id").getProductList().size();
            System.out.println(product);

            int category = productRepository.getReferenceById("p1_id").getCategoryList().size();
            System.out.println(category);




        }
    }
}
