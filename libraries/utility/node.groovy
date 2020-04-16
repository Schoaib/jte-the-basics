void call(Closure body) {
    steps.podTemplate(inheritFrom: config.label ?: 'dev-slave') {
        steps.node(POD_LABEL) {
            body()
        }
    }
}
