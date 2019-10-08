package com.blydenburgh.kgraphqldemo.dao.entity

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "game")
data class Game(
    @Id
    val id: String = UUID.randomUUID().toString(),

    @Column
    var date: String? = null,

    @Column
    var boxScoreUrl: String? = null,

    @Column
    var playByPlayUrl: String? = null,

    @ManyToOne
    var homeTeam: Team? = null,

    @ManyToOne
    var awayTeam: Team? = null
)