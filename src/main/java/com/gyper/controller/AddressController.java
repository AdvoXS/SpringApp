package com.gyper.controller;

import com.gyper.repository.AddressRepository;
import com.gyper.entity.Address;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class AddressController {
    private final AddressRepository addressRepository;

    public AddressController(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @GetMapping("/address")
    public String address(@RequestParam(name = "address", required = false, defaultValue = "World") String address, Model model) {
        model.addAttribute("address", address);
        return "address";
    }

    @GetMapping
    public String main(Map<String, Object> map) {
        findAll(map);
        return "main";
    }

    /*@PostMapping
    public String addAddress(@RequestParam String city, @RequestParam String street, @RequestParam String homeNumber, Map<String, Object> map) {
        Address address = new Address(city, street, homeNumber);
        userRepository.save(address);
        findAll(map);
        return "main";
    }*/

    private void findAll(Map<String, Object> map) {
        Iterable<Address> addresses = addressRepository.findAll();
        map.put("addresses", addresses);
    }

    /*@GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        Address address = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

        model.addAttribute("address", address);
        return "update";
    }

    @PostMapping("/update/{id}")
    public String updateAddress(@PathVariable("id") int id, Address address, Model model) {
        userRepository.save(address);

        return "main";
    }*/
}
