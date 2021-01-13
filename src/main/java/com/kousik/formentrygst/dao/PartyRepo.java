package com.kousik.formentrygst.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kousik.formentrygst.model.Party;

public interface PartyRepo extends JpaRepository<Party,Long> {

}
