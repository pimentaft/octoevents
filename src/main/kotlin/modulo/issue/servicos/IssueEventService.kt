package modulo.issue.servicos

import modulo.issue.mensagens.Event
import modulo.issue.mensagens.IssueEvent
import modulo.issue.repositorio.IssueEventRepository

interface IssueEventService{
    fun save(issueEvent: IssueEvent) : Boolean
    fun getEvents(issueId: Int): List<Event>
}

class IssueEventServiceImpl (
    private val issueEventRepository: IssueEventRepository
) : IssueEventService {
    override fun save(issueEvent: IssueEvent) = issueEventRepository.save(issueEvent)

    override fun getEvents(issueId: Int) = issueEventRepository.getEvents(issueId)
}