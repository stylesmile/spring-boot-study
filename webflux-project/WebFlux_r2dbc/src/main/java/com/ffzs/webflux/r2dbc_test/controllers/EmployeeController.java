package com.ffzs.webflux.r2dbc_test.controllers;

import com.ffzs.webflux.r2dbc_test.models.Employee;
import com.ffzs.webflux.r2dbc_test.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author: ffzs
 * @Date: 2020/8/10 下午4:43
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("employee")
@Slf4j
@RestControllerAdvice
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public Flux<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping (path = "{id}")
    public Mono<Employee> findById(@PathVariable long id) {
        return employeeService.findById(id);
    }

    @GetMapping ("find")
    public Flux<Employee> findByName(@RequestParam("name") String name) {
        return employeeService.findByName(name);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Employee> save(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> update (@RequestBody Employee employee) {
        return employeeService.update(employee);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> delete (@RequestBody Employee employee) {
        return employeeService.delete(employee);
    }

    @DeleteMapping(path = "{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteById (@PathVariable long id) {
        return employeeService.deleteById(id);
    }
}
