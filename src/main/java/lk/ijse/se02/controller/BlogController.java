package lk.ijse.se02.controller;

import lk.ijse.se02.entity.Blog;
import lk.ijse.se02.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/blog")
@CrossOrigin
public class BlogController {
  @Autowired
private BlogRepository blogRepository;


  @GetMapping("/hello")
    public String hello(){
        return "Hello world";
    }

    @PostMapping("/number")
    public int getNumber(){
        return 2;
    }

    @GetMapping("data/{id}")
    public String getId(@PathVariable String id) {
        return  id;
    }
     @GetMapping("object")
    public Object getObject(){
      Blog blog = new Blog();
      return  blog;
     }

      @PostMapping("/savepost")
      public void savePost(@RequestBody Blog blog){
        blogRepository.save(blog);

           }

      @GetMapping("/getallpost")
      public List<Blog> getAllPost() {
          return blogRepository.findAll();
      }

       @PutMapping("/updatepost")
          public void updatePost(@RequestBody Blog blog){
              blogRepository.save(blog);


       }

    @DeleteMapping("/deletepost/{id}")
    public void deletePost(@PathVariable int id){
        blogRepository.deleteById(id);


    }


      }

