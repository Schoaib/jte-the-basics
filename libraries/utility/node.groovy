void call(String label = null, Closure body){
    podTemplate(containers: [
    containerTemplate(name: 'maven', image: 'maven:3.3.9-jdk-8-alpine', ttyEnabled: true, command: 'cat'),
    containerTemplate(name: 'golang', image: 'golang:1.8.0', ttyEnabled: true, command: 'cat'),
     containerTemplate(
        name: 'golang', image: 'golang:1.9.2-stretch',
        resourceRequestCpu: '50m', resourceLimitCpu: '500m',
        resourceRequestMemory: '200Mi', resourceLimitMemory: '500Mi',
        ttyEnabled: true,command: 'cat')
  ]) {
   steps.node( label ?: config.label ?: “” ){
    body()
  }
  }
}