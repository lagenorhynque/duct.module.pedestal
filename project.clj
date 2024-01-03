(defproject duct.module.pedestal "2.1.5-SNAPSHOT"
  :description "Duct module for Pedestal"
  :url "https://github.com/lagenorhynque/duct.module.pedestal"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :min-lein-version "2.8.1"
  :dependencies [;; Duct
                 [duct/core "0.8.0"]

                 ;; Pedestal
                 [io.pedestal/pedestal.service "0.6.3"]

                 ;; Pedestal server adapter
                 ;; Remove this line and uncomment one of the next lines to
                 ;; use Immutant or Tomcat instead of Jetty:
                 [io.pedestal/pedestal.jetty "0.6.3"]
                 ;; [io.pedestal/pedestal.immutant "0.6.3"]
                 ;; [io.pedestal/pedestal.tomcat "0.6.3"]

                 ;; logging
                 [ch.qos.logback/logback-classic "1.4.14" :exclusions [org.slf4j/slf4j-api]]
                 [org.slf4j/jcl-over-slf4j "2.0.10"]
                 [org.slf4j/jul-to-slf4j "2.0.10"]
                 [org.slf4j/log4j-over-slf4j "2.0.10"]]
  :deploy-repositories [["releases" :clojars]]
  :profiles {:dev {:dependencies [[org.clojure/clojure "1.11.1"]
                                  [pjstadig/humane-test-output "0.11.0"]]
                   :plugins [[jonase/eastwood "1.4.2"]
                             [lein-cloverage "1.2.4"]
                             [lein-kibit "0.1.8"]]
                   :aliases {"test-coverage" ^{:doc "Execute cloverage."}
                             ["with-profile" "test" "cloverage" "--codecov" "--junit"]
                             "lint" ^{:doc "Execute eastwood and kibit."}
                             ["do" ["eastwood"] ["kibit"]]}
                   :injections [(require 'pjstadig.humane-test-output)
                                (pjstadig.humane-test-output/activate!)]}})
