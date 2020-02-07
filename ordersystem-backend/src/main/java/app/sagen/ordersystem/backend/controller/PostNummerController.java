package app.sagen.ordersystem.backend.controller;

import app.sagen.ordersystem.backend.model.PostNummer;
import app.sagen.ordersystem.backend.service.PostNummerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/zip")
public class PostNummerController {

    private PostNummerService postNummerService;

    @Autowired
    public PostNummerController(PostNummerService postNummerService) {
        this.postNummerService = postNummerService;
    }

    /*
     * GET /zip
     * Returns 200 and an array of all zip-code objects
     */
    @GetMapping("")
    public ResponseEntity<List<PostNummer>> all() {
        return new ResponseEntity<>(postNummerService.findAll(), HttpStatus.OK);
    }

    /*
     * GET /zip/{zip-code}
     * Returns 404 if not found
     * Returns 200 and the zip-code object if OK
     */
    @GetMapping("{zip}")
    public ResponseEntity<PostNummer> one(@PathVariable String zip) {
        Optional<PostNummer> postNummer = postNummerService.find(zip);
        if(postNummer.isEmpty()) return ResponseEntity.notFound().build();
        return new ResponseEntity<>(postNummer.get(), HttpStatus.OK);
    }

}
