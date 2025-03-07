package org.example.backend.service;

import org.example.backend.entity.electronic_card;
import org.example.backend.repository.electronic_card_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class electronic_card_service {
    @Autowired
    private electronic_card_repository ElectronicCardRepository;
    public electronic_card create_card(electronic_card card){
        return ElectronicCardRepository.save(card);
    }//创建电子名片
    public void delete_card(Integer id){
        ElectronicCardRepository.deleteById(id);
    }//删除电子名片
    public electronic_card update_card(electronic_card card){
        Optional<electronic_card> existing_card=ElectronicCardRepository.findById(card.getId());
        if (existing_card.isPresent()){
            electronic_card updated_card=existing_card.get();
            updated_card.setName(card.getName());
            updated_card.setWorkplace(card.getWorkplace());
            updated_card.setPosition(card.getPosition());
            updated_card.setTelephone_number(card.getTelephone_number());
            updated_card.setEmail_address(card.getEmail_address());
            return ElectronicCardRepository.save(updated_card);
        }else {
            return null;
        }
    }//修改电子名片
    public List<electronic_card> find_card(){
        return ElectronicCardRepository.findAll();
    }//查询电子名片
    public Page<electronic_card> find_cards_by_page(int page,int size){
        Pageable pageable = PageRequest.of(page,size);
        return ElectronicCardRepository.findAll(pageable);
    }//分页查询电子名片
    public electronic_card find_by_id(Integer id){
        Optional<electronic_card> card = ElectronicCardRepository.findById(id);
        return card.orElse(null); // 如果找不到返回null
    }//根据id查询电子名片
}