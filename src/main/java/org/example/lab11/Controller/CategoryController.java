package org.example.lab11.Controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.lab11.Api.ApiResponse;
import org.example.lab11.Model.Category;
import org.example.lab11.Service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/get")
    public ResponseEntity getAllCategory(){

        return ResponseEntity.status(200).body(categoryService.getAllCategory());
    }


    @PostMapping("/add")
    public ResponseEntity addCategory(@RequestBody @Valid Category category, Errors errors){
        if(errors.hasErrors()){
            String message= errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        categoryService.addCategory(category);
        return ResponseEntity.status(200).body(new ApiResponse("added"));
    }



    @PutMapping("/update/{id}")
    public ResponseEntity updateCategory(@PathVariable Integer id,@RequestBody @Valid Category category,Errors errors){
        if(errors.hasErrors()){
            String message= errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        categoryService.updateCategory(id, category);
        return ResponseEntity.status(200).body(new ApiResponse("updated"));
    }



    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCategory(@PathVariable Integer id){
        categoryService.deleteCategory(id);
        return ResponseEntity.status(200).body(new ApiResponse("deleted"));
    }


    @GetMapping("/get-category-id/{id}")
    public ResponseEntity getCategoryById(@PathVariable Integer id) {
        return ResponseEntity.status(200).body(categoryService.getCategoryById(id));
    }

    @GetMapping("/get-category-name/{name}")
    public ResponseEntity getCategoryById(@PathVariable String name) {
        return ResponseEntity.status(200).body(categoryService.getCategoryByName(name));
    }
}
