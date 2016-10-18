# GitCatGo - Gitflow

GitCatGo is to be developed using the [Gitflow workflow](https://www.atlassian.com/git/tutorials/comparing-workflows/gitflow-workflow/).

 * When starting work on a new feature, branch out from the develop branch and name the new branch "featureXXX", without quotes and replace XXX with a descriptive name.
 * When finished with the new feature, make a pull request into the develop branch.
 * When we want to release a new version of GitCatGo, branch out from the develop branch and name the branch "release", without quotes.
 * Bugfix/refactor on the release branch and when the whole team is satisfied, merge into the master branch with a tag describing the release.
 * When a bug occurs on the current version in master, branch out from the master branch and name the new branch "hotfixXXX", without the quotes and replace XXX with a descriptive name.
 * When finished with fixing the bug on the hotfix branch, make a pull request into the master branch.


Team members will review code of pull requests.

You cannot review your own code!
