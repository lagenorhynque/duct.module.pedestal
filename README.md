# duct.module.pedestal

[![Clojars Project](https://img.shields.io/clojars/v/duct.module.pedestal.svg)](https://clojars.org/duct.module.pedestal)
[![Circle CI](https://circleci.com/gh/lagenorhynque/duct.module.pedestal.svg?style=shield)](https://circleci.com/gh/lagenorhynque/duct.module.pedestal)
[![codecov](https://codecov.io/gh/lagenorhynque/duct.module.pedestal/branch/master/graph/badge.svg)](https://codecov.io/gh/lagenorhynque/duct.module.pedestal)

A Duct module that adds a web server and useful interceptors of [Pedestal](https://github.com/pedestal/pedestal) to a configuration. This is an alternative to [duct/module.web](https://github.com/duct-framework/module.web). The default service configuration is based on [pedestal-service](https://github.com/pedestal/pedestal/tree/master/service-template) template.

## Installation

To install, add the following to your project `:dependencies`:

```clj
[duct.module.pedestal "0.1.0"]
```

## Usage

To add this module to your configuration, add a reference to `:duct.module/pedestal` (and `:duct.server/pedestal` if necessary):

```edn
{:duct.core/project-ns some-api
 :duct.core/environment :production

 :duct.module/pedestal {}
 :duct.server/pedestal
 {:service #:io.pedestal.http{:routes #ig/ref :some-api.routes/routes
                              :port #duct/env ["SERVER_PORT" Int :or 8080]}}

 :some-api.routes/routes {,,,}}
```

- `:duct.module/pedestal` can have two options:

    - `:default?`: whether to insert [default-intercetors](http://pedestal.io/api/pedestal.service/io.pedestal.http.html#var-default-interceptors) (default: true)
    - `:dev?`: whether to insert [dev-interceptors](http://pedestal.io/api/pedestal.service/io.pedestal.http.html#var-dev-interceptors) (default: true if `:duct.core/environment` is `:development`)

- `:duct.server/pedestal` can have two options:

    - `:base-service`: base [service map](http://pedestal.io/reference/service-map) (default: configuration based on [pedestal-service](https://github.com/pedestal/pedestal/tree/master/service-template))
    - `:service`: arbitrary [service map](http://pedestal.io/reference/service-map) which overrides `:base-service` configuration
