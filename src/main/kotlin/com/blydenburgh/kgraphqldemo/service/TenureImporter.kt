package com.blydenburgh.kgraphqldemo.service

import com.blydenburgh.kgraphqldemo.CSVDataImporter
import com.blydenburgh.kgraphqldemo.dao.entity.Tenure
import com.blydenburgh.kgraphqldemo.dao.repository.PlayerRepository
import com.blydenburgh.kgraphqldemo.dao.repository.TeamRepository
import com.blydenburgh.kgraphqldemo.dao.repository.TenureRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.io.Resource
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
class TenureImporter: CSVDataImporter() {
    @Value("classpath:\${app.file.playerTenures}")
    lateinit var tenuresResource: Resource

    @Autowired
    lateinit var tenureRepository: TenureRepository

    @Autowired
    lateinit var teamRepository: TeamRepository

    @Autowired
    lateinit var playerRepository: PlayerRepository

    override fun import() = importFromCsv(tenuresResource.inputStream) { row ->
        val player = playerRepository.findById(row[0])
            ?: throw IllegalArgumentException("Cannot import tenure without valid player id")
        val team = teamRepository.findById(row[4])
            ?: throw IllegalArgumentException("Cannot import tenure without valid team id")

        try {
            tenureRepository.save(Tenure(
                player = player.get(),
                team = team.get(),
                startDate = row[8],
                endDate = row[9],
                comment = row[7],
                position = row[6].toDouble()
            ))
        } catch (ex: Exception) {
        println("Error saving to tenure repo due to [${ex.message}]")
    }
    }
}