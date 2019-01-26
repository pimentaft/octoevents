package modulo.issue.servicos

import modulo.issue.mensagens.IssueEvent
import modulo.issue.repositorio.IssueEventRepository

interface IssueEventService{
    fun save(issueEvent: IssueEvent) : Boolean
}

class IssueEventServiceImpl (
    private val issueEventRepository: IssueEventRepository
) : IssueEventService {
    override fun save(issueEvent: IssueEvent) = issueEventRepository.save(issueEvent)
}