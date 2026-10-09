package br.com.marcosvxn.spring_boot_essentials.controller;

import jakarta.validation.constraints.NotEmpty;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1/hello")
public class HelloWolrdController {

 //   @GetMapping
 //   public String helloWorld(){
 //       return "Hello World!";
  //  }

  //  @GetMapping
  //  public ResponseEntity<String> helloWorld(){
   //     return ResponseEntity.ok("Hello World!");
   // }

  //  @GetMapping
  //  public ResponseEntity<String> HelloWorld(){
  //      return new ResponseEntity<>("Hello World!", HttpStatus.OK);
  //  }

    //@GetMapping(value = "/{id}")
    //@ResponseStatus(HttpStatus.OK)
    //public String get(@PathVariable("id") String id){
    //    return "Hello World " + id;
    //}

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String get1(@RequestParam(value = "name", required = true) @NotEmpty String name){
        return "Hello World " + name;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String post(@RequestBody String name){
        return "Hello World " + name;
    }

}
