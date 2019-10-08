package com.blydenburgh.kgraphqldemo.dao.repository

import com.blydenburgh.kgraphqldemo.dao.entity.Player
import com.blydenburgh.kgraphqldemo.dao.entity.Tenure
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface TenureRepository: PagingAndSortingRepository<Tenure,String> {
    fun findTopPlayerOrderByStartDate(player: Player): Tenure
    fun findByPlayer(player: Player): List<Tenure>
}