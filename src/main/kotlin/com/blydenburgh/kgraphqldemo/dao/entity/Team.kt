package com.blydenburgh.kgraphqldemo.dao.entity

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "team")
data class Team (
    @Id
    val id: String? = null,

    @Column
    var minutes: Double = 0.0,

    @Column
    var possessionsFor: Int = 0,

    @Column
    var possessionsOpp: Int = 0,

    @Column
    var pointsFor: Int = 0,

    @Column
    var pointsOpp: Int = 0,

    @Column
    var offRtg: Double = 0.0,

    @Column
    var defRtg: Double = 0.0,

    @Column
    var overallRtg: Double = 0.0,

    @Column
    var oRebFor: Int = 0,

    @Column
    var oRebOpp: Int = 0,

    @Column
    var dRebFor: Int = 0,

    @Column
    var dRebOpp: Int = 0,

    @Column
    var oRebRate: Double = 0.0,

    @Column
    var dRebRate: Double = 0.0
    )