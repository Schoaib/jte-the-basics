void call(Closure body) {
    steps.podTemplate(inheritFrom: config.label ?: 'dev-slave',   containers: [  containerTemplate(
        name: 'docker', image: 'docker:latest',
        resourceRequestCpu: '50m', resourceLimitCpu: '500m',
        resourceRequestMemory: '200Mi', resourceLimitMemory: '500Mi',
        ttyEnabled: true,command: 'cat'),
  ]) {
        steps.node(POD_LABEL) {
            body()
        }
    }
}
