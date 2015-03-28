def service = new ContextualFrontend(
  project:"ContextualFrontend",
  repoName:"endamccormack/ConTextualSite",
)

service.build(this);

class ContextualFrontend{
  def project
  def repoName
  def github = 'https://github.com'

  def build(dslFactory) {

    def serviceCommandServerPidIfExists = "[ -d 'tmp/pids/server.pid' ] && ps -ef | grep \$(cat tmp/pids/server.pid) | awk '{print \$2}' | xargs kill || echo 'process not exists'"
    def serviceCommandReloadGems = "/usr/local/bin/gem pristine --all"
    def serviceCommandInstallGems = "/usr/local/bin/bundler install"
    def serviceCommandRun = "BUILD_ID=dontKillMe /usr/local/bin/rails s -d"

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
        shell(serviceCommandServerPidIfExists)
        shell(serviceCommandReloadGems)
        shell(serviceCommandInstallGems)
        shell(serviceCommandRun)
      }
    }
  }
}
