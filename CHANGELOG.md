# Change Log
All notable changes to this project will be documented in this file. This change log follows the conventions of [keepachangelog.com](http://keepachangelog.com/).

## [Unreleased]

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

[Unreleased]: https://github.com/lagenorhynque/duct.module.pedestal/compare/2.0.1...HEAD
[2.0.1]: https://github.com/lagenorhynque/duct.module.pedestal/compare/2.0.0...2.0.1
[2.0.0]: https://github.com/lagenorhynque/duct.module.pedestal/compare/1.0.0...2.0.0
[1.0.0]: https://github.com/lagenorhynque/duct.module.pedestal/compare/0.3.0...1.0.0
[0.3.0]: https://github.com/lagenorhynque/duct.module.pedestal/compare/0.2.0...0.3.0
[0.2.0]: https://github.com/lagenorhynque/duct.module.pedestal/compare/0.1.0...0.2.0
