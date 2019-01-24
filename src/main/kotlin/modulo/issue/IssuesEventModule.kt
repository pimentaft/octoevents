package modulo.issue

import org.koin.dsl.module.module

val IssueEventModule = module("module.issue-event") {
    single { IssuesEventEndpoint() }

}