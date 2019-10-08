package com.blydenburgh.kgraphqldemo.service

import com.blydenburgh.kgraphqldemo.CSVDataImporter
import com.blydenburgh.kgraphqldemo.dao.entity.Game
import com.blydenburgh.kgraphqldemo.dao.repository.GameRepository
import com.blydenburgh.kgraphqldemo.dao.repository.TeamRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.io.Resource
import org.springframework.stereotype.Component

@Component
class GameImporter: CSVDataImporter() {
    @Value("classpath:\${app.file.games}")
    lateinit var gamesResource: Resource

    @Autowired
    lateinit var gameRepository: GameRepository

    @Autowired
    lateinit var teamRepository: TeamRepository

    override fun import() {
        importFromCsv(gamesResource.inputStream) { row ->
            val homeTeam = teamRepository.findById(row[7])
                ?: throw IllegalArgumentException("Cannot import game without valid home team id")
            val awayTeam = teamRepository.findById(row[9])
                ?: throw IllegalArgumentException("Cannot import game without valid away team id")

            try{
                gameRepository.save(Game(
                    id = row[3],
                    date = row[2],
                    boxScoreUrl = row[4],
                    playByPlayUrl = row[5],
                    homeTeam = homeTeam.get(),
                    awayTeam = awayTeam.get()
                ))
            } catch (ex: Exception) {
                println("Error saving to game repo due to [${ex.message}]")
            }
        }
    }
}