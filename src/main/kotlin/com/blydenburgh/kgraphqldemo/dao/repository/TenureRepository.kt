package com.blydenburgh.kgraphqldemo.dao.repository

import com.blydenburgh.kgraphqldemo.dao.entity.Tenure
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TenureRepository: JpaRepository<Tenure,String> {

}