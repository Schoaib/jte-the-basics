void call(Closure body) {
    steps.podTemplate(inheritFrom: 'dev-slave',containers: [ containerTemplate(
        name: 'golang', image: 'golang:1.9.2-stretch',
        resourceRequestCpu: '50m', resourceLimitCpu: '500m',
        resourceRequestMemory: '200Mi', resourceLimitMemory: '500Mi',
        ttyEnabled: true,command: 'cat') ]) {
        steps.node(POD_LABEL) {
            body()
        }
    }
}
