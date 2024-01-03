# Change Log
All notable changes to this project will be documented in this file. This change log follows the conventions of [keepachangelog.com](http://keepachangelog.com/).

## [Unreleased]

## [2.2.0] - 2024-01-04
### Changed
- Update dependencies
    - [Pedestal 0.6.3](https://github.com/pedestal/pedestal/blob/master/CHANGELOG.md#063----30-nov-2023)

## [2.1.4] - 2021-12-15
### Changed
- Update dependencies
    - [Logback 1.2.8](http://logback.qos.ch/news.html)
        - 14th of December, 2021, Release of version 1.2.8

## [2.1.3] - 2021-05-19
### Changed
- Update dependencies
    - [Pedestal 0.5.9](https://github.com/pedestal/pedestal/blob/master/CHANGELOG.md#059---may-9-2021)

## [2.1.2] - 2020-05-24
### Changed
- Update dependencies
    - [Pedestal 0.5.8](https://github.com/pedestal/pedestal/blob/master/CHANGELOG.md#058---may-22-2020)

## [2.1.1] - 2019-12-14
### Added
- Support `:duct.profile/test` and `:test` environment

## [2.1.0] - 2019-12-02
### Changed
- Update dependencies
    - [duct/core 0.8.0](https://github.com/duct-framework/core/blob/master/CHANGELOG.md#080-2019-11-28)

## [2.0.2] - 2019-07-21
### Changed
- Update dependencies
    - [Pedestal 0.5.7](https://github.com/pedestal/pedestal/blob/master/CHANGELOG.md#057---june-21-2019)

## [2.0.1] - 2019-01-22
### Added
- `deps.edn` for Clojure CLI
### Changed
- Remove unnecessary `:duct.core/environment` keys from example config maps

## [2.0.0] - 2019-01-08
### Changed
- Support [duct/core 0.7.0](https://github.com/duct-framework/core/blob/master/CHANGELOG.md#070-2018-01-05) (**BREAKING CHANGE**)

## [1.0.0] - 2018-12-19
### Changed
- based on [duct/core 0.6.2](https://github.com/duct-framework/core/blob/master/CHANGELOG.md#062-2017-12-17)
- Update dependencies
    - [Pedestal 0.5.5](https://github.com/pedestal/pedestal/blob/master/CHANGELOG.md#055---december-18-2018)

## [0.3.0] - 2018-11-05
### Changed
- Use `duct.core/merge-configs` for merging base-service and service

## [0.2.0] - 2018-11-05
### Changed
- Split options into two Integrant keys: `:duct.module/pedestal` & `:duct.server/pedestal`

## 0.1.0 - 2018-11-04
### Added
- Duct module for Pedestal
    - a web server (Jetty)
    - useful interceptors
    - default configuration for development and production

[Unreleased]: https://github.com/lagenorhynque/duct.module.pedestal/compare/2.2.0...HEAD
[2.2.0]: https://github.com/lagenorhynque/duct.module.pedestal/compare/2.1.4...2.2.0
[2.1.4]: https://github.com/lagenorhynque/duct.module.pedestal/compare/2.1.3...2.1.4
[2.1.3]: https://github.com/lagenorhynque/duct.module.pedestal/compare/2.1.2...2.1.3
[2.1.2]: https://github.com/lagenorhynque/duct.module.pedestal/compare/2.1.1...2.1.2
[2.1.1]: https://github.com/lagenorhynque/duct.module.pedestal/compare/2.1.0...2.1.1
[2.1.0]: https://github.com/lagenorhynque/duct.module.pedestal/compare/2.0.2...2.1.0
[2.0.2]: https://github.com/lagenorhynque/duct.module.pedestal/compare/2.0.1...2.0.2
[2.0.1]: https://github.com/lagenorhynque/duct.module.pedestal/compare/2.0.0...2.0.1
[2.0.0]: https://github.com/lagenorhynque/duct.module.pedestal/compare/1.0.0...2.0.0
[1.0.0]: https://github.com/lagenorhynque/duct.module.pedestal/compare/0.3.0...1.0.0
[0.3.0]: https://github.com/lagenorhynque/duct.module.pedestal/compare/0.2.0...0.3.0
[0.2.0]: https://github.com/lagenorhynque/duct.module.pedestal/compare/0.1.0...0.2.0
