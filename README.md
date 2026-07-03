# DevOps Engineering Lab

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)
[![Shell](https://img.shields.io/badge/Shell-Bash-4EAA25?logo=gnu-bash&logoColor=white)](https://www.gnu.org/software/bash/)
[![Terraform](https://img.shields.io/badge/IaC-Terraform-844FBA?logo=terraform&logoColor=white)](https://www.terraform.io/)
[![Ansible](https://img.shields.io/badge/Config-Ansible-EE0000?logo=ansible&logoColor=white)](https://www.ansible.com/)
[![Docker](https://img.shields.io/badge/Containers-Docker-2496ED?logo=docker&logoColor=white)](https://www.docker.com/)
[![Kubernetes](https://img.shields.io/badge/Orchestration-Kubernetes-326CE5?logo=kubernetes&logoColor=white)](https://kubernetes.io/)
[![Jenkins](https://img.shields.io/badge/CI%2FCD-Jenkins-D24939?logo=jenkins&logoColor=white)](https://www.jenkins.io/)

> From validating systems to building them - a QA engineer's hands-on journey into DevOps, one production-grade project at a time.

---

## Why this repo exists

I spent years as a QA engineer answering one question all day: **"does this actually work the way it's supposed to, under real conditions?"**

This repo is that same instinct pointed at infrastructure instead of application code. Every project here isn't just "I ran a tutorial" - it's built, broken, fixed, and documented the way I'd validate a test case: What's the expected behavior? What breaks it? What would I flag in a review?

If you're hiring for DevOps and want to know whether someone actually understands the tools versus just having run `terraform apply` once - this repo is built to answer that.

---

## How QA experience translates directly into DevOps

| QA skill | DevOps equivalent | Where you'll see it in this repo |
|---|---|---|
| Writing test cases with expected outcomes | Writing idempotent, predictable infra code | `ansible_project` - playbooks verified to be safe on repeat runs |
| Regression testing before release | CI pipelines gating every change | `.github/workflows/` - lint and validation on every push |
| Root-causing a failed test | Debugging a failed pipeline or misconfigured container | Troubleshooting notes in each project README |
| Test environment setup/teardown | Infrastructure provisioning and destruction | `Terraform_First_project` - reproducible, disposable environments |
| Defect severity triage | Incident response, rollback strategy | Rollback notes in `Kubernetes_Project` |

If you're a QA engineer reading this because you're making the same move I did - the mindset transfers more than people tell you. The tools are new. The discipline isn't.

---

## Project index

| Project | What it demonstrates | Tools | Status | What I'd add for production |
|---|---|---|---|---|
| [`docker_fundamental`](./docker_fundamental) | Containerizing an app, image layering, multi-stage builds | Docker | Working | Multi-stage build to shrink final image, vulnerability scan via Trivy |
| [`Kickstart_Jenkins_Project`](./Kickstart_Jenkins_Project) | Pipeline-as-code, build/test/deploy stages | Jenkins, Groovy | Working | Shared library for reusable pipeline stages, credentials via Vault instead of Jenkins secrets |
| [`Terraform_First_project`](./Terraform_First_project) | Provisioning AWS infra as code | Terraform, AWS | Working | Migrate local state to S3 backend + DynamoDB locking for team-safe state management |
| [`ansible_project`](./ansible_project) | Configuration management, idempotent playbooks | Ansible | Working | Ansible Vault for secrets, molecule tests for playbook validation |
| [`Kubernetes_Project`](./Kubernetes_Project) | Container orchestration fundamentals | Kubernetes | Working | Promote bare Pods to Deployments + Services + ConfigMaps for self-healing and rolling updates |
| Java end-to-end project | Full app lifecycle: build, containerize, deploy | Java, Maven, Docker, Jenkins | Working | Wire into the CI pipeline for automated build-test-deploy on every commit |

Each project folder has its own README covering: what it does, why it's built that way, how to run it, and what I'd change for a production environment. That last section matters most - it's where I show the same critical eye I used to apply to test coverage, now applied to infrastructure decisions.

---

## Toolchain and why each tool is here, not just what it is

| Tool | Role in this repo | Why this over the alternative |
|---|---|---|
| Terraform | Infrastructure provisioning | Declarative, cloud-agnostic - versus ClickOps in AWS console, which leaves no audit trail |
| Ansible | Configuration management | Agentless, idempotent - versus shell scripts that silently drift from expected state |
| Docker | Packaging and portability | Consistent runtime across dev/CI/prod - versus "works on my machine" |
| Kubernetes | Orchestration | Self-healing, rolling updates, declarative desired-state - versus manually managing container lifecycles |
| Jenkins | Pipeline automation | Full control, huge plugin ecosystem - versus GitHub Actions, which I'm also using here for lighter, repo-native automation |
| GitHub Actions | Lint/validation CI | Zero infra to maintain, tightly integrated with PRs - trade-off is less flexibility than a self-hosted Jenkins for complex pipelines |

I use both Jenkins and GitHub Actions intentionally - not because I couldn't pick one, but because they solve different problems. Jenkins here handles a full build-test-deploy pipeline with more control; GitHub Actions handles lightweight validation directly on PRs with zero maintenance overhead. Knowing when to reach for which is part of the job.

---

## Continuous Integration on this repo

Every push and pull request runs:

- ShellCheck against all shell scripts
- Terraform `fmt` and `validate` against all `.tf` files
- YAML lint against Kubernetes manifests and Ansible playbooks

```yaml
# .github/workflows/ci.yml (excerpt)
name: CI

on:
  push:
    branches: [ main ]
  pull_request:
    branches: [ main ]

jobs:
  validate:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v4
      - name: ShellCheck
        uses: ludeeus/action-shellcheck@master
      - name: Terraform fmt check
        run: terraform fmt -check -recursive ./Terraform_First_project
      - name: YAML Lint
        run: yamllint ./Kubernetes_Project ./ansible_project
```

Same reason I'd insist on automated regression tests before a release - I don't want a broken script or a malformed manifest merging just because nobody happened to run it manually before pushing.

---

## Getting started

```bash
# clone the repo
git clone https://github.com/H1manshu-Kumar/DevOps.git
cd DevOps

# pick a project and read its README first - each one is self-contained
cd Terraform_First_project
cat README.md
```

Every project is designed to run independently - no shared state between them, so you can explore one without setting up the others.

---

## Roadmap - what's next

- [ ] Migrate Terraform state to S3 + DynamoDB locking
- [ ] Promote Kubernetes Pods to Deployments + Services
- [ ] Add Molecule tests to the Ansible project
- [ ] Chain Docker build -> Terraform provision -> Ansible configure -> Kubernetes deploy into one end-to-end pipeline
- [ ] Add Trivy container scanning to the Docker workflow

Tracking this openly rather than pretending the repo is "finished" - infrastructure work never really is, and I'd rather show active iteration than a static snapshot.

---

## License

This project is licensed under the [MIT License](LICENSE).

## Connect

**Himanshu Kumar** - Building, Containerizing, and Deploying One Step at a Time 🚀  

🔗 GitHub: https://github.com/H1manshu-Kumar  
🔗 LinkedIn: https://www.linkedin.com/in/h1manshu-kumar 
