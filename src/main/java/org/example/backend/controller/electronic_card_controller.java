package org.example.backend.controller;

import org.example.backend.entity.electronic_card;
import org.example.backend.service.electronic_card_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/electronic_card")
public class electronic_card_controller {
    @Autowired
    private electronic_card_service ElectronicCardService;
    @PostMapping("/")
    public ResponseEntity<electronic_card> create_card(@RequestBody electronic_card card){
        electronic_card created_card=ElectronicCardService.create_card(card);
        return new ResponseEntity<>(created_card,HttpStatus.CREATED);
    }//创建电子名片
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete_card(@PathVariable Integer id){
        ElectronicCardService.delete_card(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }//删除电子名片
    @PutMapping("/{id}")
    public ResponseEntity<electronic_card> update_card(@PathVariable Integer id,@RequestBody electronic_card card) {
        card.setId(id);
        electronic_card updated_card = ElectronicCardService.update_card(card);
        if (updated_card != null) {
            return new ResponseEntity<>(updated_card, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }//修改电子名片
    @GetMapping("/all")
    public ResponseEntity<List<electronic_card>> find_card(){
        List<electronic_card> cards = ElectronicCardService.find_card();
        return new ResponseEntity<>(cards,HttpStatus.OK);
    }//查询电子名片
    @GetMapping("/")
    public ResponseEntity<Page<electronic_card>> find_cards_by_page(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size){
        Page<electronic_card> cards=ElectronicCardService.find_cards_by_page(page,size);
        return new ResponseEntity<>(cards,HttpStatus.OK);
    }//分页查询电子名片
    @GetMapping("/{id}")
    public ResponseEntity<electronic_card> get_by_id(@PathVariable Integer id){
        electronic_card card=ElectronicCardService.find_by_id(id);
        if (card != null){
            return new ResponseEntity<>(card, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }//根据id查询电子名片
}