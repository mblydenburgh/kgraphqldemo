package com.blydenburgh.kgraphqldemo.dao.repository

import com.blydenburgh.kgraphqldemo.dao.entity.Player
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PlayerRepository: JpaRepository<Player,String> {
}