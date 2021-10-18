package io.github.caiocldias.desenvolvedores.Desenvolvedores.rest;

import io.github.caiocldias.desenvolvedores.Desenvolvedores.model.entity.Desenvolvedor;
import io.github.caiocldias.desenvolvedores.Desenvolvedores.model.repository.DesenvolvedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import sun.security.krb5.internal.crypto.Des;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/developers")
@CrossOrigin("http://localhost:4200")
public class DesenvolvedorController {


    private final DesenvolvedorRepository repository;

    @Autowired
    public DesenvolvedorController(DesenvolvedorRepository repository){
        this.repository = repository;
    }

    @GetMapping
    public List<Desenvolvedor> getDevs(@RequestParam(value = "nome", required = false) String nome){
        if(nome != ""){
            return  repository.findByName("%" + nome + "%");
        }else{
            return repository.findAll();
        }
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Desenvolvedor saveDev(@RequestBody @Valid Desenvolvedor dev){
        return repository.save(dev);
    }

    @GetMapping("{id}")
    public Desenvolvedor getDevById(@PathVariable Integer id){
        return  repository
                .findById(id).
                orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDev(@PathVariable Integer id){
        repository
                .findById(id).map(dev -> {
                    repository.delete(dev);
                    return Void.TYPE;
                })
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }

    @PutMapping("{id}")
    public void updateDev(@PathVariable Integer id, @RequestBody @Valid Desenvolvedor devAtualizado){
        repository
                .findById(id).map(dev -> {
                    dev.setNome(devAtualizado.getNome());
                    dev.setSexo(devAtualizado.getSexo());
                    dev.setDataNascimento(devAtualizado.getDataNascimento());
                    dev.setIdade(devAtualizado.getIdade());
                    dev.setHobby(devAtualizado.getHobby());
                    return repository.save(dev);
                })
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }

}
