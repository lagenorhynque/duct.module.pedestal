(defproject duct.module.pedestal "0.3.0"
  :description "Duct module for Pedestal"
  :url "https://github.com/lagenorhynque/duct.module.pedestal"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :min-lein-version "2.0.0"
  :dependencies [;; Duct
                 [duct/core "0.6.2"]

                 ;; Pedestal
                 [io.pedestal/pedestal.service "0.5.4"]

                 ;; Pedestal server adapter
                 ;; Remove this line and uncomment one of the next lines to
                 ;; use Immutant or Tomcat instead of Jetty:
                 [io.pedestal/pedestal.jetty "0.5.4"]
                 ;; [io.pedestal/pedestal.immutant "0.5.4"]
                 ;; [io.pedestal/pedestal.tomcat "0.5.4"]

                 ;; logging
                 [ch.qos.logback/logback-classic "1.2.3" :exclusions [org.slf4j/slf4j-api]]
                 [org.slf4j/jcl-over-slf4j "1.7.25"]
                 [org.slf4j/jul-to-slf4j "1.7.25"]
                 [org.slf4j/log4j-over-slf4j "1.7.25"]]
  :deploy-repositories [["releases" :clojars]]
  :profiles {:dev {:dependencies [[org.clojure/clojure "1.9.0"]
                                  [pjstadig/humane-test-output "0.8.3"]]
                   :plugins [[jonase/eastwood "0.3.3"]
                             [lein-cljfmt "0.6.1"]
                             [lein-cloverage "1.0.13"]
                             [lein-kibit "0.1.6"]]
                   :aliases {"test-coverage" ^{:doc "Execute cloverage."}
                             ["with-profile" "test" "cloverage" "--codecov" "--junit"]
                             "lint" ^{:doc "Execute cljfmt check, eastwood and kibit."}
                             ["do" ["cljfmt" "check"] ["eastwood"] ["kibit"]]}
                   :injections [(require 'pjstadig.humane-test-output)
                                (pjstadig.humane-test-output/activate!)]}})
