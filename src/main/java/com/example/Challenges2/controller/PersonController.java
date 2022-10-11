package com.example.Challenges2.controller;
import com.example.Challenges2.dao.PersonDao;
import com.example.Challenges2.model.Person;
import com.example.Challenges2.service.PersonServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonServiceInterface personeService;

    @GetMapping("/person")
    public ResponseEntity<Object> getAllPersons() {
        List<PersonDao> appList;
        try{
            appList = personeService.getAllPerson();}
        catch(Exception e){
            appList = null;
            System.out.println(e);
        }
        return ResponseEntity.ok().header("OK!").body(appList);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createPerson(@RequestBody Person acc){
        Person appDetail = personeService.createPerson(acc);
        return ResponseEntity.ok().header("Created!").body(appDetail);
    }

    @GetMapping("/person/{id}")
    @ResponseBody
    public ResponseEntity<Object> getPersonById(@PathVariable("id") int id){

        Person person = personeService.getPersonById(id);

        return ResponseEntity.ok().body(person);
    }

    @PutMapping("/update/{id}")
    @ResponseBody
    public ResponseEntity<Object> updatePerson(@PathVariable(name = "id") int id, @RequestBody Person person){
        personeService.updatePerson(person.getId(), person.getAddress(), person.getPostcode(), person.getJob(), person.getEmail(), person.getAge(), person.getPhoneNumber());
        return ResponseEntity.ok("Updated!");
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<Object> deleteAppointment(@PathVariable int id){
        personeService.deleteAcc(id);
        return ResponseEntity.ok("Deleted");
    }
}