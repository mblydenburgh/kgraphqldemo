package com.blydenburgh.kgraphqldemo.dao.entity

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "tenure")
data class Tenure (
    @Id
    val id: String = UUID.randomUUID().toString(),

    @ManyToOne
    var player: Player? = null,

    @ManyToOne
    var team: Team? = null,

    @Column
    var startDate: String? = null,

    @Column
    var endDate: String? = null,

    @Column
    var comment: String? = null,

    @Column
    var position: Double = 0.0
    )