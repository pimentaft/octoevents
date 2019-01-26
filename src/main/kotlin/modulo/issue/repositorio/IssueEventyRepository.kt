package modulo.issue.repositorio

import modulo.issue.classes.IssueEntity
import modulo.issue.classes.IssueEventEntity
import modulo.issue.mensagens.Issue
import modulo.issue.mensagens.IssueEvent
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction
import org.joda.time.DateTime

interface IssueEventRepository {
    fun save(issueEvent: IssueEvent): Boolean
}

class IssueEventRepositoryImp : IssueEventRepository {
    override fun save(issueEvent: IssueEvent) = transaction {
        IssueEntity.new(issueEvent.issue.id) {
            this.createdAt = DateTime(issueEvent.issue.createdAt)
            this.updatedAt = DateTime(issueEvent.issue.updatedAt)
        }

        IssueEventEntity.new {
            this.action = issueEvent.action
            this.issue = issue
        }.flush()
    }
}