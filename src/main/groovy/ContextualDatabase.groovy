def service = new ContextualDatabase(
  project:"ContextualDatabase",
  repoName:"endamccormack/ConTextualDatabaseMigrationScript",
)

service.build(this);

class ContextualDatabase{
  def project
  def repoName
  def github = 'git@github.com'

  def build(dslFactory) {
    def serviceCommand = "/etc/init.d/dwp-${serviceName} restart"

    dslFactory.job {
      name "${project}"
      description 'This Job is automatically generated using JobDSL that migrates the old db with a script, any manual changes will be overridden.'

      scm {
          git "${github}:${repoName}.git", "*/master"
      }
      triggers {
        scm "* * * * *"
      }
      steps {
        shell("/usr/bin/mysql -u root -p1Password2 $WORKSPACE/dumpfilename.sql")
      }
    }
  }
}
