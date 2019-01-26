package modulo.issue

import modulo.issue.repositorio.IssueEventRepository
import modulo.issue.repositorio.IssueEventRepositoryImpl
import modulo.issue.servicos.IssueEventService
import modulo.issue.servicos.IssueEventServiceImpl
import org.koin.dsl.module.module

val IssueEventModule = module("module.issue-event") {
    single { IssuesEventEndpoint() }
    single<IssueEventService> { IssueEventServiceImpl(get()) }
    single<IssueEventRepository> { IssueEventRepositoryImpl() }
}