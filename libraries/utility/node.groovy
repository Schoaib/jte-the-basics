void call(Closure body) {
    steps.podTemplate(inheritFrom: 'dev-slave') {
        steps.node(POD_LABEL) {
            body()
        }
    }
}
