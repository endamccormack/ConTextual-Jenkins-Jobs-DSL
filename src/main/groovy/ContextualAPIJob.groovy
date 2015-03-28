def service = new ContextualAPI(
  project:"ContextualAPI",
  repoName:"endamccormack/ConTextualAPI",
)

service.build(this);

class ContextualAPI{
  def project
  def repoName
  def github = 'https://github.com'

  def build(dslFactory) {
    def serviceCommandRemoveSBTLock = "rm -f /opt/play-2.2.2/framework/sbt/boot/sbt.boot.lock /opt/play-2.2.2/repository/.sbt.ivy.lock"
    def serviceCommandCompile = "/opt/playframework-2.2.2/play clean compile stage"
    def serviceCommandRun = "BUILD_ID=dontKillMe target/universal/stage/bin/contextualapi &"

    dslFactory.job {
      name "${project}"
      description 'This Job is automatically generated using JobDSL that starts the API, any manual changes will be overridden.'

      scm {
          git "${github}/${repoName}.git", "*/master"
      }
      triggers {
        scm "* * * * *"
      }
      steps {
        shell(serviceCommandRemoveSBTLock)
        shell(serviceCommandCompile)
        shell(serviceCommandRun)
      }
    }
  }
}
