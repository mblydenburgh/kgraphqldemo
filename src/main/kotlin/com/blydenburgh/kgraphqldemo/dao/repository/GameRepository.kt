package com.blydenburgh.kgraphqldemo.dao.repository

import com.blydenburgh.kgraphqldemo.dao.entity.Game
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface GameRepository: PagingAndSortingRepository<Game,String> {
}