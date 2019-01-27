package modulo.issue.repositorio

import modulo.issue.classes.IssueEntity
import modulo.issue.classes.IssueEventEntity
import modulo.issue.classes.IssueEventTable
import modulo.issue.classes.IssueTable
import modulo.issue.mensagens.Event
import modulo.issue.mensagens.Issue
import modulo.issue.mensagens.IssueEvent
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction
import org.joda.time.DateTime

interface IssueEventRepository {
    fun save(issueEvent: IssueEvent): Boolean
    fun getEvents(issueId: Int): List<Event>
}

class IssueEventRepositoryImpl : IssueEventRepository {
    override fun save(issueEvent: IssueEvent) = transaction {
        val issue = IssueEntity.new(issueEvent.issue.id) {
            this.createdAt = DateTime(issueEvent.issue.createdAt)
            this.updatedAt = DateTime(issueEvent.issue.updatedAt)
            commit()
        }

        IssueEventEntity.new {
            this.action = issueEvent.action
            this.issue = issue
        }.flush()
    }

    override fun getEvents(issueId: Int) = transaction {
        IssueEventEntity.find { IssueEventTable.issueId eq issueId }.map {
            Event(it.action, it.issue.createdAt.toString(), it.issue.updatedAt.toString())
        }
    }
}